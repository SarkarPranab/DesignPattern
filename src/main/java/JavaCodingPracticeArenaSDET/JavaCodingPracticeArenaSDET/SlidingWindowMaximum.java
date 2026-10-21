package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.function.BiFunction;

/**
 * ============================================================================
 * PROBLEM EXP-44: SLIDING WINDOW MAXIMUM
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * You are given an array of integers `nums`, there is a sliding window of size `k`
 * which is moving from the very left of the array to the very right. You can only see
 * the `k` numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums = [1, 3, -1, -3, 5, 3, 6, 7], k = 3
 *   Output: [3, 3, 5, 5, 6, 7]
 *   Explanation:
 *     Window position                Max
 *     ---------------                ---
 *     [1  3  -1] -3  5  3  6  7       3
 *      1 [3  -1  -3] 5  3  6  7       3
 *      1  3 [-1  -3  5] 3  6  7       5
 *      1  3  -1 [-3  5  3] 6  7       5
 *      1  3  -1  -3 [5  3  6] 7       6
 *      1  3  -1  -3  5 [3  6  7]      7
 *
 * Example 2:
 *   Input:  nums = [1], k = 1
 *   Output: [1]
 *
 * CONSTRAINTS:
 * - 1 <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 * - 1 <= k <= nums.length
 * ============================================================================
 */
public class SlidingWindowMaximum {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Monotonic Deque (Optimal $O(N)$ Time, $O(K)$ Space)
     *
     * @implNote Maintain a deque storing indices of elements. Keep the deque indices
     *           strictly decreasing in terms of their corresponding values in `nums`.
     *           Remove indices outside the current window `[i - k + 1, i]` from the front.
     *           Remove smaller elements from the back before inserting the current index.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(K)
     */
    public int[] maxSlidingWindowDeque(int[] nums, int k) {
        // TODO: Write solution here
        return new int[0];
    }

    /**
     * Approach 2: Max-Priority Queue with Lazy Deletion
     *
     * @implNote Store pairs `(value, index)` in a max-heap. For each window step, push the
     *           new element and pop elements from the top of the heap whose indices are
     *           less than `i - k + 1`.
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(N)
     */
    public int[] maxSlidingWindowHeap(int[] nums, int k) {
        // TODO: Write solution here
        return new int[0];
    }

    /**
     * Approach 3: Brute Force Scan
     *
     * @implNote For every window of size `k`, iterate through all `k` elements to find the max.
     * @targetTimeComplexity O(N * K)
     * @targetSpaceComplexity O(1) auxiliary space (excluding result array)
     */
    public int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        // TODO: Write solution here
        return new int[0];
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] nums;
        private final int k;
        private final int[] expected;
        private final String description;

        public TestCase(int id, int[] nums, int k, int[] expected, String description) {
            this.id = id;
            this.nums = nums;
            this.k = k;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getNums() { return nums; }
        public int getK() { return k; }
        public int[] getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solver = new SlidingWindowMaximum();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new int[]{3, 3, 5, 5, 6, 7}, "Standard sliding window max with mixed integers"),
                new TestCase(2, new int[]{1}, 1, new int[]{1}, "Single element window check"),
                new TestCase(3, new int[]{1, -1}, 1, new int[]{1, -1}, "Window size 1 with negative numbers"),
                new TestCase(4, new int[]{9, 11}, 2, new int[]{11}, "Window size equal to array length"),
                new TestCase(5, new int[]{4, -2}, 2, new int[]{4}, "Two elements window max")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-44 SLIDING WINDOW MAXIMUM");
        System.out.println("================================================================================");

        runApproach("1. Monotonic Deque", solver::maxSlidingWindowDeque, testCases);
        runApproach("2. Max-Priority Queue", solver::maxSlidingWindowHeap, testCases);
        runApproach("3. Brute Force Scan", solver::maxSlidingWindowBruteForce, testCases);
    }

    /**
     * Executes test cases, compares actual sliding window maximum array against expected, and logs timing.
     */
    private static void runApproach(String name, BiFunction<int[], Integer, int[]> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            int[] actual = method.apply(tc.getNums(), tc.getK());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Arrays.equals(actual, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected: %s\n", Arrays.toString(tc.getExpected()));
                System.out.printf("         Actual:   %s\n", Arrays.toString(actual));
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}