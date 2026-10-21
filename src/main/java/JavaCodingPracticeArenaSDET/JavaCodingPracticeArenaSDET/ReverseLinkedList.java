package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM EXP-14: REVERSE A LINKED LIST
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given the `head` of a singly linked list, reverse the list, and return
 * the new head of the reversed list.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  head = [1 -> 2 -> 3 -> 4 -> 5]
 *   Output: [5 -> 4 -> 3 -> 2 -> 1]
 *
 * Example 2:
 *   Input:  head = [1 -> 2]
 *   Output: [2 -> 1]
 *
 * Example 3:
 *   Input:  head = []
 *   Output: []
 *
 * CONSTRAINTS:
 * - The number of nodes in the list is in the range [0, 5000].
 * - -5000 <= Node.val <= 5000
 * - Handles null head safely.
 * ============================================================================
 */
public class ReverseLinkedList {

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
     * Approach 1: Iterative Three-Pointer Pointer-Reversal (Optimal Space)
     *
     * @implNote Maintain three pointers: `prev = null`, `curr = head`, and `nextTemp = null`.
     *           Traverse the list, reversing pointer direction (`curr.next = prev`) at each node.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1) in-place
     */
    public ListNode reverseListIterative(ListNode head) {
        // TODO: Write solution here
        return null;
    }

    /**
     * Approach 2: Recursive Functional Reversal
     *
     * @implNote Base case: if `head == null || head.next == null`, return `head`.
     *           Recursively reverse sub-list `newHead = reverseListRecursive(head.next)`,
     *           then update pointers: `head.next.next = head` and `head.next = null`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) call stack memory
     */
    public ListNode reverseListRecursive(ListNode head) {
        // TODO: Write solution here
        return null;
    }

    /**
     * Approach 3: Stack Auxiliary Buffer Traversal
     *
     * @implNote Push all nodes onto a Stack/Deque. Pop elements sequentially to rebuild
     *           reversed linkages.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) auxiliary space
     */
    public ListNode reverseListStack(ListNode head) {
        // TODO: Write solution here
        return null;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] input;
        private final List<Integer> expected;
        private final String description;

        public TestCase(int id, int[] input, List<Integer> expected, String description) {
            this.id = id;
            this.input = input;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getInput() { return input; }
        public List<Integer> getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        ReverseLinkedList solver = new ReverseLinkedList();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{1, 2, 3, 4, 5}, List.of(5, 4, 3, 2, 1), "Standard 5-node list reversal"),
                new TestCase(2, new int[]{1, 2}, List.of(2, 1), "Two-node list reversal"),
                new TestCase(3, new int[]{42}, List.of(42), "Single-node list"),
                new TestCase(4, new int[]{}, List.of(), "Empty list check"),
                new TestCase(5, null, List.of(), "Null head safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-14 REVERSE A LINKED LIST");
        System.out.println("================================================================================");

        runApproach("1. Iterative Three-Pointer Reversal", solver::reverseListIterative, testCases);
        runApproach("2. Recursive Functional Reversal", solver::reverseListRecursive, testCases);
        runApproach("3. Stack Auxiliary Buffer Traversal", solver::reverseListStack, testCases);
    }

    /**
     * Executes test cases, converts output list to array, compares against expected, and logs timing.
     */
    private static void runApproach(String name, Function<ListNode, ListNode> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            ListNode workingHead = ListNode.fromArray(tc.getInput());

            long startTime = System.nanoTime();
            ListNode reversedHead = method.apply(workingHead);
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            List<Integer> actual = ListNode.toList(reversedHead);

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