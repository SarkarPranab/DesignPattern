package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM EXP-71: ISOMORPHIC STRINGS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Two strings `s` and `t` are isomorphic if the characters in `s` can be replaced to get `t`.
 * Every occurrence of a character must map to the same replacement, and no two different
 * characters may map to the same character (the mapping must be one-to-one).
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  s = "egg", t = "add"
 *   Output: true
 * Example 2:
 *   Input:  s = "foo", t = "bar"
 *   Output: false
 * Example 3:
 *   Input:  s = "paper", t = "title"
 *   Output: true
 *
 * CONSTRAINTS:
 * - 0 <= s.length == t.length <= 5 * 10^4
 * - Null input or different lengths return false.
 * ============================================================================
 */
public class IsomorphicStrings {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Two HashMaps (s to t and t to s)
     *
     * @implNote Keep forward and reverse mappings; any conflict in either direction means not isomorphic.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(K) where K = alphabet size
     */
    public boolean isIsomorphicTwoMaps(String s, String t) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 2: One HashMap + Set Of Used Targets
     *
     * @implNote Map s to t; a Set records which target characters are already taken by another source.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(K)
     */
    public boolean isIsomorphicMapAndSet(String s, String t) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 3: Last Seen Index Arrays
     *
     * @implNote Two int[65536] tables store the last position (1-based) where each character was seen; they must match.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) fixed tables
     */
    public boolean isIsomorphicLastSeen(String s, String t) {
        // TODO: Write solution here
        return false;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    @FunctionalInterface
    interface Solver {
        boolean solve(String s, String t);
    }

    static class TestCase {
        private final int id;
        private final String description;
        private final String s;
        private final String t;
        private final boolean expected;

        public TestCase(int id, String description, String s, String t, boolean expected) {
            this.id = id;
            this.description = description;
            this.s = s;
            this.t = t;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        IsomorphicStrings solver = new IsomorphicStrings();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "egg / add", "egg", "add", true),
                new TestCase(2, "foo / bar", "foo", "bar", false),
                new TestCase(3, "paper / title", "paper", "title", true),
                new TestCase(4, "Two sources to one target", "badc", "baba", false),
                new TestCase(5, "Digits", "13", "42", true),
                new TestCase(6, "Different lengths", "ab", "a", false),
                new TestCase(7, "Empty strings", "", "", true),
                new TestCase(8, "Null input safety check", null, "a", false)
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-71 ISOMORPHIC STRINGS");
        System.out.println("================================================================================");

        runApproach("1. Two HashMaps (s to t and t to s)", solver::isIsomorphicTwoMaps, testCases);
        runApproach("2. One HashMap + Set Of Used Targets", solver::isIsomorphicMapAndSet, testCases);
        runApproach("3. Last Seen Index Arrays", solver::isIsomorphicLastSeen, testCases);
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
                result = method.solve(tc.s, tc.t);
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
                System.out.printf("         Input:    %s\n", java.util.Arrays.asList(fmt(tc.s), fmt(tc.t)));
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
