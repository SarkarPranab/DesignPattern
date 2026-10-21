package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

/**
 * ============================================================================
 * PROBLEM EXP-35: ADD TWO NUMBERS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  l1 = [2 -> 4 -> 3], l2 = [5 -> 6 -> 4]
 *   Output: 7 -> 0 -> 8
 *   Explanation: 342 + 465 = 807.
 *
 * Example 2:
 *   Input:  l1 = [0], l2 = [0]
 *   Output: 0
 *
 * Example 3:
 *   Input:  l1 = [9 -> 9 -> 9 -> 9 -> 9 -> 9 -> 9], l2 = [9 -> 9 -> 9 -> 9]
 *   Output: 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1
 *
 * CONSTRAINTS:
 * - The number of nodes in each linked list is in the range [1, 100].
 * - 0 <= Node.val <= 9
 * - It is guaranteed that the list represents a number that does not have leading zeros.
 * - Handles null heads safely by treating them as 0.
 * ============================================================================
 */
public class AddTwoNumbers {

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

        /**
         * Helper utility to convert a linked list to a List for assertion.
         */
        public static List<Integer> toList(ListNode head) {
            List<Integer> list = new ArrayList<>();
            ListNode curr = head;
            while (curr != null) {
                list.add(curr.val);
                curr = curr.next;
            }
            return list;
        }
    }

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Elementary Math Iterative Traversal with Carry (Optimal O(max(N, M)) Time)
     *
     * @implNote Traverse both lists simultaneously, maintaining a running `carry`.
     *           At each step, sum `val1 + val2 + carry`, compute new digit `sum % 10`,
     *           and update `carry = sum / 10`. Continue until both lists are fully exhausted
     *           and `carry == 0`.
     * @targetTimeComplexity O(max(N, M))
     * @targetSpaceComplexity O(max(N, M)) to store the output result list
     */
    public ListNode addTwoNumbersIterative(ListNode l1, ListNode l2) {
        // TODO: Write solution here
        return null;
    }

    /**
     * Approach 2: Recursive Addition with Carry Propagation
     *
     * @implNote Recursively compute sum node by node passing carry forward.
     *           Base case: if `l1 == null`, `l2 == null`, and `carry == 0`, return `null`.
     * @targetTimeComplexity O(max(N, M))
     * @targetSpaceComplexity O(max(N, M)) call stack memory
     */
    public ListNode addTwoNumbersRecursive(ListNode l1, ListNode l2) {
        // TODO: Write solution here
        return null;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] input1;
        private final int[] input2;
        private final List<Integer> expected;
        private final String description;

        public TestCase(int id, int[] input1, int[] input2, List<Integer> expected, String description) {
            this.id = id;
            this.input1 = input1;
            this.input2 = input2;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getInput1() { return input1; }
        public int[] getInput2() { return input2; }
        public List<Integer> getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        AddTwoNumbers solver = new AddTwoNumbers();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{2, 4, 3}, new int[]{5, 6, 4}, List.of(7, 0, 8), "Standard addition with carry (342 + 465 = 807)"),
                new TestCase(2, new int[]{0}, new int[]{0}, List.of(0), "Zero plus zero addition"),
                new TestCase(3, new int[]{9, 9, 9, 9, 9, 9, 9}, new int[]{9, 9, 9, 9}, List.of(8, 9, 9, 9, 0, 0, 0, 1), "Unequal lengths with cascading carries"),
                new TestCase(4, new int[]{5}, new int[]{5}, List.of(0, 1), "Single digit addition producing carry"),
                new TestCase(5, null, new int[]{1, 2, 3}, List.of(1, 2, 3), "Null head l1 safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-35 ADD TWO NUMBERS");
        System.out.println("================================================================================");

        runApproach("1. Elementary Math Iterative Traversal", solver::addTwoNumbersIterative, testCases);
        runApproach("2. Recursive Addition with Carry", solver::addTwoNumbersRecursive, testCases);
    }

    /**
     * Executes test cases, compares actual output list against expected, and logs timing.
     */
    private static void runApproach(String name, BiFunction<ListNode, ListNode, ListNode> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            ListNode l1 = ListNode.fromArray(tc.getInput1());
            ListNode l2 = ListNode.fromArray(tc.getInput2());

            long startTime = System.nanoTime();
            ListNode resultHead = method.apply(l1, l2);
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            List<Integer> actual = ListNode.toList(resultHead);

            boolean isCorrect = Objects.equals(actual, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected: %s\n", tc.getExpected());
                System.out.printf("         Actual:   %s\n", actual);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}