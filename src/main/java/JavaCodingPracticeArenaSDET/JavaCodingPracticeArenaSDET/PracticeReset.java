import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Resets the practice arena after a day of practice.
 *
 * It keeps a pristine "baseline" copy of every practice class (the version with the TODO stubs).
 * On "reset" it first ARCHIVES every class you changed into my-solutions/<date_time>/ and then restores the
 * baseline version, so tomorrow you start from clean stubs and today's solutions are never lost.
 *
 * Requires only a JDK (11 or newer). Run it from the repository root:
 *
 *   java tools/PracticeReset.java init                 one time: save the current stubs as the baseline
 *   java tools/PracticeReset.java init --add-new       later: add only newly created problems to the baseline
 *   java tools/PracticeReset.java status               show which classes you changed or added
 *   java tools/PracticeReset.java reset --dry-run      show what reset would do, change nothing
 *   java tools/PracticeReset.java reset                archive your solutions, then restore clean stubs
 *
 * Options:
 *   --root <dir>         repository root (default: current directory)
 *   --src <dir>          practice package folder, relative to root
 *                        (default: src/main/java/JavaCodingPracticeArenaSDET/JavaCodingPracticeArenaSDET)
 *   --archive-dir <dir>  where solutions are saved, relative to root (default: my-solutions)
 *   --force              with init: overwrite existing baseline files (use only when the stubs themselves changed)
 *   --dry-run            print actions without changing any file
 */
public class PracticeReset {

    private static final String DEFAULT_SRC = "src/main/java/JavaCodingPracticeArenaSDET/JavaCodingPracticeArenaSDET";
    private static final String BASELINE_DIR = ".practice/baseline";

    public static void main(String[] args) throws IOException {
        if (args.length == 0 || args[0].equals("-h") || args[0].equals("--help")) {
            usage();
            return;
        }
        String command = args[0];
        Path root = Paths.get(".");
        String src = DEFAULT_SRC;
        String archiveDir = "my-solutions";
        boolean force = false;
        boolean dryRun = false;
        boolean addNew = false;

        for (int i = 1; i < args.length; i++) {
            switch (args[i]) {
                case "--root": root = Paths.get(args[++i]); break;
                case "--src": src = args[++i]; break;
                case "--archive-dir": archiveDir = args[++i]; break;
                case "--force": force = true; break;
                case "--dry-run": dryRun = true; break;
                case "--add-new": addNew = true; break;
                default:
                    System.err.println("Unknown option: " + args[i]);
                    usage();
                    System.exit(2);
            }
        }

        root = root.toAbsolutePath().normalize();
        Path srcPath = root.resolve(src);
        Path baseline = root.resolve(BASELINE_DIR);
        if (!Files.isDirectory(srcPath)) {
            System.err.println("Practice folder not found: " + srcPath);
            System.exit(1);
        }

        switch (command) {
            case "init": init(srcPath, baseline, force, dryRun); break;
            case "status": status(srcPath, baseline); break;
            case "reset": reset(root, srcPath, baseline, archiveDir, dryRun); break;
            default:
                System.err.println("Unknown command: " + command);
                usage();
                System.exit(2);
        }
    }

    private static void init(Path srcPath, Path baseline, boolean force, boolean dryRun) throws IOException {
        int copied = 0;
        int skipped = 0;
        if (!dryRun) Files.createDirectories(baseline);
        for (String name : javaFiles(srcPath)) {
            Path target = baseline.resolve(name);
            if (Files.exists(target) && !force) {
                skipped++;
                continue;
            }
            System.out.println((dryRun ? "[dry-run] would save " : "saved ") + name);
            if (!dryRun) Files.copy(srcPath.resolve(name), target, StandardCopyOption.REPLACE_EXISTING);
            copied++;
        }
        System.out.printf("Baseline: %d saved, %d already present (use --force to overwrite).%n", copied, skipped);
        if (copied > 0 && !dryRun) {
            System.out.println("Reminder: run init when every file is still a clean stub, otherwise solutions get saved as the baseline.");
        }
    }

