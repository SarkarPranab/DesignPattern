package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

/**
 * ============================================================================
 * PROBLEM COD-02: PRINT MULTIPLICATION TABLE WITHOUT MULTIPLY OPERATOR
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Generate the multiplication table for a given number `num` up to `limit` terms
 * WITHOUT using the multiplication operator (`*`).
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  num = 5, limit = 10
 *   Output: [5, 10, 15, 20, 25, 30, 35, 40, 45, 50]
 *   Explanation:
 *     5 x 1 = 5 (0 + 5)
 *     5 x 2 = 10 (5 + 5)
 *     ...
 *     5 x 10 = 50
 *
 * Example 2:
 *   Input:  num = 7, limit = 3
 *   Output: [7, 14, 21]
 *
 * CONSTRAINTS:
 * - Direct use of the binary multiplication operator (`*`) is restricted.
 * - `limit` >= 0
 * - Handles negative numbers and 0 safely.
 * ============================================================================
 */
public class MultiplicationTableWithoutMultiply {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Repeated Addition Loop
     *
     * @implNote Maintain a running accumulator variable `sum = 0`. Loop `limit` times,
     *           adding `num` to `sum` in each iteration (`sum += num`), and collect the values.
     * @targetTimeComplexity O(limit)
     * @targetSpaceComplexity O(limit) for output sequence
     */
    public int[] generateTableRepeatedAddition(int num, int limit) {
        // TODO: Write solution here
        return new int[0];
    }

    /**
     * Approach 2: Bitwise Bit-Shift Multiplication (Russian Peasant / Booth's Algorithm)
     *
     * @implNote Compute product `a * b` without `*` using binary bitwise shifts (`<<`, `>>`)
     *           and additions for each term `i` from 1 to `limit`.
     * @targetTimeComplexity O(limit * log(limit))
     * @targetSpaceComplexity O(limit)
     */
    public int[] generateTableBitwiseShift(int num, int limit) {
        // TODO: Write solution here
        return new int[0];
    }

    /**
     * Approach 3: Tail-Recursive Sequence Generator
     *
     * @implNote Recursively accumulate values without using loops or the `*` operator.
     * @targetTimeComplexity O(limit)
     * @targetSpaceComplexity O(limit) recursion stack depth
     */
    public int[] generateTableRecursive(int num, int limit) {
        // TODO: Write solution here
        return new int[0];
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int num;
        private final int limit;
        private final int[] expected;
        private final String description;

        public TestCase(int id, int num, int limit, int[] expected, String description) {
            this.id = id;
            this.num = num;
            this.limit = limit;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int getNum() { return num; }
        public int getLimit() { return limit; }
        public int[] getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        MultiplicationTableWithoutMultiply solver = new MultiplicationTableWithoutMultiply();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, 5, 10, new int[]{5, 10, 15, 20, 25, 30, 35, 40, 45, 50}, "Standard 5 multiplication table up to 10 terms"),
                new TestCase(2, 7, 3, new int[]{7, 14, 21}, "7 table up to 3 terms"),
                new TestCase(3, 0, 5, new int[]{0, 0, 0, 0, 0}, "Zero multiplication table"),
                new TestCase(4, -4, 4, new int[]{-4, -8, -12, -16}, "Negative integer multiplication table"),
                new TestCase(5, 10, 0, new int[]{}, "Zero limit test"),
                new TestCase(6, 3, 100_000, generateExpectedLargeTable(3, 100_000), "Large stress test (100k terms)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: COD-02 MULTIPLICATION TABLE WITHOUT * OPERATOR");
        System.out.println("================================================================================");

        runApproach("1. Repeated Addition Loop", solver::generateTableRepeatedAddition, testCases);
        runApproach("2. Bitwise Bit-Shift Multiplication", solver::generateTableBitwiseShift, testCases);
        runApproach("3. Tail-Recursive Generator", solver::generateTableRecursive, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected table, and logs execution duration.
     */
    private static void runApproach(String name, BiFunction<Integer, Integer, int[]> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            int[] result = method.apply(tc.getNum(), tc.getLimit());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Arrays.equals(result, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Inputs:   num = %d, limit = %d\n", tc.getNum(), tc.getLimit());
                System.out.printf("         Expected: %s\n", tc.getExpected() != null && tc.getExpected().length > 15 ? "[Large Sequence]" : Arrays.toString(tc.getExpected()));
                System.out.printf("         Actual:   %s\n", result != null && result.length > 15 ? "[Large Sequence]" : Arrays.toString(result));
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static int[] generateExpectedLargeTable(int num, int limit) {
        int[] expected = new int[limit];
        int sum = 0;
        for (int i = 0; i < limit; i++) {
            sum += num;
            expected[i] = sum;
        }
        return expected;
    }
}