package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM: REMOVE DUPLICATES FROM ARRAY PRESERVING ORDER
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array `arr`, remove all duplicate elements such that each element
 * appears only once in the resulting array. The relative order of the first
 * appearance of each element must be preserved.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  arr = [12, 6, 7, 12, 7, 4, 9]
 *   Output: [12, 6, 7, 4, 9]
 *   Explanation:
 *     - 12 first seen at index 0 -> kept
 *     - 6 first seen at index 1 -> kept
 *     - 7 first seen at index 2 -> kept
 *     - 12 duplicate -> removed
 *     - 7 duplicate -> removed
 *     - 4 first seen at index 5 -> kept
 *     - 9 first seen at index 6 -> kept
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
 * - Handles null and empty arrays safely by returning empty or null.
 * - Element values can be negative, zero, or positive integers.
 * ============================================================================
 */
public class RemoveDuplicatesFromArrayPreservingOrder {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: LinkedHashSet Insertion-Order Collection
     *
     * @implNote Iterate through `arr`, insert elements into a `LinkedHashSet<Integer>`.
     *           Convert the set back to a primitive `int[]` array.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(U) where U is unique element count
     */
    public int[] removeDuplicatesLinkedHashSet(int[] arr) {
        // TODO: Write solution here
        return new int[0];
    }

    /**
     * Approach 2: Primitive Array Scan with HashSet Lookup
     *
     * @implNote Use an auxiliary `HashSet<Integer>` to track seen values and a
     *           temporary `int[]` buffer to collect unique elements in order.
     *           Return a trimmed `Arrays.copyOf(temp, uniqueCount)` array.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(U) avoiding boxed stream conversions
     */
    public int[] removeDuplicatesHashSetLookup(int[] arr) {
        // TODO: Write solution here
        return new int[0];
    }

    /**
     * Approach 3: Java 8+ Stream API .distinct() (Declarative Style)
     *
     * @implNote Stream array using `Arrays.stream(arr)`, invoke `.distinct()`,
     *           and collect result using `.toArray()`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(U)
     */
    public int[] removeDuplicatesStream(int[] arr) {
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
        RemoveDuplicatesFromArrayPreservingOrder solver = new RemoveDuplicatesFromArrayPreservingOrder();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{12, 6, 7, 12, 7, 4, 9}, new int[]{12, 6, 7, 4, 9}, "Standard array with multiple duplicates"),
                new TestCase(2, new int[]{1, 1, 1, 1}, new int[]{1}, "Array with all identical elements"),
                new TestCase(3, new int[]{5, 4, 3, 2, 1}, new int[]{5, 4, 3, 2, 1}, "Array with all unique elements"),
                new TestCase(4, new int[]{-10, 20, -10, 0, 20, 0}, new int[]{-10, 20, 0}, "Array with negative numbers and zeros"),
                new TestCase(5, new int[]{99}, new int[]{99}, "Single element array"),
                new TestCase(6, new int[]{}, new int[]{}, "Empty array input"),
                new TestCase(7, null, null, "Null input array safety check"),
                new TestCase(8, generateLargeArray(1_000_000), generateExpectedLargeArray(100), "Large stress test (1 Million elements, 100 unique values)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: REMOVE DUPLICATES FROM ARRAY PRESERVING ORDER");
        System.out.println("================================================================================");

        runApproach("1. LinkedHashSet Insertion-Order Collection", solver::removeDuplicatesLinkedHashSet, testCases);
        runApproach("2. Primitive Array Buffer with HashSet Lookup", solver::removeDuplicatesHashSetLookup, testCases);
        runApproach("3. Stream API distinct()", solver::removeDuplicatesStream, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected array output, and logs timing.
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