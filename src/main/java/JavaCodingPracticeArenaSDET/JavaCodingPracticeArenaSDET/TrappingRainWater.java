package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM EXP-55: TRAPPING RAIN WATER
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given `n` non-negative integers representing an elevation map where the width of each
 * bar is 1, compute how much water it can trap after raining.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
 *   Output: 6
 *   Explanation: The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 *                In this case, 6 units of rain water are being trapped.
 *
 * Example 2:
 *   Input:  height = [4, 2, 0, 3, 2, 5]
 *   Output: 9
 *
 * CONSTRAINTS:
 * - n == height.length
 * - 1 <= n <= 2 * 10^4
 * - 0 <= height[i] <= 10^5
 * ============================================================================
 */
public class TrappingRainWater {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Two Pointers (Optimal $O(N)$ Time, $O(1)$ Auxiliary Space)
     *
     * @implNote Use `left` and `right` pointers moving inward, keeping track of `leftMax` and `rightMax`.
     *           Process the side with the smaller maximum height to guarantee water trapping capacity.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int trapTwoPointers(int[] height) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 2: Dynamic Programming with Prefix/Suffix Max Arrays ($O(N)$ Time, $O(N)$ Space)
     *
     * @implNote Precompute maximum heights to the left and right of every index using auxiliary arrays.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public int trapDP(int[] height) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 3: Monotonic Stack ($O(N)$ Time, $O(N)$ Space)
     *
     * @implNote Maintain a decreasing stack of indices. When a bar taller than the stack top is encountered,
     *           pop elements and compute trapped water layer by layer.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public int trapStack(int[] height) {
        // TODO: Write solution here
        return 0;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] height;
        private final int expected;
        private final String description;

        public TestCase(int id, int[] height, int expected, String description) {
            this.id = id;
            this.height = height;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getHeight() { return height; }
        public int getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        TrappingRainWater solver = new TrappingRainWater();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6, "Standard elevation map with multiple peaks"),
                new TestCase(2, new int[]{4, 2, 0, 3, 2, 5}, 9, "V-shaped depression with tall outer bounds"),
                new TestCase(3, new int[]{3, 0, 2, 0, 4}, 7, "Alternating zero troughs"),
                new TestCase(4, new int[]{2, 0, 2}, 2, "Simple single depression"),
                new TestCase(5, new int[]{1, 2, 3, 4, 5}, 0, "Strictly increasing elevation map (no water trapped)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-55 TRAPPING RAIN WATER");
        System.out.println("================================================================================");

        runApproach("1. Two Pointers (O(1) Space)", solver::trapTwoPointers, testCases);
        runApproach("2. Dynamic Programming (Prefix/Suffix Max)", solver::trapDP, testCases);
        runApproach("3. Monotonic Stack", solver::trapStack, testCases);
    }

    /**
     * Executes test cases, compares actual trapped water against expected, and logs timing.
     */
    private static void runApproach(String name, Function<int[], Integer> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            int actual = method.apply(tc.getHeight());
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