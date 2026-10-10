package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.function.BiConsumer;

/**
 * ============================================================================
 * PROBLEM: ROTATE AN ARRAY BY K POSITIONS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array `nums` and an integer `k`, rotate the array to the right
 * by `k` steps, where `k` is non-negative.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums = [1, 2, 3, 4, 5], k = 2
 *   Output: [4, 5, 1, 2, 3]
 *   Explanation:
 *     Rotate 1 step right: [5, 1, 2, 3, 4]
 *     Rotate 2 steps right: [4, 5, 1, 2, 3]
 *
 * Example 2:
 *   Input:  nums = [-1, -100, 3, 99], k = 2
 *   Output: [3, 99, -1, -100]
 *
 * CONSTRAINTS:
 * - 0 <= nums.length <= 10^5
 * - 0 <= k <= 10^9 (k can be larger than array length; k = k % nums.length)
 * ============================================================================
 */
public class RotateArrayByKPositions {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Reversal Algorithm (Optimal)
     *
     * @implNote
     * 1. Normalize k: `k = k % n`.
     * 2. Reverse the entire array `[0 ... n - 1]`.
     * 3. Reverse the first `k` elements `[0 ... k - 1]`.
     * 4. Reverse the remaining `n - k` elements `[k ... n - 1]`.
     *
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) in-place
     */
    public void rotateReversalAlgorithm(int[] nums, int k) {
        // TODO: Write solution here
    }

    /**
     * Approach 2: Auxiliary Array Allocation
     *
     * @implNote Allocate a temporary array `temp` of size N. Copy element `nums[i]`
     *           to `temp[(i + k) % N]`. Copy `temp` contents back into `nums`.
     *
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public void rotateAuxiliaryArray(int[] nums, int k) {
        // TODO: Write solution here
    }

    /**
     * Approach 3: Left Rotation (Alternative Variant)
     *
     * @implNote Rotate array to the LEFT by k positions:
     *           Reverse `[0 ... k - 1]`, reverse `[k ... n - 1]`, then reverse `[0 ... n - 1]`.
     *
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) in-place
     */
    public void rotateLeftByK(int[] nums, int k) {
        // TODO: Write solution here
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] originalArray;
        private final int k;
        private final int[] expectedRightRotated;
        private final String description;

        public TestCase(int id, int[] originalArray, int k, int[] expectedRightRotated, String description) {
            this.id = id;
            this.originalArray = originalArray;
            this.k = k;
            this.expectedRightRotated = expectedRightRotated;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getOriginalArray() { return originalArray; }
        public int getK() { return k; }
        public int[] getExpectedRightRotated() { return expectedRightRotated; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        RotateArrayByKPositions solver = new RotateArrayByKPositions();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{1, 2, 3, 4, 5}, 2, new int[]{4, 5, 1, 2, 3}, "Standard right rotation by k=2"),
                new TestCase(2, new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100}, "Rotation with negative numbers"),
                new TestCase(3, new int[]{1, 2, 3, 4, 5}, 7, new int[]{4, 5, 1, 2, 3}, "k larger than array length (k=7, n=5 -> k%n=2)"),
                new TestCase(4, new int[]{1, 2, 3, 4, 5}, 0, new int[]{1, 2, 3, 4, 5}, "Zero rotation (k=0)"),
                new TestCase(5, new int[]{10}, 5, new int[]{10}, "Single element array"),
                new TestCase(6, new int[]{}, 3, new int[]{}, "Empty array input")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: ROTATE ARRAY BY K POSITIONS");
        System.out.println("================================================================================");

        runApproach("1. Reversal Algorithm (In-Place)", solver::rotateReversalAlgorithm, testCases);
        runApproach("2. Auxiliary Array Allocation", solver::rotateAuxiliaryArray, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected output, and benchmarks execution time.
     */
    private static void runApproach(String name, BiConsumer<int[], Integer> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int[] workingArray = (tc.getOriginalArray() != null) ? tc.getOriginalArray().clone() : null;

            long startTime = System.nanoTime();
            method.accept(workingArray, tc.getK());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Arrays.equals(workingArray, tc.getExpectedRightRotated());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Result:   %s\n", Arrays.toString(workingArray));
                System.out.printf("         Expected: %s\n", Arrays.toString(tc.getExpectedRightRotated()));
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}