package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM EXP-53: PRODUCT OF ARRAY EXCEPT SELF
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to
 * the product of all the elements of `nums` except `nums[i]`.
 *
 * The product of any prefix or suffix of `nums` is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in $O(N)$ time and without using the division operation.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums = [1, 2, 3, 4]
 *   Output: [24, 12, 8, 6]
 *
 * Example 2:
 *   Input:  nums = [-1, 1, 0, -3, 3]
 *   Output: [0, 0, 9, 0, 0]
 *
 * CONSTRAINTS:
 * - 2 <= nums.length <= 10^5
 * - -30 <= nums[i] <= 30
 * - The product of any prefix or suffix of `nums` is guaranteed to fit in a 32-bit integer.
 * ============================================================================
 */
public class ProductOfArrayExceptSelf {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Left and Right Product Passes (Optimal $O(N)$ Time, $O(1)$ Auxiliary Space)
     *
     * @implNote Use the result array to store running left-side products, then iterate backwards
     *           from the right to multiply running right-side products in place.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) auxiliary space (excluding result array)
     */
    public int[] productExceptSelfOptimized(int[] nums) {
        // TODO: Write solution here
        return new int[0];
    }

    /**
     * Approach 2: Left and Right Prefix/Suffix Arrays ($O(N)$ Time, $O(N)$ Space)
     *
     * @implNote Explicitly construct separate `leftProducts` and `rightProducts` arrays,
     *           then combine them for each index.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public int[] productExceptSelfArrays(int[] nums) {
        // TODO: Write solution here
        return new int[0];
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] nums;
        private final int[] expected;
        private final String description;

        public TestCase(int id, int[] nums, int[] expected, String description) {
            this.id = id;
            this.nums = nums;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getNums() { return nums; }
        public int[] getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solver = new ProductOfArrayExceptSelf();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}, "Standard array product except self"),
                new TestCase(2, new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0}, "Array containing a zero element"),
                new TestCase(3, new int[]{2, 3}, new int[]{3, 2}, "Minimum length array check"),
                new TestCase(4, new int[]{0, 0}, new int[]{0, 0}, "Multiple zeros array check"),
                new TestCase(5, new int[]{4, 5, 1, 8, 2}, new int[]{80, 64, 320, 40, 160}, "Mixed positive integer elements")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-53 PRODUCT OF ARRAY EXCEPT SELF");
        System.out.println("================================================================================");

        runApproach("1. Left and Right Product Passes (O(1) Space)", solver::productExceptSelfOptimized, testCases);
        runApproach("2. Left and Right Prefix/Suffix Arrays", solver::productExceptSelfArrays, testCases);
    }

    /**
     * Executes test cases, compares actual product array against expected, and logs timing.
     */
    private static void runApproach(String name, Function<int[], int[]> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            int[] actual = method.apply(tc.getNums());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Arrays.equals(actual, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected: %s\n", Arrays.toString(tc.getExpected()));
                System.out.printf("         Actual:   %s\n", Arrays.toString(actual));
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}