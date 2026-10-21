package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Objects;
import java.util.function.BiFunction;

/**
 * ============================================================================
 * PROBLEM COD-11: COUNT OCCURRENCES OF A CHARACTER IN A STRING
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a string `str` and a character `target`, return the total count of times
 * `target` appears inside `str`.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  str = "automation engineering", target = 'e'
 *   Output: 3
 *
 * Example 2:
 *   Input:  str = "Java", target = 'a'
 *   Output: 2
 *
 * Example 3:
 *   Input:  str = "hello", target = 'z'
 *   Output: 0
 *
 * CONSTRAINTS:
 * - 0 <= str.length() <= 10^7
 * - Case-sensitive character evaluation.
 * - Handles null and empty strings safely by returning 0.
 * ============================================================================
 */
public class CountCharacterOccurrences {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Standard Imperative Loop with charAt()
     *
     * @implNote Iterate through string indices `i = 0` to `str.length() - 1`.
     *           Compare `str.charAt(i) == target` and increment counter.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int countOccurrencesLoop(String str, char target) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 2: Character Array Iteration (toCharArray)
     *
     * @implNote Convert string to `char[]` and use enhanced for-each loop
     *           `for (char c : str.toCharArray())` to accumulate target matches.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) for character array allocation
     */
    public int countOccurrencesCharArray(String str, char target) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 3: String Length Difference Manipulation
     *
     * @implNote Compute `str.length() - str.replace(String.valueOf(target), "").length()`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) string copy allocation
     */
    public int countOccurrencesStringReplace(String str, char target) {
        // TODO: Write solution here
        return 0;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String input;
        private final char target;
        private final int expected;
        private final String description;

        public TestCase(int id, String input, char target, int expected, String description) {
            this.id = id;
            this.input = input;
            this.target = target;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getInput() { return input; }
        public char getTarget() { return target; }
        public int getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        CountCharacterOccurrences solver = new CountCharacterOccurrences();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "automation engineering", 'e', 3, "Standard string with multiple occurrences"),
                new TestCase(2, "Java", 'a', 2, "Word with repeated vowel"),
                new TestCase(3, "hello", 'z', 0, "Character not present in string"),
                new TestCase(4, "AAAAA", 'A', 5, "All characters match target"),
                new TestCase(5, "a", 'a', 1, "Single matching character"),
                new TestCase(6, "", 'a', 0, "Empty string safety check"),
                new TestCase(7, null, 'a', 0, "Null string safety check"),
                new TestCase(8, generateLargeString(10_000_000, 'x'), 'x', 10_000_000, "Large stress test (10 Million matches)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: COD-11 COUNT CHARACTER OCCURRENCES");
        System.out.println("================================================================================");

        runApproach("1. Standard Imperative Loop (charAt)", solver::countOccurrencesLoop, testCases);
        runApproach("2. Character Array Iteration (toCharArray)", solver::countOccurrencesCharArray, testCases);
        runApproach("3. String Length Difference (replace)", solver::countOccurrencesStringReplace, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected occurrence count, and logs timing.
     */
    private static void runApproach(String name, BiFunction<String, Character, Integer> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            int result = method.apply(tc.getInput(), tc.getTarget());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = (result == tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Input:    \"%s\", target = '%c'\n",
                        tc.getInput() != null && tc.getInput().length() > 20 ? "[Large String]" : tc.getInput(), tc.getTarget());
                System.out.printf("         Expected: %d | Actual: %d\n", tc.getExpected(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static String generateLargeString(int length, char fillChar) {
        char[] arr = new char[length];
        for (int i = 0; i < length; i++) {
            arr[i] = fillChar;
        }
        return new String(arr);
    }
}