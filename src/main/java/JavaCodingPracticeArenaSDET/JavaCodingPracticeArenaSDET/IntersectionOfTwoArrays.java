package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM EXP-72: INTERSECTION OF TWO ARRAYS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given two integer arrays `a` and `b`, return an array of their intersection. Each element in
 * the result must be UNIQUE and the result may be in any order (the harness sorts it).
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  a = [1, 2, 2, 1], b = [2, 2]
 *   Output: [2]
 * Example 2:
 *   Input:  a = [4, 9, 5], b = [9, 4, 9, 8, 4]
 *   Output: [4, 9]
 *
 * CONSTRAINTS:
 * - 0 <= a.length, b.length <= 1000
 * - 0 <= a[i], b[i] <= 1000
 * - Null input returns an empty array.
 * ============================================================================
 */
public class IntersectionOfTwoArrays {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: HashSet Lookup
     *
     * @implNote Put one array in a HashSet and collect matching values from the other into a result set.
     * @targetTimeComplexity O(N + M)
     * @targetSpaceComplexity O(N + M)
     */
    public int[] intersectionHashSet(int[] a, int[] b) {
        // TODO: Write solution here
        return new int[]{-999};
    }

    /**
     * Approach 2: Sort Both And Two Pointers
     *
     * @implNote Sort copies of both arrays and advance two pointers, skipping duplicates in the output.
     * @targetTimeComplexity O(N log N + M log M)
     * @targetSpaceComplexity O(N + M)
     */
    public int[] intersectionTwoPointers(int[] a, int[] b) {
        // TODO: Write solution here
        return new int[]{-999};
    }

    /**
     * Approach 3: Java Streams distinct + filter
     *
     * @implNote Collect b into a Set, then stream distinct values of a and keep those contained in the Set.
     * @targetTimeComplexity O(N + M)
     * @targetSpaceComplexity O(M)
     */
    public int[] intersectionStreams(int[] a, int[] b) {
        // TODO: Write solution here
        return new int[]{-999};
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    @FunctionalInterface
    interface Solver {
        int[] solve(int[] a, int[] b);
    }

    static class TestCase {
        private final int id;
        private final String description;
        private final int[] a;
        private final int[] b;
        private final int[] expected;

        public TestCase(int id, String description, int[] a, int[] b, int[] expected) {
            this.id = id;
            this.description = description;
            this.a = a;
            this.b = b;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays solver = new IntersectionOfTwoArrays();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Duplicates collapse", new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2}),
                new TestCase(2, "Two common values", new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}, new int[]{4, 9}),
                new TestCase(3, "No common values", new int[]{1}, new int[]{2}, new int[0]),
                new TestCase(4, "Identical sets different order", new int[]{1, 2, 3}, new int[]{3, 2, 1}, new int[]{1, 2, 3}),
                new TestCase(5, "One empty array", new int[0], new int[]{1}, new int[0]),
                new TestCase(6, "Null input safety check", null, new int[]{1}, new int[0])
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-72 INTERSECTION OF TWO ARRAYS");
        System.out.println("================================================================================");

        runApproach("1. HashSet Lookup", solver::intersectionHashSet, testCases);
        runApproach("2. Sort Both And Two Pointers", solver::intersectionTwoPointers, testCases);
        runApproach("3. Java Streams distinct + filter", solver::intersectionStreams, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected output, and logs timing.
     */
    private static void runApproach(String name, Solver method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int[] result = null;
            boolean threw = false;
            long startTime = System.nanoTime();
            try {
                result = method.solve(tc.a == null ? null : tc.a.clone(), tc.b == null ? null : tc.b.clone());
            } catch (RuntimeException e) {
                threw = true;
            }
            long durationNano = System.nanoTime() - startTime;
            totalDurationNano += durationNano;
            if (result != null) Arrays.sort(result);

            boolean isCorrect = !threw && Objects.deepEquals(result, tc.expected);
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.id, tc.description, durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.id, tc.description);
                System.out.printf("         Input:    %s\n", java.util.Arrays.asList(fmt(tc.a), fmt(tc.b)));
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
