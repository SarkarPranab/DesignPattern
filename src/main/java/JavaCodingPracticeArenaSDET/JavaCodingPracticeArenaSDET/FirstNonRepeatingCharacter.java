package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.ToIntFunction;

/**
 * ============================================================================
 * PROBLEM EXP-02: FIRST NON-REPEATING CHARACTER
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a string `s`, find the first non-repeating character in it and return
 * its index. If it does not exist, return `-1`.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  s = "leetcode"
 *   Output: 0
 *   Explanation: 'l' is the first character that appears only once.
 *
 * Example 2:
 *   Input:  s = "loveleetcode"
 *   Output: 2
 *   Explanation: 'v' at index 2 is the first unique character.
 *
 * Example 3:
 *   Input:  s = "aabb"
 *   Output: -1
 *   Explanation: Every character repeats.
 *
 * CONSTRAINTS:
 * - 1 <= s.length <= 10^5
 * - `s` consists of lowercase English letters.
 * - Handles null and empty strings safely by returning `-1`.
 * ============================================================================
 */
public class FirstNonRepeatingCharacter {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Fixed-Size Frequency Array Buffer (Two-Pass)
     *
     * @implNote First pass: build frequency array `int[26]` counting occurrences.
     *           Second pass: iterate through `s` character-by-character and return
     *           the first index where frequency equals 1.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) - fixed 26-element integer array
     */
    public int firstUniqCharFrequencyArray(String s) {
        // TODO: Write solution here
        return -1;
    }

    /**
     * Approach 2: LinkedHashMap Order-Preserving Counter (Single Pass String Search)
     *
     * @implNote Store character frequencies in a `LinkedHashMap` to preserve insertion order.
     *           Iterate over the map entries to find the first character with count 1,
     *           then return its `indexOf()`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(K) where K is number of unique characters (K <= 26)
     */
    public int firstUniqCharLinkedHashMap(String s) {
        // TODO: Write solution here
        return -1;
    }

    /**
     * Approach 3: String Index Bounds Check (`indexOf` vs `lastIndexOf`)
     *
     * @implNote Iterate through characters in `s`. If `s.indexOf(ch) == s.lastIndexOf(ch)`,
     *           return the current index immediately.
     * @targetTimeComplexity O(N^2) worst case, highly practical for short strings
     * @targetSpaceComplexity O(1)
     */
    public int firstUniqCharIndexOf(String s) {
        // TODO: Write solution here
        return -1;
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
        FirstNonRepeatingCharacter solver = new FirstNonRepeatingCharacter();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "leetcode", 0, "First character is unique"),
                new TestCase(2, "loveleetcode", 2, "Unique character in middle of string"),
                new TestCase(3, "aabb", -1, "All characters repeat"),
                new TestCase(4, "z", 0, "Single character string"),
                new TestCase(5, "aabccbd", 6, "Unique character at last index"),
                new TestCase(6, "", -1, "Empty string safety check"),
                new TestCase(7, null, -1, "Null input safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-02 FIRST NON-REPEATING CHARACTER");
        System.out.println("================================================================================");

        runApproach("1. Fixed-Size Frequency Array Buffer", solver::firstUniqCharFrequencyArray, testCases);
        runApproach("2. LinkedHashMap Order-Preserving Counter", solver::firstUniqCharLinkedHashMap, testCases);
        runApproach("3. indexOf vs lastIndexOf Bounds Check", solver::firstUniqCharIndexOf, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected index, and logs timing.
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