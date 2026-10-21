package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM EXP-67: PALINDROME NUMBER
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer `x`, return true if `x` reads the same forwards and backwards.
 * Negative numbers are never palindromes because of the leading minus sign.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  x = 121
 *   Output: true
 * Example 2:
 *   Input:  x = -121
 *   Output: false
 * Example 3:
 *   Input:  x = 10
 *   Output: false
 *
 * CONSTRAINTS:
 * - -2^31 <= x <= 2^31 - 1
 * - Follow-up: solve it without converting the integer to a string.
 * ============================================================================
 */
public class PalindromeNumber {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: String Reverse Compare
     *
     * @implNote Convert to a String, reverse it with StringBuilder and compare.
     * @targetTimeComplexity O(log10 N)
     * @targetSpaceComplexity O(log10 N)
     */
    public boolean isPalindromeString(int x) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 2: Reverse The Whole Number
     *
     * @implNote Build the reversed number in a long and compare it with the original.
     * @targetTimeComplexity O(log10 N)
     * @targetSpaceComplexity O(1)
     */
    public boolean isPalindromeFullReverse(int x) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 3: Reverse Only Half Of The Number
     *
     * @implNote Reverse digits until the reversed half is >= the remaining half; compare both (drop the middle digit).
     * @targetTimeComplexity O(log10 N)
     * @targetSpaceComplexity O(1)
     */
    public boolean isPalindromeHalfReverse(int x) {
        // TODO: Write solution here
        return false;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    @FunctionalInterface
    interface Solver {
        boolean solve(int x);
    }

    static class TestCase {
        private final int id;
        private final String description;
        private final int x;
        private final boolean expected;

        public TestCase(int id, String description, int x, boolean expected) {
            this.id = id;
            this.description = description;
            this.x = x;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        PalindromeNumber solver = new PalindromeNumber();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Odd length palindrome", 121, true),
                new TestCase(2, "Negative number", -121, false),
                new TestCase(3, "Ends with zero", 10, false),
                new TestCase(4, "Zero", 0, true),
                new TestCase(5, "Even length palindrome", 1221, true),
                new TestCase(6, "Longer non palindrome", 1000021, false),
                new TestCase(7, "Single digit", 7, true)
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-67 PALINDROME NUMBER");
        System.out.println("================================================================================");

        runApproach("1. String Reverse Compare", solver::isPalindromeString, testCases);
        runApproach("2. Reverse The Whole Number", solver::isPalindromeFullReverse, testCases);
        runApproach("3. Reverse Only Half Of The Number", solver::isPalindromeHalfReverse, testCases);
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
