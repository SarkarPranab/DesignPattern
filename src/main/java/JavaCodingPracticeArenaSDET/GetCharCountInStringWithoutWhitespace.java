package JavaCodingPracticeArenaSDET;

import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM: COUNT CHARACTERS IN A STRING (EXCLUDING WHITESPACE & DELIMITERS)
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a string `str`, count characters under different common filtering requirements:
 *   1. Non-Whitespace Characters: Count all characters excluding spaces (' '), tabs ('\t'), and newlines ('\n').
 *   2. Alphabetic Characters: Count only letters ('a'-'z', 'A'-'Z').
 *   3. Enclosed / Internal Letters: Count letters that are immediately surrounded by alphabetic letters on both sides.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  str = "Hello"
 *   Non-whitespace count: 5
 *   Alphabetic count: 5
 *   Internal letters count: 3 ('e', 'l', 'l')
 *
 * Example 2:
 *   Input:  str = "__hell yeah __ mother__fucker__"
 *   Non-whitespace count: 32
 *   Alphabetic count: 20 ("hell", "yeah", "mother", "fucker")
 *
 * Example 3:
 *   Input:  str = "  "
 *   Non-whitespace count: 0
 *   Alphabetic count: 0
 *
 * CONSTRAINTS:
 * - 0 <= str.length() <= 10^6
 * - `str` can contain letters, numbers, spaces, tabs, and special symbols or be null.
 * ============================================================================
 */
public class GetCharCountInStringWithoutWhitespace {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Count Non-Whitespace Characters (Iterative Loop)
     *
     * @implNote Iterate through `str.toCharArray()` and count characters where 
     *           `!Character.isWhitespace(ch)`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int countNonWhitespaceIterative(String str) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 2: Count Enclosed / Internal Letters (Neighbor Checking)
     *
     * @implNote Iterate through `str` and count alphabetic characters that have 
     *           valid alphabetic neighbors at index `i-1` and index `i+1`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int countInternalAlphabeticChars(String str) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 3: Stream & Lambda Expression (Non-Whitespace Filter)
     *
     * @implNote Convert `str.chars()` into an IntStream, filter out whitespace 
     *           using `!Character.isWhitespace(ch)`, and call `.count()`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int countNonWhitespaceStream(String str) {
        // TODO: Write solution here
        return 0;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String str;
        private final int expectedNonWhitespace;
        private final int expectedInternalAlphabetic;
        private final String description;

        public TestCase(int id, String str, int expectedNonWhitespace, int expectedInternalAlphabetic, String description) {
            this.id = id;
            this.str = str;
            this.expectedNonWhitespace = expectedNonWhitespace;
            this.expectedInternalAlphabetic = expectedInternalAlphabetic;
            this.description = description;
        }

        public int getId() { return id; }
        public String getStr() { return str; }
        public int getExpectedNonWhitespace() { return expectedNonWhitespace; }
        public int getExpectedInternalAlphabetic() { return expectedInternalAlphabetic; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        GetCharCountInStringWithoutWhitespace solver = new GetCharCountInStringWithoutWhitespace();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Hello", 5, 3, "Standard word without spaces"),
                new TestCase(2, "hell yeah __ r__fucker__", 24, 10, "Mixed underscores, spaces, and letters"),
                new TestCase(3, "__Hie__", 7, 1, "Underscore delimiters around 3-letter word"),
                new TestCase(4, "a b c d e", 5, 0, "Single letters separated by spaces"),
                new TestCase(5, "   \t\n   ", 0, 0, "Whitespace only (spaces, tabs, newlines)"),
                new TestCase(6, "", 0, 0, "Empty string"),
                new TestCase(7, null, 0, 0, "Null safety check"),
                new TestCase(8, generateLargeString(1_000_000), 1_000_000, 999_998, "Large stress test (1 Million characters)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: GET CHAR COUNT WITHOUT WHITESPACE");
        System.out.println("================================================================================");

        runApproach("1. Non-Whitespace Iterative (O(N) Time)",
                solver::countNonWhitespaceIterative, testCases, true);

        runApproach("2. Internal Alphabetic Characters (Neighbor Check)",
                solver::countInternalAlphabeticChars, testCases, false);

        runApproach("3. Non-Whitespace Stream & Lambda",
                solver::countNonWhitespaceStream, testCases, true);
    }

    /**
     * Executes test cases, compares actual vs expected result, and logs timing.
     */
    private static void runApproach(String name, Function<String, Integer> method, TestCase[] testCases, boolean checkNonWhitespace) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;

        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            int expected = checkNonWhitespace ? tc.getExpectedNonWhitespace() : tc.getExpectedInternalAlphabetic();

            long startTime = System.nanoTime();
            int result = method.apply(tc.getStr());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = (result == expected);
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s) | Expected: %d | Got: %d\n",
                        tc.getId(), tc.getDescription(), expected, result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static String generateLargeString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append('a');
        }
        return sb.toString();
    }
}