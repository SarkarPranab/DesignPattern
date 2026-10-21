package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM EXP-66: REVERSE INTEGER (WITH OVERFLOW CHECK)
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a signed 32-bit integer `x`, return `x` with its digits reversed. If reversing causes
 * the value to go outside the signed 32-bit range [-2^31, 2^31 - 1], return 0.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  x = 123
 *   Output: 321
 * Example 2:
 *   Input:  x = -123
 *   Output: -321
 * Example 3:
 *   Input:  x = 120
 *   Output: 21
 *
 * CONSTRAINTS:
 * - -2^31 <= x <= 2^31 - 1
 * - You may not use a 64-bit type in the pure-int approach.
 * ============================================================================
 */
public class ReverseInteger {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Pure Int Math With Pre-Overflow Check
     *
     * @implNote Pop digits with % 10 and check against MAX/10 and MIN/10 before multiplying by 10.
     * @targetTimeComplexity O(log10 N)
     * @targetSpaceComplexity O(1)
     */
    public int reverseMathOverflowCheck(int x) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 2: Long Accumulator
     *
     * @implNote Accumulate in a long and compare with Integer.MAX_VALUE / MIN_VALUE at the end.
     * @targetTimeComplexity O(log10 N)
     * @targetSpaceComplexity O(1)
     */
    public int reverseWithLong(int x) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 3: StringBuilder Reverse
     *
     * @implNote Reverse the digit string of |x| using StringBuilder, parse as long, restore the sign, range check.
     * @targetTimeComplexity O(log10 N)
     * @targetSpaceComplexity O(log10 N)
     */
    public int reverseWithString(int x) {
        // TODO: Write solution here
        return 0;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    @FunctionalInterface
    interface Solver {
        int solve(int x);
    }

    static class TestCase {
        private final int id;
        private final String description;
        private final int x;
        private final int expected;

        public TestCase(int id, String description, int x, int expected) {
            this.id = id;
            this.description = description;
            this.x = x;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        ReverseInteger solver = new ReverseInteger();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Positive number", 123, 321),
                new TestCase(2, "Negative number", -123, -321),
                new TestCase(3, "Trailing zero dropped", 120, 21),
                new TestCase(4, "Zero", 0, 0),
                new TestCase(5, "Overflow positive", 1534236469, 0),
                new TestCase(6, "Overflow at Integer.MIN_VALUE", -2147483648, 0),
                new TestCase(7, "Largest valid result", 1463847412, 2147483641)
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-66 REVERSE INTEGER (WITH OVERFLOW CHECK)");
        System.out.println("================================================================================");

        runApproach("1. Pure Int Math With Pre-Overflow Check", solver::reverseMathOverflowCheck, testCases);
        runApproach("2. Long Accumulator", solver::reverseWithLong, testCases);
        runApproach("3. StringBuilder Reverse", solver::reverseWithString, testCases);
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
                result = method.solve(tc.x);
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
                System.out.printf("         Input:    %s\n", java.util.Arrays.asList(fmt(tc.x)));
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
