package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM EXP-23: REVERSE WORDS IN A STRING
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an input string `s`, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in `s`
 * will be separated by at least one space. Return a string of the words in
 * reverse order concatenated by a single space.
 *
 * Note that `s` may contain leading or trailing spaces or multiple spaces
 * between two words. The returned string should only have a single space
 * separating the words, with no extra leading or trailing spaces.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  s = "the sky is blue"
 *   Output: "blue is sky the"
 *
 * Example 2:
 *   Input:  s = "  hello world  "
 *   Output: "world hello"
 *   Explanation: Leading or trailing spaces should be trimmed.
 *
 * Example 3:
 *   Input:  s = "a good   example"
 *   Output: "example good a"
 *   Explanation: Multiple spaces between words should be reduced to a single space.
 *
 * CONSTRAINTS:
 * - 1 <= s.length <= 10^4
 * - `s` contains English letters (upper/lower case), digits, and spaces ' '.
 * - Handles null and whitespace-only strings safely by returning an empty string.
 * ============================================================================
 */
public class ReverseWordsInString {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Trim, Regex Split, and Reverse Iteration
     *
     * @implNote Trim `s`, split by regex whitespace `\\s+`, and iterate through the
     *           resulting string array backwards to construct the reversed word sentence
     *           using a `StringBuilder`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) for split tokens
     */
    public String reverseWordsSplit(String s) {
        // TODO: Write solution here
        return "";
    }

    /**
     * Approach 2: Two-Pointer Backward Parsing (Zero Regex / In-Place Style)
     *
     * @implNote Scan string backwards from `s.length() - 1` to `0`. Skip trailing/extra spaces,
     *           identify word boundaries using two pointers (`end` and `start`), and append
     *           substrings directly to `StringBuilder`.
     * @targetTimeComplexity O(N) single pass
     * @targetSpaceComplexity O(N) for output string
     */
    public String reverseWordsTwoPointers(String s) {
        // TODO: Write solution here
        return "";
    }

    /**
     * Approach 3: Collections / List Reversal Pipeline (`Collections.reverse()`)
     *
     * @implNote Split string by regex `\\s+`, convert array to `List<String>`,
     *           invoke `Collections.reverse()`, and join with `String.join(" ", list)`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public String reverseWordsCollections(String s) {
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
        ReverseWordsInString solver = new ReverseWordsInString();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "the sky is blue", "blue is sky the", "Standard multi-word sentence"),
                new TestCase(2, "  hello world  ", "world hello", "Leading and trailing spaces"),
                new TestCase(3, "a good   example", "example good a", "Multiple internal spaces between words"),
                new TestCase(4, "  Bob   Loves  Alice ", "Alice Loves Bob", "Mixed whitespace padding"),
                new TestCase(5, "Alice", "Alice", "Single word input"),
                new TestCase(6, "   ", "", "Whitespace only input"),
                new TestCase(7, "", "", "Empty string check"),
                new TestCase(8, null, "", "Null string safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-23 REVERSE WORDS IN A STRING");
        System.out.println("================================================================================");

        runApproach("1. Trim, Regex Split & Reverse Iteration", solver::reverseWordsSplit, testCases);
        runApproach("2. Two-Pointer Backward Parsing", solver::reverseWordsTwoPointers, testCases);
        runApproach("3. Collections / List Reversal Pipeline", solver::reverseWordsCollections, testCases);
    }

    /**
     * Executes test cases, compares actual reversed words string against expected output, and logs timing.
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