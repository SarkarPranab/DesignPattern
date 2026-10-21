package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

/**
 * ============================================================================
 * PROBLEM EXP-05: TWO SUM
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an array of integers `nums` and an integer `target`, return indices of
 * the two numbers such that they add up to `target`.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * You can return the answer in any order (by convention, sorted ascending indices).
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums = [2, 7, 11, 15], target = 9
 *   Output: [0, 1]
 *   Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 *   Input:  nums = [3, 2, 4], target = 6
 *   Output: [1, 2]
 *
 * Example 3:
 *   Input:  nums = [3, 3], target = 6
 *   Output: [0, 1]
 *
 * CONSTRAINTS:
 * - 2 <= nums.length <= 10^4
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= target <= 10^9
 * - Handles null and arrays with length < 2 safely by returning `new int[0]`.
 * ============================================================================
 */
public class TwoSum {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: One-Pass HashMap Lookup
     *
     * @implNote Iterate through `nums`. For each element, calculate `complement = target - nums[i]`.
     *           If `complement` exists in the `Map<Integer, Integer>`, return `new int[]{map.get(complement), i}`.
     *           Otherwise, put `(nums[i], i)` into the map.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public int[] twoSumOnePassHashMap(int[] nums, int target) {
        // TODO: Write solution here
        return new int[0];
    }

    /**
     * Approach 2: Two-Pointer Method on Indexed Class Array
     *
     * @implNote Store original indices alongside values in a custom element structure.
     *           Sort elements by value, then use two pointers (`left = 0`, `right = N - 1`)
     *           moving inward based on `sum < target` or `sum > target`.
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(N)
     */
    public int[] twoSumTwoPointers(int[] nums, int target) {
        // TODO: Write solution here
        return new int[0];
    }

    /**
     * Approach 3: Brute Force Nested Loop Traversal
     *
     * @implNote Use dual nested loops `i` and `j = i + 1` to check all pairs `nums[i] + nums[j] == target`.
     * @targetTimeComplexity O(N^2)
     * @targetSpaceComplexity O(1)
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        // TODO: Write solution here
        return new int[0];
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] nums;
        private final int target;
        private final int[] expected;
        private final String description;

        public TestCase(int id, int[] nums, int target, int[] expected, String description) {
            this.id = id;
            this.nums = nums;
            this.target = target;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getNums() { return nums; }
        public int getTarget() { return target; }
        public int[] getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        TwoSum solver = new TwoSum();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}, "Standard positive numbers"),
                new TestCase(2, new int[]{3, 2, 4}, 6, new int[]{1, 2}, "Unsorted array indices"),
                new TestCase(3, new int[]{3, 3}, 6, new int[]{0, 1}, "Duplicate values in array"),
                new TestCase(4, new int[]{-1, -2, -3, -4, -5}, -8, new int[]{2, 4}, "Negative numbers target"),
                new TestCase(5, new int[]{0, 4, 3, 0}, 0, new int[]{0, 3}, "Zeros in array"),
                new TestCase(6, new int[]{1}, 5, new int[0], "Single element array safety check"),
                new TestCase(7, null, 10, new int[0], "Null input safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-05 TWO SUM");
        System.out.println("================================================================================");

        runApproach("1. One-Pass HashMap Lookup", solver::twoSumOnePassHashMap, testCases);
        runApproach("2. Two-Pointer Sorting Verification", solver::twoSumTwoPointers, testCases);
        runApproach("3. Brute Force Nested Loop", solver::twoSumBruteForce, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected indices, and logs timing.
     */
    private static void runApproach(String name, BiFunction<int[], Integer, int[]> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int[] workingArray = (tc.getNums() != null) ? tc.getNums().clone() : null;

            long startTime = System.nanoTime();
            int[] result = method.apply(workingArray, tc.getTarget());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            if (result != null) {
                Arrays.sort(result);
            }

            boolean isCorrect = Arrays.equals(result, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Input:    %s, target = %d\n", Arrays.toString(tc.getNums()), tc.getTarget());
                System.out.printf("         Expected: %s | Actual: %s\n",
                        Arrays.toString(tc.getExpected()), Arrays.toString(result));
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}