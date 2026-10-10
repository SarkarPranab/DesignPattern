package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM: REMOVE DUPLICATE CHARACTERS PRESERVING ORIGINAL ORDER
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a string `str`, remove all duplicate characters such that each character
 * appears only once in the resulting string. The relative order of the first
 * appearance of each character must be preserved.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  str = "abbacdaab"
 *   Output: "abcd"
 *   Explanation:
 *     - 'a' first seen at index 0 -> included ("a")
 *     - 'b' first seen at index 1 -> included ("ab")
 *     - 'b' duplicate -> skipped
 *     - 'a' duplicate -> skipped
 *     - 'c' first seen at index 4 -> included ("abc")
 *     - 'd' first seen at index 5 -> included ("abcd")
 *
 * Example 2:
 *   Input:  str = "programming"
 *   Output: "progami"
 *
 * Example 3:
 *   Input:  str = "aaaaa"
 *   Output: "a"
 *
 * CONSTRAINTS:
 * - 0 <= str.length() <= 10^6
 * - Handles null and empty strings safely by returning an empty string or null.
 * - String can contain upper/lowercase ASCII, digits, and special characters.
 * ============================================================================
 */
public class RemoveDuplicateCharactersPreserveOrder {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: LinkedHashSet Tracking
     *
     * @implNote Iterate through `str.toCharArray()`. Add each character to a `LinkedHashSet<Character>`.
     *           Since `Set.add()` returns `true` only for new elements, append added characters to a `StringBuilder`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(K) where K is unique character set size
     */
    public String removeDuplicatesLinkedHashSet(String str) {
        // TODO: Write solution here
        return "";
    }

    /**
     * Approach 2: Boolean Array / BitSet Lookup
     *
     * @implNote Allocate a `boolean[] seen = new boolean[256]` (or `128` for ASCII).
     *           Iterate through characters; if `seen[ch]` is false, mark it true and append `ch` to `StringBuilder`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) fixed auxiliary array size 256
     */
    public String removeDuplicatesBooleanArray(String str) {
        // TODO: Write solution here
        return "";
    }

    /**
     * Approach 3: Java Stream API & distinct() (Functional Style)
     *
     * @implNote Stream `str.chars()`, apply `.distinct()`, map integers back to character strings,
     *           and join using `Collectors.joining()`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(K)
     */
    public String removeDuplicatesStream(String str) {
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
        RemoveDuplicateCharactersPreserveOrder solver = new RemoveDuplicateCharactersPreserveOrder();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "abbacdaab", "abcd", "Standard string with repeating characters"),
                new TestCase(2, "programming", "progami", "Standard word with multiple duplicate letters"),
                new TestCase(3, "aaaaa", "a", "All identical characters"),
                new TestCase(4, "abcdef", "abcdef", "All unique characters (no duplicates)"),
                new TestCase(5, "Java SDET 2026!", "Jav SDET206!", "Mixed case with spaces, digits, and punctuation"),
                new TestCase(6, "", "", "Empty string input"),
                new TestCase(7, null, null, "Null input safety check"),
                new TestCase(8, generateLargeString(1_000_000), "abcdefghijklmnopqrstuvwxyz", "Large stress test (1 Million characters)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: REMOVE DUPLICATE CHARACTERS PRESERVING ORDER");
        System.out.println("================================================================================");

        runApproach("1. LinkedHashSet Tracking", solver::removeDuplicatesLinkedHashSet, testCases);
        runApproach("2. Boolean Lookup Array (ASCII)", solver::removeDuplicatesBooleanArray, testCases);
        runApproach("3. Stream API distinct() & Collectors.joining()", solver::removeDuplicatesStream, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected output, and benchmarks execution duration.
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
                    (result != null && result.equals(tc.getExpected()));

            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Input:    %s\n",
                        tc.getInput() != null && tc.getInput().length() > 20 ? "[Large String]" : tc.getInput());
                System.out.printf("         Expected: \"%s\"\n", tc.getExpected());
                System.out.printf("         Actual:   \"%s\"\n", result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static String generateLargeString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append((char) ('a' + (i % 26)));
        }
        return sb.toString();
    }
}