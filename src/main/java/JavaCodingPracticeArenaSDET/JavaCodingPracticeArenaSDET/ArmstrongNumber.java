package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM EXP-69: ARMSTRONG NUMBER
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * A non-negative integer is an Armstrong number if it equals the sum of its own digits each
 * raised to the power of the number of digits. Return true if `n` is an Armstrong number.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  n = 153
 *   Output: true   (1^3 + 5^3 + 3^3 = 153)
 * Example 2:
 *   Input:  n = 9474
 *   Output: true   (9^4 + 4^4 + 7^4 + 4^4 = 9474)
 * Example 3:
 *   Input:  n = 123
 *   Output: false
 *
 * CONSTRAINTS:
 * - Negative numbers return false.
 * - 0 and single digit numbers are Armstrong numbers.
 * ============================================================================
 */
public class ArmstrongNumber {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Digit Extraction With % And /
     *
     * @implNote Count digits, then pop each digit with % 10 and add digit^count using a multiply loop.
     * @targetTimeComplexity O(D^2) where D = digits
     * @targetSpaceComplexity O(1)
     */
    public boolean isArmstrongMath(int n) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 2: String Characters With Math.pow
     *
     * @implNote Walk the characters of the number string and sum Math.pow(digit, length).
     * @targetTimeComplexity O(D)
     * @targetSpaceComplexity O(D)
     */
    public boolean isArmstrongString(int n) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 3: Java Streams On Digits
     *
     * @implNote s.chars().map(c -> c - '0').mapToLong(d -> (long) Math.pow(d, s.length())).sum().
     * @targetTimeComplexity O(D)
     * @targetSpaceComplexity O(D)
     */
    public boolean isArmstrongStreams(int n) {
        // TODO: Write solution here
        return false;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    @FunctionalInterface
    interface Solver {
        boolean solve(int n);
    }

    static class TestCase {
        private final int id;
        private final String description;
        private final int n;
        private final boolean expected;

        public TestCase(int id, String description, int n, boolean expected) {
            this.id = id;
            this.description = description;
            this.n = n;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        ArmstrongNumber solver = new ArmstrongNumber();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Three digit Armstrong", 153, true),
                new TestCase(2, "Another three digit", 370, true),
                new TestCase(3, "Four digit Armstrong", 9474, true),
                new TestCase(4, "Not Armstrong", 123, false),
                new TestCase(5, "Zero", 0, true),
                new TestCase(6, "Single digit", 7, true),
                new TestCase(7, "Negative number", -153, false)
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-69 ARMSTRONG NUMBER");
        System.out.println("================================================================================");

        runApproach("1. Digit Extraction With % And /", solver::isArmstrongMath, testCases);
        runApproach("2. String Characters With Math.pow", solver::isArmstrongString, testCases);
        runApproach("3. Java Streams On Digits", solver::isArmstrongStreams, testCases);
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
                result = method.solve(tc.n);
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
                System.out.printf("         Input:    %s\n", java.util.Arrays.asList(fmt(tc.n)));
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
