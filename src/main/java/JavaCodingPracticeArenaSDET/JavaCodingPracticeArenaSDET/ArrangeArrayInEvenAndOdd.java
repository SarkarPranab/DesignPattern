package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * ============================================================================
 * PROBLEM: ARRANGE ARRAY IN EVEN AND ODD (SORT ARRAY BY PARITY)
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an array of integers `nums`, rearrange the elements such that all the
 * EVEN integers appear at the beginning of the array, followed by all the ODD integers.
 *
 * The relative order of elements within the even or odd groups does not matter
 * unless specified by a stable sorting requirement.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums = [3, 0, 2, 0, 4, 1, 5]
 *   Output: [0, 2, 0, 4, 3, 1, 5] (or any variation where all evens precede all odds)
 *
 * Example 2:
 *   Input:  nums = [1, 3, 5, 2, 4, 6]
 *   Output: [2, 4, 6, 1, 3, 5]
 *
 * Example 3:
 *   Input:  nums = [0]
 *   Output: [0]
 *
 * CONSTRAINTS:
 * - 0 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 * - Handle negative numbers correctly (e.g., -2 is even, -3 is odd)
 * ============================================================================
 */
public class ArrangeArrayInEvenAndOdd {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Two Pointers (In-Place Partitioning)
     *
     * @implNote Use two pointers (`left` at index 0, `right` at index N-1).
     *           Increment `left` while `nums[left]` is even, decrement `right`
     *           while `nums[right]` is odd. Swap elements when `left < right`
     *           and `nums[left]` is odd and `nums[right]` is even.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int[] arrangeEvenOddTwoPointer(int[] nums) {
        // TODO: Write solution here
        return new int[0];
    }

    /**
     * Approach 2: Auxiliary Array / Two-Pass
     *
     * @implNote Allocate a new array of size N. Iterate through `nums` to copy all
     *           even numbers first, then iterate again (or use dual indices) to copy
     *           all odd numbers.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public int[] arrangeEvenOddExtraSpace(int[] nums) {
        // TODO: Write solution here
        return new int[0];
    }

    /**
     * Approach 3: Java Stream & Lambda Expression
     *
     * @implNote Use `IntStream.concat()` combining a stream filtered for even elements
     *           with a stream filtered for odd elements.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public int[] arrangeEvenOddStream(int[] nums) {
        // TODO: Write solution here
        return new int[0];
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    // Java 8+ Compatible Test Case Container (replaces Java 16 record)
    static class TestCase {
        private final int id;
        private final int[] nums;
        private final String description;

        public TestCase(int id, int[] nums, String description) {
            this.id = id;
            this.nums = nums;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getNums() { return nums; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        ArrangeArrayInEvenAndOdd solver = new ArrangeArrayInEvenAndOdd();

        // Comprehensive Test Suite covering edge cases, negatives, empty arrays, stress cases
        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{3, 0, 2, 0, 4, 1, 5}, "Standard unsorted mix"),
                new TestCase(2, new int[]{2, 4, 6, 8}, "All even numbers"),
                new TestCase(3, new int[]{1, 3, 5, 7}, "All odd numbers"),
                new TestCase(4, new int[]{1, 3, 5, 2, 4, 6}, "Odds first, then Evens"),
                new TestCase(5, new int[]{-2, -3, 0, 4, -5, -8, 7}, "Negative numbers mix"),
                new TestCase(6, new int[]{42}, "Single element array"),
                new TestCase(7, new int[]{}, "Empty array"),
                new TestCase(8, generateLargeArray(100_000), "Large stress test (100k elements)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: ARRANGE ARRAY IN EVEN AND ODD");
        System.out.println("================================================================================");

        runApproach("1. Two Pointers (In-Place O(1) Space)", solver::arrangeEvenOddTwoPointer, testCases);
        runApproach("2. Auxiliary Array (O(N) Space)", solver::arrangeEvenOddExtraSpace, testCases);
        runApproach("3. Stream & Lambda Expression", solver::arrangeEvenOddStream, testCases);
    }

    /**
     * Executes test cases, verifies validity of partition and element retention, and benchmarks execution time.
     */
    private static void runApproach(String name, Function<int[], int[]> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int[] numsCopy = tc.getNums().clone();

            long startTime = System.nanoTime();
            int[] result = method.apply(numsCopy);
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = isValidEvenOddPartition(tc.getNums(), result);
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s) | Input: %s | Got: %s\n",
                        tc.getId(), tc.getDescription(),
                        tc.getNums().length > 20 ? "[Large Array]" : Arrays.toString(tc.getNums()),
                        result == null ? "null" : (result.length > 20 ? "[Large Array]" : Arrays.toString(result)));
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    /**
     * Validates that:
     * 1. Output length matches input length.
     * 2. All elements from original input are preserved (multiset match).
     * 3. No even number appears after the first odd number in the result array.
     */
    private static boolean isValidEvenOddPartition(int[] original, int[] result) {
        if (result == null || result.length != original.length) {
            return false;
        }

        // Check element preservation via frequency comparison
        Map<Integer, Long> originalFreq = IntStream.of(original).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> resultFreq = IntStream.of(result).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if (!originalFreq.equals(resultFreq)) {
            return false;
        }

        // Check parity sequence: once an odd number is seen, no even numbers should follow
        boolean seenOdd = false;
        for (int num : result) {
            boolean isEven = (num % 2 == 0);
            if (!isEven) {
                seenOdd = true;
            } else if (seenOdd) {
                return false; // Found an even number after an odd number
            }
        }

        return true;
    }

    private static int[] generateLargeArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }
}