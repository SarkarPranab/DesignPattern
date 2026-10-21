package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM COD-15: LONGEST COMMON PREFIX
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Write a function to find the longest common prefix string amongst an array
 * of strings. If there is no common prefix, return an empty string `""`.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  strs = ["flower", "flow", "flight"]
 *   Output: "fl"
 *
 * Example 2:
 *   Input:  strs = ["dog", "racecar", "car"]
 *   Output: ""
 *   Explanation: There is no common prefix among the input strings.
 *
 * CONSTRAINTS:
 * - 1 <= strs.length <= 200
 * - 0 <= strs[i].length <= 200
 * - `strs[i]` consists of only lowercase English letters if non-null.
 * - Handles null and empty arrays safely by returning `""`.
 * ============================================================================
 */
public class LongestCommonPrefix {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Horizontal Scanning
     *
     * @implNote Initialize `prefix = strs[0]`. Iterate through remaining strings
     *           `i = 1` to `N-1`, truncating `prefix` using `indexOf(prefix) != 0`
     *           until it matches the start of `strs[i]`.
     * @targetTimeComplexity O(S) where S is sum of all characters in all strings
     * @targetSpaceComplexity O(1)
     */
    public String longestCommonPrefixHorizontal(String[] strs) {
        // TODO: Write solution here
        return "";
    }

    /**
     * Approach 2: Vertical Scanning
     *
     * @implNote Compare characters index-by-index across all strings simultaneously
     *           (index 0 across all strings, then index 1, etc.). Stop on first mismatch.
     * @targetTimeComplexity O(S) worst case, early exit optimization
     * @targetSpaceComplexity O(1)
     */
    public String longestCommonPrefixVertical(String[] strs) {
        // TODO: Write solution here
        return "";
    }

    /**
     * Approach 3: Lexicographical Array Sorting Bounds Comparison
     *
     * @implNote Sort array lexicographically. Compare only the first (lexicographically
     *           smallest) and last (lexicographically largest) strings to extract the prefix.
     * @targetTimeComplexity O(N * M * log N) where N is array length, M is string length
     * @targetSpaceComplexity O(1) or O(N) depending on sort implementation
     */
    public String longestCommonPrefixSortedBounds(String[] strs) {
        // TODO: Write solution here
        return "";
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String[] input;
        private final String expected;
        private final String description;

        public TestCase(int id, String[] input, String expected, String description) {
            this.id = id;
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String[] getInput() { return input; }
        public String getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        LongestCommonPrefix solver = new LongestCommonPrefix();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new String[]{"flower", "flow", "flight"}, "fl", "Standard common prefix found"),
                new TestCase(2, new String[]{"dog", "racecar", "car"}, "", "No common prefix"),
                new TestCase(3, new String[]{"interspecies", "interstellar", "interstate"}, "inters", "Long common prefix"),
                new TestCase(4, new String[]{"a"}, "a", "Single string array"),
                new TestCase(5, new String[]{"", "b"}, "", "Array containing empty string"),
                new TestCase(6, new String[]{}, "", "Empty array safety check"),
                new TestCase(7, null, "", "Null input safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: COD-15 LONGEST COMMON PREFIX");
        System.out.println("================================================================================");

        runApproach("1. Horizontal Scanning", solver::longestCommonPrefixHorizontal, testCases);
        runApproach("2. Vertical Character Scanning", solver::longestCommonPrefixVertical, testCases);
        runApproach("3. Lexicographical Sorting Bounds", solver::longestCommonPrefixSortedBounds, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected common prefix string, and logs timing.
     */
    private static void runApproach(String name, Function<String[], String> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            String[] workingArray = (tc.getInput() != null) ? tc.getInput().clone() : null;

            long startTime = System.nanoTime();
            String result = method.apply(workingArray);
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Objects.equals(result, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Input:    %s\n", Arrays.toString(tc.getInput()));
                System.out.printf("         Expected: \"%s\" | Actual: \"%s\"\n", tc.getExpected(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}