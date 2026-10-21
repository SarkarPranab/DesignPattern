package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.function.ToIntFunction;

/**
 * ============================================================================
 * PROBLEM COD-01: ARRAY ELEMENT SUM AND METRICS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Create a method that accepts an integer array `arr` and returns the sum of
 * all elements in the array.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  arr = [1, 2, 3, 4, 5]
 *   Output: 15
 *
 * Example 2:
 *   Input:  arr = [-10, 20, -30, 40]
 *   Output: 20
 *
 * Example 3:
 *   Input:  arr = []
 *   Output: 0
 *
 * CONSTRAINTS:
 * - 0 <= arr.length <= 10^7
 * - Element values can be negative, zero, or positive integers.
 * - Handles null and empty arrays safely by returning 0.
 * ============================================================================
 */
public class ArrayElementSumAndMetrics {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Standard Imperative For-Loop
     *
     * @implNote Iterate through `arr` using a standard `for` loop and accumulate
     *           the running sum into a primitive `int` variable.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int sumArrayImperative(int[] arr) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 2: Enhanced For-Each Loop
     *
     * @implNote Iterate through each element in `arr` using Java's `for (int val : arr)`
     *           syntax and accumulate the total sum.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int sumArrayForEach(int[] arr) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 3: Java 8+ Arrays.stream().sum() (Declarative Style)
     *
     * @implNote Stream array using `Arrays.stream(arr)` and apply the terminal `.sum()` operation.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int sumArrayStream(int[] arr) {
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
        ArrayElementSumAndMetrics solver = new ArrayElementSumAndMetrics();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{1, 2, 3, 4, 5}, 15, "Standard array with positive numbers"),
                new TestCase(2, new int[]{-10, 20, -30, 40}, 20, "Array with positive and negative numbers"),
                new TestCase(3, new int[]{100}, 100, "Single element array"),
                new TestCase(4, new int[]{0, 0, 0, 0}, 0, "Array with all zeros"),
                new TestCase(5, new int[]{}, 0, "Empty array input"),
                new TestCase(6, null, 0, "Null array safety check"),
                new TestCase(7, generateLargeArray(10_000_000, 1), 10_000_000, "Large stress test (10 Million elements)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: COD-01 ARRAY ELEMENT SUM");
        System.out.println("================================================================================");

        runApproach("1. Standard Imperative For-Loop", solver::sumArrayImperative, testCases);
        runApproach("2. Enhanced For-Each Loop", solver::sumArrayForEach, testCases);
        runApproach("3. Stream API Arrays.stream().sum()", solver::sumArrayStream, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected sum, and logs execution timing.
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

    private static int[] generateLargeArray(int size, int fillValue) {
        int[] arr = new int[size];
        Arrays.fill(arr, fillValue);
        return arr;
    }
}