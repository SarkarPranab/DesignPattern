package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * ============================================================================
 * PROBLEM EXP-20: CHECK IF A STRING CONTAINS ONLY DIGITS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a string `s`, write a function that returns `true` if the string contains
 * exclusively numeric digits ('0' through '9'), and `false` otherwise.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  s = "123456"
 *   Output: true
 *
 * Example 2:
 *   Input:  s = "123a45"
 *   Output: false
 *
 * Example 3:
 *   Input:  s = ""
 *   Output: false
 *
 * CONSTRAINTS:
 * - 0 <= s.length <= 10^5
 * - An empty string should return `false`.
 * - Handles null strings safely by returning `false`.
 * ============================================================================
 */
public class CheckStringOnlyDigits {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Single Pass Iterative Character Inspection (`Character.isDigit`)
     *
     * @implNote Verify input non-null and non-empty. Iterate through `s.toCharArray()`
     *           and check `Character.isDigit(ch)` for each character. Return false on
     *           the first non-digit encountered.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public boolean isOnlyDigitsIterative(String s) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 2: Regular Expression (`s.matches("\\d+")`)
     *
     * @implNote Evaluate `s != null && s.matches("\\d+")` using regex pattern matching.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public boolean isOnlyDigitsRegex(String s) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 3: Functional Stream API (`s.chars().allMatch`)
     *
     * @implNote Use `s.chars().allMatch(Character::isDigit)` on non-empty string streams.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public boolean isOnlyDigitsStream(String s) {
        // TODO: Write solution here
        return false;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String input;
        private final boolean expected;
        private final String description;

        public TestCase(int id, String input, boolean expected, String description) {
            this.id = id;
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getInput() { return input; }
        public boolean getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        CheckStringOnlyDigits solver = new CheckStringOnlyDigits();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "123456", true, "Standard numeric string"),
                new TestCase(2, "0", true, "Single zero digit"),
                new TestCase(3, "123a45", false, "Numeric string with embedded letter"),
                new TestCase(4, "12 34", false, "Digits with space in between"),
                new TestCase(5, "-123", false, "Negative sign present"),
                new TestCase(6, "12.34", false, "Decimal point present"),
                new TestCase(7, "", false, "Empty string check"),
                new TestCase(8, null, false, "Null string safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-20 CHECK IF A STRING CONTAINS ONLY DIGITS");
        System.out.println("================================================================================");

        runApproach("1. Single Pass Character Inspection", solver::isOnlyDigitsIterative, testCases);
        runApproach("2. Regular Expression (\\d+)", solver::isOnlyDigitsRegex, testCases);
        runApproach("3. Functional Stream API (allMatch)", solver::isOnlyDigitsStream, testCases);
    }

    /**
     * Executes test cases, compares actual boolean output against expected, and logs timing.
     */
    private static void runApproach(String name, Predicate<String> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            boolean result = method.test(tc.getInput());
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
                System.out.printf("         Expected: %b | Actual: %b\n", tc.getExpected(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}