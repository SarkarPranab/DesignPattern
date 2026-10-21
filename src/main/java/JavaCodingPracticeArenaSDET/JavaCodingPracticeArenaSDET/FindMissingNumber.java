package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.ToIntFunction;

/**
 * ============================================================================
 * PROBLEM EXP-08: FIND THE MISSING NUMBER FROM 1 TO N
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an array `nums` containing `n` distinct numbers taken from the range
 * `1` to `n + 1` (or `0` to `n`), find the single missing number from the sequence.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums = [1, 2, 4, 5, 6] (n = 5, expected range 1 to 6)
 *   Output: 3
 *
 * Example 2:
 *   Input:  nums = [3, 0, 1] (Range 0 to 3)
 *   Output: 2
 *
 * Example 3:
 *   Input:  nums = [1] (Range 1 to 2)
 *   Output: 2
 *
 * CONSTRAINTS:
 * - 1 <= nums.length <= 10^4
 * - All numbers in `nums` are unique.
 * - Handles null and empty arrays safely by returning `-1`.
 * ============================================================================
 */
public class FindMissingNumber {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Gauss Sum Formula (Arithmetic Series Math)
     *
     * @implNote Calculate total expected sum using `totalSum = (N * (N + 1)) / 2`
     *           where N = nums.length + 1. Subtract each element in `nums` from `totalSum`.
     *           The remaining difference is the missing number.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int findMissingGaussSum(int[] nums) {
        // TODO: Write solution here
        return -1;
    }

    /**
     * Approach 2: Bitwise XOR Operator Logic
     *
     * @implNote XOR all numbers from 1 to N, and XOR all elements present in `nums`.
     *           Since `a ^ a = 0` and `a ^ 0 = a`, all numbers present twice cancel
     *           out, leaving the missing number. Prevents integer overflow.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int findMissingXOR(int[] nums) {
        // TODO: Write solution here
        return -1;
    }

    /**
     * Approach 3: HashSet Lookup Buffer
     *
     * @implNote Add all elements of `nums` into a `Set<Integer>`. Iterate from 1 to N,
     *           and return the first integer not present in the set.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public int findMissingHashSet(int[] nums) {
        // TODO: Write solution here
        return -1;
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
        FindMissingNumber solver = new FindMissingNumber();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{1, 2, 4, 5, 6}, 3, "Missing number in middle (range 1 to 6)"),
                new TestCase(2, new int[]{2, 3, 4, 5}, 1, "Missing first number in sequence"),
                new TestCase(3, new int[]{1, 2, 3, 4}, 5, "Missing last number in sequence"),
                new TestCase(4, new int[]{1}, 2, "Single element array missing 2"),
                new TestCase(5, new int[]{}, -1, "Empty array safety check"),
                new TestCase(6, null, -1, "Null input safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-08 FIND MISSING NUMBER");
        System.out.println("================================================================================");

        runApproach("1. Gauss Sum Formula", solver::findMissingGaussSum, testCases);
        runApproach("2. Bitwise XOR Operator Logic", solver::findMissingXOR, testCases);
        runApproach("3. HashSet Lookup Buffer", solver::findMissingHashSet, testCases);
    }

    /**
     * Executes test cases, compares actual missing integer result, and logs timing.
     */
    private static void runApproach(String name, ToIntFunction<int[]> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            int result = method.applyAsInt(tc.getNums());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = (result == tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Input:    %s\n", Arrays.toString(tc.getNums()));
                System.out.printf("         Expected: %d | Actual: %d\n", tc.getExpected(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}