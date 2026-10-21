package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM EXP-59: SUBARRAY SUM EQUALS K
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array `nums` and an integer `k`, return the total number of contiguous
 * subarrays whose sum equals `k`. The array may contain negative numbers and zeros.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums = [1, 1, 1], k = 2
 *   Output: 2
 * Example 2:
 *   Input:  nums = [1, 2, 3], k = 3
 *   Output: 2   ([1, 2] and [3])
 *
 * CONSTRAINTS:
 * - 1 <= nums.length <= 2 * 10^4
 * - -1000 <= nums[i] <= 1000
 * - -10^7 <= k <= 10^7
 * - Null input returns 0.
 * ============================================================================
 */
public class SubarraySumEqualsK {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Brute Force With Running Sum
     *
     * @implNote For every start index extend the end index while keeping a running sum.
     * @targetTimeComplexity O(N^2)
     * @targetSpaceComplexity O(1)
     */
    public int subarraySumBruteForce(int[] nums, int k) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 2: Prefix Sum Array (Pair Check)
     *
     * @implNote Build prefix[]; a subarray (i, j] sums to k when prefix[j] - prefix[i] == k.
     * @targetTimeComplexity O(N^2)
     * @targetSpaceComplexity O(N)
     */
    public int subarraySumPrefixArray(int[] nums, int k) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 3: Prefix Sum With HashMap (Optimal)
     *
     * @implNote Store how often each prefix sum has occurred; add seen[sum - k] at every index.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public int subarraySumHashMap(int[] nums, int k) {
        // TODO: Write solution here
        return 0;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    @FunctionalInterface
    interface Solver {
        int solve(int[] nums, int k);
    }

    static class TestCase {
        private final int id;
        private final String description;
        private final int[] nums;
        private final int k;
        private final int expected;

        public TestCase(int id, String description, int[] nums, int k, int expected) {
            this.id = id;
            this.description = description;
            this.nums = nums;
            this.k = k;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solver = new SubarraySumEqualsK();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "All ones", new int[]{1, 1, 1}, 2, 2),
                new TestCase(2, "Distinct positives", new int[]{1, 2, 3}, 3, 2),
                new TestCase(3, "Zeros and negatives", new int[]{1, -1, 0}, 0, 3),
                new TestCase(4, "Single element match", new int[]{1}, 1, 1),
                new TestCase(5, "Mixed signs", new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7, 4),
                new TestCase(6, "No match", new int[]{1, 2}, 10, 0),
                new TestCase(7, "Null input safety check", null, 0, 0)
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-59 SUBARRAY SUM EQUALS K");
        System.out.println("================================================================================");

        runApproach("1. Brute Force With Running Sum", solver::subarraySumBruteForce, testCases);
        runApproach("2. Prefix Sum Array (Pair Check)", solver::subarraySumPrefixArray, testCases);
        runApproach("3. Prefix Sum With HashMap (Optimal)", solver::subarraySumHashMap, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected output, and logs timing.
     */
    private static void runApproach(String name, Solver method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int result = 0;
            boolean threw = false;
            long startTime = System.nanoTime();
            try {
                result = method.solve(tc.nums == null ? null : tc.nums.clone(), tc.k);
            } catch (RuntimeException e) {
                threw = true;
            }
            long durationNano = System.nanoTime() - startTime;
            totalDurationNano += durationNano;

            boolean isCorrect = !threw && Objects.deepEquals(result, tc.expected);
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.id, tc.description, durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.id, tc.description);
                System.out.printf("         Input:    %s\n", java.util.Arrays.asList(fmt(tc.nums), fmt(tc.k)));
                System.out.printf("         Expected: %s | Actual: %s%s\n",
                        fmt(tc.expected), fmt(result), threw ? " (exception thrown)" : "");
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    /**
     * Formats arrays, linked lists and other objects for readable test output.
     */
    private static String fmt(Object o) {
        if (o instanceof int[]) return Arrays.toString((int[]) o);
        if (o instanceof long[]) return Arrays.toString((long[]) o);
        return String.valueOf(o);
    }
}
