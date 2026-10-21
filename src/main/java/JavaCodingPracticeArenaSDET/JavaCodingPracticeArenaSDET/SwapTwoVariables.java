package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Objects;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM COD-06: SWAP TWO VARIABLES WITH AND WITHOUT TEMP VARIABLE
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given two integer values `a` and `b`, swap their values using multiple
 * technique approaches:
 * 1. Traditional temporary variable usage
 * 2. Arithmetic addition and subtraction (`+`, `-`) without temp variable
 * 3. Bitwise XOR operator (`^`) without temp variable
 * 4. Single-line inline arithmetic assignment without temp variable
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  a = 10, b = 20
 *   Output: SwapPair(a = 20, b = 10)
 *
 * Example 2:
 *   Input:  a = -5, b = 15
 *   Output: SwapPair(a = 15, b = -5)
 *
 * CONSTRAINTS:
 * - Integer values fit within 32-bit signed integer range (`Integer.MIN_VALUE` to `Integer.MAX_VALUE`).
 * - For arithmetic methods (`+`, `-`), watch out for potential integer overflow/underflow.
 * ============================================================================
 */
public class SwapTwoVariables {

    /**
     * Immutable container holding swapped values for assertion testing.
     */
    public static class SwapPair {
        private final int a;
        private final int b;

        public SwapPair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() { return a; }
        public int getB() { return b; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SwapPair)) return false;
            SwapPair swapPair = (SwapPair) o;
            return a == swapPair.a && b == swapPair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public String toString() {
            return String.format("(a = %d, b = %d)", a, b);
        }
    }

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Classical Temporary Variable Swap
     *
     * @implNote Store `a` in `temp`, set `a = b`, and restore `b = temp`.
     * @targetTimeComplexity O(1)
     * @targetSpaceComplexity O(1)
     */
    public SwapPair swapWithTemp(SwapPair input) {
        // TODO: Write solution here
        return new SwapPair(0, 0);
    }

    /**
     * Approach 2: Arithmetic Addition & Subtraction (No Temp Variable)
     *
     * @implNote Set `a = a + b`, then `b = a - b`, and finally `a = a - b`.
     * @targetTimeComplexity O(1)
     * @targetSpaceComplexity O(1)
     */
    public SwapPair swapArithmeticWithoutTemp(SwapPair input) {
        // TODO: Write solution here
        return new SwapPair(0, 0);
    }

    /**
     * Approach 3: Bitwise XOR Operator (No Temp Variable)
     *
     * @implNote Set `a = a ^ b`, then `b = a ^ b`, and finally `a = a ^ b`.
     *           Prevents integer overflow issues present in arithmetic addition.
     * @targetTimeComplexity O(1)
     * @targetSpaceComplexity O(1)
     */
    public SwapPair swapBitwiseXORWithoutTemp(SwapPair input) {
        // TODO: Write solution here
        return new SwapPair(0, 0);
    }

    /**
     * Approach 4: Single-Line Inline Expression Swap (No Temp Variable)
     *
     * @implNote Use inline assignment trick: `b = (a + b) - (a = b);`
     * @targetTimeComplexity O(1)
     * @targetSpaceComplexity O(1)
     */
    public SwapPair swapSingleLineWithoutTemp(SwapPair input) {
        // TODO: Write solution here
        return new SwapPair(0, 0);
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final SwapPair input;
        private final SwapPair expected;
        private final String description;

        public TestCase(int id, SwapPair input, SwapPair expected, String description) {
            this.id = id;
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public SwapPair getInput() { return input; }
        public SwapPair getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        SwapTwoVariables solver = new SwapTwoVariables();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new SwapPair(10, 20), new SwapPair(20, 10), "Standard positive integers"),
                new TestCase(2, new SwapPair(-5, 15), new SwapPair(15, -5), "Mixed negative and positive integers"),
                new TestCase(3, new SwapPair(0, 42), new SwapPair(42, 0), "Swap involving zero"),
                new TestCase(4, new SwapPair(-100, -200), new SwapPair(-200, -100), "Both negative integers"),
                new TestCase(5, new SwapPair(99, 99), new SwapPair(99, 99), "Identical values")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: COD-06 SWAP TWO VARIABLES");
        System.out.println("================================================================================");

        runApproach("1. Classical Temporary Variable Swap", solver::swapWithTemp, testCases);
        runApproach("2. Arithmetic (+, -) Without Temp", solver::swapArithmeticWithoutTemp, testCases);
        runApproach("3. Bitwise XOR (^) Without Temp", solver::swapBitwiseXORWithoutTemp, testCases);
        runApproach("4. Single-Line Inline Swap", solver::swapSingleLineWithoutTemp, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected swapped values, and logs timing.
     */
    private static void runApproach(String name, Function<SwapPair, SwapPair> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            SwapPair result = method.apply(tc.getInput());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Objects.equals(result, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Input:    %s\n", tc.getInput());
                System.out.printf("         Expected: %s | Actual: %s\n", tc.getExpected(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}