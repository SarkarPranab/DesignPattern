package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.Predicate;

/**
 * ============================================================================
 * PROBLEM EXP-31: PALINDROME LINKED LIST
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given the `head` of a singly linked list, return `true` if it is a palindrome
 * or `false` otherwise.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  head = [1 -> 2 -> 2 -> 1]
 *   Output: true
 *
 * Example 2:
 *   Input:  head = [1 -> 2]
 *   Output: false
 *
 * CONSTRAINTS:
 * - The number of nodes in the list is in the range [1, 10^5].
 * - 0 <= Node.val <= 9
 * - Handles null and single-node lists safely (returns true for single nodes/null).
 * ============================================================================
 */
public class PalindromeLinkedList {

    /**
     * Definition for singly-linked list node.
     */
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        /**
         * Helper utility to construct a linked list from an array.
         */
        public static ListNode fromArray(int[] arr) {
            if (arr == null || arr.length == 0) return null;
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;
            for (int val : arr) {
                curr.next = new ListNode(val);
                curr = curr.next;
            }
            return dummy.next;
        }
    }

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Fast & Slow Pointer with Second Half Reversal (Optimal O(1) Space)
     *
     * @implNote Find the middle of the linked list using slow and fast pointers.
     *           Reverse the second half of the list in-place. Compare the first half
     *           and reversed second half values. Restore list structure (optional) and return result.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public boolean isPalindromeOptimal(ListNode head) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 2: ArrayList Buffer Copy
     *
     * @implNote Traverse linked list, copying node values into an `ArrayList<Integer>`.
     *           Use two pointers from start and end of list to verify palindromic symmetry.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) auxiliary space
     */
    public boolean isPalindromeArrayList(ListNode head) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 3: Stack Auxiliary Buffer
     *
     * @implNote Push all linked list nodes onto a `Deque` / Stack. Traverse the list
     *           a second time, popping from the stack and comparing values.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) call stack / deque storage
     */
    public boolean isPalindromeStack(ListNode head) {
        // TODO: Write solution here
        return false;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] input;
        private final boolean expected;
        private final String description;

        public TestCase(int id, int[] input, boolean expected, String description) {
            this.id = id;
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getInput() { return input; }
        public boolean getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        PalindromeLinkedList solver = new PalindromeLinkedList();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{1, 2, 2, 1}, true, "Even length symmetric palindrome"),
                new TestCase(2, new int[]{1, 2, 3, 2, 1}, true, "Odd length symmetric palindrome"),
                new TestCase(3, new int[]{1, 2}, false, "Two-node non-palindrome"),
                new TestCase(4, new int[]{1, 2, 3}, false, "Three-node non-palindrome"),
                new TestCase(5, new int[]{7}, true, "Single node palindrome"),
                new TestCase(6, new int[]{}, true, "Empty list check"),
                new TestCase(7, null, true, "Null safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-31 PALINDROME LINKED LIST");
        System.out.println("================================================================================");

        runApproach("1. Fast & Slow Pointer with In-Place Reversal", solver::isPalindromeOptimal, testCases);
        runApproach("2. ArrayList Buffer Copy", solver::isPalindromeArrayList, testCases);
        runApproach("3. Stack Auxiliary Buffer", solver::isPalindromeStack, testCases);
    }

    /**
     * Executes test cases, compares actual boolean output against expected, and logs timing.
     */
    private static void runApproach(String name, Predicate<ListNode> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            ListNode head = ListNode.fromArray(tc.getInput());

            long startTime = System.nanoTime();
            boolean result = method.test(head);
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = (result == tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected: %b | Actual: %b\n", tc.getExpected(), result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}