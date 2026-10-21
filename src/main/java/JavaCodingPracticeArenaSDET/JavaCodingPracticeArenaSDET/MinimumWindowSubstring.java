package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

/**
 * ============================================================================
 * PROBLEM EXP-45: MINIMUM WINDOW SUBSTRING
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given two strings `s` and `t` of lengths `m` and `n` respectively, return the minimum window
 * substring of `s` such that every character in `t` (including duplicates) is included in the window.
 * If there is no such substring, return the empty string `""`.
 *
 * The testcases will be generated such that the answer is unique.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  s = "ADOBECODEBANC", t = "ABC"
 *   Output: "BANC"
 *   Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 *
 * Example 2:
 *   Input:  s = "a", t = "a"
 *   Output: "a"
 *   Explanation: The entire string s is the minimum window.
 *
 * Example 3:
 *   Input:  s = "a", t = "aa"
 *   Output: ""
 *   Explanation: Both 'a's from t must be included in the window, but s only has one 'a'.
 *
 * CONSTRAINTS:
 * - m == s.length
 * - n == t.length
 * - 1 <= m, n <= 10^5
 * - s and t consist of uppercase and lowercase English letters.
 * ============================================================================
 */
public class MinimumWindowSubstring {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Sliding Window with Frequency Map / Hash Array (Optimal $O(N)$ Time, $O(1)$ Space)
     *
     * @implNote Use two pointers (`left` and `right`) to form a sliding window. Expand `right` until
     *           all characters of `t` are covered. Then contract `left` as much as possible while keeping
     *           the window valid, updating the minimum window length and start index.
     * @targetTimeComplexity O(M + N)
     * @targetSpaceComplexity O(1) assuming fixed alphabet size (or O(N) auxiliary space)
     */
    public String minWindow(String s, String t) {
        // TODO: Write solution here
        return "";
    }

    /**
     * Approach 2: Filtered Sliding Window
     *
     * @implNote Extract all indices in `s` that match characters present in `t`, then apply the
     *           sliding window technique specifically on the filtered index sequence.
     * @targetTimeComplexity O(M + N)
     * @targetSpaceComplexity O(M)
     */
    public String minWindowFiltered(String s, String t) {
        // TODO: Write solution here
        return "";
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String s;
        private final String t;
        private final String expected;
        private final String description;

        public TestCase(int id, String s, String t, String expected, String description) {
            this.id = id;
            this.s = s;
            this.t = t;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getS() { return s; }
        public String getT() { return t; }
        public String getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solver = new MinimumWindowSubstring();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "ADOBECODEBANC", "ABC", "BANC", "Standard minimum window containing all target chars"),
                new TestCase(2, "a", "a", "a", "Single character exact match"),
                new TestCase(3, "a", "aa", "", "Target requires more duplicates than available in s"),
                new TestCase(4, "ab", "A", "", "Case-sensitive non-matching target"),
                new TestCase(5, "cbaebabacd", "abc", "cba", "Multiple valid windows with optimal minimum")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-45 MINIMUM WINDOW SUBSTRING");
        System.out.println("================================================================================");

        runApproach("1. Sliding Window with Frequency Tracker", solver::minWindow, testCases);
        runApproach("2. Filtered Sliding Window", solver::minWindowFiltered, testCases);
    }

    /**
     * Executes test cases, compares actual minimum window substring against expected, and logs timing.
     */
    private static void runApproach(String name, BiFunction<String, String, String> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            String actual = method.apply(tc.getS(), tc.getT());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Objects.equals(actual, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected: \"%s\"\n", tc.getExpected());
                System.out.printf("         Actual:   \"%s\"\n", actual);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}