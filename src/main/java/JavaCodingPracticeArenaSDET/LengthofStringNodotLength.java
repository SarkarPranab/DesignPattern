package JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM: FIND LENGTH OF STRING WITHOUT USING .length() METHOD
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a string `str`, return its total character length without invoking the
 * standard built-in `str.length()` method or `arr.length` array property.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  str = "Hello World"
 *   Output: 11
 *
 * Example 2:
 *   Input:  str = ""
 *   Output: 0
 *
 * Example 3:
 *   Input:  str = null
 *   Output: 0
 *
 * CONSTRAINTS:
 * - 0 <= string length <= 10^6
 * - Handles null inputs gracefully by returning 0.
 * ============================================================================
 */
public class LengthofStringNodotLength {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Iterative Character Array Loop
     *
     * @implNote Convert string to char array using `str.toCharArray()` and iterate
     *           through a `for-each` loop, incrementing a counter for each character.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) for character array allocation
     */
    public int lengthIterativeCharArray(String str) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 2: Exception Handling (StringIndexOutOfBoundsException)
     *
     * @implNote Iterate indefinitely using index `i` calling `str.charAt(i)` inside
     *           a `try-catch` block until `StringIndexOutOfBoundsException` is thrown,
     *           returning `i`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int lengthExceptionHandling(String str) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 3: Stream & Lambda Expression
     *
     * @implNote Convert `str.chars()` into an IntStream, map each character
     *           to 1, and compute the sum using `.map(c -> 1).sum()`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int lengthStreamLambda(String str) {
        // TODO: Write solution here
        return 0;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String str;
        private final int expected;
        private final String description;

        public TestCase(int id, String str, int expected, String description) {
            this.id = id;
            this.str = str;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getStr() { return str; }
        public int getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        LengthofStringNodotLength solver = new LengthofStringNodotLength();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Hello World", 11, "Standard multi-word string"),
                new TestCase(2, "SDET Automation 2026", 20, "Alphanumeric string with spaces"),
                new TestCase(3, "a", 1, "Single character string"),
                new TestCase(4, "   \t\n   ", 8, "String with spaces, tab, and newline"),
                new TestCase(5, "", 0, "Empty string"),
                new TestCase(6, null, 0, "Null input safety check"),
                new TestCase(7, generateLargeString(100_000), 100_000, "Large stress test (100,000 characters)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: STRING LENGTH WITHOUT .length()");
        System.out.println("================================================================================");

        runApproach("1. Iterative Char Array Loop", solver::lengthIterativeCharArray, testCases);
        runApproach("2. Exception Handling (charAt)", solver::lengthExceptionHandling, testCases);
        runApproach("3. Stream & Lambda Expression", solver::lengthStreamLambda, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected output, and benchmarks timing.
     */
    private static void runApproach(String name, Function<String, Integer> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            int result = method.apply(tc.getStr());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = (result == tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s) | Expected: %d | Got: %d\n",
                        tc.getId(), tc.getDescription(), tc.getExpected(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static String generateLargeString(int length) {
        char[] arr = new char[length];
        Arrays.fill(arr, 'x');
        return new String(arr);
    }
}