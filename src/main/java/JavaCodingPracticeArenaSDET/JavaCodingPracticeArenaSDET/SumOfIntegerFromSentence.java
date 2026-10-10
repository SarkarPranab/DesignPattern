package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.function.ToIntFunction;

/**
 * ============================================================================
 * PROBLEM: SUM OF INTEGERS FROM A SENTENCE STRING
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a sentence string containing a mixture of words and numerical substrings,
 * identify all integer values embedded in the string and calculate their total sum.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  sentence = "This is 1000 and it should be 20 30 50 1050"
 *   Numbers found: [1000, 20, 30, 50, 1050]
 *   Output: 2150
 *
 * Example 2:
 *   Input:  sentence = "Order 5 items for 12 dollars and 3 cents"
 *   Numbers found: [5, 12, 3]
 *   Output: 20
 *
 * Example 3:
 *   Input:  sentence = "No numbers in this text!"
 *   Numbers found: []
 *   Output: 0
 *
 * CONSTRAINTS:
 * - 0 <= sentence.length() <= 10^6
 * - Handles null and empty sentence strings safely by returning 0.
 * - Numerical substrings are non-negative standard integers fit within 32-bit int.
 * ============================================================================
 */
public class SumOfIntegerFromSentence {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Regex Matcher Scanning (`\d+`)
     *
     * @implNote Use `Pattern.compile("\\d+")` and iterate through matches using `Matcher.find()`.
     *           Parse each matched numeric string via `Integer.parseInt()` and accumulate sum.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) auxiliary space (no array allocation)
     */
    public int sumIntegersRegexMatcher(String sentence) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 2: Whitespace Split & Stream Filter
     *
     * @implNote Split sentence by whitespace `sentence.split("\\s+")`. Stream tokens,
     *           filter tokens matching `data.matches("\\d+")`, map to `Integer::parseInt`,
     *           and sum using `.sum()`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) due to string array allocation
     */
    public int sumIntegersStreamFilter(String sentence) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 3: Imperative Character-by-Character Parser
     *
     * @implNote Iterate through `sentence.toCharArray()`. Accumulate digits into a
     *           running number variable `current = current * 10 + (ch - '0')`.
     *           Add `current` to total sum whenever a non-digit character or end of string is reached.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int sumIntegersCharacterParser(String sentence) {
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
        SumOfIntegerFromSentence solver = new SumOfIntegerFromSentence();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "This is 1000 and it should be 20 30 50 1050", 2150, "Standard sentence with multiple numbers"),
                new TestCase(2, "Order 5 items for 12 dollars and 3 cents", 20, "Sentence with small integers"),
                new TestCase(3, "No numbers here", 0, "Sentence containing zero numbers"),
                new TestCase(4, "100 200 300", 600, "Only numbers separated by spaces"),
                new TestCase(5, "ItemA10 ItemB20", 30, "Numbers embedded adjacent to text"),
                new TestCase(6, "", 0, "Empty string input"),
                new TestCase(7, null, 0, "Null input safety check"),
                new TestCase(8, generateLargeSentence(100_000), 500_000, "Large stress test (100k numbers)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: SUM OF INTEGERS FROM SENTENCE");
        System.out.println("================================================================================");

        runApproach("1. Regex Matcher Scanning (Zero Array Allocation)", solver::sumIntegersRegexMatcher, testCases);
        runApproach("2. Whitespace Split & Stream Filter", solver::sumIntegersStreamFilter, testCases);
        runApproach("3. Imperative Character-by-Character Parser", solver::sumIntegersCharacterParser, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected sum, and logs execution duration.
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
                System.out.printf("         Input:    \"%s\"\n",
                        tc.getInput() != null && tc.getInput().length() > 30 ? "[Large Sentence]" : tc.getInput());
                System.out.printf("         Expected: %d | Actual: %d\n", tc.getExpected(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static String generateLargeSentence(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("word 5 ");
        }
        return sb.toString();
    }
}