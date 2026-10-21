package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM EXP-60: CONTAINS DUPLICATE
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array `nums`, return true if any value appears at least twice in the
 * array, and false if every element is distinct.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums = [1, 2, 3, 1]
 *   Output: true
 * Example 2:
 *   Input:  nums = [1, 2, 3, 4]
 *   Output: false
 *
 * CONSTRAINTS:
 * - 1 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 * - Null or empty input returns false.
 * ============================================================================
 */
public class ContainsDuplicate {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: HashSet Early Exit
     *
     * @implNote Add each value to a HashSet; Set.add returns false when the value was already present.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public boolean containsDuplicateHashSet(int[] nums) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 2: Sort And Compare Neighbours
     *
     * @implNote Sort a copy; duplicates must then sit next to each other.
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(N)
     */
    public boolean containsDuplicateSorting(int[] nums) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 3: Java Streams Distinct Count
     *
     * @implNote Compare the count of distinct values with the array length.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public boolean containsDuplicateStreams(int[] nums) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 4: Brute Force Nested Loop
     *
     * @implNote Compare every pair of indices (i, j) with j > i.
     * @targetTimeComplexity O(N^2)
     * @targetSpaceComplexity O(1)
     */
    public boolean containsDuplicateBruteForce(int[] nums) {
        // TODO: Write solution here
        return false;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    @FunctionalInterface
    interface Solver {
        boolean solve(int[] nums);
    }

    static class TestCase {
        private final int id;
        private final String description;
        private final int[] nums;
        private final boolean expected;

        public TestCase(int id, String description, int[] nums, boolean expected) {
            this.id = id;
            this.description = description;
            this.nums = nums;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        ContainsDuplicate solver = new ContainsDuplicate();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Duplicate at the ends", new int[]{1, 2, 3, 1}, true),
                new TestCase(2, "All distinct", new int[]{1, 2, 3, 4}, false),
                new TestCase(3, "Many duplicates", new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true),
                new TestCase(4, "Single element", new int[]{5}, false),
                new TestCase(5, "Negative duplicates", new int[]{-1, -2, -1}, true),
                new TestCase(6, "Empty array safety check", new int[0], false),
                new TestCase(7, "Null input safety check", null, false)
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-60 CONTAINS DUPLICATE");
        System.out.println("================================================================================");

        runApproach("1. HashSet Early Exit", solver::containsDuplicateHashSet, testCases);
        runApproach("2. Sort And Compare Neighbours", solver::containsDuplicateSorting, testCases);
        runApproach("3. Java Streams Distinct Count", solver::containsDuplicateStreams, testCases);
        runApproach("4. Brute Force Nested Loop", solver::containsDuplicateBruteForce, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected output, and logs timing.
     */
    private static void runApproach(String name, Solver method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            boolean result = false;
            boolean threw = false;
            long startTime = System.nanoTime();
            try {
                result = method.solve(tc.nums == null ? null : tc.nums.clone());
            } catch (RuntimeException e) {
                threw = true;
            }
            long durationNano = System.nanoTime() - startTime;
            totalDurationNano += durationNano;

            boolean isCorrect = !threw && Objects.deepEquals(result, tc.expected);
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.id, tc.description, durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.id, tc.description);
                System.out.printf("         Input:    %s\n", java.util.Arrays.asList(fmt(tc.nums)));
                System.out.printf("         Expected: %s | Actual: %s%s\n",
                        fmt(tc.expected), fmt(result), threw ? " (exception thrown)" : "");
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    /**
     * Formats arrays, linked lists and other objects for readable test output.
     */
    private static String fmt(Object o) {
        if (o instanceof int[]) return Arrays.toString((int[]) o);
        if (o instanceof long[]) return Arrays.toString((long[]) o);
        return String.valueOf(o);
    }
}
