package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM COD-05: SORT ARRAY IN ASCENDING AND DESCENDING ORDER
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array `arr`, implement algorithms to sort the array elements
 * in both Ascending (lowest to highest) and Descending (highest to lowest) order.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  arr = [12, 5, 1, 9, 3]
 *   Output Ascending:  [1, 3, 5, 9, 12]
 *   Output Descending: [12, 9, 5, 3, 1]
 *
 * Example 2:
 *   Input:  arr = [-3, 0, 10, -10]
 *   Output Ascending:  [-10, -3, 0, 10]
 *   Output Descending: [10, 0, -3, -10]
 *
 * CONSTRAINTS:
 * - 0 <= arr.length <= 10^6
 * - -10^9 <= arr[i] <= 10^9
 * - Handles null and empty arrays safely.
 * ============================================================================
 */
public class SortArrayAscendingAndDescending {

    /**
     * Container record/class holding both Ascending and Descending sorted variants.
     */
    public static class SortResult {
        private final int[] ascending;
        private final int[] descending;

        public SortResult(int[] ascending, int[] descending) {
            this.ascending = ascending;
            this.descending = descending;
        }

        public int[] getAscending() { return ascending; }
        public int[] getDescending() { return descending; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SortResult)) return false;
            SortResult that = (SortResult) o;
            return Arrays.equals(ascending, that.ascending) &&
                    Arrays.equals(descending, that.descending);
        }

        @Override
        public int hashCode() {
            return Objects.hash(Arrays.hashCode(ascending), Arrays.hashCode(descending));
        }
    }

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Dual Dual Pivot Quicksort (`Arrays.sort` & Two-Pointer Inversion)
     *
     * @implNote Sort input using built-in `Arrays.sort(asc)`. Create `desc` by copying
     *           `asc` and reversing elements in-place using two-pointer swaps.
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(N)
     */
    public SortResult sortBuiltInTwoPointer(int[] arr) {
        // TODO: Write solution here
        return new SortResult(new int[0], new int[0]);
    }

    /**
     * Approach 2: Manual In-Place Algorithm Implementation
     *
     * @implNote Implement custom in-place array sorting algorithms without relying
     *           on Java collection frameworks or library methods.
     * @targetTimeComplexity O(N log N) or O(N^2)
     * @targetSpaceComplexity O(N)
     */
    public SortResult sortManualImplementation(int[] arr) {
        // TODO: Write solution here
        return new SortResult(new int[0], new int[0]);
    }

    /**
     * Approach 3: Java 8+ Streams & Boxed Collections
     *
     * @implNote Use `Arrays.stream(arr)` to sort ascending and `.boxed()` stream
     *           with `Comparator.reverseOrder()` to produce descending primitive array.
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(N)
     */
    public SortResult sortStreamBoxed(int[] arr) {
        // TODO: Write solution here
        return new SortResult(new int[0], new int[0]);
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] input;
        private final SortResult expected;
        private final String description;

        public TestCase(int id, int[] input, SortResult expected, String description) {
            this.id = id;
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getInput() { return input; }
        public SortResult getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        SortArrayAscendingAndDescending solver = new SortArrayAscendingAndDescending();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{12, 5, 1, 9, 3},
                        new SortResult(new int[]{1, 3, 5, 9, 12}, new int[]{12, 9, 5, 3, 1}), "Standard unsorted array"),
                new TestCase(2, new int[]{-3, 0, 10, -10},
                        new SortResult(new int[]{-10, -3, 0, 10}, new int[]{10, 0, -3, -10}), "Array with positive and negative values"),
                new TestCase(3, new int[]{7, 7, 7, 7},
                        new SortResult(new int[]{7, 7, 7, 7}, new int[]{7, 7, 7, 7}), "Array with identical elements"),
                new TestCase(4, new int[]{100},
                        new SortResult(new int[]{100}, new int[]{100}), "Single element array"),
                new TestCase(5, new int[]{},
                        new SortResult(new int[]{}, new int[]{}), "Empty array input"),
                new TestCase(6, null, null, "Null input safety check"),
                new TestCase(7, generateLargeArray(100_000), generateExpectedLargeResult(100_000), "Large stress test (100k elements)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: COD-05 SORT ARRAY ASCENDING & DESCENDING");
        System.out.println("================================================================================");

        runApproach("1. Built-in Arrays.sort() & Two-Pointer Inversion", solver::sortBuiltInTwoPointer, testCases);
        runApproach("2. Manual In-Place Algorithm", solver::sortManualImplementation, testCases);
        runApproach("3. Stream API & Boxed Reverse Comparator", solver::sortStreamBoxed, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected SortResult objects, and logs timing.
     */
    private static void runApproach(String name, Function<int[], SortResult> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int[] workingArray = (tc.getInput() != null) ? tc.getInput().clone() : null;

            long startTime = System.nanoTime();
            SortResult result = method.apply(workingArray);
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Objects.equals(result, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected Asc:  %s\n", tc.getExpected() != null ? Arrays.toString(tc.getExpected().getAscending()) : "null");
                System.out.printf("         Expected Desc: %s\n", tc.getExpected() != null ? Arrays.toString(tc.getExpected().getDescending()) : "null");
                System.out.printf("         Actual Asc:    %s\n", result != null ? Arrays.toString(result.getAscending()) : "null");
                System.out.printf("         Actual Desc:   %s\n", result != null ? Arrays.toString(result.getDescending()) : "null");
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static int[] generateLargeArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }

    private static SortResult generateExpectedLargeResult(int size) {
        int[] asc = new int[size];
        int[] desc = new int[size];
        for (int i = 0; i < size; i++) {
            asc[i] = i + 1;
            desc[i] = size - i;
        }
        return new SortResult(asc, desc);
    }
}