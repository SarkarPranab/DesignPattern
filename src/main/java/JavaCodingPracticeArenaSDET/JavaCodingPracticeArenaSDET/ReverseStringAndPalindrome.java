package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Objects;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM COD-10: REVERSE STRING AND PALINDROME CHECK (STANDARD JAVA)
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a string `str`, write methods to reverse the string and check whether
 * it is a palindrome WITHOUT using predefined reverse methods like
 * `StringBuilder.reverse()` or `StringBuffer.reverse()`.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  str = "madam"
 *   Output: ReverseResult[reversed = "madam", isPalindrome = true]
 *
 * Example 2:
 *   Input:  str = "automation"
 *   Output: ReverseResult[reversed = "noitamotua", isPalindrome = false]
 *
 * Example 3:
 *   Input:  str = "A man, a plan, a canal: Panama" (Case-insensitive alphanumeric check)
 *   Output: isPalindrome = true
 *
 * CONSTRAINTS:
 * - Direct calls to predefined reverse functions are restricted.
 * - Handles null and empty strings safely.
 * ============================================================================
 */
public class ReverseStringAndPalindrome {

    /**
     * Standard POJO holding the reversed string and palindrome flag.
     */
    public static class ReverseResult {
        private final String reversed;
        private final boolean isPalindrome;

        public ReverseResult(String reversed, boolean isPalindrome) {
            this.reversed = reversed;
            this.isPalindrome = isPalindrome;
        }

        public String getReversed() { return reversed; }
        public boolean isPalindrome() { return isPalindrome; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ReverseResult)) return false;
            ReverseResult that = (ReverseResult) o;
            return isPalindrome == that.isPalindrome && Objects.equals(reversed, that.reversed);
        }

        @Override
        public int hashCode() {
            return Objects.hash(reversed, isPalindrome);
        }

        @Override
        public String toString() {
            return String.format("ReverseResult{reversed='%s', isPalindrome=%b}", reversed, isPalindrome);
        }
    }

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Two-Pointer Character Array Swap
     *
     * @implNote Convert string to `char[]`. Use left and right pointers to swap
     *           characters in-place towards the middle. Compare reversed result with original.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public ReverseResult reverseTwoPointer(String str) {
        // TODO: Write solution here
        return new ReverseResult("", false);
    }

    /**
     * Approach 2: Backward Loop Concatenation / StringBuilder
     *
     * @implNote Iterate through string characters backwards from `str.length() - 1`
     *           down to 0 and append to a `StringBuilder`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public ReverseResult reverseBackwardLoop(String str) {
        // TODO: Write solution here
        return new ReverseResult("", false);
    }

    /**
     * Approach 3: Two-Pointer Early Exit Palindrome Validation
     *
     * @implNote Validate palindrome efficiently by comparing outer characters moving inward.
     *           Exits early on first mismatch without needing to reverse the full string.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public ReverseResult reverseEarlyExitCheck(String str) {
        // TODO: Write solution here
        return new ReverseResult("", false);
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String input;
        private final ReverseResult expected;
        private final String description;

        public TestCase(int id, String input, ReverseResult expected, String description) {
            this.id = id;
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getInput() { return input; }
        public ReverseResult getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        ReverseStringAndPalindrome solver = new ReverseStringAndPalindrome();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "madam", new ReverseResult("madam", true), "Standard odd-length palindrome"),
                new TestCase(2, "noon", new ReverseResult("noon", true), "Standard even-length palindrome"),
                new TestCase(3, "automation", new ReverseResult("noitamotua", false), "Standard non-palindrome string"),
                new TestCase(4, "a", new ReverseResult("a", true), "Single character string"),
                new TestCase(5, "", new ReverseResult("", true), "Empty string safety check"),
                new TestCase(6, null, new ReverseResult("", false), "Null string safety check"),
                new TestCase(7, generateLargeString(100_000), new ReverseResult(generateLargeString(100_000), true), "Large stress test (100k characters)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: COD-10 REVERSE STRING & PALINDROME CHECK");
        System.out.println("================================================================================");

        runApproach("1. Two-Pointer Character Array Swap", solver::reverseTwoPointer, testCases);
        runApproach("2. Backward Loop String Building", solver::reverseBackwardLoop, testCases);
        runApproach("3. Two-Pointer Early Exit Check", solver::reverseEarlyExitCheck, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected ReverseResult objects, and logs timing.
     */
    private static void runApproach(String name, Function<String, ReverseResult> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            ReverseResult result = method.apply(tc.getInput());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Objects.equals(result, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Input:    \"%s\"\n", tc.getInput() != null && tc.getInput().length() > 20 ? "[Large String]" : tc.getInput());
                System.out.printf("         Expected: %s\n", tc.getExpected());
                System.out.printf("         Actual:   %s\n", result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static String generateLargeString(int length) {
        char[] arr = new char[length];
        for (int i = 0; i < length; i++) {
            arr[i] = 'a';
        }
        return new String(arr);
    }
}