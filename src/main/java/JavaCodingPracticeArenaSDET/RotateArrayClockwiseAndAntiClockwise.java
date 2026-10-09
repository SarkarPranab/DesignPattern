package JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.function.BiConsumer;

/**
 * ============================================================================
 * PROBLEM: ROTATE ARRAY K TIMES (CLOCKWISE & ANTI-CLOCKWISE)
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array `nums` and an integer `k`:
 * 1. Rotate the array CLOCKWISE (Right Shift) by `k` positions.
 * 2. Rotate the array ANTI-CLOCKWISE (Left Shift) by `k` positions.
 *
 * ROTATION DEFINITIONS:
 * - Clockwise / Right Shift: Elements move toward higher indices. The last element wraps to index 0.
 *   Example: nums = [1, 2, 3, 4, 5], k = 2  =>  [4, 5, 1, 2, 3]
 *
 * - Anti-Clockwise / Left Shift: Elements move toward lower indices. The first element wraps to index N - 1.
 *   Example: nums = [1, 2, 3, 4, 5], k = 2  =>  [3, 4, 5, 1, 2]
 *
 * CONSTRAINTS:
 * - 0 <= nums.length <= 10^5
 * - 0 <= k <= 10^9 (Handle k > nums.length via k = k % N)
 * ============================================================================
 */
public class RotateArrayClockwiseAndAntiClockwise {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Clockwise (Right) Rotation using In-Place Reversal Algorithm
     *
     * @implNote
     * 1. Normalize k: `k = k % n`.
     * 2. Reverse entire array `[0 ... n - 1]`.
     * 3. Reverse first `k` elements `[0 ... k - 1]`.
     * 4. Reverse remaining `n - k` elements `[k ... n - 1]`.
     *
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) in-place
     */
    public void rotateClockwise(int[] nums, int k) {
        // TODO: Write solution here
    }

    /**
     * Approach 2: Anti-Clockwise (Left) Rotation using In-Place Reversal Algorithm
     *
     * @implNote
     * 1. Normalize k: `k = k % n`.
     * 2. Reverse first `k` elements `[0 ... k - 1]`.
     * 3. Reverse remaining `n - k` elements `[k ... n - 1]`.
     * 4. Reverse entire array `[0 ... n - 1]`.
     *
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) in-place
     */
    public void rotateAntiClockwise(int[] nums, int k) {
        // TODO: Write solution here
    }

    /**
     * Helper method to reverse a subarray in-place between start and end index.
     */
    private void reverse(int[] nums, int start, int end) {
        // TODO: Write two-pointer reversal logic here
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] originalArray;
        private final int k;
        private final int[] expectedClockwise;
        private final int[] expectedAntiClockwise;
        private final String description;

        public TestCase(int id, int[] originalArray, int k,
                        int[] expectedClockwise, int[] expectedAntiClockwise, String description) {
            this.id = id;
            this.originalArray = originalArray;
            this.k = k;
            this.expectedClockwise = expectedClockwise;
            this.expectedAntiClockwise = expectedAntiClockwise;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getOriginalArray() { return originalArray; }
        public int getK() { return k; }
        public int[] getExpectedClockwise() { return expectedClockwise; }
        public int[] getExpectedAntiClockwise() { return expectedAntiClockwise; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        RotateArrayClockwiseAndAntiClockwise solver = new RotateArrayClockwiseAndAntiClockwise();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{1, 2, 3, 4, 5}, 2, new int[]{4, 5, 1, 2, 3}, new int[]{3, 4, 5, 1, 2}, "Standard k=2 shift"),
                new TestCase(2, new int[]{10, 20, 30, 40}, 1, new int[]{40, 10, 20, 30}, new int[]{20, 30, 40, 10}, "Single position shift k=1"),
                new TestCase(3, new int[]{1, 2, 3, 4, 5}, 7, new int[]{4, 5, 1, 2, 3}, new int[]{3, 4, 5, 1, 2}, "k larger than length (k=7, n=5 -> k%n=2)"),
                new TestCase(4, new int[]{1, 2, 3, 4}, 0, new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}, "Zero shift k=0"),
                new TestCase(5, new int[]{99}, 3, new int[]{99}, new int[]{99}, "Single element array"),
                new TestCase(6, new int[]{}, 2, new int[]{}, new int[]{}, "Empty array input")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: ROTATE ARRAY (CLOCKWISE & ANTI-CLOCKWISE)");
        System.out.println("================================================================================");

        runDirectionalSuite("1. CLOCKWISE (RIGHT ROTATION)", solver::rotateClockwise, testCases, true);
        runDirectionalSuite("2. ANTI-CLOCKWISE (LEFT ROTATION)", solver::rotateAntiClockwise, testCases, false);
    }

    /**
     * Executes test cases for either Clockwise or Anti-Clockwise rotation and verifies results.
     */
    private static void runDirectionalSuite(String suiteName, BiConsumer<int[], Integer> rotationMethod,
                                            TestCase[] testCases, boolean isClockwise) {
        System.out.printf("\n--- %s ---\n", suiteName);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int[] workingArray = (tc.getOriginalArray() != null) ? tc.getOriginalArray().clone() : null;
            int[] expected = isClockwise ? tc.getExpectedClockwise() : tc.getExpectedAntiClockwise();

            long startTime = System.nanoTime();
            rotationMethod.accept(workingArray, tc.getK());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Arrays.equals(workingArray, expected);
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Result:   %s\n", Arrays.toString(workingArray));
                System.out.printf("         Expected: %s\n", Arrays.toString(expected));
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}