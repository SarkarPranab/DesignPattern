package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;

/**
 * ============================================================================
 * PROBLEM EXP-22: CHECK IF A STRING IS ANAGRAM OF ANOTHER
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`,
 * and `false` otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly once.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  s = "anagram", t = "nagaram"
 *   Output: true
 *
 * Example 2:
 *   Input:  s = "rat", t = "car"
 *   Output: false
 *
 * CONSTRAINTS:
 * - 1 <= s.length, t.length <= 5 * 10^4
 * - `s` and `t` consist of lowercase English letters (or extended Unicode).
 * - Handles null and length-mismatched strings safely by returning `false`.
 * ============================================================================
 */
public class ValidAnagram {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Fixed-Size Character Frequency Counter Array (Optimal Space/Time)
     *
     * @implNote Check `s.length() == t.length()`. Maintain a frequency array `counts`
     *           of size 26 (or 256 for ASCII). Increment count for characters in `s`
     *           and decrement for `t`. Verify all element counts return to `0`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) fixed 26/256 array
     */
    public boolean isAnagramFrequencyArray(String s, String t) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 2: Sorting Character Arrays
     *
     * @implNote Convert both `s` and `t` to `char[]`, sort them using `Arrays.sort()`,
     *           and compare sorted arrays with `Arrays.equals()`.
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(N) for primitive array creation
     */
    public boolean isAnagramSorting(String s, String t) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 3: HashMap Character Frequency Map (Unicode/General Purpose)
     *
     * @implNote Store character frequencies in a `Map<Character, Integer>`. Increment
     *           for `s` and decrement for `t`, then verify all values in map are 0.
     *           Ideal for full Unicode character sets beyond ASCII.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(K) where K is number of unique characters
     */
    public boolean isAnagramHashMap(String s, String t) {
        // TODO: Write solution here
        return false;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String s;
        private final String t;
        private final boolean expected;
        private final String description;

        public TestCase(int id, String s, String t, boolean expected, String description) {
            this.id = id;
            this.s = s;
            this.t = t;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getS() { return s; }
        public String getT() { return t; }
        public boolean getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        ValidAnagram solver = new ValidAnagram();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "anagram", "nagaram", true, "Standard valid anagrams"),
                new TestCase(2, "rat", "car", false, "Same length, different characters"),
                new TestCase(3, "listen", "silent", true, "Classic English anagram pair"),
                new TestCase(4, "a", "a", true, "Single character match"),
                new TestCase(5, "a", "b", false, "Single character mismatch"),
                new TestCase(6, "ab", "a", false, "Mismatched string lengths"),
                new TestCase(7, "", "", true, "Empty strings check"),
                new TestCase(8, null, "test", false, "Null input safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-22 CHECK IF A STRING IS ANAGRAM OF ANOTHER");
        System.out.println("================================================================================");

        runApproach("1. Fixed-Size Frequency Counter Array", solver::isAnagramFrequencyArray, testCases);
        runApproach("2. Sorting Character Arrays", solver::isAnagramSorting, testCases);
        runApproach("3. HashMap Frequency Map (Unicode)", solver::isAnagramHashMap, testCases);
    }

    /**
     * Executes test cases, compares actual boolean output against expected, and logs timing.
     */
    private static void runApproach(String name, BiPredicate<String, String> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            boolean result = method.test(tc.getS(), tc.getT());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = (result == tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Inputs: s = \"%s\", t = \"%s\"\n", tc.getS(), tc.getT());
                System.out.printf("         Expected: %b | Actual: %b\n", tc.getExpected(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}