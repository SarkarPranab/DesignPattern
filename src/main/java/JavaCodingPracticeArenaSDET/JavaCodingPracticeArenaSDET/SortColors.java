package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM EXP-62: SORT COLORS (SORT 0s, 1s AND 2s)
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an array `nums` containing only 0, 1 and 2 (red, white, blue), sort it in place so
 * that equal values are adjacent in the order 0, 1, 2. Return the sorted array.
 * Interview follow-up: do it in ONE pass without using the library sort.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums = [2, 0, 2, 1, 1, 0]
 *   Output: [0, 0, 1, 1, 2, 2]
 * Example 2:
 *   Input:  nums = [2, 0, 1]
 *   Output: [0, 1, 2]
 *
 * CONSTRAINTS:
 * - 1 <= nums.length <= 300
 * - nums[i] is 0, 1 or 2
 * - Null input returns null.
 * ============================================================================
 */
public class SortColors {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Library Sort
     *
     * @implNote Call Arrays.sort on the array (baseline; not the expected interview answer).
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(1)
     */
    public int[] sortColorsLibrary(int[] nums) {
        // TODO: Write solution here
        return new int[0];
    }

    /**
     * Approach 2: Counting Sort (Two Passes)
     *
     * @implNote Count how many 0s, 1s and 2s exist, then overwrite the array with that many of each.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int[] sortColorsCounting(int[] nums) {
        // TODO: Write solution here
        return new int[0];
    }

    /**
     * Approach 3: Dutch National Flag (One Pass)
     *
     * @implNote Maintain low, mid, high pointers: send 0s to the front, 2s to the back, skip 1s.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int[] sortColorsDutchFlag(int[] nums) {
        // TODO: Write solution here
        return new int[0];
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    @FunctionalInterface
    interface Solver {
        int[] solve(int[] nums);
    }

    static class TestCase {
        private final int id;
        private final String description;
        private final int[] nums;
        private final int[] expected;

        public TestCase(int id, String description, int[] nums, int[] expected) {
            this.id = id;
            this.description = description;
            this.nums = nums;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        SortColors solver = new SortColors();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Standard example", new int[]{2, 0, 2, 1, 1, 0}, new int[]{0, 0, 1, 1, 2, 2}),
                new TestCase(2, "Each color once", new int[]{2, 0, 1}, new int[]{0, 1, 2}),
                new TestCase(3, "Single element", new int[]{0}, new int[]{0}),
                new TestCase(4, "All the same color", new int[]{1, 1, 1}, new int[]{1, 1, 1}),
                new TestCase(5, "Reverse sorted", new int[]{2, 2, 1, 1, 0, 0}, new int[]{0, 0, 1, 1, 2, 2}),
                new TestCase(6, "Empty array", new int[0], new int[0]),
                new TestCase(7, "Null input safety check", null, null)
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-62 SORT COLORS (SORT 0s, 1s AND 2s)");
        System.out.println("================================================================================");

        runApproach("1. Library Sort", solver::sortColorsLibrary, testCases);
        runApproach("2. Counting Sort (Two Passes)", solver::sortColorsCounting, testCases);
        runApproach("3. Dutch National Flag (One Pass)", solver::sortColorsDutchFlag, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected output, and logs timing.
     */
    private static void runApproach(String name, Solver method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int[] result = null;
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
