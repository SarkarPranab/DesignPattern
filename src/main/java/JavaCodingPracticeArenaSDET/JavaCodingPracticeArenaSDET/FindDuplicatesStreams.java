package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM EXP-13: FIND DUPLICATES IN A LIST USING STREAMS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a list of elements (e.g., integers or strings), identify and return
 * all duplicate elements present in the list using Java Streams and Collections.
 * The result list should contain unique duplicate elements (no duplicate
 * duplicates in the output).
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  [10, 20, 30, 20, 40, 10, 50]
 *   Output: [10, 20]
 *
 * Example 2:
 *   Input:  ["apple", "banana", "apple", "cherry", "banana", "apple"]
 *   Output: ["apple", "banana"]
 *
 * Example 3:
 *   Input:  [1, 2, 3, 4]
 *   Output: []
 *
 * CONSTRAINTS:
 * - 0 <= list.size() <= 10^5
 * - Handles null lists, empty lists, and elements safely.
 * ============================================================================
 */
public class FindDuplicatesStreams {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Stream Filter with Set.add() Side-Effect
     *
     * @implNote Use `Set.add()` inside `.filter(n -> !set.add(n))` to capture
     *           elements that fail insertion into the set, then collect with `.distinct()`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public <T> List<T> findDuplicatesSetFilter(List<T> list) {
        // TODO: Write solution here
        return new ArrayList<>();
    }

    /**
     * Approach 2: Stream Collectors.groupingBy & Frequency Filtering
     *
     * @implNote Use `list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))`
     *           and filter map entries where count > 1.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public <T> List<T> findDuplicatesFrequencyMap(List<T> list) {
        // TODO: Write solution here
        return new ArrayList<>();
    }

    /**
     * Approach 3: Stream Collections.frequency() Filter
     *
     * @implNote Filter using `.filter(i -> Collections.frequency(list, i) > 1)`
     *           combined with `.distinct()`.
     * @targetTimeComplexity O(N^2) - clean functional syntax for small inputs
     * @targetSpaceComplexity O(N)
     */
    public <T> List<T> findDuplicatesCollectionsFrequency(List<T> list) {
        // TODO: Write solution here
        return new ArrayList<>();
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase<T> {
        private final int id;
        private final List<T> input;
        private final List<T> expected;
        private final String description;

        public TestCase(int id, List<T> input, List<T> expected, String description) {
            this.id = id;
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public List<T> getInput() { return input; }
        public List<T> getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        FindDuplicatesStreams solver = new FindDuplicatesStreams();

        TestCase<Integer> tc1 = new TestCase<>(1, List.of(10, 20, 30, 20, 40, 10, 50), List.of(10, 20), "Multiple integer duplicates");
        TestCase<String> tc2 = new TestCase<>(2, List.of("apple", "banana", "apple", "cherry", "banana"), List.of("apple", "banana"), "String duplicates");
        TestCase<Integer> tc3 = new TestCase<>(3, List.of(1, 2, 3, 4), List.of(), "No duplicates present");
        TestCase<Integer> tc4 = new TestCase<>(4, List.of(), List.of(), "Empty list check");
        TestCase<Integer> tc5 = new TestCase<>(5, null, List.of(), "Null list safety check");

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-13 FIND DUPLICATES IN A LIST USING STREAMS");
        System.out.println("================================================================================");

        runApproach("1. Stream Filter with Set.add()", solver::findDuplicatesSetFilter, tc1, tc2, tc3, tc4, tc5);
        runApproach("2. Stream Collectors.groupingBy & Frequency Filtering", solver::findDuplicatesFrequencyMap, tc1, tc2, tc3, tc4, tc5);
        runApproach("3. Stream Collections.frequency() Filter", solver::findDuplicatesCollectionsFrequency, tc1, tc2, tc3, tc4, tc5);
    }

    /**
     * Executes test cases, compares actual duplicate results against expected output, and logs timing.
     */
    @SafeVarargs
    private static void runApproach(String name, Function<List<Object>, List<Object>> method, TestCase<?>... testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase<?> tc : testCases) {
            @SuppressWarnings("unchecked")
            List<Object> workingList = (tc.getInput() != null) ? new ArrayList<>((List<Object>) tc.getInput()) : null;

            long startTime = System.nanoTime();
            List<Object> result = method.apply(workingList);
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            if (result != null) {
                result = new ArrayList<>(new HashSet<>(result));
            }
            List<?> expectedSorted = (tc.getExpected() != null) ? new ArrayList<>(new HashSet<>(tc.getExpected())) : List.of();

            boolean isCorrect = Objects.equals(result, expectedSorted);
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
}