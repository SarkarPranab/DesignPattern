package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Objects;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM EXP-19: REMOVE ALL WHITE SPACES FROM A STRING
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a string `s`, remove all whitespace characters from it, including
 * spaces, tabs (`\t`), newlines (`\n`), carriage returns (`\r`), and other
 * Unicode whitespace characters.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  s = " J a v a   S D E T "
 *   Output: "JavaSDET"
 *
 * Example 2:
 *   Input:  s = "Hello\tWorld\nPractice"
 *   Output: "HelloWorldPractice"
 *
 * Example 3:
 *   Input:  s = "   "
 *   Output: ""
 *
 * CONSTRAINTS:
 * - 0 <= s.length <= 10^5
 * - Handles null and empty strings safely (returns empty string or null as appropriate).
 * ============================================================================
 */
public class RemoveWhiteSpaces {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Regular Expression Replacement (`replaceAll("\\s+", "")`)
     *
     * @implNote Use standard String `replaceAll()` with the regex character class
     *           `\\s+` to eliminate all whitespace sequences in a single expression.
     * @targetTimeComplexity O(N) regex evaluation
     * @targetSpaceComplexity O(N) for string copy
     */
    public String removeWhitespaceRegex(String s) {
        // TODO: Write solution here
        return "";
    }

    /**
     * Approach 2: StringBuilder Traversal (`Character.isWhitespace()`)
     *
     * @implNote Iterate through `s.toCharArray()`. Append non-whitespace characters
     *           to a `StringBuilder` by checking `!Character.isWhitespace(ch)`.
     * @targetTimeComplexity O(N) single pass
     * @targetSpaceComplexity O(N) for StringBuilder output
     */
    public String removeWhitespaceStringBuilder(String s) {
        // TODO: Write solution here
        return "";
    }

    /**
     * Approach 3: In-Place Primitive Char Array Pointer Filtering
     *
     * @implNote Convert string to `char[]`, maintain a `writeIndex = 0`, iterate and
     *           copy non-whitespace characters forward, then construct a new String
     *           from `0` to `writeIndex`.
     * @targetTimeComplexity O(N) zero auto-boxing
     * @targetSpaceComplexity O(N) primitive char array memory
     */
    public String removeWhitespaceCharArray(String s) {
        // TODO: Write solution here
        return "";
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String input;
        private final String expected;
        private final String description;

        public TestCase(int id, String input, String expected, String description) {
            this.id = id;
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getInput() { return input; }
        public String getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        RemoveWhiteSpaces solver = new RemoveWhiteSpaces();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, " J a v a   S D E T ", "JavaSDET", "Standard spaced string"),
                new TestCase(2, "Hello\tWorld\nPractice\rArena", "HelloWorldPracticeArena", "Tabs, newlines, and carriage returns"),
                new TestCase(3, "   ", "", "String with only spaces"),
                new TestCase(4, "NoSpacesHere", "NoSpacesHere", "String with no spaces"),
                new TestCase(5, "", "", "Empty string check"),
                new TestCase(6, null, null, "Null string safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-19 REMOVE ALL WHITE SPACES FROM A STRING");
        System.out.println("================================================================================");

        runApproach("1. Regex Replacement (\\s+)", solver::removeWhitespaceRegex, testCases);
        runApproach("2. StringBuilder with Character.isWhitespace()", solver::removeWhitespaceStringBuilder, testCases);
        runApproach("3. In-Place Primitive Char Array Pointer Filtering", solver::removeWhitespaceCharArray, testCases);
    }

    /**
     * Executes test cases, compares actual string output against expected, and logs timing.
     */
    private static void runApproach(String name, Function<String, String> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            String result = method.apply(tc.getInput());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Objects.equals(result, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Input:    \"%s\"\n", tc.getInput());
                System.out.printf("         Expected: \"%s\"\n", tc.getExpected());
                System.out.printf("         Actual:   \"%s\"\n", result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}