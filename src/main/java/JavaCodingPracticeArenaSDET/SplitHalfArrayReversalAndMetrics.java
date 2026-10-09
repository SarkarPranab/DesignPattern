package JavaCodingPracticeArenaSDET;

import java.util.Arrays;

/**
 * ============================================================================
 * PROBLEM: REVERSE ARRAY HALVES IN-PLACE & COMPUTE ARRAY METRICS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an array of integers `arr`:
 * 1. Calculate the sum of all elements in the array.
 * 2. Divide the array into two halves at index `mid = arr.length / 2`.
 * 3. Reverse the first half `[0 ... mid - 1]` in-place.
 * 4. Reverse the second half `[mid ... arr.length - 1]` in-place.
 * 5. Find the largest and second largest numbers in the array.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  arr = [4, 5, 10, 3, 7, 11]
 *   Midpoint: 3 (First half: [4, 5, 10], Second half: [3, 7, 11])
 *   Sum: 40
 *   After First Half Reverse:  [10, 5, 4, 3, 7, 11]
 *   After Second Half Reverse: [10, 5, 4, 11, 7, 3]
 *   Largest: 11
 *   Second Largest: 10
 *
 * Example 2 (Odd length):
 *   Input:  arr = [1, 2, 3, 4, 5]
 *   Midpoint: 2 (First half: [1, 2], Second half: [3, 4, 5])
 *   Sum: 15
 *   After Both Halves Reversed: [2, 1, 5, 4, 3]
 *   Largest: 5
 *   Second Largest: 4
 *
 * CONSTRAINTS:
 * - 0 <= arr.length <= 10^5
 * - Handle arrays with fewer than 2 elements gracefully for second largest calculation.
 * ============================================================================
 */
public class SplitHalfArrayReversalAndMetrics {

    /**
     * DTO to encapsulate metrics calculated from the array.
     */
    public static class ArrayMetrics {
        public int sum;
        public int largest;
        public Integer secondLargest; // Nullable if length < 2 or no distinct 2nd largest

        public ArrayMetrics(int sum, int largest, Integer secondLargest) {
            this.sum = sum;
            this.largest = largest;
            this.secondLargest = secondLargest;
        }

        @Override
        public String toString() {
            return String.format("Sum=%d, Largest=%d, SecondLargest=%s",
                    sum, largest, (secondLargest != null ? secondLargest : "N/A"));
        }
    }

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Two-Pointer Range Reversal & Single-Pass Metrics
     *
     * @implNote Helper function to reverse subarray between `left` and `right` indices in-place.
     *           Find sum, max, and 2nd max in optimal O(N) time without full array sorting.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) in-place
     */
    public void reverseHalvesInPlace(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int mid = arr.length / 2;

        // TODO: Reverse range [0, mid - 1]
        // TODO: Reverse range [mid, arr.length - 1]
    }

    /**
     * Calculates array metrics (Sum, Max, 2nd Max) efficiently.
     *
     * @targetTimeComplexity O(N) single scan
     * @targetSpaceComplexity O(1)
     */
    public ArrayMetrics computeMetrics(int[] arr) {
        // TODO: Write single-pass algorithm to compute sum, max, and second max
        return new ArrayMetrics(0, 0, null);
    }

    /**
     * Approach 2: Java 8+ Stream & Array Processing (Declarative Style)
     *
     * @targetTimeComplexity O(N log N) due to stream sorting
     * @targetSpaceComplexity O(N)
     */
    public ArrayMetrics computeMetricsStream(int[] arr) {
        // TODO: Write stream-based solution for sum, max, and second max
        return new ArrayMetrics(0, 0, null);
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] originalArray;
        private final int[] expectedReversedHalves;
        private final int expectedSum;
        private final int expectedLargest;
        private final Integer expectedSecondLargest;
        private final String description;

        public TestCase(int id, int[] originalArray, int[] expectedReversedHalves,
                        int expectedSum, int expectedLargest, Integer expectedSecondLargest, String description) {
            this.id = id;
            this.originalArray = originalArray;
            this.expectedReversedHalves = expectedReversedHalves;
            this.expectedSum = expectedSum;
            this.expectedLargest = expectedLargest;
            this.expectedSecondLargest = expectedSecondLargest;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getOriginalArray() { return originalArray; }
        public int[] getExpectedReversedHalves() { return expectedReversedHalves; }
        public int getExpectedSum() { return expectedSum; }
        public int getExpectedLargest() { return expectedLargest; }
        public Integer getExpectedSecondLargest() { return expectedSecondLargest; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        SplitHalfArrayReversalAndMetrics solver = new SplitHalfArrayReversalAndMetrics();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{4, 5, 10, 3, 7, 11}, new int[]{10, 5, 4, 11, 7, 3}, 40, 11, 10, "Even length array"),
                new TestCase(2, new int[]{1, 2, 3, 4, 5}, new int[]{2, 1, 5, 4, 3}, 15, 5, 4, "Odd length array"),
                new TestCase(3, new int[]{10, 20}, new int[]{10, 20}, 30, 20, 10, "Minimal 2-element array"),
                new TestCase(4, new int[]{7}, new int[]{7}, 7, 7, null, "Single element array"),
                new TestCase(5, new int[]{-5, -10, -3, -1, -8, -2}, new int[]{-3, -10, -5, -2, -8, -1}, -29, -1, -2, "Negative numbers array")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: SPLIT HALF ARRAY REVERSAL & METRICS");
        System.out.println("================================================================================");

        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int[] workingArray = (tc.getOriginalArray() != null) ? tc.getOriginalArray().clone() : null;

            long startTime = System.nanoTime();

            // Compute metrics before/after reversal
            ArrayMetrics metrics = solver.computeMetrics(workingArray);
            solver.reverseHalvesInPlace(workingArray);

            long durationNano = System.nanoTime() - startTime;
            totalDurationNano += durationNano;

            boolean isReversalCorrect = Arrays.equals(workingArray, tc.getExpectedReversedHalves());
            boolean isSumCorrect = (metrics != null && metrics.sum == tc.getExpectedSum());
            boolean isLargestCorrect = (metrics != null && metrics.largest == tc.getExpectedLargest());
            boolean isSecondLargestCorrect = (metrics != null && ObjectsEquals(metrics.secondLargest, tc.getExpectedSecondLargest()));

            boolean allPassed = isReversalCorrect && isSumCorrect && isLargestCorrect && isSecondLargestCorrect;

            if (allPassed) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Array Output: %s | Expected: %s\n",
                        Arrays.toString(workingArray), Arrays.toString(tc.getExpectedReversedHalves()));
                System.out.printf("         Metrics Output: %s | Expected: [Sum=%d, Largest=%d, SecondLargest=%s]\n",
                        metrics, tc.getExpectedSum(), tc.getExpectedLargest(), tc.getExpectedSecondLargest());
            }
        }

        System.out.printf("\nSummary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static boolean ObjectsEquals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }
}