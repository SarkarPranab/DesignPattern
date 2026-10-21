package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM EXP-54: FIRST MISSING POSITIVE
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an unsorted integer array `nums`, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in $O(N)$ time and uses $O(1)$ auxiliary space.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums = [1, 2, 0]
 *   Output: 3
 *   Explanation: The numbers in the range [1, 2] are all in the array.
 *
 * Example 2:
 *   Input:  nums = [3, 4, -1, 1]
 *   Output: 2
 *   Explanation: 1 is in the array but 2 is missing.
 *
 * Example 3:
 *   Input:  nums = [7, 8, 9, 11, 12]
 *   Output: 1
 *   Explanation: Smallest positive integer 1 is missing.
 *
 * CONSTRAINTS:
 * - 1 <= nums.length <= 10^5
 * - -2^31 <= nums[i] <= 2^31 - 1
 * ============================================================================
 */
public class FirstMissingPositive {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: In-Place Cyclic Sort / Index Marking (Optimal $O(N)$ Time, $O(1)$ Space)
     *
     * @implNote Place each number `x` (where $1 \le x \le N$) at its correct index `x - 1` by swapping.
     *           Then iterate through the array to find the first index `i` where `nums[i] != i + 1`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) auxiliary space
     */
    public int firstMissingPositiveCyclicSort(int[] nums) {
        // TODO: Write solution here
        return 1;
    }

    /**
     * Approach 2: HashSet Filtering ($O(N)$ Time, $O(N)$ Space)
     *
     * @implNote Store all positive integers in a HashSet, then check sequentially starting from 1
     *           until a missing integer is found.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public int firstMissingPositiveHashSet(int[] nums) {
        // TODO: Write solution here
        return 1;
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
        FirstMissingPositive solver = new FirstMissingPositive();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{1, 2, 0}, 3, "Standard missing positive at the end"),
                new TestCase(2, new int[]{3, 4, -1, 1}, 2, "Mixed positives and negatives with missing middle"),
                new TestCase(3, new int[]{7, 8, 9, 11, 12}, 1, "Only large positive numbers, 1 missing"),
                new TestCase(4, new int[]{1}, 2, "Single element array [1]"),
                new TestCase(5, new int[]{2, 1}, 3, "Consecutive elements starting from 1 missing last")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-54 FIRST MISSING POSITIVE");
        System.out.println("================================================================================");

        runApproach("1. In-Place Cyclic Sort (O(1) Space)", solver::firstMissingPositiveCyclicSort, testCases);
        runApproach("2. HashSet Filtering (O(N) Space)", solver::firstMissingPositiveHashSet, testCases);
    }

    /**
     * Executes test cases, compares actual missing positive against expected, and logs timing.
     */
    private static void runApproach(String name, Function<int[], Integer> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            // Pass a clone to allow in-place modification approaches without side effects across test runs
            int[] inputCopy = tc.getNums().clone();

            long startTime = System.nanoTime();
            int actual = method.apply(inputCopy);
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