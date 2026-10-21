package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

/**
 * ============================================================================
 * PROBLEM COD-04: COMPARE SAME INDEXES OF 2 ARRAYS AND EXTRACT MATCHES
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given two integer arrays `arr1` and `arr2`, compare the elements present at
 * identical indices (`arr1[i] == arr2[i]`). Return a new array containing only
 * the values where elements at the same index match.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  arr1 = [1, 4, 7, 9, 12]
 *           arr2 = [1, 5, 7, 3, 12]
 *   Index Comparisons:
 *     i = 0: 1 == 1 -> Match (1)
 *     i = 1: 4 != 5 -> Discard
 *     i = 2: 7 == 7 -> Match (7)
 *     i = 3: 9 != 3 -> Discard
 *     i = 4: 12 == 12 -> Match (12)
 *   Output: [1, 7, 12]
 *
 * Example 2 (Unequal Lengths):
 *   Input:  arr1 = [10, 20, 30, 40]
 *           arr2 = [10, 99, 30]
 *   Evaluated bound: min(arr1.length, arr2.length) = 3
 *   Output: [10, 30]
 *
 * CONSTRAINTS:
 * - 0 <= arr1.length, arr2.length <= 10^7
 * - Compare up to `min(arr1.length, arr2.length)`.
 * - Return empty array if either array is null, empty, or contains no matches.
 * ============================================================================
 */
public class CompareArrayIndicesAndExtractMatches {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Dynamic List Collector with Single Pass Iteration
     *
     * @implNote Iterate up to `Math.min(arr1.length, arr2.length)`. Collect matches
     *           into an `ArrayList<Integer>` and map back to primitive `int[]`.
     * @targetTimeComplexity O(min(N, M))
     * @targetSpaceComplexity O(K) where K is match count
     */
    public int[] extractMatchesListCollector(int[] arr1, int[] arr2) {
        // TODO: Write solution here
        return new int[0];
    }

    /**
     * Approach 2: Two-Pass Fixed Primitive Array Buffer (Zero Auto-boxing)
     *
     * @implNote Pass 1: Count total matching indices.
     *           Pass 2: Allocate fixed array `int[matchCount]` and populate directly.
     * @targetTimeComplexity O(min(N, M))
     * @targetSpaceComplexity O(K) avoiding wrapper object allocations
     */
    public int[] extractMatchesTwoPassPrimitiveBuffer(int[] arr1, int[] arr2) {
        // TODO: Write solution here
        return new int[0];
    }

    /**
     * Approach 3: IntStream Range Filtering (Declarative Stream Style)
     *
     * @implNote Stream range `IntStream.range(0, Math.min(arr1.length, arr2.length))`,
     *           filter `i -> arr1[i] == arr2[i]`, map index to value `i -> arr1[i]`, `.toArray()`.
     * @targetTimeComplexity O(min(N, M))
     * @targetSpaceComplexity O(K)
     */
    public int[] extractMatchesStream(int[] arr1, int[] arr2) {
        // TODO: Write solution here
        return new int[0];
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] arr1;
        private final int[] arr2;
        private final int[] expected;
        private final String description;

        public TestCase(int id, int[] arr1, int[] arr2, int[] expected, String description) {
            this.id = id;
            this.arr1 = arr1;
            this.arr2 = arr2;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getArr1() { return arr1; }
        public int[] getArr2() { return arr2; }
        public int[] getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        CompareArrayIndicesAndExtractMatches solver = new CompareArrayIndicesAndExtractMatches();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{1, 4, 7, 9, 12}, new int[]{1, 5, 7, 3, 12}, new int[]{1, 7, 12}, "Standard matching arrays of equal length"),
                new TestCase(2, new int[]{10, 20, 30, 40}, new int[]{10, 99, 30}, new int[]{10, 30}, "Arrays of unequal lengths"),
                new TestCase(3, new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{}, "No index matches found"),
                new TestCase(4, new int[]{5, 5, 5}, new int[]{5, 5, 5}, new int[]{5, 5, 5}, "100% identical elements at all indices"),
                new TestCase(5, new int[]{}, new int[]{1, 2}, new int[]{}, "Empty first array"),
                new TestCase(6, null, new int[]{1, 2}, new int[]{}, "Null input safety check"),
                new TestCase(7, generateLargeArray(10_000_000, true), generateLargeArray(10_000_000, false), generateExpectedLargeMatches(10_000_000), "Large stress test (10 Million elements)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: COD-04 COMPARE SAME INDEXES & EXTRACT MATCHES");
        System.out.println("================================================================================");

        runApproach("1. Dynamic List Collector", solver::extractMatchesListCollector, testCases);
        runApproach("2. Two-Pass Primitive Buffer (Zero Auto-Boxing)", solver::extractMatchesTwoPassPrimitiveBuffer, testCases);
        runApproach("3. Stream API IntStream Range Filtering", solver::extractMatchesStream, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected matching array results, and logs timing.
     */
    private static void runApproach(String name, BiFunction<int[], int[], int[]> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int[] w1 = (tc.getArr1() != null) ? tc.getArr1().clone() : null;
            int[] w2 = (tc.getArr2() != null) ? tc.getArr2().clone() : null;

            long startTime = System.nanoTime();
            int[] result = method.apply(w1, w2);
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = (result == null && tc.getExpected() == null) ||
                    (result != null && Arrays.equals(result, tc.getExpected()));

            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected: %s\n", tc.getExpected() != null && tc.getExpected().length > 15 ? "[Large Array]" : Arrays.toString(tc.getExpected()));
                System.out.printf("         Actual:   %s\n", result != null && result.length > 15 ? "[Large Array]" : Arrays.toString(result));
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static int[] generateLargeArray(int size, boolean isFirst) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                arr[i] = 100;
            } else {
                arr[i] = isFirst ? 200 : 300;
            }
        }
        return arr;
    }

    private static int[] generateExpectedLargeMatches(int size) {
        int expectedSize = size / 2;
        int[] expected = new int[expectedSize];
        Arrays.fill(expected, 100);
        return expected;
    }
}