package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM EXP-56: BEST TIME TO BUY AND SELL STOCK
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an array `prices` where prices[i] is the price of a stock on day i, choose one day
 * to buy and a later day to sell to maximise profit. Return the maximum profit, or 0 if
 * no profit is possible.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  prices = [7, 1, 5, 3, 6, 4]
 *   Output: 5   (buy at 1, sell at 6)
 * Example 2:
 *   Input:  prices = [7, 6, 4, 3, 1]
 *   Output: 0   (prices only fall)
 *
 * CONSTRAINTS:
 * - 1 <= prices.length <= 10^5
 * - 0 <= prices[i] <= 10^4
 * - Handles null and arrays with length < 2 safely by returning 0.
 * ============================================================================
 */
public class BestTimeToBuyAndSellStock {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Brute Force (All Pairs)
     *
     * @implNote Try every buy day i and sell day j > i and track the best difference.
     * @targetTimeComplexity O(N^2)
     * @targetSpaceComplexity O(1)
     */
    public int maxProfitBruteForce(int[] prices) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 2: One Pass With Running Minimum
     *
     * @implNote Track the lowest price seen so far; at each day the best profit is price - minSoFar.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int maxProfitOnePass(int[] prices) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 3: Kadane On Daily Differences
     *
     * @implNote Profit equals the maximum subarray sum of day-to-day differences (never below 0).
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int maxProfitKadane(int[] prices) {
        // TODO: Write solution here
        return 0;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    @FunctionalInterface
    interface Solver {
        int solve(int[] prices);
    }

    static class TestCase {
        private final int id;
        private final String description;
        private final int[] prices;
        private final int expected;

        public TestCase(int id, String description, int[] prices, int expected) {
            this.id = id;
            this.description = description;
            this.prices = prices;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solver = new BestTimeToBuyAndSellStock();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Standard example", new int[]{7, 1, 5, 3, 6, 4}, 5),
                new TestCase(2, "Prices only fall", new int[]{7, 6, 4, 3, 1}, 0),
                new TestCase(3, "Single day", new int[]{1}, 0),
                new TestCase(4, "Low then high then low", new int[]{2, 4, 1}, 2),
                new TestCase(5, "Two days rising", new int[]{1, 2}, 1),
                new TestCase(6, "Minimum appears late", new int[]{3, 3, 5, 0, 0, 3, 1, 4}, 4),
                new TestCase(7, "Null input safety check", null, 0)
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-56 BEST TIME TO BUY AND SELL STOCK");
        System.out.println("================================================================================");

        runApproach("1. Brute Force (All Pairs)", solver::maxProfitBruteForce, testCases);
        runApproach("2. One Pass With Running Minimum", solver::maxProfitOnePass, testCases);
        runApproach("3. Kadane On Daily Differences", solver::maxProfitKadane, testCases);
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
                result = method.solve(tc.prices == null ? null : tc.prices.clone());
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
                System.out.printf("         Input:    %s\n", java.util.Arrays.asList(fmt(tc.prices)));
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
