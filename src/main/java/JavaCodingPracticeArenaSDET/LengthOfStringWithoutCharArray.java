package JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM: FIND LENGTH OF STRING WITHOUT USING toCharArray() OR .length()
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a string `str`, return its total character count WITHOUT calling `str.toCharArray()`
 * or the direct `str.length()` method.
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
 * - Handles null inputs safely by returning 0.
 * ============================================================================
 */
public class LengthOfStringWithoutCharArray {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Iterative Index Lookup via charAt & Exception Handling
     *
     * @implNote Increment an index counter inside an infinite loop calling `str.charAt(index)`
     *           until `IndexOutOfBoundsException` is caught.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int lengthUsingCharAt(String str) {
        // TODO: Write solution here
        return 0;
    }

    /**
     * Approach 2: String Split & Stream API
     *
     * @implNote Split the string into single-character substrings using `str.split("")`
     *           and count the elements using `Arrays.stream().count()`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) for string array allocation
     */
    public long lengthUsingStringSplitStream(String str) {
        // TODO: Write solution here
        return 0L;
    }

    /**
     * Approach 3: IntStream CodePoints / Chars & Lambda Expression
     *
     * @implNote Stream character integer values using `str.codePoints()` or `str.chars()`
     *           without creating a char array, then call `.count()`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public long lengthUsingCodePointStream(String str) {
        // TODO: Write solution here
        return 0L;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String str;
        private final long expected;
        private final String description;

        public TestCase(int id, String str, long expected, String description) {
            this.id = id;
            this.str = str;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getStr() { return str; }
        public long getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        LengthOfStringWithoutCharArray solver = new LengthOfStringWithoutCharArray();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Hello World", 11, "Standard multi-word string"),
                new TestCase(2, "SDET Automation 2026", 20, "Alphanumeric string with spaces"),
                new TestCase(3, "a", 1, "Single character string"),
                new TestCase(4, "   \t\n   ", 8, "String with spaces, tabs, and newlines"),
                new TestCase(5, "", 0, "Empty string"),
                new TestCase(6, null, 0, "Null input safety check"),
                new TestCase(7, generateLargeString(100_000), 100_000, "Large stress test (100,000 characters)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: STRING LENGTH WITHOUT toCharArray()");
        System.out.println("================================================================================");

        runApproach("1. Iterative charAt & Exception Handling",
                s -> (long) solver.lengthUsingCharAt(s), testCases);

        runApproach("2. String Split & Stream API",
                solver::lengthUsingStringSplitStream, testCases);

        runApproach("3. CodePoint IntStream & Lambda",
                solver::lengthUsingCodePointStream, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected result, and logs duration in milliseconds.
     */
    private static void runApproach(String name, Function<String, Long> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            Long result = method.apply(tc.getStr());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = (result != null && result == tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s) | Expected: %d | Got: %s\n",
                        tc.getId(), tc.getDescription(), tc.getExpected(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static String generateLargeString(int length) {
        char[] arr = new char[length];
        Arrays.fill(arr, 'z');
        return new String(arr);
    }
}