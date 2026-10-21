package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM EXP-46: LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a string `s`, find the length of the longest substring without repeating characters.
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
 *                Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * CONSTRAINTS:
 * - 0 <= s.length <= 5 * 10^4
 * - `s` consists of English letters, digits, symbols and spaces.
 * ============================================================================
 */
public class LongestSubstringWithoutRepeatingCharacters {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Optimized Sliding Window with Character Index Map (Optimal $O(N)$ Time)
     *
     * @implNote Use a hash map or integer tracking array to store the last seen index of each character.
     *           When a duplicate character is encountered within the current window, advance the `left`
     *           pointer directly to `Math.max(left, lastSeenIndex + 1)`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(min(N, charset_size))
     */
    public int lengthOfLongestSubstringOptimized(String s) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 2: Sliding Window with HashSet
     *
     * @implNote Maintain a `HashSet` representing the current window characters. Expand `right`
     *           pointer and contract `left` pointer whenever a duplicate character is found.
     * @targetTimeComplexity O(2N) = O(N)
     * @targetSpaceComplexity O(min(N, charset_size))
     */
    public int lengthOfLongestSubstringSet(String s) {
        // TODO: Write solution here
        return 0;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String s;
        private final int expected;
        private final String description;

        public TestCase(int id, String s, int expected, String description) {
            this.id = id;
            this.s = s;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getS() { return s; }
        public int getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solver = new LongestSubstringWithoutRepeatingCharacters();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "abcabcbb", 3, "Standard repeating sequence ('abc')"),
                new TestCase(2, "bbbbb", 1, "All identical characters"),
                new TestCase(3, "pwwkew", 3, "Non-contiguous duplicate check ('wke')"),
                new TestCase(4, "", 0, "Empty string safety check"),
                new TestCase(5, "au", 2, "Two distinct characters")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-46 LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS");
        System.out.println("================================================================================");

        runApproach("1. Optimized Sliding Window (Character Index Map)", solver::lengthOfLongestSubstringOptimized, testCases);
        runApproach("2. Sliding Window with HashSet", solver::lengthOfLongestSubstringSet, testCases);
    }

    /**
     * Executes test cases, compares actual max length against expected, and logs timing.
     */
    private static void runApproach(String name, Function<String, Integer> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            int actual = method.apply(tc.getS());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = (actual == tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected: %d | Actual: %d\n", tc.getExpected(), actual);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}