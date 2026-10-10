package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.function.ToIntFunction;

/**
 * ============================================================================
 * PROBLEM: MAXIMUM PRODUCT OF THREE NUMBERS (OPTIMAL O(N) WITHOUT SORTING)
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array `nums`, find three numbers whose product is maximum
 * and return the maximum product WITHOUT using array sorting ($O(N)$ time complexity).
 *
 * KEY INSIGHT & INITIALIZATION:
 * To find the maximum product of 3 numbers in a single pass:
 * 1. Maintain 3 largest values: `max1 >= max2 >= max3`
 * 2. Maintain 2 smallest values: `min1 <= min2`
 *
 * Correct Initialization:
 * Initialize `max1, max2, max3` to `Integer.MIN_VALUE` and `min1, min2` to `Integer.MAX_VALUE`
 * to handle arrays containing negative numbers or zero correctly (avoiding default 0 issues).
 *
 * Formula:
 *   `Result = Math.max(max1 * max2 * max3, min1 * min2 * max1)`
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums = [-10, -3, 5, 6, -20]
 *   Tracked Maxima: max1 = 6, max2 = 5, max3 = -3
 *   Tracked Minima: min1 = -20, min2 = -10
 *   Result 1 (3 largest): 6 * 5 * (-3) = -90
 *   Result 2 (2 smallest negatives * largest positive): (-20) * (-10) * 6 = 1200
 *   Output: 1200
 *
 * Example 2:
 *   Input:  nums = [5, 2, 4, 0, 7]
 *   Output: 140 (7 * 5 * 4)
 *
 * CONSTRAINTS:
 * - 3 <= nums.length <= 10^6
 * - -1000 <= nums[i] <= 1000
 * ============================================================================
 */
public class MaximumProductOfThreeNumbersWithoutSorting {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Single-Pass Linear Pointer Scan (Optimal O(N) Time, O(1) Space)
     *
     * @implNote Iterate through `nums` once. Update `max1, max2, max3` when `n > max`
     *           and `min1, min2` when `n < min`. Return `Math.max(max1 * max2 * max3, min1 * min2 * max1)`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int maxProductLinearScan(int[] nums) {
        // TODO: Write single-pass tracking solution here
        return 0;
    }

    /**
     * Approach 2: Min-Heap & Max-Heap PriorityQueue
     *
     * @implNote Use a Min-Heap of size 3 to keep top 3 maximums and a Max-Heap
     *           of size 2 to keep top 2 minimums in a single pass.
     * @targetTimeComplexity O(N log 3) = O(N)
     * @targetSpaceComplexity O(1)
     */
    public int maxProductHeaps(int[] nums) {
        // TODO: Write heap-based solution here
        return 0;
    }

    /**
     * Approach 3: Dual-Scan (Separated Max/Min Passes)
     *
     * @implNote First pass finds top 3 largest elements, second pass finds top 2 smallest elements.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int maxProductDualPass(int[] nums) {
        // TODO: Write solution here
        return 0;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] nums;
        private final int expected;
        private final String description;

        public TestCase(int id, int[] nums, int expected, String description) {
            this.id = id;
            this.nums = nums;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getNums() { return nums; }
        public int getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        MaximumProductOfThreeNumbersWithoutSorting solver = new MaximumProductOfThreeNumbersWithoutSorting();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{-10, -3, 5, 6, -20}, 1200, "Negative numbers yielding highest product with largest positive"),
                new TestCase(2, new int[]{5, 2, 4, 0, 7}, 140, "All non-negative integers"),
                new TestCase(3, new int[]{7, 3, 2, 5}, 105, "Small array (4 elements)"),
                new TestCase(4, new int[]{-1, -2, -3, -4}, -6, "All negative integers"),
                new TestCase(5, new int[]{-100, -98, 1, 2, 3, 4}, 39200, "Large negative numbers option (-100 * -98 * 4)"),
                new TestCase(6, new int[]{0, 0, 0}, 0, "All zeros"),
                new TestCase(7, generateLargeArray(1_000_000), 999_970_000, "Large stress test (1 Million elements)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: MAXIMUM PRODUCT OF THREE NUMBERS (WITHOUT SORTING)");
        System.out.println("================================================================================");

        runApproach("1. Single-Pass Linear Scan (O(N) Time, O(1) Space)", solver::maxProductLinearScan, testCases);
        runApproach("2. PriorityQueue Heaps (O(N) Time, O(1) Space)", solver::maxProductHeaps, testCases);
        runApproach("3. Dual-Pass Scan", solver::maxProductDualPass, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected output, and logs timing.
     */
    private static void runApproach(String name, ToIntFunction<int[]> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int[] workingArray = (tc.getNums() != null) ? tc.getNums().clone() : null;

            long startTime = System.nanoTime();
            int result = method.applyAsInt(workingArray);
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = (result == tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Input:    %s\n",
                        tc.getNums() != null && tc.getNums().length > 15 ? "[Large Array]" : Arrays.toString(tc.getNums()));
                System.out.printf("         Expected: %d | Actual: %d\n", tc.getExpected(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static int[] generateLargeArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i - (size / 2);
        }
        return arr;
    }
}