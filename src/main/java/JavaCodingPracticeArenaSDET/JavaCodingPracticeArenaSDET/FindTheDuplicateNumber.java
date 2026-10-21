package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM EXP-61: FIND THE DUPLICATE NUMBER
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an array `nums` of n + 1 integers where every integer is in the range [1, n], there
 * is exactly one repeated number (it may repeat more than twice). Return that number.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  nums = [1, 3, 4, 2, 2]
 *   Output: 2
 * Example 2:
 *   Input:  nums = [3, 1, 3, 4, 2]
 *   Output: 3
 *
 * CONSTRAINTS:
 * - 1 <= n <= 10^5, nums.length == n + 1
 * - Interview follow-up: solve without modifying the array and in O(1) extra space.
 * - Null input or length < 2 returns -1.
 * ============================================================================
 */
public class FindTheDuplicateNumber {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: HashSet Of Seen Values
     *
     * @implNote Return the first value that cannot be added to the set.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public int findDuplicateHashSet(int[] nums) {
        // TODO: Write solution here
        return -1;
    }

    /**
     * Approach 2: Sort A Copy
     *
     * @implNote Sort a copy of the array and return the first value equal to its predecessor.
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(N)
     */
    public int findDuplicateSorting(int[] nums) {
        // TODO: Write solution here
        return -1;
    }

    /**
     * Approach 3: Floyd Cycle Detection (Tortoise And Hare)
     *
     * @implNote Treat nums[i] as a pointer to index nums[i]; the duplicate is the cycle entry point.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int findDuplicateFloyd(int[] nums) {
        // TODO: Write solution here
        return -1;
    }

    /**
     * Approach 4: Negative Index Marking
     *
     * @implNote Use the value as an index and flip the sign there; meeting an already negative slot means duplicate.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) (modifies input)
     */
    public int findDuplicateNegativeMarking(int[] nums) {
        // TODO: Write solution here
        return -1;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    @FunctionalInterface
    interface Solver {
        int solve(int[] nums);
    }

    static class TestCase {
        private final int id;
        private final String description;
        private final int[] nums;
        private final int expected;

        public TestCase(int id, String description, int[] nums, int expected) {
            this.id = id;
            this.description = description;
            this.nums = nums;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber solver = new FindTheDuplicateNumber();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Standard example", new int[]{1, 3, 4, 2, 2}, 2),
                new TestCase(2, "Duplicate at start", new int[]{3, 1, 3, 4, 2}, 3),
                new TestCase(3, "Repeated more than twice", new int[]{3, 3, 3, 3, 3}, 3),
                new TestCase(4, "Smallest valid array", new int[]{1, 1}, 1),
                new TestCase(5, "Duplicate is the largest", new int[]{2, 2, 1}, 2),
                new TestCase(6, "Null input safety check", null, -1)
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-61 FIND THE DUPLICATE NUMBER");
        System.out.println("================================================================================");

        runApproach("1. HashSet Of Seen Values", solver::findDuplicateHashSet, testCases);
        runApproach("2. Sort A Copy", solver::findDuplicateSorting, testCases);
        runApproach("3. Floyd Cycle Detection (Tortoise And Hare)", solver::findDuplicateFloyd, testCases);
        runApproach("4. Negative Index Marking", solver::findDuplicateNegativeMarking, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected output, and logs timing.
     */
    private static void runApproach(String name, Solver method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int result = -1;
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
