package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Objects;
import java.util.function.ToIntFunction;

/**
 * ============================================================================
 * PROBLEM COD-14: LENGTH OF LAST WORD
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a string `s` consisting of words and spaces, return the length of the
 * last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  s = "Hello World"
 *   Output: 5
 *
 * Example 2:
 *   Input:  s = "   fly me   to   the moon  "
 *   Output: 4
 *
 * Example 3:
 *   Input:  s = "luffy is still joyboy"
 *   Output: 6
 *
 * CONSTRAINTS:
 * - 1 <= s.length <= 10^5
 * - `s` consists of English letters and spaces `' '`.
 * - Return 0 for null or whitespace-only inputs.
 * ============================================================================
 */
public class LengthOfLastWord {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Right-to-Left String Pointer Traversal (No Split)
     *
     * @implNote Trim trailing spaces, then traverse backward from `s.length() - 1`
     *           incrementing count until encountering a space character or string start.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int lengthOfLastWordPointer(String s) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 2: Regex String Split Arrays
     *
     * @implNote Trim string, split using regex `\\s+`, and return the length of the
     *           last element in the resulting array.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) for string array allocation
     */
    public int lengthOfLastWordSplit(String s) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 3: String lastIndexOf Substring Truncation
     *
     * @implNote Trim string, find last index of space `s.trim().lastIndexOf(' ')`,
     *           and return `trimmed.length() - 1 - lastIndex`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int lengthOfLastWordLastIndexOf(String s) {
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
        LengthOfLastWord solver = new LengthOfLastWord();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Hello World", 5, "Standard two word string"),
                new TestCase(2, "   fly me   to   the moon  ", 4, "String with trailing and leading spaces"),
                new TestCase(3, "luffy is still joyboy", 6, "Multiple words string"),
                new TestCase(4, "a", 1, "Single letter word"),
                new TestCase(5, "    ", 0, "Whitespace only string safety check"),
                new TestCase(6, null, 0, "Null input safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: COD-14 LENGTH OF LAST WORD");
        System.out.println("================================================================================");

        runApproach("1. Right-to-Left Pointer Traversal", solver::lengthOfLastWordPointer, testCases);
        runApproach("2. Regex String Split", solver::lengthOfLastWordSplit, testCases);
        runApproach("3. Substring lastIndexOf Truncation", solver::lengthOfLastWordLastIndexOf, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected length, and logs timing.
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