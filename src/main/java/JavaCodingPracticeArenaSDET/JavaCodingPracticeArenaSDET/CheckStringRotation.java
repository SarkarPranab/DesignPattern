package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.Objects;
import java.util.function.BiPredicate;

/**
 * ============================================================================
 * PROBLEM EXP-17: CHECK WHETHER ONE STRING IS A ROTATION OF ANOTHER
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given two strings `s1` and `s2`, write a function to check if `s2` is a
 * valid rotation of `s1`.
 *
 * A string `s2` is a rotation of `s1` if it can be obtained by moving a
 * prefix of `s1` to its end.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  s1 = "waterbottle", s2 = "erbottlewat"
 *   Output: true
 *   Explanation: "erbottlewat" is formed by rotating "waterbottle" at "wat".
 *
 * Example 2:
 *   Input:  s1 = "hello", s2 = "lohel"
 *   Output: true
 *
 * Example 3:
 *   Input:  s1 = "hello", s2 = "lhleo"
 *   Output: false
 *
 * CONSTRAINTS:
 * - 0 <= s1.length, s2.length <= 10^5
 * - `s1` and `s2` consist of lowercase/uppercase English letters and digits.
 * - Handles null and mismatched length strings safely by returning `false`.
 * ============================================================================
 */
public class CheckStringRotation {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: String Concatenation Trick (`(s1 + s1).contains(s2)`)
     *
     * @implNote First check if `s1.length() == s2.length()`. Concatenate `s1` with
     *           itself (`concat = s1 + s1`). If `s2` is a rotation of `s1`, it MUST
     *           be a substring of `concat`.
     * @targetTimeComplexity O(N) where N is length of string
     * @targetSpaceComplexity O(N) for concatenated string
     */
    public boolean isRotationConcatenation(String s1, String s2) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 2: Manual Rotation Pointer Matching (KMP / Rolling Hash Pattern)
     *
     * @implNote Iterate through possible split pivot indices `i` in `s1`. Verify if
     *           `s1.substring(i) + s1.substring(0, i)` matches `s2` without extra memory copies.
     * @targetTimeComplexity O(N^2) worst case, O(N) with KMP index search
     * @targetSpaceComplexity O(1)
     */
    public boolean isRotationManualSplit(String s1, String s2) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 3: Two-Pointer Circular Index Modulo Traversal
     *
     * @implNote Locate matching candidate starting characters of `s2` in `s1`,
     *           then verify full length equivalence using `(start + offset) % length`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public boolean isRotationCircularTraversal(String s1, String s2) {
        // TODO: Write solution here
        return false;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String s1;
        private final String s2;
        private final boolean expected;
        private final String description;

        public TestCase(int id, String s1, String s2, boolean expected, String description) {
            this.id = id;
            this.s1 = s1;
            this.s2 = s2;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getS1() { return s1; }
        public String getS2() { return s2; }
        public boolean getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        CheckStringRotation solver = new CheckStringRotation();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "waterbottle", "erbottlewat", true, "Standard valid rotation"),
                new TestCase(2, "hello", "lohel", true, "Short word valid rotation"),
                new TestCase(3, "hello", "lhleo", false, "Same characters, invalid order"),
                new TestCase(4, "abc", "def", false, "Completely different strings"),
                new TestCase(5, "a", "a", true, "Single character identical"),
                new TestCase(6, "", "", true, "Empty strings match"),
                new TestCase(7, "abc", "abcd", false, "Mismatched length safety check"),
                new TestCase(8, null, "waterbottle", false, "Null input safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-17 CHECK STRING ROTATION");
        System.out.println("================================================================================");

        runApproach("1. String Concatenation Trick", solver::isRotationConcatenation, testCases);
        runApproach("2. Manual Rotation Split Verification", solver::isRotationManualSplit, testCases);
        runApproach("3. Circular Modulo Index Traversal", solver::isRotationCircularTraversal, testCases);
    }

    /**
     * Executes test cases, compares actual boolean output against expected, and logs timing.
     */
    private static void runApproach(String name, BiPredicate<String, String> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            boolean result = method.test(tc.getS1(), tc.getS2());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = (result == tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Inputs: s1=\"%s\", s2=\"%s\"\n", tc.getS1(), tc.getS2());
                System.out.printf("         Expected: %b | Actual: %b\n", tc.getExpected(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}