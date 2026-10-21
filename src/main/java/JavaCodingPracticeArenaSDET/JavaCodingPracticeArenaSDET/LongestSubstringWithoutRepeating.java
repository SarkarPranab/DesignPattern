package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.ToIntFunction;

/**
 * ============================================================================
 * PROBLEM EXP-03: LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a string `s`, find the length of the longest substring without
 * repeating characters.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  s = "abcabcbb"
 *   Output: 3
 *   Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *   Input:  s = "bbbbb"
 *   Output: 1
 *   Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *   Input:  s = "pwwkew"
 *   Output: 3
 *   Explanation: The answer is "wke", with the length of 3.
 *   Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * CONSTRAINTS:
 * - 0 <= s.length <= 5 * 10^4
 * - `s` consists of English letters, digits, symbols and spaces.
 * - Handles null and empty strings safely by returning `0`.
 * ============================================================================
 */
public class LongestSubstringWithoutRepeating {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Sliding Window using HashMap (Optimized Pointer Jump)
     *
     * @implNote Maintain sliding window pointers `left` and `right`. Store character
     *           last-seen indices in a `Map<Character, Integer>`. When encountering a
     *           duplicate character, jump `left = Math.max(left, map.get(ch) + 1)`.
     * @targetTimeComplexity O(N) single pass
     * @targetSpaceComplexity O(K) where K is number of unique characters
     */
    public int lengthOfLongestSubstringHashMap(String s) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 2: Sliding Window using HashSet (Two Pointers)
     *
     * @implNote Use two pointers `left` and `right`. Expand `right` and add characters
     *           to `Set<Character>`. When a duplicate is hit, contract `left` and
     *           remove characters from set until duplicate is gone.
     * @targetTimeComplexity O(N) worst-case 2N steps
     * @targetSpaceComplexity O(K)
     */
    public int lengthOfLongestSubstringHashSet(String s) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 3: Direct Integer Array Index Lookup (ASCII Buffer)
     *
     * @implNote Use an `int[128]` or `int[256]` array initialized with `-1` (or 0)
     *           to store character indices, replacing HashMap for zero-overhead array access.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) fixed 128/256 size array
     */
    public int lengthOfLongestSubstringASCIIArray(String s) {
        // TODO: Write solution here
        return 0;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String input;
        private final int expected;
        private final String description;

        public TestCase(int id, String input, int expected, String description) {
            this.id = id;
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getInput() { return input; }
        public int getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating solver = new LongestSubstringWithoutRepeating();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "abcabcbb", 3, "Standard string with repeating patterns"),
                new TestCase(2, "bbbbb", 1, "All identical characters"),
                new TestCase(3, "pwwkew", 3, "Substring in middle"),
                new TestCase(4, "au", 2, "Two distinct characters"),
                new TestCase(5, " ", 1, "Single whitespace character"),
                new TestCase(6, "", 0, "Empty string safety check"),
                new TestCase(7, null, 0, "Null input safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-03 LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS");
        System.out.println("================================================================================");

        runApproach("1. Sliding Window HashMap (Pointer Jump)", solver::lengthOfLongestSubstringHashMap, testCases);
        runApproach("2. Sliding Window HashSet (Two Pointers)", solver::lengthOfLongestSubstringHashSet, testCases);
        runApproach("3. Direct ASCII Array Lookup", solver::lengthOfLongestSubstringASCIIArray, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected max length, and logs timing.
     */
    private static void runApproach(String name, ToIntFunction<String> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            int result = method.applyAsInt(tc.getInput());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = (result == tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Input:    \"%s\"\n", tc.getInput());
                System.out.printf("         Expected: %d | Actual: %d\n", tc.getExpected(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}