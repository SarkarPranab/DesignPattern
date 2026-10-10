package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM: COUNT UPPERCASE AND LOWERCASE CHARACTERS IN A STRING
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a string `str`, count the total number of uppercase letters and lowercase
 * letters present in it. Ignore digits, spaces, and special characters.
 *
 * OUTPUT FORMAT:
 * Return an integer array of size 2:
 *   - index 0: count of uppercase characters
 *   - index 1: count of lowercase characters
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  str = "AabBBcDF234@#iKLYhfd"
 *   Output: [8, 7]
 *   Explanation:
 *     Uppercase (8): 'A', 'B', 'B', 'D', 'F', 'K', 'L', 'Y'
 *     Lowercase (7): 'a', 'b', 'c', 'i', 'h', 'f', 'd'
 *
 * Example 2:
 *   Input:  str = "Java123!"
 *   Output: [1, 3]
 *
 * Example 3:
 *   Input:  str = "12345@#$"
 *   Output: [0, 0]
 *
 * CONSTRAINTS:
 * - 0 <= str.length() <= 10^6
 * - `str` can contain any printable ASCII characters or be null.
 * ============================================================================
 */
public class CountUpperAndLowerCase {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Traditional Iterative Loop (Character.isUpperCase / isLowerCase)
     *
     * @implNote Convert string to char array or iterate by index. Check each character
     *           using `Character.isUpperCase(ch)` and `Character.isLowerCase(ch)`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int[] countUpperAndLowerIterative(String str) {
        // TODO: Write solution here
        return new int[]{0, 0};
    }

    /**
     * Approach 2: ASCII Value Range Checking
     *
     * @implNote Iterate through characters and check their numeric ASCII values:
     *           Uppercase: 'A' <= ch <= 'Z' (65 to 90)
     *           Lowercase: 'a' <= ch <= 'z' (97 to 122)
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int[] countUpperAndLowerAscii(String str) {
        // TODO: Write solution here
        return new int[]{0, 0};
    }

    /**
     * Approach 3: Java Stream & Lambda Expression
     *
     * @implNote Convert string to `str.chars()` IntStream and filter using
     *           `Character::isUpperCase` and `Character::isLowerCase` to count elements.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int[] countUpperAndLowerStream(String str) {
        // TODO: Write solution here
        return new int[]{0, 0};
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String str;
        private final int[] expected; // [uppercaseCount, lowercaseCount]
        private final String description;

        public TestCase(int id, String str, int expectedUpper, int expectedLower, String description) {
            this.id = id;
            this.str = str;
            this.expected = new int[]{expectedUpper, expectedLower};
            this.description = description;
        }

        public int getId() { return id; }
        public String getStr() { return str; }
        public int[] getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        CountUpperAndLowerCase solver = new CountUpperAndLowerCase();

        // Comprehensive Test Suite covering edge cases, nulls, numbers, large strings
        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "AabBBcDF234@#iKLYhfd", 8, 7, "Mixed case with numbers and symbols"),
                new TestCase(2, "HELLO WORLD", 10, 0, "All uppercase with space"),
                new TestCase(3, "sdet automation testing", 0, 21, "All lowercase with spaces"),
                new TestCase(4, "1234567890!@#$%^&*()", 0, 0, "Numbers and special characters only"),
                new TestCase(5, "Z", 1, 0, "Single uppercase character"),
                new TestCase(6, "a", 0, 1, "Single lowercase character"),
                new TestCase(7, "", 0, 0, "Empty string"),
                new TestCase(8, null, 0, 0, "Null input safety check"),
                new TestCase(9, generateLargeString(1_000_000), 500_000, 500_000, "Large stress test (1 Million characters)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: COUNT UPPERCASE AND LOWERCASE");
        System.out.println("================================================================================");

        runApproach("1. Iterative Loop (Character Methods)", solver::countUpperAndLowerIterative, testCases);
        runApproach("2. ASCII Value Range Checking", solver::countUpperAndLowerAscii, testCases);
        runApproach("3. Stream & Lambda Expression", solver::countUpperAndLowerStream, testCases);
    }

    /**
     * Executes test cases, verifies counts, and logs detailed execution runtime in milliseconds.
     */
    private static void runApproach(String name, Function<String, int[]> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            int[] result = method.apply(tc.getStr());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Arrays.equals(result, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s) | Expected: [Upper: %d, Lower: %d] | Got: %s\n",
                        tc.getId(), tc.getDescription(),
                        tc.getExpected()[0], tc.getExpected()[1],
                        Arrays.toString(result));
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static String generateLargeString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length / 2; i++) {
            sb.append('A').append('a');
        }
        return sb.toString();
    }
}