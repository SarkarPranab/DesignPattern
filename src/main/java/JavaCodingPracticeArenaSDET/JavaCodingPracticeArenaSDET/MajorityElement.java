package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM EXP-57: MAJORITY ELEMENT
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an array `nums` of size n, return the majority element: the element that appears
 * MORE than n / 2 times. You may assume the majority element always exists.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums = [3, 2, 3]
 *   Output: 3
 * Example 2:
 *   Input:  nums = [2, 2, 1, 1, 1, 2, 2]
 *   Output: 2
 *
 * CONSTRAINTS:
 * - 1 <= nums.length <= 5 * 10^4
 * - -10^9 <= nums[i] <= 10^9
 * - Null or empty input returns Integer.MIN_VALUE as a safety marker.
 * ============================================================================
 */
public class MajorityElement {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: HashMap Frequency Count
     *
     * @implNote Count occurrences in a HashMap and return the first element whose count exceeds n / 2.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public int majorityHashMap(int[] nums) {
        // TODO: Write solution here
        return Integer.MIN_VALUE;
    }

    /**
     * Approach 2: Sort And Take Middle
     *
     * @implNote After sorting, the majority element always occupies the middle index n / 2.
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(N)
     */
    public int majoritySorting(int[] nums) {
        // TODO: Write solution here
        return Integer.MIN_VALUE;
    }

    /**
     * Approach 3: Boyer-Moore Voting
     *
     * @implNote Keep a candidate and a counter: matching elements add 1, others subtract 1, reset when 0.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int majorityBoyerMoore(int[] nums) {
        // TODO: Write solution here
        return Integer.MIN_VALUE;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    @FunctionalInterface
    interface Solver {
        int solve(int[] nums);
    }

    static class TestCase {
        private final int id;
        private final String description;
        private final int[] nums;
        private final int expected;

        public TestCase(int id, String description, int[] nums, int expected) {
            this.id = id;
            this.description = description;
            this.nums = nums;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        MajorityElement solver = new MajorityElement();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Simple majority", new int[]{3, 2, 3}, 3),
                new TestCase(2, "Majority at the end", new int[]{2, 2, 1, 1, 1, 2, 2}, 2),
                new TestCase(3, "Single element", new int[]{1}, 1),
                new TestCase(4, "Negative majority", new int[]{-1, -1, 2}, -1),
                new TestCase(5, "All equal", new int[]{7, 7, 7, 7}, 7),
                new TestCase(6, "Empty array safety check", new int[0], Integer.MIN_VALUE),
                new TestCase(7, "Null input safety check", null, Integer.MIN_VALUE)
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-57 MAJORITY ELEMENT");
        System.out.println("================================================================================");

        runApproach("1. HashMap Frequency Count", solver::majorityHashMap, testCases);
        runApproach("2. Sort And Take Middle", solver::majoritySorting, testCases);
        runApproach("3. Boyer-Moore Voting", solver::majorityBoyerMoore, testCases);
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
                result = method.solve(tc.nums == null ? null : tc.nums.clone());
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
                System.out.printf("         Input:    %s\n", java.util.Arrays.asList(fmt(tc.nums)));
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
