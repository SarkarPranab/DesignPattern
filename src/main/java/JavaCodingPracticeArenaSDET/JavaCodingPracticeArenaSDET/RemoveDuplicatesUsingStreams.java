package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM: REMOVE DUPLICATE ELEMENTS FROM ARRAY USING JAVA STREAMS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array `arr`, remove all duplicate elements using Java Stream API
 * operations while preserving the original order of appearance.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  arr = [12, 12, 20, 14, 20, 12, 4854, 9898, 12, 98]
 *   Output: [12, 20, 14, 4854, 9898, 98]
 *
 * Example 2:
 *   Input:  arr = [1, 1, 1, 1]
 *   Output: [1]
 *
 * Example 3:
 *   Input:  arr = [5, 4, 3, 2, 1]
 *   Output: [5, 4, 3, 2, 1]
 *
 * CONSTRAINTS:
 * - 0 <= arr.length <= 10^6
 * - Handle null and empty arrays safely.
 * - Negative numbers, zero, and positive integers supported.
 * ============================================================================
 */
public class RemoveDuplicatesUsingStreams {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Primitive IntStream.distinct() (Optimal Functional One-Liner)
     *
     * @implNote Stream primitive array via `Arrays.stream(arr)`, invoke `.distinct()`,
     *           and convert back to array with `.toArray()`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(U) where U is unique element count
     */
    public int[] removeDuplicatesStreamDistinct(int[] arr) {
        // TODO: Write solution here
        return new int[0];
    }

    /**
     * Approach 2: Boxed Stream with Collectors.toCollection(LinkedHashSet::new)
     *
     * @implNote Box primitive stream via `.boxed()`, collect into a `LinkedHashSet`
     *           to preserve insertion order, then map back to primitive `int[]`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(U)
     */
    public int[] removeDuplicatesStreamCollectors(int[] arr) {
        // TODO: Write solution here
        return new int[0];
    }

    /**
     * Approach 3: Imperative LinkedHashSet (Benchmarking Baseline)
     *
     * @implNote Iterate through primitive array using standard loop and `LinkedHashSet`
     *           to compare performance against stream pipeline overhead.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(U)
     */
    public int[] removeDuplicatesImperative(int[] arr) {
        // TODO: Write solution here
        return new int[0];
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] input;
        private final int[] expected;
        private final String description;

        public TestCase(int id, int[] input, int[] expected, String description) {
            this.id = id;
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getInput() { return input; }
        public int[] getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        RemoveDuplicatesUsingStreams solver = new RemoveDuplicatesUsingStreams();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{12, 12, 20, 14, 20, 12, 4854, 9898, 12, 98}, new int[]{12, 20, 14, 4854, 9898, 98}, "Standard array with multiple duplicate values"),
                new TestCase(2, new int[]{1, 1, 1, 1}, new int[]{1}, "Array with all identical elements"),
                new TestCase(3, new int[]{5, 4, 3, 2, 1}, new int[]{5, 4, 3, 2, 1}, "Array with all unique elements"),
                new TestCase(4, new int[]{-10, 0, -10, 20, 0}, new int[]{-10, 0, 20}, "Array with negative numbers and zero"),
                new TestCase(5, new int[]{99}, new int[]{99}, "Single element array"),
                new TestCase(6, new int[]{}, new int[]{}, "Empty array input"),
                new TestCase(7, null, null, "Null array safety check"),
                new TestCase(8, generateLargeArray(1_000_000), generateExpectedLargeArray(100), "Large stress test (1 Million elements, 100 unique values)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: REMOVE DUPLICATE ELEMENTS USING STREAMS");
        System.out.println("================================================================================");

        runApproach("1. IntStream.distinct().toArray()", solver::removeDuplicatesStreamDistinct, testCases);
        runApproach("2. Boxed Stream & Collectors.toCollection(LinkedHashSet::new)", solver::removeDuplicatesStreamCollectors, testCases);
        runApproach("3. Imperative LinkedHashSet Loop (Benchmark Baseline)", solver::removeDuplicatesImperative, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected array output, and logs execution timing.
     */
    private static void runApproach(String name, Function<int[], int[]> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int[] workingArray = (tc.getInput() != null) ? tc.getInput().clone() : null;

            long startTime = System.nanoTime();
            int[] result = method.apply(workingArray);
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
                System.out.printf("         Input:    %s\n",
                        tc.getInput() != null && tc.getInput().length > 15 ? "[Large Array]" : Arrays.toString(tc.getInput()));
                System.out.printf("         Expected: %s\n", Arrays.toString(tc.getExpected()));
                System.out.printf("         Actual:   %s\n", Arrays.toString(result));
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static int[] generateLargeArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i % 100;
        }
        return arr;
    }

    private static int[] generateExpectedLargeArray(int uniqueCount) {
        int[] expected = new int[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            expected[i] = i;
        }
        return expected;
    }
}