    private static void status(Path srcPath, Path baseline) throws IOException {
        requireBaseline(baseline);
        List<String> changed = new ArrayList<>();
        List<String> added = new ArrayList<>();
        List<String> missing = new ArrayList<>();
        classify(srcPath, baseline, changed, added, missing);
        print("Changed since baseline (would be archived and reset)", changed);
        print("New files not in baseline (left untouched)", added);
        print("Missing files (would be restored)", missing);
        System.out.printf("Unchanged: %d%n", baselineFiles(baseline).size() - changed.size() - missing.size());
    }

    private static void reset(Path root, Path srcPath, Path baseline, String archiveDir, boolean dryRun) throws IOException {
        requireBaseline(baseline);
        List<String> changed = new ArrayList<>();
        List<String> added = new ArrayList<>();
        List<String> missing = new ArrayList<>();
        classify(srcPath, baseline, changed, added, missing);

        if (changed.isEmpty() && missing.isEmpty()) {
            System.out.println("Nothing to reset: every practice class already matches the baseline.");
            return;
        }

        String stamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmm"));
        Path archive = root.resolve(archiveDir).resolve(stamp);

        for (String name : changed) {
            System.out.println((dryRun ? "[dry-run] would archive + reset " : "archive + reset ") + name);
            if (dryRun) continue;
            Files.createDirectories(archive);
            Files.copy(srcPath.resolve(name), archive.resolve(name), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(baseline.resolve(name), srcPath.resolve(name), StandardCopyOption.REPLACE_EXISTING);
        }
        for (String name : missing) {
            System.out.println((dryRun ? "[dry-run] would restore " : "restore ") + name);
            if (!dryRun) Files.copy(baseline.resolve(name), srcPath.resolve(name), StandardCopyOption.REPLACE_EXISTING);
        }

        System.out.printf("%s %d changed class(es), restored %d missing.%n",
                dryRun ? "Would reset" : "Reset", changed.size(), missing.size());
        if (!changed.isEmpty() && !dryRun) System.out.println("Your solutions are saved in: " + archive);
        if (!added.isEmpty()) System.out.println("Left untouched (not in baseline): " + added.size() + " new file(s)");
    }

    private static void classify(Path srcPath, Path baseline, List<String> changed, List<String> added,
                                 List<String> missing) throws IOException {
        TreeSet<String> base = baselineFiles(baseline);
        for (String name : base) {
            Path current = srcPath.resolve(name);
            if (!Files.exists(current)) {
                missing.add(name);
            } else if (!normalized(current).equals(normalized(baseline.resolve(name)))) {
                changed.add(name);
            }
        }
        for (String name : javaFiles(srcPath)) {
            if (!base.contains(name)) added.add(name);
        }
    }

    private static String normalized(Path file) throws IOException {
        // Ignore line-ending differences (Windows CRLF vs Unix LF) and trailing whitespace at end of file.
        return new String(Files.readAllBytes(file), StandardCharsets.UTF_8).replace("\r\n", "\n").stripTrailing();
    }

    private static TreeSet<String> javaFiles(Path dir) throws IOException {
        try (Stream<Path> s = Files.list(dir)) {
            return s.filter(p -> p.getFileName().toString().endsWith(".java"))
                    .map(p -> p.getFileName().toString())
                    .collect(Collectors.toCollection(TreeSet::new));
        }
    }

    private static TreeSet<String> baselineFiles(Path baseline) throws IOException {
        return javaFiles(baseline);
    }

    private static void requireBaseline(Path baseline) {
        if (!Files.isDirectory(baseline)) {
            System.err.println("No baseline found. Run once while every file is a clean stub:  java tools/PracticeReset.java init");
            System.exit(1);
        }
    }

    private static void print(String title, List<String> names) {
        System.out.println(title + ": " + names.size());
        for (String n : names) System.out.println("  - " + n);
    }

    private static void usage() {
        System.out.println("Usage: java tools/PracticeReset.java <init|status|reset> [--dry-run] [--force] [--add-new]"
                + " [--root dir] [--src dir] [--archive-dir dir]");
    }
}
