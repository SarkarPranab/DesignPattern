package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.function.BiConsumer;

/**
 * ============================================================================
 * PROBLEM: ROTATE ARRAY IN RIGHT AND LEFT DIRECTIONS BY K POSITIONS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array `nums` and a non-negative integer `k`:
 * 1. Rotate the array in the RIGHT direction (Clockwise / Right Shift) by `k` steps.
 * 2. Rotate the array in the LEFT direction (Anti-Clockwise / Left Shift) by `k` steps.
 *
 * ROTATION LOGIC (USING IN-PLACE REVERSAL ALGORITHM):
 * - Right Rotation by k:
 *     1. Reverse entire array: `reverse(0, N - 1)`
 *     2. Reverse first k elements: `reverse(0, k - 1)`
 *     3. Reverse remaining elements: `reverse(k, N - 1)`
 *
 * - Left Rotation by k:
 *     1. Reverse first k elements: `reverse(0, k - 1)`
 *     2. Reverse remaining elements: `reverse(k, N - 1)`
 *     3. Reverse entire array: `reverse(0, N - 1)`
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums = [1, 2, 3, 4, 5], k = 2
 *   Right Shift Output: [4, 5, 1, 2, 3]
 *   Left Shift Output:  [3, 4, 5, 1, 2]
 *
 * Example 2:
 *   Input:  nums = [10, 20, 30, 40], k = 1
 *   Right Shift Output: [40, 10, 20, 30]
 *   Left Shift Output:  [20, 30, 40, 10]
 *
 * CONSTRAINTS:
 * - 0 <= nums.length <= 10^5
 * - 0 <= k <= 10^9 (Handle k > nums.length via k = k % N)
 * ============================================================================
 */
public class RotateArrayInRightAndLeftDirection {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Helper Method: Reverses elements in array `a` between index `first` and `last` in-place.
     *
     * @param a Array to reverse
     * @param first Start index (inclusive)
     * @param last End index (inclusive)
     * @return Transformed array reference
     * @targetTimeComplexity O(range length)
     * @targetSpaceComplexity O(1)
     */
    public int[] reverse(int[] a, int first, int last) {
        // TODO: Write two-pointer in-place range reversal solution here
        return a;
    }

    /**
     * Approach 1A: Right Rotation via Range Reversal Algorithm
     *
     * @implNote Normalize `k = k % N`. Call `reverse(0, N-1)`, `reverse(0, k-1)`, and `reverse(k, N-1)`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) in-place
     */
    public void rotateArrayInRightDirection(int[] a, int k) {
        // TODO: Write solution here
    }

    /**
     * Approach 1B: Left Rotation via Range Reversal Algorithm
     *
     * @implNote Normalize `k = k % N`. Call `reverse(0, k-1)`, `reverse(k, N-1)`, and `reverse(0, N-1)`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) in-place
     */
    public void rotateArrayInLeftDirection(int[] a, int k) {
        // TODO: Write solution here
    }

    /**
     * Approach 2: Right Rotation via Auxiliary Array Allocation
     *
     * @implNote Copy element `a[i]` to `temp[(i + k) % N]` and copy back into `a`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public void rotateRightAuxiliary(int[] a, int k) {
        // TODO: Write solution here
    }

    /**
     * Approach 3: Stream & IntStream Index Mapping
     *
     * @implNote Use `IntStream.range(0, N)` to construct a shifted array stream.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public int[] rotateRightStream(int[] a, int k) {
        // TODO: Write solution here
        return new int[0];
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] originalArray;
        private final int k;
        private final int[] expectedRight;
        private final int[] expectedLeft;
        private final String description;

        public TestCase(int id, int[] originalArray, int k,
                        int[] expectedRight, int[] expectedLeft, String description) {
            this.id = id;
            this.originalArray = originalArray;
            this.k = k;
            this.expectedRight = expectedRight;
            this.expectedLeft = expectedLeft;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getOriginalArray() { return originalArray; }
        public int getK() { return k; }
        public int[] getExpectedRight() { return expectedRight; }
        public int[] getExpectedLeft() { return expectedLeft; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        RotateArrayInRightAndLeftDirection solver = new RotateArrayInRightAndLeftDirection();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{1, 2, 3, 4, 5}, 2, new int[]{4, 5, 1, 2, 3}, new int[]{3, 4, 5, 1, 2}, "Standard k=2 rotation"),
                new TestCase(2, new int[]{10, 20, 30, 40}, 1, new int[]{40, 10, 20, 30}, new int[]{20, 30, 40, 10}, "Single shift k=1"),
                new TestCase(3, new int[]{1, 2, 3, 4, 5}, 7, new int[]{4, 5, 1, 2, 3}, new int[]{3, 4, 5, 1, 2}, "k larger than length (k=7, n=5 -> k%n=2)"),
                new TestCase(4, new int[]{1, 2, 3, 4}, 0, new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}, "Zero shift k=0"),
                new TestCase(5, new int[]{99}, 5, new int[]{99}, new int[]{99}, "Single element array"),
                new TestCase(6, new int[]{}, 3, new int[]{}, new int[]{}, "Empty array input")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: ROTATE ARRAY IN RIGHT AND LEFT DIRECTIONS");
        System.out.println("================================================================================");

        runDirectionalSuite("1. RIGHT ROTATION (Reversal Algorithm)",
                solver::rotateArrayInRightDirection, testCases, true);

        runDirectionalSuite("2. LEFT ROTATION (Reversal Algorithm)",
                solver::rotateArrayInLeftDirection, testCases, false);

        runDirectionalSuite("3. RIGHT ROTATION (Auxiliary Array)",
                solver::rotateRightAuxiliary, testCases, true);
    }

    /**
     * Executes test cases for directional rotations and benchmarks execution time.
     */
    private static void runDirectionalSuite(String name, BiConsumer<int[], Integer> rotationMethod,
                                            TestCase[] testCases, boolean isRightDirection) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int[] workingArray = (tc.getOriginalArray() != null) ? tc.getOriginalArray().clone() : null;
            int[] expected = isRightDirection ? tc.getExpectedRight() : tc.getExpectedLeft();

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