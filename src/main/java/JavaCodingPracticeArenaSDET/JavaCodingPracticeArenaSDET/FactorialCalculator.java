package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.math.BigInteger;
import java.util.Objects;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM COD-13: FIND FACTORIAL OF A NUMBER
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a non-negative integer `n`, compute its factorial (`n!`).
 * Factorial of `n` is defined as:
 *   n! = n * (n - 1) * (n - 2) * ... * 1
 *   0! = 1
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  n = 5
 *   Output: 120
 *
 * Example 2:
 *   Input:  n = 0
 *   Output: 1
 *
 * CONSTRAINTS:
 * - 0 <= n <= 1000
 * - Must support arbitrary-precision integers (`BigInteger`) to prevent overflow for `n > 20`.
 * - Negative inputs return `BigInteger.ZERO` or throw an exception.
 * ============================================================================
 */
public class FactorialCalculator {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Standard Imperative For-Loop
     *
     * @implNote Maintain an accumulator variable `result = BigInteger.ONE`.
     *           Iterate `i` from 1 to `n`, multiplying `result = result.multiply(BigInteger.valueOf(i))`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public BigInteger factorialIterative(int n) {
        // TODO: Write solution here
        return BigInteger.ZERO;
    }

    /**
     * Approach 2: Traditional Tail-Recursive Function
     *
     * @implNote Base cases: `n <= 0` returns `BigInteger.ONE`.
     *           Recursive step: `BigInteger.valueOf(n).multiply(factorialRecursive(n - 1))`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) stack frames
     */
    public BigInteger factorialRecursive(int n) {
        // TODO: Write solution here
        return BigInteger.ZERO;
    }

    /**
     * Approach 3: BigInteger Stream Reduction
     *
     * @implNote Stream range `IntStream.rangeClosed(1, n)`, map to `BigInteger`,
     *           and aggregate total using `reduce(BigInteger.ONE, BigInteger::multiply)`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public BigInteger factorialStream(int n) {
        // TODO: Write solution here
        return BigInteger.ZERO;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int n;
        private final BigInteger expected;
        private final String description;

        public TestCase(int id, int n, BigInteger expected, String description) {
            this.id = id;
            this.n = n;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int getN() { return n; }
        public BigInteger getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        FactorialCalculator solver = new FactorialCalculator();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, 5, BigInteger.valueOf(120), "Standard small integer (5!)"),
                new TestCase(2, 0, BigInteger.ONE, "Zero factorial edge case (0! = 1)"),
                new TestCase(3, 1, BigInteger.ONE, "One factorial edge case (1! = 1)"),
                new TestCase(4, 10, BigInteger.valueOf(3628800), "Medium integer (10!)"),
                new TestCase(5, -3, BigInteger.ZERO, "Negative number safety check"),
                new TestCase(6, 100, calculateExpectedLargeFactorial(100), "Large factorial stress test (100!)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: COD-13 FACTORIAL CALCULATOR");
        System.out.println("================================================================================");

        runApproach("1. Imperative Loop (BigInteger)", solver::factorialIterative, testCases);
        runApproach("2. Traditional Recursion", solver::factorialRecursive, testCases);
        runApproach("3. Stream API IntStream Reduction", solver::factorialStream, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected BigInteger result, and logs execution timing.
     */
    private static void runApproach(String name, Function<Integer, BigInteger> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            BigInteger result = method.apply(tc.getN());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Objects.equals(result, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Input n = %d\n", tc.getN());
                System.out.printf("         Expected: %s\n", tc.getExpected());
                System.out.printf("         Actual:   %s\n", result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static BigInteger calculateExpectedLargeFactorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}