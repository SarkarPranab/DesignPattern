package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.function.ToIntFunction;

/**
 * ============================================================================
 * PROBLEM: MAXIMUM PRODUCT OF THREE NUMBERS (LEETCODE 628)
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array `nums`, find three numbers whose product is maximum
 * and return the maximum product.
 *
 * KEY INSIGHT:
 * The maximum product of three numbers in an array can occur in only two scenarios:
 *   1. Product of the three largest numbers: `max1 * max2 * max3`
 *   2. Product of the two smallest (most negative) numbers and the single largest number: `min1 * min2 * max1`
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums = [-10, -3, 5, 6, -20]
 *   Sorted: [-20, -10, -3, 5, 6]
 *   Option 1 (3 largest): 6 * 5 * -3 = -90
 *   Option 2 (2 smallest negatives * largest): -20 * -10 * 6 = 1200
 *   Output: 1200
 *
 * Example 2:
 *   Input:  nums = [1, 2, 3, 4]
 *   Output: 24 (2 * 3 * 4)
 *
 * Example 3:
 *   Input:  nums = [-1, -2, -3, -4]
 *   Output: -6 (-1 * -2 * -3)
 *
 * CONSTRAINTS:
 * - 3 <= nums.length <= 10^5
 * - -1000 <= nums[i] <= 1000
 * ============================================================================
 */
public class MaximumProductOfThreeNumbers {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Array Sorting
     *
     * @implNote Sort array in ascending order. Compare product of 3 largest elements
     *           (`nums[n-1] * nums[n-2] * nums[n-3]`) against 2 smallest + 1 largest
     *           (`nums[0] * nums[1] * nums[n-1]`).
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(1) or O(log N) space depending on sort implementation
     */
    public int maxProductSorting(int[] nums) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 2: Single-Pass Linear Scan (Optimal O(N) Time, O(1) Space)
     *
     * @implNote Iterate through array in a single pass while tracking 3 maximums
     *           (`max1, max2, max3`) and 2 minimums (`min1, min2`). Return
     *           `Math.max(max1 * max2 * max3, min1 * min2 * max1)`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int maxProductSinglePass(int[] nums) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 3: Stream API Sorting (Declarative Style)
     *
     * @implNote Use `Arrays.stream(nums).sorted().toArray()` to obtain sorted array,
     *           then apply max product choice formula.
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(N)
     */
    public int maxProductStream(int[] nums) {
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
        MaximumProductOfThreeNumbers solver = new MaximumProductOfThreeNumbers();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{-10, -3, 5, 6, -20}, 1200, "Negative numbers yielding highest product with largest positive"),
                new TestCase(2, new int[]{5, 2, 4, 0, 7}, 140, "All non-negative integers"),
                new TestCase(3, new int[]{1, 2, 3, 4}, 24, "Standard small increasing array"),
                new TestCase(4, new int[]{-1, -2, -3, -4}, -6, "All negative integers"),
                new TestCase(5, new int[]{-100, -98, 1, 2, 3, 4}, 39200, "Large negative numbers option (-100 * -98 * 4)"),
                new TestCase(6, new int[]{-10, -20, -30}, -6000, "Exactly three negative elements"),
                new TestCase(7, generateLargeArray(100_000), 999_970_000, "Large stress test (100k elements)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: MAXIMUM PRODUCT OF THREE NUMBERS");
        System.out.println("================================================================================");

        runApproach("1. Array Sorting (O(N log N) Time)", solver::maxProductSorting, testCases);
        runApproach("2. Single-Pass Linear Scan (O(N) Time, O(1) Space)", solver::maxProductSinglePass, testCases);
        runApproach("3. Java Stream API Sorting", solver::maxProductStream, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected output, and logs execution timing.
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