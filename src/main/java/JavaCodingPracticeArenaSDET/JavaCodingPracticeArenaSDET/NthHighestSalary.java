package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM EXP-64: NTH HIGHEST DISTINCT SALARY
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an array of salaries and a number `n`, return the nth highest DISTINCT salary.
 * Return -1 if fewer than n distinct salaries exist.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  salaries = [100, 200, 300], n = 2
 *   Output: 200
 * Example 2:
 *   Input:  salaries = [100, 200, 200, 300], n = 2
 *   Output: 200   (duplicates count once)
 *
 * CONSTRAINTS:
 * - 0 <= salaries.length <= 10^5
 * - n >= 1
 * - Null input or n < 1 returns -1.
 * ============================================================================
 */
public class NthHighestSalary {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Streams distinct + sorted + skip
     *
     * @implNote boxed().distinct().sorted(reverseOrder()).skip(n - 1).findFirst().
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(N)
     */
    public int nthHighestStreams(int[] salaries, int n) {
        // TODO: Write solution here
        return -1;
    }

    /**
     * Approach 2: TreeSet In Descending Order
     *
     * @implNote A TreeSet removes duplicates and keeps order; iterate to the nth element.
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(N)
     */
    public int nthHighestTreeSet(int[] salaries, int n) {
        // TODO: Write solution here
        return -1;
    }

    /**
     * Approach 3: Min-Heap Of Size N (Distinct)
     *
     * @implNote Skip duplicates with a Set and keep only the n largest distinct values in a min-heap.
     * @targetTimeComplexity O(N log n)
     * @targetSpaceComplexity O(N)
     */
    public int nthHighestMinHeap(int[] salaries, int n) {
        // TODO: Write solution here
        return -1;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    @FunctionalInterface
    interface Solver {
        int solve(int[] salaries, int n);
    }

    static class TestCase {
        private final int id;
        private final String description;
        private final int[] salaries;
        private final int n;
        private final int expected;

        public TestCase(int id, String description, int[] salaries, int n, int expected) {
            this.id = id;
            this.description = description;
            this.salaries = salaries;
            this.n = n;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        NthHighestSalary solver = new NthHighestSalary();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Second highest", new int[]{100, 200, 300}, 2, 200),
                new TestCase(2, "Duplicates count once", new int[]{100, 200, 200, 300}, 2, 200),
                new TestCase(3, "Not enough distinct values", new int[]{100, 100}, 2, -1),
                new TestCase(4, "Single salary", new int[]{50}, 1, 50),
                new TestCase(5, "n equals distinct count", new int[]{5, 3, 9, 1}, 4, 1),
                new TestCase(6, "Invalid n", new int[]{10, 20, 30}, 0, -1),
                new TestCase(7, "Null input safety check", null, 1, -1)
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-64 NTH HIGHEST DISTINCT SALARY");
        System.out.println("================================================================================");

        runApproach("1. Streams distinct + sorted + skip", solver::nthHighestStreams, testCases);
        runApproach("2. TreeSet In Descending Order", solver::nthHighestTreeSet, testCases);
        runApproach("3. Min-Heap Of Size N (Distinct)", solver::nthHighestMinHeap, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected output, and logs timing.
     */
    private static void runApproach(String name, Solver method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int result = 0;
            boolean threw = false;
            long startTime = System.nanoTime();
            try {
                result = method.solve(tc.salaries == null ? null : tc.salaries.clone(), tc.n);
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
                System.out.printf("         Input:    %s\n", java.util.Arrays.asList(fmt(tc.salaries), fmt(tc.n)));
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
