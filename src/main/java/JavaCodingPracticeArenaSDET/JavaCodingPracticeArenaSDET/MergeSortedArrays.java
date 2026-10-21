package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

/**
 * ============================================================================
 * PROBLEM EXP-06: MERGE TWO SORTED ARRAYS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * You are given two integer arrays `nums1` and `nums2`, sorted in non-decreasing order,
 * and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2`
 * respectively.
 *
 * Merge `nums1` and `nums2` into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be
 * stored inside the array `nums1`. To accommodate this, `nums1` has a length of `m + n`,
 * where the first `m` elements denote the elements that should be merged, and the last
 * `n` elements are set to `0` and should be ignored. `nums2` has a length of `n`.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 *   Output: [1,2,2,3,5,6]
 *   Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 *                The result of the merge is [1,2,2,3,5,6].
 *
 * Example 2:
 *   Input:  nums1 = [1], m = 1, nums2 = [], n = 0
 *   Output: [1]
 *
 * Example 3:
 *   Input:  nums1 = [0], m = 0, nums2 = [1], n = 1
 *   Output: [1]
 *
 * CONSTRAINTS:
 * - nums1.length == m + n
 * - nums2.length == n
 * - 0 <= m, n <= 200
 * - 1 <= m + n <= 200
 * - -10^9 <= nums1[i], nums2[j] <= 10^9
 * - Handles null arrays safely.
 * ============================================================================
 */
public class MergeSortedArrays {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Three-Pointer In-Place Reverse Traversal (Optimal)
     *
     * @implNote Maintain three pointers: `p1 = m - 1` (last active element in nums1),
     *           `p2 = n - 1` (last element in nums2), and `p = m + n - 1` (write index in nums1).
     *           Compare `nums1[p1]` and `nums2[p2]` from right to left, filling larger
     *           values into `nums1[p]` to avoid overwriting unmerged elements.
     * @targetTimeComplexity O(m + n)
     * @targetSpaceComplexity O(1) in-place modification
     */
    public void mergeReversePointers(int[] nums1, int m, int[] nums2, int n) {
        // TODO: Write solution here
    }

    /**
     * Approach 2: Temporary Buffer Merge Array
     *
     * @implNote Allocate `int[] merged = new int[m + n]`. Use standard two-pointer
     *           merge from index 0 upward. Copy result back into `nums1`.
     * @targetTimeComplexity O(m + n)
     * @targetSpaceComplexity O(m + n) extra space
     */
    public void mergeWithBuffer(int[] nums1, int m, int[] nums2, int n) {
        // TODO: Write solution here
    }

    /**
     * Approach 3: Copy and Sort System Utility (`System.arraycopy` + `Arrays.sort`)
     *
     * @implNote Copy `nums2` into `nums1` starting at index `m` using `System.arraycopy()`,
     *           then sort `nums1` using `Arrays.sort()`.
     * @targetTimeComplexity O((m + n) log(m + n))
     * @targetSpaceComplexity O(1) or O(log(m + n)) depending on sort implementation
     */
    public void mergeCopyAndSort(int[] nums1, int m, int[] nums2, int n) {
        // TODO: Write solution here
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] nums1;
        private final int m;
        private final int[] nums2;
        private final int n;
        private final int[] expected;
        private final String description;

        public TestCase(int id, int[] nums1, int m, int[] nums2, int n, int[] expected, String description) {
            this.id = id;
            this.nums1 = nums1;
            this.m = m;
            this.nums2 = nums2;
            this.n = n;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getNums1() { return nums1; }
        public int getM() { return m; }
        public int[] getNums2() { return nums2; }
        public int getN() { return n; }
        public int[] getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    @FunctionalInterface
    interface MergeMethod {
        void execute(int[] nums1, int m, int[] nums2, int n);
    }

    public static void main(String[] args) {
        MergeSortedArrays solver = new MergeSortedArrays();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3, new int[]{1, 2, 2, 3, 5, 6}, "Standard overlapping arrays"),
                new TestCase(2, new int[]{1}, 1, new int[]{}, 0, new int[]{1}, "Empty second array"),
                new TestCase(3, new int[]{0}, 0, new int[]{1}, 1, new int[]{1}, "Empty first array active elements"),
                new TestCase(4, new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3, new int[]{1, 2, 3, 4, 5, 6}, "All elements in nums2 smaller than nums1"),
                new TestCase(5, new int[]{-5, -2, 0, 0, 0}, 2, new int[]{-3, 1, 4}, 3, new int[]{-5, -3, -2, 1, 4}, "Arrays with negative numbers")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-06 MERGE TWO SORTED ARRAYS");
        System.out.println("================================================================================");

        runApproach("1. Reverse Three-Pointer In-Place Traversal", solver::mergeReversePointers, testCases);
        runApproach("2. Temporary Buffer Merge Array", solver::mergeWithBuffer, testCases);
        runApproach("3. Copy and Sort System Utility", solver::mergeCopyAndSort, testCases);
    }

    /**
     * Executes test cases, compares actual merged nums1 against expected array, and logs timing.
     */
    private static void runApproach(String name, MergeMethod method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int[] workingNums1 = (tc.getNums1() != null) ? tc.getNums1().clone() : null;
            int[] workingNums2 = (tc.getNums2() != null) ? tc.getNums2().clone() : null;

            long startTime = System.nanoTime();
            method.execute(workingNums1, tc.getM(), workingNums2, tc.getN());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Arrays.equals(workingNums1, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected: %s | Actual: %s\n",
                        Arrays.toString(tc.getExpected()), Arrays.toString(workingNums1));
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}