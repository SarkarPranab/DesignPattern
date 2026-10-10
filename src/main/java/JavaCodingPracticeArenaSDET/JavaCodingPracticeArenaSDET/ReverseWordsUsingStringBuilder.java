package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM: REVERSE CHARACTERS OF EACH WORD USING STRINGBUILDER
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a string `str`, reverse the character order of each word in place
 * while maintaining original word sequence using Java's `StringBuilder`.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  str = "This is Fun"
 *   Output: "sihT si nuF"
 *
 * Example 2:
 *   Input:  str = "Java SDET 2026"
 *   Output: "avaJ TEDS 6202"
 *
 * Example 3:
 *   Input:  str = "a"
 *   Output: "a"
 *
 * CONSTRAINTS:
 * - 0 <= str.length <= 10^5
 * - Handle null, empty, and multi-whitespace input cleanly.
 * ============================================================================
 */
public class ReverseWordsUsingStringBuilder {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Word Split & StringBuilder.reverse() Loop
     *
     * @implNote Split input using `\\s+`, iterate through words, reverse each word
     *           via `new StringBuilder(word).reverse()`, and join with trailing trim.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public String reverseWordsStringBuilder(String str) {
        // TODO: Write solution here
        return "";
    }

    /**
     * Approach 2: Single-Pass Traversing with StringBuilder Buffer
     *
     * @implNote Iterate through characters into a word buffer `StringBuilder`. Upon hitting
     *           a space or string boundary, call `.reverse()` on buffer and append to main result.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public String reverseWordsSinglePassBuilder(String str) {
        // TODO: Write solution here
        return "";
    }

    /**
     * Approach 3: Stream API with StringBuilder Mapping
     *
     * @implNote Stream split words, map using `new StringBuilder(word).reverse()`,
     *           and collect with `Collectors.joining(" ")`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public String reverseWordsStreamBuilder(String str) {
        // TODO: Write solution here
        return "";
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String input;
        private final String expected;
        private final String description;

        public TestCase(int id, String input, String expected, String description) {
            this.id = id;
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getInput() { return input; }
        public String getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        ReverseWordsUsingStringBuilder solver = new ReverseWordsUsingStringBuilder();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "This is Fun", "sihT si nuF", "Standard multi-word string"),
                new TestCase(2, "Java SDET 2026", "avaJ TEDS 6202", "Alphanumeric string with numbers"),
                new TestCase(3, "Automation", "noitamotuA", "Single word string"),
                new TestCase(4, "a b c d", "a b c d", "Single character words"),
                new TestCase(5, "", "", "Empty string input"),
                new TestCase(6, null, null, "Null input safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: REVERSE WORDS USING STRINGBUILDER");
        System.out.println("================================================================================");

        runApproach("1. Split & StringBuilder.reverse() Loop", solver::reverseWordsStringBuilder, testCases);
        runApproach("2. Single-Pass Traversing with StringBuilder", solver::reverseWordsSinglePassBuilder, testCases);
        runApproach("3. Stream API with StringBuilder Mapping", solver::reverseWordsStreamBuilder, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected output, and records execution timing.
     */
    private static void runApproach(String name, Function<String, String> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            String result = method.apply(tc.getInput());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = (result == null && tc.getExpected() == null) ||
                    (result != null && result.trim().equals(tc.getExpected()));

            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Input:    \"%s\"\n", tc.getInput());
                System.out.printf("         Expected: \"%s\"\n", tc.getExpected());
                System.out.printf("         Actual:   \"%s\"\n", result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}