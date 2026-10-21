package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * ============================================================================
 * PROBLEM EXP-10: BINARY SEARCH
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an array of integers `nums` which is sorted in ascending order, and an
 * integer `target`, write a function to search `target` in `nums`. If `target`
 * exists, then return its index. Otherwise, return `-1`.
 *
 * You must write an algorithm with `O(log n)` runtime complexity.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums = [-1, 0, 3, 5, 9, 12], target = 9
 *   Output: 4
 *   Explanation: 9 exists in nums and its index is 4.
 *
 * Example 2:
 *   Input:  nums = [-1, 0, 3, 5, 9, 12], target = 2
 *   Output: -1
 *   Explanation: 2 does not exist in nums so return -1.
 *
 * CONSTRAINTS:
 * - 1 <= nums.length <= 10^4
 * - -10^4 <= nums[i], target <= 10^4
 * - All integers in `nums` are unique.
 * - `nums` is sorted in ascending order.
 * - Handles null and empty arrays safely by returning `-1`.
 * ============================================================================
 */
public class BinarySearch {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Iterative Binary Search (Optimal Space)
     *
     * @implNote Maintain pointers `left = 0` and `right = nums.length - 1`. While `left <= right`,
     *           calculate overflow-safe midpoint `mid = left + (right - left) / 2`.
     *           Adjust `left = mid + 1` or `right = mid - 1` based on value comparison.
     * @targetTimeComplexity O(log N)
     * @targetSpaceComplexity O(1)
     */
    public int searchIterative(int[] nums, int target) {
        // TODO: Write solution here
        return -1;
    }

    /**
     * Approach 2: Recursive Binary Search
     *
     * @implNote Pass `left` and `right` indices into a recursive helper function. Base cases:
     *           `left > right` returns `-1`, `nums[mid] == target` returns `mid`.
     * @targetTimeComplexity O(log N)
     * @targetSpaceComplexity O(log N) recursion call stack memory
     */
    public int searchRecursive(int[] nums, int target) {
        // TODO: Write solution here
        return -1;
    }

    /**
     * Approach 3: Standard JDK Utility Wrapper (`Arrays.binarySearch`)
     *
     * @implNote Use `Arrays.binarySearch(nums, target)`. If returned index is `>= 0`, return it;
     *           otherwise return `-1`.
     * @targetTimeComplexity O(log N)
     * @targetSpaceComplexity O(1)
     */
    public int searchJDKUtility(int[] nums, int target) {
        // TODO: Write solution here
        return -1;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] nums;
        private final int target;
        private final int expected;
        private final String description;

        public TestCase(int id, int[] nums, int target, int expected, String description) {
            this.id = id;
            this.nums = nums;
            this.target = target;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getNums() { return nums; }
        public int getTarget() { return target; }
        public int getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        BinarySearch solver = new BinarySearch();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{-1, 0, 3, 5, 9, 12}, 9, 4, "Target present in right half"),
                new TestCase(2, new int[]{-1, 0, 3, 5, 9, 12}, 2, -1, "Target missing from array"),
                new TestCase(3, new int[]{5}, 5, 0, "Single element match"),
                new TestCase(4, new int[]{5}, 10, -1, "Single element mismatch"),
                new TestCase(5, new int[]{1, 3, 5, 7, 9, 11}, 1, 0, "Target at left boundary"),
                new TestCase(6, new int[]{1, 3, 5, 7, 9, 11}, 11, 5, "Target at right boundary"),
                new TestCase(7, new int[]{}, 5, -1, "Empty array safety check"),
                new TestCase(8, null, 5, -1, "Null input safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-10 BINARY SEARCH");
        System.out.println("================================================================================");

        runApproach("1. Iterative Binary Search", solver::searchIterative, testCases);
        runApproach("2. Recursive Binary Search", solver::searchRecursive, testCases);
        runApproach("3. JDK Utility Wrapper (Arrays.binarySearch)", solver::searchJDKUtility, testCases);
    }

    /**
     * Executes test cases, compares actual index result against expected, and logs timing.
     */
    private static void runApproach(String name, BiFunction<int[], Integer, Integer> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            int result = method.apply(tc.getNums(), tc.getTarget());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = (result == tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Input:    %s, target = %d\n", Arrays.toString(tc.getNums()), tc.getTarget());
                System.out.printf("         Expected: %d | Actual: %d\n", tc.getExpected(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}