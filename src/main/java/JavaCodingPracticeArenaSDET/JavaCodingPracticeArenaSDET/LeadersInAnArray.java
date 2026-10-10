package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM: LEADERS IN AN ARRAY (SUPERIOR ELEMENTS)
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array `arr`, find all the "Leaders" in the array.
 * An element is defined as a Leader if it is strictly greater than all elements
 * to its right side.
 *
 * Note: The rightmost element is always a leader because there are no elements
 * to its right.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  arr = [16, 17, 4, 3, 5, 2]
 *   Output: [17, 5, 2] (or [2, 5, 17] depending on collection order)
 *   Explanation:
 *     - 2 has no right elements -> Leader
 *     - 5 > 2 -> Leader
 *     - 3 < 5 -> Not a leader
 *     - 4 < 5 -> Not a leader
 *     - 17 > 5 -> Leader
 *     - 16 < 17 -> Not a leader
 *
 * Example 2:
 *   Input:  arr = [1, 2, 3, 4, 0]
 *   Output: [4, 0]
 *
 * Example 3:
 *   Input:  arr = [7, 4, 5, 7, 3]
 *   Output: [7, 7, 3] or [7, 5, 3] depending on strict vs non-strict rules.
 *
 * CONSTRAINTS:
 * - 1 <= arr.length <= 10^5
 * - -10^9 <= arr[i] <= 10^9
 * ============================================================================
 */
public class LeadersInAnArray {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Right-to-Left Single Scan (Optimal O(N) Time, O(1) Extra Space)
     *
     * @implNote Start from the rightmost element (`arr[N-1]`), maintain a `maxFromRight`
     *           variable, and iterate leftwards down to index 0. Whenever `arr[i] > maxFromRight`,
     *           add `arr[i]` to leaders and update `maxFromRight`. Reverse result if left-to-right order is desired.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) auxiliary space (excluding output list)
     */
    public List<Integer> findLeadersRightToLeft(int[] arr) {
        // TODO: Write solution here
        return Collections.emptyList();
    }

    /**
     * Approach 2: Brute Force Nested Loops
     *
     * @implNote For each element at index `i`, run an inner loop from `j = i + 1` to `N - 1`.
     *           If any element `arr[j] >= arr[i]` is found, `arr[i]` is not a leader.
     * @targetTimeComplexity O(N^2)
     * @targetSpaceComplexity O(1)
     */
    public List<Integer> findLeadersBruteForce(int[] arr) {
        // TODO: Write solution here
        return Collections.emptyList();
    }

    /**
     * Approach 3: Stream & IntStream Functional Range Filter
     *
     * @implNote Use `IntStream.range(0, N)` to filter indices `i` where `arr[i]`
     *           is strictly greater than all elements in `Arrays.stream(arr, i + 1, N)`.
     * @targetTimeComplexity O(N^2)
     * @targetSpaceComplexity O(N)
     */
    public List<Integer> findLeadersStream(int[] arr) {
        // TODO: Write solution here
        return Collections.emptyList();
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] arr;
        private final List<Integer> expectedLeaders;
        private final String description;

        public TestCase(int id, int[] arr, List<Integer> expectedLeaders, String description) {
            this.id = id;
            this.arr = arr;
            this.expectedLeaders = expectedLeaders;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getArr() { return arr; }
        public List<Integer> getExpectedLeaders() { return expectedLeaders; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        LeadersInAnArray solver = new LeadersInAnArray();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{16, 17, 4, 3, 5, 2}, Arrays.asList(17, 5, 2), "Standard array input"),
                new TestCase(2, new int[]{1, 2, 3, 4, 0}, Arrays.asList(4, 0), "Increasing array followed by drop"),
                new TestCase(3, new int[]{5, 4, 3, 2, 1}, Arrays.asList(5, 4, 3, 2, 1), "Strictly decreasing array (all leaders)"),
                new TestCase(4, new int[]{1, 2, 3, 4, 5}, Arrays.asList(5), "Strictly increasing array (only last is leader)"),
                new TestCase(5, new int[]{10}, Arrays.asList(10), "Single element array"),
                new TestCase(6, generateLargeArray(100_000), Arrays.asList(99999), "Large stress test (100k elements)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: LEADERS IN AN ARRAY");
        System.out.println("================================================================================");

        runApproach("1. Optimal Right-To-Left Scan (O(N) Time)", solver::findLeadersRightToLeft, testCases);
        runApproach("2. Brute Force Nested Loops (O(N^2) Time)", solver::findLeadersBruteForce, testCases);
        runApproach("3. Functional Stream Range Filter", solver::findLeadersStream, testCases);
    }

    /**
     * Executes test cases, compares result content (regardless of order), and logs timing.
     */
    private static void runApproach(String name, Function<int[], List<Integer>> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int[] workingArray = (tc.getArr() != null) ? tc.getArr().clone() : null;

            long startTime = System.nanoTime();
            List<Integer> result = method.apply(workingArray);
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = compareUnorderedLists(result, tc.getExpectedLeaders());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Input:    %s\n",
                        tc.getArr() != null && tc.getArr().length > 15 ? "[Large Array]" : Arrays.toString(tc.getArr()));
                System.out.printf("         Expected: %s | Actual: %s\n", tc.getExpectedLeaders(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static boolean compareUnorderedLists(List<Integer> l1, List<Integer> l2) {
        if (l1 == null || l2 == null) return l1 == l2;
        if (l1.size() != l2.size()) return false;
        List<Integer> copy1 = new ArrayList<>(l1);
        List<Integer> copy2 = new ArrayList<>(l2);
        Collections.sort(copy1);
        Collections.sort(copy2);
        return Objects.equals(copy1, copy2);
    }

    private static int[] generateLargeArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }
}