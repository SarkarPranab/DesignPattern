package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Objects;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM: REVERSE THE FIRST WORD OF A STRING
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a space-separated sentence string `words`, reverse the character order
 * of ONLY the first word while leaving all subsequent words and spacing intact.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  words = "Hello World from Java"
 *   Output: "olleH World from Java"
 *   Explanation: "Hello" is reversed to "olleH", rest of the string remains unchanged.
 *
 * Example 2:
 *   Input:  words = "Automation"
 *   Output: "noitamotuA"
 *   Explanation: Single word input, entire word is reversed.
 *
 * Example 3:
 *   Input:  words = "a b c"
 *   Output: "a b c"
 *
 * CONSTRAINTS:
 * - 0 <= words.length() <= 10^5
 * - Handle null, empty, single-word, and multi-word inputs safely.
 * - Preserve exact whitespace separators between the first word and remainder.
 * ============================================================================
 */
public class ReverseFirstWordOfString {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Limited Regex Split (limit=2) & Two-Pointer Char Array Reversal
     *
     * @implNote Split string using `words.split("\\s+", 2)`. Reverse `arr[0]`
     *           in-place using two pointers (`left` and `right`), then concatenate
     *           with `arr[1]` if present.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public String reverseFirstWordTwoPointer(String words) {
        // TODO: Write solution here
        return "";
    }

    /**
     * Approach 2: Limited Split & StringBuilder.reverse()
     *
     * @implNote Split by first whitespace boundary `words.split("\\s+", 2)`.
     *           Reverse `arr[0]` using `new StringBuilder(arr[0]).reverse()`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public String reverseFirstWordStringBuilder(String words) {
        // TODO: Write solution here
        return "";
    }

    /**
     * Approach 3: Substring Index Scan (Zero Regex Split Allocations)
     *
     * @implNote Locate first space using `words.indexOf(' ')`. If found, reverse
     *           substring `[0 ... spaceIndex)` and append `words.substring(spaceIndex)`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) avoiding array allocation from regex split
     */
    public String reverseFirstWordIndexScan(String words) {
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
        ReverseFirstWordOfString solver = new ReverseFirstWordOfString();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Hello World from Java", "olleH World from Java", "Standard multi-word sentence"),
                new TestCase(2, "Automation", "noitamotuA", "Single-word string without spaces"),
                new TestCase(3, "a b c", "a b c", "Single-character words"),
                new TestCase(4, "SDET 2026 Prep", "TEDS 2026 Prep", "Alphanumeric string"),
                new TestCase(5, "", "", "Empty string input"),
                new TestCase(6, null, null, "Null input safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: REVERSE FIRST WORD OF STRING");
        System.out.println("================================================================================");

        runApproach("1. Split(limit=2) & Two-Pointer Char Array Reversal", solver::reverseFirstWordTwoPointer, testCases);
        runApproach("2. Split(limit=2) & StringBuilder.reverse()", solver::reverseFirstWordStringBuilder, testCases);
        runApproach("3. Zero-Allocation Index Scan & Substring Reversal", solver::reverseFirstWordIndexScan, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected output, and logs execution timing.
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

            boolean isCorrect = Objects.equals(result, tc.getExpected());
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