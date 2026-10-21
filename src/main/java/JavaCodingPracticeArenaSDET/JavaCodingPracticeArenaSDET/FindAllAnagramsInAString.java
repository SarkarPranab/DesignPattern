package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

/**
 * ============================================================================
 * PROBLEM EXP-49: FIND ALL ANAGRAMS IN A STRING
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given two strings `s` and `p`, return an array of all the start indices of `p`'s
 * anagrams in `s`. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word
 * or phrase, typically using all the original letters exactly once.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  s = "cbaebabacd", p = "abc"
 *   Output: [0, 6]
 *   Explanation:
 *     The substring with start index 0 is "cba", which is an anagram of "abc".
 *     The substring with start index 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 *   Input:  s = "abab", p = "ab"
 *   Output: [0, 1, 2]
 *
 * CONSTRAINTS:
 * - 1 <= s.length, p.length <= 3 * 10^4
 * - `s` and `p` consist of lowercase English letters.
 * ============================================================================
 */
public class FindAllAnagramsInAString {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Sliding Window Frequency Array Comparison (Optimal $O(N)$ Time)
     *
     * @implNote Maintain a fixed-size sliding window of length `p.length()` over `s`.
     *           Compare character frequency arrays of size 26 in $O(1)$ time per window slide.
     * @targetTimeComplexity O(N) where N is length of s
     * @targetSpaceComplexity O(1) constant frequency array space
     */
    public List<Integer> findAnagramsSlidingWindow(String s, String p) {
        // TODO: Write solution here
        return new ArrayList<>();
    }

    /**
     * Approach 2: Sliding Window Match Count Optimization
     *
     * @implNote Track the number of characters whose frequencies match between `p` and the current
     *           sliding window in `s`, updating incrementally in $O(1)$ per step.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public List<Integer> findAnagramsOptimized(String s, String p) {
        // TODO: Write solution here
        return new ArrayList<>();
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String s;
        private final String p;
        private final List<Integer> expected;
        private final String description;

        public TestCase(int id, String s, String p, List<Integer> expected, String description) {
            this.id = id;
            this.s = s;
            this.p = p;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getS() { return s; }
        public String getP() { return p; }
        public List<Integer> getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString solver = new FindAllAnagramsInAString();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "cbaebabacd", "abc", Arrays.asList(0, 6), "Multiple anagram occurrences in s"),
                new TestCase(2, "abab", "ab", Arrays.asList(0, 1, 2), "Overlapping anagram occurrences"),
                new TestCase(3, "a", "ab", new ArrayList<>(), "Pattern longer than string s"),
                new TestCase(4, "abcde", "f", new ArrayList<>(), "Non-existent pattern character"),
                new TestCase(5, "b", "b", Arrays.asList(0), "Single character exact match")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-49 FIND ALL ANAGRAMS IN A STRING");
        System.out.println("================================================================================");

        runApproach("1. Sliding Window Frequency Array Comparison", solver::findAnagramsSlidingWindow, testCases);
        runApproach("2. Sliding Window Match Count Optimization", solver::findAnagramsOptimized, testCases);
    }

    /**
     * Executes test cases, compares actual index list against expected, and logs timing.
     */
    private static void runApproach(String name, BiFunction<String, String, List<Integer>> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            List<Integer> actual = method.apply(tc.getS(), tc.getP());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Objects.equals(actual, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected: %s\n", tc.getExpected());
                System.out.printf("         Actual:   %s\n", actual);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}