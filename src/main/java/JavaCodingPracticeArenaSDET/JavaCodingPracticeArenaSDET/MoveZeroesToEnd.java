package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;

/**
 * ============================================================================
 * PROBLEM EXP-07: MOVE ZEROES TO END
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array `nums`, move all `0`s to the end of it while maintaining
 * the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums = [0, 1, 0, 3, 12]
 *   Output: [1, 3, 12, 0, 0]
 *
 * Example 2:
 *   Input:  nums = [0]
 *   Output: [0]
 *
 * Example 3:
 *   Input:  nums = [4, 2, 4, 0, 0, 3, 0, 5, 1, 0]
 *   Output: [4, 2, 4, 3, 5, 1, 0, 0, 0, 0]
 *
 * CONSTRAINTS:
 * - 1 <= nums.length <= 10^4
 * - -2^31 <= nums[i] <= 2^31 - 1
 * - Handles null and empty arrays safely.
 * ============================================================================
 */
public class MoveZeroesToEnd {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Two-Pointer Overwrite and Zero-Fill (Optimal)
     *
     * @implNote Maintain a write pointer `lastNonZeroFoundAt = 0`. Iterate through
     *           `nums` with `i`. When `nums[i] != 0`, write `nums[lastNonZeroFoundAt++] = nums[i]`.
     *           After the loop, fill remaining indices from `lastNonZeroFoundAt` to `nums.length - 1` with 0.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) in-place
     */
    public void moveZeroesTwoPointerFill(int[] nums) {
        // TODO: Write solution here
    }

    /**
     * Approach 2: Two-Pointer Swap (Single Pass)
     *
     * @implNote Maintain pointer `lastNonZeroFoundAt = 0`. Whenever `nums[i] != 0`,
     *           swap `nums[i]` with `nums[lastNonZeroFoundAt]` and increment `lastNonZeroFoundAt`.
     * @targetTimeComplexity O(N) single pass
     * @targetSpaceComplexity O(1) in-place
     */
    public void moveZeroesTwoPointerSwap(int[] nums) {
        // TODO: Write solution here
    }

    /**
     * Approach 3: Temporary Buffer Array Copy
     *
     * @implNote Allocate a temporary array `temp = new int[nums.length]`. Copy non-zero
     *           elements sequentially into `temp`, then copy `temp` back into `nums`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) auxiliary space
     */
    public void moveZeroesWithBuffer(int[] nums) {
        // TODO: Write solution here
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

    @FunctionalInterface
    interface MoveZeroesMethod {
        void execute(int[] nums);
    }

    public static void main(String[] args) {
        MoveZeroesToEnd solver = new MoveZeroesToEnd();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}, "Standard array with mixed zeroes"),
                new TestCase(2, new int[]{0}, new int[]{0}, "Single zero element"),
                new TestCase(3, new int[]{1, 2, 3}, new int[]{1, 2, 3}, "No zeroes present"),
                new TestCase(4, new int[]{0, 0, 0}, new int[]{0, 0, 0}, "All zeroes present"),
                new TestCase(5, new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0}, new int[]{4, 2, 4, 3, 5, 1, 0, 0, 0, 0}, "Multiple consecutive zeroes"),
                new TestCase(6, new int[]{}, new int[]{}, "Empty array check"),
                new TestCase(7, null, null, "Null input safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-07 MOVE ZEROES TO END");
        System.out.println("================================================================================");

        runApproach("1. Two-Pointer Overwrite and Zero-Fill", solver::moveZeroesTwoPointerFill, testCases);
        runApproach("2. Two-Pointer Swap (Single Pass)", solver::moveZeroesTwoPointerSwap, testCases);
        runApproach("3. Temporary Buffer Array Copy", solver::moveZeroesWithBuffer, testCases);
    }

    /**
     * Executes test cases, compares modified array against expected results, and logs timing.
     */
    private static void runApproach(String name, MoveZeroesMethod method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int[] workingNums = (tc.getNums() != null) ? tc.getNums().clone() : null;

            long startTime = System.nanoTime();
            method.execute(workingNums);
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Arrays.equals(workingNums, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected: %s | Actual: %s\n",
                        Arrays.toString(tc.getExpected()), Arrays.toString(workingNums));
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}