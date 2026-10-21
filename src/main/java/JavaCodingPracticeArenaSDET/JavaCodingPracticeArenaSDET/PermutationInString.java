package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * ============================================================================
 * PROBLEM EXP-48: PERMUTATION IN STRING
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given two strings `s1` and `s2`, return `true` if `s2` contains a permutation of `s1`,
 * or `false` otherwise.
 *
 * In other words, return `true` if one of `s1`'s permutations is the substring of `s2`.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  s1 = "ab", s2 = "eidbaooo"
 *   Output: true
 *   Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Example 2:
 *   Input:  s1 = "ab", s2 = "eidboaoo"
 *   Output: false
 *
 * CONSTRAINTS:
 * - 1 <= s1.length, s2.length <= 10^4
 * - `s1` and `s2` consist of lowercase English letters.
 * ============================================================================
 */
public class PermutationInString {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Sliding Window Frequency Array Comparison (Optimal $O(N)$ Time)
     *
     * @implNote Maintain a fixed-size sliding window of length `s1.length()` over `s2`.
     *           Compare character frequency arrays of size 26 in $O(1)$ time per window slide.
     * @targetTimeComplexity O(N) where N is length of s2
     * @targetSpaceComplexity O(1) constant frequency array space
     */
    public boolean checkInclusionSlidingWindow(String s1, String s2) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 2: Sliding Window with Match Count Optimization
     *
     * @implNote Track the number of characters whose frequencies match between `s1` and the current
     *           sliding window in `s2`, updating incrementally in $O(1)$ per step.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public boolean checkInclusionOptimized(String s1, String s2) {
        // TODO: Write solution here
        return false;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String s1;
        private final String s2;
        private final boolean expected;
        private final String description;

        public TestCase(int id, String s1, String s2, boolean expected, String description) {
            this.id = id;
            this.s1 = s1;
            this.s2 = s2;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getS1() { return s1; }
        public String getS2() { return s2; }
        public boolean getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        PermutationInString solver = new PermutationInString();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "ab", "eidbaooo", true, "Permutation 'ba' present inside s2"),
                new TestCase(2, "ab", "eidboaoo", false, "No permutation of s1 present in s2"),
                new TestCase(3, "adc", "dcda", true, "Permutation 'cda' present in s2"),
                new TestCase(4, "a", "ab", true, "Single character match at start"),
                new TestCase(5, "hello", "ooolleoooleh", false, "Length mismatch and non-matching counts")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-48 PERMUTATION IN STRING");
        System.out.println("================================================================================");

        runApproach("1. Sliding Window Frequency Array Comparison", solver::checkInclusionSlidingWindow, testCases);
        runApproach("2. Sliding Window Match Count Optimization", solver::checkInclusionOptimized, testCases);
    }

    /**
     * Executes test cases, compares actual boolean result against expected, and logs timing.
     */
    private static void runApproach(String name, BiFunction<String, String, Boolean> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            boolean actual = method.apply(tc.getS1(), tc.getS2());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = (actual == tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected: %b | Actual: %b\n", tc.getExpected(), actual);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}