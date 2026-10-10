package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM: REVERSE A HASHMAP (SWAP KEYS AND VALUES)
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a `Map<K, V>`, invert/reverse the map such that every original value
 * becomes a key in the new map, and every original key becomes its corresponding
 * value `Map<V, K>`.
 *
 * SPECIAL CONSIDERATION & EDGE CASES:
 * 1. Duplicate Values: If multiple keys in the original map share the same value
 *    (e.g., `{"A": 1, "B": 1}`), standard key-value swapping will overwrite
 *    previous mappings in a 1-to-1 map structure.
 * 2. Null Safety: Handle null input maps, null keys, and null values gracefully.
 *
 * EXAMPLES:
 * Example 1 (Unique Values):
 *   Input:  {"A": 1, "B": 2, "C": 3, "D": 4}
 *   Output: {1: "A", 2: "B", 3: "C", 4: "D"}
 *
 * Example 2 (Duplicate Values - Multi-Map Representation):
 *   Input:  {"Apple": 1, "Banana": 1, "Cherry": 2}
 *   Output (1-to-1): {1: "Banana" (or "Apple"), 2: "Cherry"}
 *
 * CONSTRAINTS:
 * - 0 <= map.size() <= 10^6
 * - Key and value types can be any non-null or null-permitted object reference.
 * ============================================================================
 */
public class ReverseHashMap {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: KeySet Iteration Loop (Standard 1-to-1 Map Inversion)
     *
     * @implNote Iterate through `data.keySet()`, retrieving each key's corresponding value
     *           via `data.get(key)`, and inserting into `reversedMap.put(value, key)`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public Map<Integer, String> reverseMapKeySet(Map<String, Integer> data) {
        // TODO: Write solution here
        return Collections.emptyMap();
    }

    /**
     * Approach 2: EntrySet Iteration Loop (Optimal Performance)
     *
     * @implNote Iterate directly over `data.entrySet()`. Eliminates redundant `get(key)` hash lookups
     *           by calling `entry.getValue()` and `entry.getKey()` directly.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public Map<Integer, String> reverseMapEntrySet(Map<String, Integer> data) {
        // TODO: Write solution here
        return Collections.emptyMap();
    }

    /**
     * Approach 3: Java 8+ Stream API Collectors.toMap()
     *
     * @implNote Stream `data.entrySet()` and collect using `Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey)`.
     *           Use a merge function `(existing, replacement) -> replacement` to handle potential duplicate values.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public Map<Integer, String> reverseMapStream(Map<String, Integer> data) {
        // TODO: Write solution here
        return Collections.emptyMap();
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final Map<String, Integer> input;
        private final Map<Integer, String> expected;
        private final String description;

        public TestCase(int id, Map<String, Integer> input, Map<Integer, String> expected, String description) {
            this.id = id;
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public Map<String, Integer> getInput() { return input; }
        public Map<Integer, String> getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        ReverseHashMap solver = new ReverseHashMap();

        Map<String, Integer> standardMap = new HashMap<>();
        standardMap.put("A", 1);
        standardMap.put("B", 2);
        standardMap.put("C", 3);
        standardMap.put("D", 4);

        Map<Integer, String> expectedStandard = new HashMap<>();
        expectedStandard.put(1, "A");
        expectedStandard.put(2, "B");
        expectedStandard.put(3, "C");
        expectedStandard.put(4, "D");

        Map<String, Integer> singleMap = Collections.singletonMap("SoleKey", 100);
        Map<Integer, String> expectedSingle = Collections.singletonMap(100, "SoleKey");

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, standardMap, expectedStandard, "Standard 1-to-1 map inversion"),
                new TestCase(2, singleMap, expectedSingle, "Single entry map"),
                new TestCase(3, new HashMap<>(), new HashMap<>(), "Empty map input"),
                new TestCase(4, null, null, "Null map input safety check"),
                new TestCase(5, generateLargeMap(100_000), generateExpectedLargeMap(100_000), "Large stress test (100k entries)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: REVERSE HASHMAP (KEY-VALUE SWAP)");
        System.out.println("================================================================================");

        runApproach("1. KeySet Iteration Loop", solver::reverseMapKeySet, testCases);
        runApproach("2. EntrySet Direct Iteration", solver::reverseMapEntrySet, testCases);
        runApproach("3. Stream API Collectors.toMap()", solver::reverseMapStream, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected map contents, and logs execution duration.
     */
    private static void runApproach(String name, Function<Map<String, Integer>, Map<Integer, String>> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            Map<String, Integer> workingMap = (tc.getInput() != null) ? new HashMap<>(tc.getInput()) : null;

            long startTime = System.nanoTime();
            Map<Integer, String> result = method.apply(workingMap);
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

    private static Map<String, Integer> generateLargeMap(int size) {
        Map<String, Integer> map = new HashMap<>(size);
        for (int i = 0; i < size; i++) {
            map.put("Key_" + i, i);
        }
        return map;
    }

    private static Map<Integer, String> generateExpectedLargeMap(int size) {
        Map<Integer, String> map = new HashMap<>(size);
        for (int i = 0; i < size; i++) {
            map.put(i, "Key_" + i);
        }
        return map;
    }
}