package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM EXP-65: SORT A MAP BY VALUE
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a Map<String, Integer>, return a new map ordered by value in DESCENDING order.
 * If two entries have the same value, order them by key in ascending (alphabetical) order.
 * The returned map must preserve this order when iterated (hint: LinkedHashMap).
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  {apple=3, banana=1, cherry=2}
 *   Output: {apple=3, cherry=2, banana=1}
 * Example 2:
 *   Input:  {a=2, b=2, c=3}
 *   Output: {c=3, a=2, b=2}
 *
 * CONSTRAINTS:
 * - 0 <= map.size() <= 10^4
 * - Null map returns an empty map.
 * ============================================================================
 */
public class SortMapByValue {

    static Map<String, Integer> mapOf(Object... keyValues) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < keyValues.length; i += 2) {
            map.put((String) keyValues[i], (Integer) keyValues[i + 1]);
        }
        return map;
    }

    static Map<String, Integer> ordered(Object... keyValues) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < keyValues.length; i += 2) {
            map.put((String) keyValues[i], (Integer) keyValues[i + 1]);
        }
        return map;
    }

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Streams sorted + LinkedHashMap Collector
     *
     * @implNote entrySet().stream().sorted(comparingByValue reversed, then by key).collect(toMap(..., LinkedHashMap::new)).
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(N)
     */
    public Map<String, Integer> sortByValueStreams(Map<String, Integer> map) {
        // TODO: Write solution here
        return new LinkedHashMap<>();
    }

    /**
     * Approach 2: List Of Entries + Collections.sort
     *
     * @implNote Copy the entries into a List, sort with a Comparator, then re-insert into a LinkedHashMap.
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(N)
     */
    public Map<String, Integer> sortByValueList(Map<String, Integer> map) {
        // TODO: Write solution here
        return new LinkedHashMap<>();
    }

    /**
     * Approach 3: PriorityQueue Of Entries
     *
     * @implNote Offer all entries to a PriorityQueue with the comparator and poll them into a LinkedHashMap.
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(N)
     */
    public Map<String, Integer> sortByValueHeap(Map<String, Integer> map) {
        // TODO: Write solution here
        return new LinkedHashMap<>();
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    @FunctionalInterface
    interface Solver {
        Map<String, Integer> solve(Map<String, Integer> map);
    }

    static class TestCase {
        private final int id;
        private final String description;
        private final Map<String, Integer> map;
        private final Map<String, Integer> expected;

        public TestCase(int id, String description, Map<String, Integer> map, Map<String, Integer> expected) {
            this.id = id;
            this.description = description;
            this.map = map;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        SortMapByValue solver = new SortMapByValue();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Distinct values", mapOf("apple", 3, "banana", 1, "cherry", 2), ordered("apple", 3, "cherry", 2, "banana", 1)),
                new TestCase(2, "Ties broken by key", mapOf("a", 2, "b", 2, "c", 3), ordered("c", 3, "a", 2, "b", 2)),
                new TestCase(3, "Single entry", mapOf("x", 9), ordered("x", 9)),
                new TestCase(4, "Negative values", mapOf("p", -1, "q", -5, "r", 0), ordered("r", 0, "p", -1, "q", -5)),
                new TestCase(5, "All equal values", mapOf("z", 1, "y", 1, "x", 1), ordered("x", 1, "y", 1, "z", 1)),
                new TestCase(6, "Empty map", mapOf(), ordered()),
                new TestCase(7, "Null input safety check", null, ordered())
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-65 SORT A MAP BY VALUE");
        System.out.println("================================================================================");

        runApproach("1. Streams sorted + LinkedHashMap Collector", solver::sortByValueStreams, testCases);
        runApproach("2. List Of Entries + Collections.sort", solver::sortByValueList, testCases);
        runApproach("3. PriorityQueue Of Entries", solver::sortByValueHeap, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected output, and logs timing.
     */
    private static void runApproach(String name, Solver method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            Map<String, Integer> result = null;
            boolean threw = false;
            long startTime = System.nanoTime();
            try {
                result = method.solve(tc.map);
            } catch (RuntimeException e) {
                threw = true;
            }
            long durationNano = System.nanoTime() - startTime;
            totalDurationNano += durationNano;

            boolean isCorrect = !threw && String.valueOf(result).equals(String.valueOf(tc.expected));
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.id, tc.description, durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.id, tc.description);
                System.out.printf("         Input:    %s\n", java.util.Arrays.asList(fmt(tc.map)));
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
