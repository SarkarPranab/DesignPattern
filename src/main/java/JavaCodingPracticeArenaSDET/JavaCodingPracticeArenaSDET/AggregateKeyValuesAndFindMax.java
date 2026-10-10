package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM: AGGREGATE KEY-VALUE PAIRS AND FIND MAXIMUM SUM KEY
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an array of space-separated key-value string pairs (e.g., `["xyz 9", "abc 11", "xyz 21"]`),
 * perform two operations:
 *   1. Aggregate / accumulate the integer values for each unique key.
 *   2. Identify and return the key that has the maximum total aggregated sum,
 *      along with its total sum value.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  entries = ["xyz 9", "abc 11", "xyz 21", "abc 20", "pqr 99"]
 *   Aggregated Totals:
 *     - "xyz": 9 + 21 = 30
 *     - "abc": 11 + 20 = 31
 *     - "pqr": 99
 *   Output: Key = "pqr", TotalSum = 99
 *
 * Example 2:
 *   Input:  entries = ["apple 10", "banana 25", "apple 20", "orange 5"]
 *   Aggregated Totals:
 *     - "apple": 10 + 20 = 30
 *     - "banana": 25
 *     - "orange": 5
 *   Output: Key = "apple", TotalSum = 30
 *
 * CONSTRAINTS:
 * - 0 <= entries.length <= 10^5
 * - Each element is a string formatted as `"<key_string> <integer_value>"`.
 * - Handles negative values and null/empty array inputs safely.
 * ============================================================================
 */
public class AggregateKeyValuesAndFindMax {

    /**
     * DTO to encapsulate the result containing the key with the maximum sum and its value.
     */
    public static class AggregateResult {
        private final String key;
        private final int totalSum;

        public AggregateResult(String key, int totalSum) {
            this.key = key;
            this.totalSum = totalSum;
        }

        public String getKey() { return key; }
        public int getTotalSum() { return totalSum; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AggregateResult that = (AggregateResult) o;
            return totalSum == that.totalSum && Objects.equals(key, that.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, totalSum);
        }

        @Override
        public String toString() {
            return String.format("Key='%s', TotalSum=%d", key, totalSum);
        }
    }

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: HashMap Aggregation & Iterative Entry Scan
     *
     * @implNote Split each string entry by whitespace, parse integer value, and populate
     *           a `HashMap<String, Integer>` using `getOrDefault()`. Then scan map entries
     *           to find the maximum aggregated sum.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(U) where U is unique keys count
     */
    public AggregateResult findMaxAggregatedKeyIterative(String[] entries) {
        // TODO: Write solution here
        return null;
    }

    /**
     * Approach 2: Java 8+ Stream API Grouping & Reduction
     *
     * @implNote Stream array entries, map to key-value objects or arrays, collect with
     *           `Collectors.groupingBy(..., Collectors.summingInt(...))`, and find max entry.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(U)
     */
    public AggregateResult findMaxAggregatedKeyStream(String[] entries) {
        // TODO: Write solution here
        return null;
    }

    /**
     * Approach 3: Helper Method to Return Full Aggregated Map
     *
     * @implNote Aggregate entries into a map for scenarios requiring full key breakdown.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(U)
     */
    public Map<String, Integer> aggregateAllKeys(String[] entries) {
        // TODO: Write solution here
        return Collections.emptyMap();
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String[] entries;
        private final AggregateResult expected;
        private final String description;

        public TestCase(int id, String[] entries, AggregateResult expected, String description) {
            this.id = id;
            this.entries = entries;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String[] getEntries() { return entries; }
        public AggregateResult getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        AggregateKeyValuesAndFindMax solver = new AggregateKeyValuesAndFindMax();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new String[]{"xyz 9", "abc 11", "xyz 21", "abc 20", "pqr 99"}, new AggregateResult("pqr", 99), "Standard key-value aggregation"),
                new TestCase(2, new String[]{"apple 10", "banana 25", "apple 20", "orange 5"}, new AggregateResult("apple", 30), "Multiple duplicate keys"),
                new TestCase(3, new String[]{"a -5", "a 15", "b 5"}, new AggregateResult("a", 10), "Negative and positive numbers mixed"),
                new TestCase(4, new String[]{"single 42"}, new AggregateResult("single", 42), "Single entry array"),
                new TestCase(5, new String[]{}, null, "Empty input array"),
                new TestCase(6, null, null, "Null input array safety check"),
                new TestCase(7, generateLargeDataSet(100_000), new AggregateResult("key_0", 100_000 * 10), "Large stress test (100k entries)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: AGGREGATE KEY-VALUES AND FIND MAX SUM");
        System.out.println("================================================================================");

        runApproach("1. Iterative HashMap Aggregation & Entry Scan", solver::findMaxAggregatedKeyIterative, testCases);
        runApproach("2. Stream API GroupingBy & Max Entry Reduction", solver::findMaxAggregatedKeyStream, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected AggregateResult, and benchmarks execution duration.
     */
    private static void runApproach(String name, Function<String[], AggregateResult> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            AggregateResult result = method.apply(tc.getEntries());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Objects.equals(result, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected: %s\n", tc.getExpected());
                System.out.printf("         Actual:   %s\n", result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static String[] generateLargeDataSet(int size) {
        String[] entries = new String[size];
        for (int i = 0; i < size; i++) {
            entries[i] = "key_" + (i % 100) + " 10";
        }
        return entries;
    }
}