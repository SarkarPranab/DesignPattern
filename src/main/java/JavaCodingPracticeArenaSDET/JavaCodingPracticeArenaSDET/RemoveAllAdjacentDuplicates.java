package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Stack;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM COD-20: REMOVE ALL ADJACENT DUPLICATES IN STRING
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * You are given a string `s` consisting of lowercase English letters. A duplicate
 * removal consists of choosing two adjacent and equal letters and removing them.
 *
 * We repeatedly make duplicate removals on `s` until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.
 * It can be proven that the answer is unique.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  s = "abbaca"
 *   Output: "ca"
 *   Explanation:
 *   For example, in "abbaca" we could remove "bb" since the letters are adjacent
 *   and equal, and this is the only possible move. The result of this move is
 *   "aca", of which only "cc" is possible, so the final string is "ca".
 *
 * Example 2:
 *   Input:  s = "azxxzy"
 *   Output: "ay"
 *
 * CONSTRAINTS:
 * - 1 <= s.length <= 10^5
 * - `s` consists of lowercase English letters.
 * - Handles null and empty strings safely by returning `""`.
 * ============================================================================
 */
public class RemoveAllAdjacentDuplicates {

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: StringBuilder as an In-Place Stack Buffer
     *
     * @implNote Maintain a `StringBuilder sb`. Iterate through characters in `s`.
     *           If `sb` is non-empty and `sb.charAt(sb.length() - 1) == currentChar`,
     *           delete the last character (`sb.deleteCharAt(sb.length() - 1)`).
     *           Otherwise, append `currentChar`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public String removeDuplicatesStringBuilderStack(String s) {
        // TODO: Write solution here
        return "";
    }

    /**
     * Approach 2: Character Array Two-Pointer Simulation
     *
     * @implNote Convert string to `char[] arr`. Maintain an index `i = 0` representing
     *           the top of the stack. Iterate through elements using `j`: if `i > 0`
     *           and `arr[i - 1] == arr[j]`, decrement `i` (pop); otherwise set `arr[i] = arr[j]`
     *           and increment `i` (push). Return `new String(arr, 0, i)`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) for char array
     */
    public String removeDuplicatesTwoPointerArray(String s) {
        // TODO: Write solution here
        return "";
    }

    /**
     * Approach 3: Explicit Stack (`java.util.ArrayDeque`)
     *
     * @implNote Use `ArrayDeque<Character>` as LIFO stack. Pop on adjacent match,
     *           otherwise push. Reconstruct reversed string output from remaining elements.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public String removeDuplicatesStack(String s) {
        // TODO: Write solution here
        return "";
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final String input;
        private final String expected;
        private final String description;

        public TestCase(int id, String input, String expected, String description) {
            this.id = id;
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public String getInput() { return input; }
        public String getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicates solver = new RemoveAllAdjacentDuplicates();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "abbaca", "ca", "Standard adjacent duplicate cascade"),
                new TestCase(2, "azxxzy", "ay", "Symmetric nested cancellation"),
                new TestCase(3, "aaaaaaaaa", "a", "Odd number of repeated characters"),
                new TestCase(4, "aaaaaaaa", "", "Even number of repeated characters resulting in empty string"),
                new TestCase(5, "abcdef", "abcdef", "No adjacent duplicates present"),
                new TestCase(6, "", "", "Empty string safety check"),
                new TestCase(7, null, "", "Null input safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: COD-20 REMOVE ALL ADJACENT DUPLICATES IN STRING");
        System.out.println("================================================================================");

        runApproach("1. StringBuilder as In-Place Stack Buffer", solver::removeDuplicatesStringBuilderStack, testCases);
        runApproach("2. Character Array Two-Pointer Simulation", solver::removeDuplicatesTwoPointerArray, testCases);
        runApproach("3. ArrayDeque Character Stack", solver::removeDuplicatesStack, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected resulting string, and logs timing.
     */
    private static void runApproach(String name, Function<String, String> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            String result = method.apply(tc.getInput());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Objects.equals(result, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Input:    \"%s\"\n", tc.getInput());
                System.out.printf("         Expected: \"%s\" | Actual: \"%s\"\n", tc.getExpected(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}