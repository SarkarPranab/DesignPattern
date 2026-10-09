package JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM: REVERSE CHARACTERS OF EACH WORD IN A STRING
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a string `str`, reverse the order of characters within each word while
 * preserving the original word order and whitespace structure.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  str = "This is Fun"
 *   Output: "sihT si nuF"
 *
 * Example 2:
 *   Input:  str = "Java SDET 2026"
 *   Output: "avaJ TEDS 6202"
 *
 * Example 3:
 *   Input:  str = "a"
 *   Output: "a"
 *
 * CONSTRAINTS:
 * - 0 <= str.length <= 10^5
 * - Handle null/empty input safely by returning an empty string or null.
 * - Words are separated by single or multiple whitespace characters.
 * ============================================================================
 */
public class ReverseCharactersOfEachWord {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Split Words & Two-Pointer Char Array Reversal
     *
     * @implNote Split string by regex `\\s+`, reverse each word's char array using two pointers,
     *           and assemble result using StringBuilder.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public String reverseWordsCharArray(String str) {
        // TODO: Write solution here
        return "";
    }

    /**
     * Approach 2: Single-Pass In-Place Reversal (Zero Split Allocations)
     *
     * @implNote Convert full string to `char[]`, scan for word start and end boundaries,
     *           and reverse character ranges in-place without creating substring arrays.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) for final output string allocation
     */
    public String reverseWordsSinglePass(String str) {
        // TODO: Write solution here
        return "";
    }

    /**
     * Approach 3: Stream API & StringBuilder (Functional Style)
     *
     * @implNote Stream words split by regex, map each word using `new StringBuilder(word).reverse()`,
     *           and collect with `Collectors.joining(" ")`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public String reverseWordsStream(String str) {
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
        ReverseCharactersOfEachWord solver = new ReverseCharactersOfEachWord();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "This is Fun", "sihT si nuF", "Standard multi-word string"),
                new TestCase(2, "Java SDET 2026", "avaJ TEDS 6202", "Alphanumeric string with numbers"),
                new TestCase(3, "Automation", "noitamotuA", "Single word string"),
                new TestCase(4, "a b c d", "a b c d", "Single character words"),
                new TestCase(5, "", "", "Empty string input"),
                new TestCase(6, null, null, "Null input safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: REVERSE CHARACTERS OF EACH WORD");
        System.out.println("================================================================================");

        runApproach("1. Split & Two-Pointer Char Array", solver::reverseWordsCharArray, testCases);
        runApproach("2. Single-Pass In-Place Pointer Scan", solver::reverseWordsSinglePass, testCases);
        runApproach("3. Stream API & StringBuilder.reverse()", solver::reverseWordsStream, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected output, and benchmarks timing.
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

            boolean isCorrect = (result == null && tc.getExpected() == null) ||
                    (result != null && result.equals(tc.getExpected()));

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