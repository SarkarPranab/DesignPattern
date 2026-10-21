package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;


import java.util.Arrays;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

/**
 * ============================================================================
 * PROBLEM COD-03: MAX DIFFERENCE BETWEEN ADJACENT INDICES IN ARRAY
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array `arr`, find the maximum absolute difference between
 * any two adjacent elements (`|arr[i] - arr[i + 1]|`).
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  arr = [1, 4, 8, 15, 17]
 *   Adjacent Differences:
 *     |1 - 4| = 3
 *     |4 - 8| = 4
 *     |8 - 15| = 7
 *     |15 - 17| = 2
 *   Output: 7
 *
 * Example 2:
 *   Input:  arr = [10, -5, 20, 0]
 *   Adjacent Differences:
 *     |10 - (-5)| = 15
 *     |-5 - 20| = 25
 *     |20 - 0| = 20
 *   Output: 25
 *
 * Example 3:
 *   Input:  arr = [5]
 *   Output: 0 (Fewer than 2 elements)
 *
 * CONSTRAINTS:
 * - 0 <= arr.length <= 10^7
 * - -10^9 <= arr[i] <= 10^9
 * - Return 0 for null or arrays with fewer than 2 elements.
 * ============================================================================
 */
public class MaxAdjacentDifferenceInArray {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Single Pass Linear Iteration (Math.abs)
     *
     * @implNote Loop from `i = 0` to `arr.length - 2`. Calculate absolute difference
     *           `Math.abs(arr[i] - arr[i + 1])` and track maximum seen so far.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int maxAdjacentDiffImperative(int[] arr) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 2: Bitwise Absolute Difference (Branchless Math)
     *
     * @implNote Computes difference without `Math.abs` or branching, using
     *           bitwise XOR and arithmetic shifts for absolute value calculation.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int maxAdjacentDiffBitwise(int[] arr) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 3: IntStream Range Mapping (Declarative Functional Style)
     *
     * @implNote Stream index range `IntStream.range(0, arr.length - 1)`, map to absolute
     *           adjacent differences, and extract max via `.max().orElse(0)`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int maxAdjacentDiffStream(int[] arr) {
        // TODO: Write solution here
        return 0;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] input;
        private final int expected;
        private final String description;

        public TestCase(int id, int[] input, int expected, String description) {
            this.id = id;
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getInput() { return input; }
        public int getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        MaxAdjacentDifferenceInArray solver = new MaxAdjacentDifferenceInArray();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{1, 4, 8, 15, 17}, 7, "Standard array with increasing positive numbers"),
                new TestCase(2, new int[]{10, -5, 20, 0}, 25, "Array containing negative numbers"),
                new TestCase(3, new int[]{5, 5, 5, 5}, 0, "Array with all equal values"),
                new TestCase(4, new int[]{-100, -200, -50}, 150, "Array with all negative numbers"),
                new TestCase(5, new int[]{42}, 0, "Single element array"),
                new TestCase(6, new int[]{}, 0, "Empty array input"),
                new TestCase(7, null, 0, "Null array safety check"),
                new TestCase(8, generateLargeArray(10_000_000), 999_999_999, "Large stress test (10 Million elements)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: COD-03 MAX ADJACENT DIFFERENCE IN ARRAY");
        System.out.println("================================================================================");

        runApproach("1. Single Pass Linear Iteration (Math.abs)", solver::maxAdjacentDiffImperative, testCases);
        runApproach("2. Bitwise Branchless Absolute Difference", solver::maxAdjacentDiffBitwise, testCases);
        runApproach("3. Stream API Range Mapping", solver::maxAdjacentDiffStream, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected max difference, and logs timing.
     */
    private static void runApproach(String name, ToIntFunction<int[]> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int[] workingArray = (tc.getInput() != null) ? tc.getInput().clone() : null;

            long startTime = System.nanoTime();
            int result = method.applyAsInt(workingArray);
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = (result == tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Input:    %s\n",
                        tc.getInput() != null && tc.getInput().length > 15 ? "[Large Array]" : Arrays.toString(tc.getInput()));
                System.out.printf("         Expected: %d | Actual: %d\n", tc.getExpected(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static int[] generateLargeArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (i % 2 == 0) ? 0 : 999_999_999;
        }
        return arr;
    }
}