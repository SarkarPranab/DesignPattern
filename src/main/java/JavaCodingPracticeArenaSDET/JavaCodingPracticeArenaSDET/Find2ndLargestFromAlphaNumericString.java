package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM: FIND 2ND LARGEST DIGIT FROM ALPHANUMERIC STRING
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given an alphanumeric string `str`, find the 2nd largest DISTINCT numerical digit
 * present in the string. If there are fewer than 2 distinct numerical digits in
 * the string, return -1.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  str = "abDv1c64d41"
 *   Digits present: [1, 6, 4, 4, 1] -> Distinct digits: [1, 4, 6]
 *   Output: 4
 *
 * Example 2:
 *   Input:  str = "a9b9c8"
 *   Digits present: [9, 9, 8] -> Distinct digits: [8, 9]
 *   Output: 8
 *
 * Example 3:
 *   Input:  str = "abc5def"
 *   Digits present: [5]
 *   Output: -1 (only 1 distinct digit present)
 *
 * CONSTRAINTS:
 * - 0 <= str.length() <= 10^6
 * - `str` contains alphanumeric characters, special symbols, or can be null.
 * ============================================================================
 */
public class Find2ndLargestFromAlphaNumericString {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Single-Pass Tracking Pointers
     *
     * @implNote Maintain two integer pointers (`first` and `second`) initialized to -1.
     *           Iterate through characters, convert digits (`ch - '0'`), and update
     *           pointers ensuring distinct values (`num > first` vs `num > second && num < first`).
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int find2ndLargestIterative(String str) {
        // TODO: Write solution here
        return -1;
    }

    /**
     * Approach 2: Deduplication via Set / TreeSet Sorting
     *
     * @implNote Collect all distinct digits into a `TreeSet<Integer>`. If set size < 2,
     *           return -1. Otherwise, fetch the element immediately preceding the maximum.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) -- max set size is 10 (digits 0-9)
     */
    public int find2ndLargestSet(String str) {
        // TODO: Write solution here
        return -1;
    }

    /**
     * Approach 3: Java Stream & Lambda Expression
     *
     * @implNote Process `str.chars()`, filter by `Character::isDigit`, map to `ch - '0'`,
     *           boxed, distinct, sorted descending (`Comparator.reverseOrder()`),
     *           skip(1), and findFirst().
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int find2ndLargestStream(String str) {
        // TODO: Write solution here
        return -1;
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
        Find2ndLargestFromAlphaNumericString solver = new Find2ndLargestFromAlphaNumericString();

        // Comprehensive Test Suite covering distinct logic, edge cases, duplicates, nulls, stress test
        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "abDv1c64d41", 4, "Standard alphanumeric with duplicates"),
                new TestCase(2, "a9b9c8", 8, "Duplicate largest digit (9, 9, 8)"),
                new TestCase(3, "abc5def", -1, "Single digit present"),
                new TestCase(4, "abcdefg!@#$", -1, "No digits present"),
                new TestCase(5, "7777777", -1, "All identical digits"),
                new TestCase(6, "z0a0b1", 0, "Digits include zero (0, 0, 1)"),
                new TestCase(7, "9876543210", 8, "All 10 digits present in reverse order"),
                new TestCase(8, "", -1, "Empty string"),
                new TestCase(9, null, -1, "Null safety check"),
                new TestCase(10, generateLargeString(1_000_000), 8, "Large stress test (1 Million characters)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: FIND 2ND LARGEST DIGIT FROM ALPHANUMERIC STRING");
        System.out.println("================================================================================");

        runApproach("1. Single-Pass Tracking (O(N) Time, O(1) Space)", solver::find2ndLargestIterative, testCases);
        runApproach("2. Set / TreeSet Deduplication", solver::find2ndLargestSet, testCases);
        runApproach("3. Stream & Lambda Expression", solver::find2ndLargestStream, testCases);
    }

    /**
     * Executes test cases, verifies result accuracy, and benchmarks execution time.
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
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length / 3; i++) {
            sb.append("a9b8c7");
        }
        return sb.toString();
    }
}