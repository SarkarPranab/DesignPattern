package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiPredicate;

/**
 * ============================================================================
 * PROBLEM EXP-01: ANAGRAM CHECK
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given two strings `s1` and `s2`, write a function to determine if `s2` is an
 * anagram of `s1`. An anagram is a word or phrase formed by rearranging the
 * letters of a different word or phrase, using all the original letters exactly once.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  s1 = "listen", s2 = "silent"
 *   Output: true
 *
 * Example 2:
 *   Input:  s1 = "rat", s2 = "car"
 *   Output: false
 *
 * Example 3:
 *   Input:  s1 = "Anagram", s2 = "Nagaram" (Case-insensitive match)
 *   Output: true
 *
 * CONSTRAINTS:
 * - 0 <= s1.length(), s2.length() <= 10^5
 * - Ignore case during comparison.
 * - Handles null and empty strings safely.
 * ============================================================================
 */
public class AnagramCheck {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Fixed-Size Frequency Array Buffer
     *
     * @implNote Normalize strings to lowercase. Check if lengths match. Maintain
     *           an `int[26]` array to count character frequencies (+1 for s1, -1 for s2).
     *           Verify all frequencies return to zero.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) - fixed 26-element array
     */
    public boolean isAnagramFrequencyArray(String s1, String s2) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 2: Character Array Sorting
     *
     * @implNote Convert both normalized strings to `char[]`, sort them using
     *           `Arrays.sort()`, and check equality with `Arrays.equals()`.
     * @targetTimeComplexity O(N log N)
     * @targetSpaceComplexity O(N)
     */
    public boolean isAnagramSorting(String s1, String s2) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 3: HashMap Frequency Counter
     *
     * @implNote Use a `Map<Character, Integer>` to track character counts for general
     *           Unicode/ASCII support beyond basic English alphabets.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(K) where K is number of unique characters
     */
    public boolean isAnagramHashMap(String s1, String s2) {
        // TODO: Write solution here
        return false;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String s1;
        private final String s2;
        private final boolean expected;
        private final String description;

        public TestCase(int id, String s1, String s2, boolean expected, String description) {
            this.id = id;
            this.s1 = s1;
            this.s2 = s2;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getS1() { return s1; }
        public String getS2() { return s2; }
        public boolean getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        AnagramCheck solver = new AnagramCheck();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "listen", "silent", true, "Standard lowercase valid anagram"),
                new TestCase(2, "rat", "car", false, "Standard invalid anagram"),
                new TestCase(3, "Anagram", "Nagaram", true, "Case-insensitive valid anagram"),
                new TestCase(4, "a", "a", true, "Single character match"),
                new TestCase(5, "a", "b", false, "Single character mismatch"),
                new TestCase(6, "", "", true, "Both empty strings check"),
                new TestCase(7, null, "test", false, "Null input safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-01 ANAGRAM CHECK");
        System.out.println("================================================================================");

        runApproach("1. Fixed-Size Frequency Array Buffer", solver::isAnagramFrequencyArray, testCases);
        runApproach("2. Character Array Sorting", solver::isAnagramSorting, testCases);
        runApproach("3. HashMap Frequency Counter", solver::isAnagramHashMap, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected boolean results, and logs timing.
     */
    private static void runApproach(String name, BiPredicate<String, String> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            boolean result = method.test(tc.getS1(), tc.getS2());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = (result == tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Input: s1=\"%s\", s2=\"%s\"\n", tc.getS1(), tc.getS2());
                System.out.printf("         Expected: %b | Actual: %b\n", tc.getExpected(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}