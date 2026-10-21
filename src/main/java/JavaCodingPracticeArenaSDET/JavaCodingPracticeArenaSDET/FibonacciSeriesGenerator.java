package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM COD-12: PRINT FIBONACCI SERIES UP TO N TERMS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer `n` representing the total number of terms, generate the
 * Fibonacci sequence containing the first `n` terms.
 *
 * The Fibonacci sequence starts with 0 and 1, where each subsequent term is
 * the sum of the preceding two terms: F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2).
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  n = 8
 *   Output: [0, 1, 1, 2, 3, 5, 8, 13]
 *
 * Example 2:
 *   Input:  n = 1
 *   Output: [0]
 *
 * Example 3:
 *   Input:  n = 0
 *   Output: []
 *
 * CONSTRAINTS:
 * - 0 <= n <= 90 (Fits within 64-bit signed long before overflow)
 * - Returns an empty array if `n <= 0`.
 * ============================================================================
 */
public class FibonacciSeriesGenerator {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Iterative Dynamic State Swapping
     *
     * @implNote Maintain two tracking variables (`first = 0`, `second = 1`).
     *           Loop `n` times, adding `first` to the output array and calculating
     *           the next term (`next = first + second`).
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) for sequence array storage
     */
    public long[] generateFibonacciIterative(int n) {
        // TODO: Write solution here
        return new long[0];
    }

    /**
     * Approach 2: Memoized Recursive Sequence Builder
     *
     * @implNote Fill sequence array recursively using bottom-up memoization
     *           `arr[i] = arr[i - 1] + arr[i - 2]` to eliminate duplicate subproblems.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) call stack and array storage
     */
    public long[] generateFibonacciMemoized(int n) {
        // TODO: Write solution here
        return new long[0];
    }

    /**
     * Approach 3: Binet's Closed-Form Formula (Math Exact Rounding)
     *
     * @implNote Calculate individual terms directly using Golden Ratio formula:
     *           F(k) = (Phi^k - psi^k) / sqrt(5).
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public long[] generateFibonacciClosedForm(int n) {
        // TODO: Write solution here
        return new long[0];
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int n;
        private final long[] expected;
        private final String description;

        public TestCase(int id, int n, long[] expected, String description) {
            this.id = id;
            this.n = n;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int getN() { return n; }
        public long[] getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        FibonacciSeriesGenerator solver = new FibonacciSeriesGenerator();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, 8, new long[]{0, 1, 1, 2, 3, 5, 8, 13}, "Standard 8 terms"),
                new TestCase(2, 1, new long[]{0}, "Single term sequence"),
                new TestCase(3, 2, new long[]{0, 1}, "Two terms sequence"),
                new TestCase(4, 0, new long[]{}, "Zero terms safety check"),
                new TestCase(5, -5, new long[]{}, "Negative terms safety check"),
                new TestCase(6, 50, generateExpectedLargeFibonacci(50), "50 terms stress test")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: COD-12 FIBONACCI SERIES GENERATOR");
        System.out.println("================================================================================");

        runApproach("1. Iterative Dynamic State Swapping", solver::generateFibonacciIterative, testCases);
        runApproach("2. Memoized Bottom-Up Recursion", solver::generateFibonacciMemoized, testCases);
        runApproach("3. Binet's Closed-Form Formula", solver::generateFibonacciClosedForm, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected Fibonacci sequences, and logs timing.
     */
    private static void runApproach(String name, Function<Integer, long[]> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            long[] result = method.apply(tc.getN());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Arrays.equals(result, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Input n = %d\n", tc.getN());
                System.out.printf("         Expected: %s\n", Arrays.toString(tc.getExpected()));
                System.out.printf("         Actual:   %s\n", Arrays.toString(result));
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static long[] generateExpectedLargeFibonacci(int n) {
        if (n <= 0) return new long[0];
        long[] fib = new long[n];
        fib[0] = 0;
        if (n > 1) fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }
}