package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.function.BiConsumer;

/**
 * ============================================================================
 * PROBLEM: ROTATE ARRAY TO RIGHT WITH MODULO K HANDLING (LEETCODE 189)
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array `nums` and a non-negative integer `k`, rotate the array
 * to the right by `k` steps.
 *
 * CRITICAL REQUIREMENT:
 * `k` can be significantly larger than the length of the array `N` (e.g., k = 100, N = 5).
 * Rotating an array of size N by N positions results in the same array.
 * Therefore, always normalize `k` first using modulo arithmetic: `k = k % N`.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums = [1, 2, 3, 4, 5, 6, 7], k = 3
 *   Output: [5, 6, 7, 1, 2, 3, 4]
 *
 * Example 2:
 *   Input:  nums = [-1, -100, 3, 99], k = 2
 *   Output: [3, 99, -1, -100]
 *
 * Example 3:
 *   Input:  nums = [1, 2], k = 5  (5 % 2 = 1)
 *   Output: [2, 1]
 *
 * CONSTRAINTS:
 * - 0 <= nums.length <= 10^5
 * - 0 <= k <= 10^9
 * ============================================================================
 */
public class RotateArrayWithModulo {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Helper Method: Reverses elements in-place between `left` and `right` indices.
     */
    public int[] reverse(int[] a, int left, int right) {
        // TODO: Write two-pointer range reversal helper logic here
        return a;
    }

    /**
     * Approach 1: Reversal Algorithm with Modulo Normalization (Optimal In-Place)
     *
     * @implNote
     * 1. Check null or empty array.
     * 2. Calculate `k = k % a.length`.
     * 3. Reverse full array `[0 ... N - 1]`.
     * 4. Reverse first `k` elements `[0 ... k - 1]`.
     * 5. Reverse remaining elements `[k ... N - 1]`.
     *
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) in-place
     */
    public void rotateRightReversal(int[] a, int k) {
        // TODO: Write solution here
    }

    /**
     * Approach 2: Extra Array Allocation with Modulo Index Mapping
     *
     * @implNote Allocate new array `temp` of size N. Place `a[i]` into `temp[(i + k) % N]`.
     *
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public void rotateRightExtraArray(int[] a, int k) {
        // TODO: Write solution here
    }

    /**
     * Approach 3: Functional / Java IntStream Lambda Expression (One-Liner)
     *
     * @implNote Generate index stream `IntStream.range(0, N)`, map each target index
     *           from `(i - k % N + N) % N` source element, and update array.
     *
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public void rotateRightStream(int[] a, int k) {
        // TODO: Write solution here
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] originalArray;
        private final int k;
        private final int[] expected;
        private final String description;

        public TestCase(int id, int[] originalArray, int k, int[] expected, String description) {
            this.id = id;
            this.originalArray = originalArray;
            this.k = k;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getOriginalArray() { return originalArray; }
        public int getK() { return k; }
        public int[] getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        RotateArrayWithModulo solver = new RotateArrayWithModulo();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}, "Standard rotation k=3"),
                new TestCase(2, new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100}, "Even length array k=2"),
                new TestCase(3, new int[]{1, 2, 3, 4, 5, 6, 7}, 10, new int[]{5, 6, 7, 1, 2, 3, 4}, "k larger than length (k=10, N=7 -> k%N=3)"),
                new TestCase(4, new int[]{1, 2, 3, 4, 5}, 5, new int[]{1, 2, 3, 4, 5}, "k is multiple of N (k=5, N=5 -> k%N=0)"),
                new TestCase(5, new int[]{10}, 100, new int[]{10}, "Single element array with huge k"),
                new TestCase(6, new int[]{}, 3, new int[]{}, "Empty array input"),
                new TestCase(7, generateLargeArray(100_000), 1_000_003, generateExpectedLargeArray(100_000, 3), "Stress test (100k elements, k=1,000,003)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: ROTATE ARRAY WITH MODULO K");
        System.out.println("================================================================================");

        runApproach("1. Reversal Algorithm (In-Place O(1) Space)", solver::rotateRightReversal, testCases);
        runApproach("2. Extra Array Allocation (O(N) Space)", solver::rotateRightExtraArray, testCases);
        runApproach("3. IntStream & Lambda Expression", solver::rotateRightStream, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected output, and benchmarks execution time.
     */
    private static void runApproach(String name, BiConsumer<int[], Integer> rotationMethod, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int[] workingArray = (tc.getOriginalArray() != null) ? tc.getOriginalArray().clone() : null;

            long startTime = System.nanoTime();
            rotationMethod.accept(workingArray, tc.getK());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Arrays.equals(workingArray, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Actual:   %s\n",
                        workingArray != null && workingArray.length > 15 ? "[Large Array]" : Arrays.toString(workingArray));
                System.out.printf("         Expected: %s\n",
                        tc.getExpected() != null && tc.getExpected().length > 15 ? "[Large Array]" : Arrays.toString(tc.getExpected()));
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static int[] generateLargeArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    private static int[] generateExpectedLargeArray(int size, int shift) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[(i + shift) % size] = i;
        }
        return arr;
    }
}