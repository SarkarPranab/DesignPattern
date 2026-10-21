package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM EXP-58: KTH LARGEST ELEMENT IN AN ARRAY
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array `nums` and an integer `k`, return the kth largest element in the
 * array. It is the kth largest in sorted order, NOT the kth distinct element.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums = [3, 2, 1, 5, 6, 4], k = 2
 *   Output: 5
 * Example 2:
 *   Input:  nums = [3, 2, 3, 1, 2, 4, 5, 5, 6], k = 4
 *   Output: 4
 *
 * CONSTRAINTS:
 * - 1 <= k <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 * - Null input or invalid k returns Integer.MIN_VALUE as a safety marker.
 * ============================================================================
 */
public class KthLargestElement {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Sort Then Index
     *
     * @implNote Sort ascending and return the element at index n - k.
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(N)
     */
    public int kthLargestSorting(int[] nums, int k) {
        // TODO: Write solution here
        return Integer.MIN_VALUE;
    }

    /**
     * Approach 2: Min-Heap Of Size K
     *
     * @implNote Keep a PriorityQueue of the k largest values; the heap root is the kth largest.
     * @targetTimeComplexity O(N log K)
     * @targetSpaceComplexity O(K)
     */
    public int kthLargestMinHeap(int[] nums, int k) {
        // TODO: Write solution here
        return Integer.MIN_VALUE;
    }

    /**
     * Approach 3: Quickselect (Average O(N))
     *
     * @implNote Partition around a random pivot until the pivot lands on index n - k.
     * @targetTimeComplexity O(N) average, O(N^2) worst
     * @targetSpaceComplexity O(1) extra
     */
    public int kthLargestQuickSelect(int[] nums, int k) {
        // TODO: Write solution here
        return Integer.MIN_VALUE;
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
        KthLargestElement solver = new KthLargestElement();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Standard example", new int[]{3, 2, 1, 5, 6, 4}, 2, 5),
                new TestCase(2, "Duplicates count separately", new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4),
                new TestCase(3, "Single element", new int[]{1}, 1, 1),
                new TestCase(4, "All equal values", new int[]{5, 5, 5}, 2, 5),
                new TestCase(5, "k equals array length (minimum)", new int[]{9, 3, 7}, 3, 3),
                new TestCase(6, "k larger than length", new int[]{1, 2}, 3, Integer.MIN_VALUE),
                new TestCase(7, "Null input safety check", null, 1, Integer.MIN_VALUE)
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-58 KTH LARGEST ELEMENT IN AN ARRAY");
        System.out.println("================================================================================");

        runApproach("1. Sort Then Index", solver::kthLargestSorting, testCases);
        runApproach("2. Min-Heap Of Size K", solver::kthLargestMinHeap, testCases);
        runApproach("3. Quickselect (Average O(N))", solver::kthLargestQuickSelect, testCases);
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
