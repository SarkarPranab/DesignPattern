package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM EXP-68: GCD AND LCM OF TWO NUMBERS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given two integers `a` and `b`, return a long array {gcd, lcm}.
 * gcd is the greatest common divisor; lcm is the least common multiple.
 * If either number is 0 the lcm is defined as 0.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  a = 12, b = 18
 *   Output: [6, 36]
 * Example 2:
 *   Input:  a = 0, b = 5
 *   Output: [5, 0]
 *
 * CONSTRAINTS:
 * - -10^9 <= a, b <= 10^9
 * - Use absolute values so the results are non-negative.
 * - Hint: lcm(a, b) = |a / gcd * b| (divide first to avoid overflow).
 * ============================================================================
 */
public class GcdAndLcm {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Iterative Euclidean Algorithm
     *
     * @implNote Repeat (x, y) = (y, x % y) until y is 0; x is the gcd. Then lcm = |a / gcd * b|.
     * @targetTimeComplexity O(log(min(a, b)))
     * @targetSpaceComplexity O(1)
     */
    public long[] gcdLcmIterative(int a, int b) {
        // TODO: Write solution here
        return new long[0];
    }

    /**
     * Approach 2: Recursive Euclidean Algorithm
     *
     * @implNote gcd(x, y) = y == 0 ? x : gcd(y, x % y) using a private recursive helper.
     * @targetTimeComplexity O(log(min(a, b)))
     * @targetSpaceComplexity O(log(min(a, b))) call stack
     */
    public long[] gcdLcmRecursive(int a, int b) {
        // TODO: Write solution here
        return new long[0];
    }

    /**
     * Approach 3: Brute Force Counting Down
     *
     * @implNote Start from min(|a|, |b|) and count down until a number divides both; lcm = |a| / gcd * |b|.
     * @targetTimeComplexity O(min(a, b))
     * @targetSpaceComplexity O(1)
     */
    public long[] gcdLcmBruteForce(int a, int b) {
        // TODO: Write solution here
        return new long[0];
    }

    private static long gcdRecursive(long x, long y) {
        return y == 0 ? x : gcdRecursive(y, x % y);
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    @FunctionalInterface
    interface Solver {
        long[] solve(int a, int b);
    }

    static class TestCase {
        private final int id;
        private final String description;
        private final int a;
        private final int b;
        private final long[] expected;

        public TestCase(int id, String description, int a, int b, long[] expected) {
            this.id = id;
            this.description = description;
            this.a = a;
            this.b = b;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        GcdAndLcm solver = new GcdAndLcm();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Standard example", 12, 18, new long[]{6, 36}),
                new TestCase(2, "Coprime numbers", 7, 13, new long[]{1, 91}),
                new TestCase(3, "One number is zero", 0, 5, new long[]{5, 0}),
                new TestCase(4, "One divides the other", 100, 10, new long[]{10, 100}),
                new TestCase(5, "Equal numbers", 5, 5, new long[]{5, 5}),
                new TestCase(6, "Both zero", 0, 0, new long[]{0, 0}),
                new TestCase(7, "Negative input uses absolute values", -12, 18, new long[]{6, 36})
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-68 GCD AND LCM OF TWO NUMBERS");
        System.out.println("================================================================================");

        runApproach("1. Iterative Euclidean Algorithm", solver::gcdLcmIterative, testCases);
        runApproach("2. Recursive Euclidean Algorithm", solver::gcdLcmRecursive, testCases);
        runApproach("3. Brute Force Counting Down", solver::gcdLcmBruteForce, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected output, and logs timing.
     */
    private static void runApproach(String name, Solver method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long[] result = null;
            boolean threw = false;
            long startTime = System.nanoTime();
            try {
                result = method.solve(tc.a, tc.b);
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
