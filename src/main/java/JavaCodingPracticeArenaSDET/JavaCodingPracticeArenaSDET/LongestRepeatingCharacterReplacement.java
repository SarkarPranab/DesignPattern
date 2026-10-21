package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.function.BiFunction;

/**
 * ============================================================================
 * PROBLEM EXP-47: LONGEST REPEATING CHARACTER REPLACEMENT
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * You are given a string `s` and an integer `k`. You can choose any character of
 * the string and change it to any other uppercase English character. You can perform
 * this operation at most `k` times.
 *
 * Return the length of the longest substring containing the same letter you can get
 * after performing the above operations.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  s = "ABAB", k = 2
 *   Output: 4
 *   Explanation: Replace the two 'A's with two 'B's or vice versa.
 *
 * Example 2:
 *   Input:  s = "AABABBA", k = 1
 *   Output: 4
 *   Explanation: Replace the 'B' in the middle with 'A' to form "A A A A B B A".
 *                The substring "AAAA" has the longest repeating letters, which is 4.
 *
 * CONSTRAINTS:
 * - 1 <= s.length <= 10^5
 * - `s` consists of only uppercase English letters.
 * - 0 <= k <= s.length
 * ============================================================================
 */
public class LongestRepeatingCharacterReplacement {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Optimized Sliding Window with Frequency Tracker (Optimal $O(N)$ Time)
     *
     * @implNote Maintain a sliding window `[left, right]` and a frequency array for characters 'A'-'Z'.
     *           Keep track of `maxCount`, the frequency of the most frequent character in the current window.
     *           If `(windowLength - maxCount) > k`, the window is invalid; increment `left` to shrink it.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) fixed 26-element character frequency array
     */
    public int characterReplacementSlidingWindow(String s, int k) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 2: Sliding Window with Dynamic Max Frequency Optimization
     *
     * @implNote Similar to Approach 1, but explicitly optimizing window expansion without shrinking `maxCount`,
     *           yielding maximum possible valid window size tracking.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int characterReplacementOptimized(String s, int k) {
        // TODO: Write solution here
        return 0;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String s;
        private final int k;
        private final int expected;
        private final String description;

        public TestCase(int id, String s, int k, int expected, String description) {
            this.id = id;
            this.s = s;
            this.k = k;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getS() { return s; }
        public int getK() { return k; }
        public int getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solver = new LongestRepeatingCharacterReplacement();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "ABAB", 2, 4, "Standard replacement with k=2"),
                new TestCase(2, "AABABBA", 1, 4, "Middle replacement with k=1"),
                new TestCase(3, "AAAA", 0, 4, "Zero replacements needed for identical string"),
                new TestCase(4, "A", 0, 1, "Single character string check"),
                new TestCase(5, "ABAA", 0, 2, "Zero k with adjacent duplicate check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-47 LONGEST REPEATING CHARACTER REPLACEMENT");
        System.out.println("================================================================================");

        runApproach("1. Optimized Sliding Window with Frequency Tracker", solver::characterReplacementSlidingWindow, testCases);
        runApproach("2. Sliding Window Dynamic Max Frequency", solver::characterReplacementOptimized, testCases);
    }

    /**
     * Executes test cases, compares actual max length against expected, and logs timing.
     */
    private static void runApproach(String name, BiFunction<String, Integer, Integer> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            int actual = method.apply(tc.getS(), tc.getK());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = (actual == tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected: %d | Actual: %d\n", tc.getExpected(), actual);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}