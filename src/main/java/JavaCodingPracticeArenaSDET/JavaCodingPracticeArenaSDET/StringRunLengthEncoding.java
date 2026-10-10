package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM: STRING RUN-LENGTH ENCODING / CHARACTER COMPRESSION
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a string `str`, perform basic string compression (Run-Length Encoding)
 * by replacing consecutive repeated characters with the character followed by
 * its count of consecutive occurrences.
 *
 * Note on standard snippet bug fix:
 * Care must be taken to flush the last group of characters (`str.charAt(N - 1)`
 * and its final `count`) after loop termination to avoid missing trailing characters!
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  str = "ddmmmmtta"
 *   Output: "d2m4t2a1"
 *   Explanation:
 *     'd' repeated 2 times -> "d2"
 *     'm' repeated 4 times -> "m4"
 *     't' repeated 2 times -> "t2"
 *     'a' repeated 1 time  -> "a1"
 *
 * Example 2:
 *   Input:  str = "aabcccccaaa"
 *   Output: "a2b1c5a3"
 *
 * Example 3:
 *   Input:  str = "a"
 *   Output: "a1"
 *
 * CONSTRAINTS:
 * - 0 <= str.length() <= 10^6
 * - `str` consists of uppercase/lowercase English letters, numbers, and special characters.
 * - Handles null and empty strings safely by returning an empty string or null.
 * ============================================================================
 */
public class StringRunLengthEncoding {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Iterative Single-Pass Loop with Tail Flush
     *
     * @implNote Iterate from `i = 1` to `N - 1`. Increment `count` when `str.charAt(i) == str.charAt(i - 1)`.
     *           Otherwise, append `str.charAt(i - 1)` and `count` to `StringBuilder` and reset `count = 1`.
     *           Crucially, append the final character group after the loop terminates.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) for StringBuilder output allocation
     */
    public String encodeIterativeWithTailFlush(String str) {
        // TODO: Write solution here
        return "";
    }

    /**
     * Approach 2: Two-Pointer / Sliding Window Character Grouping
     *
     * @implNote Use a start pointer `i` and end pointer `j` to scan consecutive identical
     *           character groups. Calculate group length `(j - i)`, append `str.charAt(i)`
     *           and `(j - i)` to `StringBuilder`, and set `i = j`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public String encodeTwoPointers(String str) {
        // TODO: Write solution here
        return "";
    }

    /**
     * Approach 3: Regex Pattern Matching & Matcher Group Replacement
     *
     * @implNote Match consecutive duplicate characters using regex pattern `"(.)\\1*"`
     *           and iterate through matched groups, appending `matcher.group(1)`
     *           along with `matcher.group(0).length()`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public String encodeRegex(String str) {
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
        StringRunLengthEncoding solver = new StringRunLengthEncoding();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "ddmmmmtta", "d2m4t2a1", "Standard string ending with single occurrence"),
                new TestCase(2, "aabcccccaaa", "a2b1c5a3", "Standard string ending with multiple occurrences"),
                new TestCase(3, "a", "a1", "Single character string"),
                new TestCase(4, "abcdef", "a1b1c1d1e1f1", "All unique characters (no consecutive repeats)"),
                new TestCase(5, "aaaaa", "a5", "All identical characters"),
                new TestCase(6, "", "", "Empty string input"),
                new TestCase(7, null, null, "Null input safety check"),
                new TestCase(8, generateLargeString(1_000_000), "a1000000", "Large stress test (1 Million identical characters)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: STRING RUN-LENGTH ENCODING");
        System.out.println("================================================================================");

        runApproach("1. Iterative Single-Pass with Tail Flush", solver::encodeIterativeWithTailFlush, testCases);
        runApproach("2. Two-Pointer Sliding Window", solver::encodeTwoPointers, testCases);
        runApproach("3. Regex Pattern Group Matching", solver::encodeRegex, testCases);
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
            sb.append('a');
        }
        return sb.toString();
    }
}