package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * PROBLEM EXP-70: MIDDLE OF THE LINKED LIST
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given the head of a singly linked list, return the middle node. If there are two middle
 * nodes (even length), return the SECOND middle node.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  [1, 2, 3, 4, 5]
 *   Output: node 3  (list from there: [3, 4, 5])
 * Example 2:
 *   Input:  [1, 2, 3, 4, 5, 6]
 *   Output: node 4  (list from there: [4, 5, 6])
 *
 * CONSTRAINTS:
 * - 0 <= list length <= 100
 * - Null head returns null.
 * ============================================================================
 */
public class MiddleOfLinkedList {

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
     * Approach 1: Count Nodes Then Walk Half
     *
     * @implNote First pass counts the nodes; second pass walks n / 2 steps.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public ListNode middleNodeCounting(ListNode head) {
        // TODO: Write solution here
        return null;
    }

    /**
     * Approach 2: Slow And Fast Pointers
     *
     * @implNote Move slow by 1 and fast by 2; when fast reaches the end, slow is at the middle.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public ListNode middleNodeSlowFast(ListNode head) {
        // TODO: Write solution here
        return null;
    }

    /**
     * Approach 3: Copy Nodes To ArrayList
     *
     * @implNote Store every node in an ArrayList and return the element at index size / 2.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N)
     */
    public ListNode middleNodeArrayList(ListNode head) {
        // TODO: Write solution here
        return null;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    @FunctionalInterface
    interface Solver {
        ListNode solve(ListNode head);
    }

    static class TestCase {
        private final int id;
        private final String description;
        private final ListNode head;
        private final ListNode expected;

        public TestCase(int id, String description, ListNode head, ListNode expected) {
            this.id = id;
            this.description = description;
            this.head = head;
            this.expected = expected;
        }
    }

    public static void main(String[] args) {
        MiddleOfLinkedList solver = new MiddleOfLinkedList();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, "Odd length list", ListNode.fromArray(new int[]{1, 2, 3, 4, 5}), ListNode.fromArray(new int[]{3, 4, 5})),
                new TestCase(2, "Even length list (second middle)", ListNode.fromArray(new int[]{1, 2, 3, 4, 5, 6}), ListNode.fromArray(new int[]{4, 5, 6})),
                new TestCase(3, "Single node", ListNode.fromArray(new int[]{1}), ListNode.fromArray(new int[]{1})),
                new TestCase(4, "Two nodes", ListNode.fromArray(new int[]{1, 2}), ListNode.fromArray(new int[]{2})),
                new TestCase(5, "Three nodes", ListNode.fromArray(new int[]{7, 8, 9}), ListNode.fromArray(new int[]{8, 9})),
                new TestCase(6, "Null input safety check", null, null)
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-70 MIDDLE OF THE LINKED LIST");
        System.out.println("================================================================================");

        runApproach("1. Count Nodes Then Walk Half", solver::middleNodeCounting, testCases);
        runApproach("2. Slow And Fast Pointers", solver::middleNodeSlowFast, testCases);
        runApproach("3. Copy Nodes To ArrayList", solver::middleNodeArrayList, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected output, and logs timing.
     */
    private static void runApproach(String name, Solver method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            ListNode result = null;
            boolean threw = false;
            long startTime = System.nanoTime();
            try {
                result = method.solve(tc.head);
            } catch (RuntimeException e) {
                threw = true;
            }
            long durationNano = System.nanoTime() - startTime;
            totalDurationNano += durationNano;

            boolean isCorrect = !threw && ListNode.toList(result).equals(ListNode.toList(tc.expected));
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.id, tc.description, durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.id, tc.description);
                System.out.printf("         Input:    %s\n", java.util.Arrays.asList(fmt(tc.head)));
                System.out.printf("         Expected: %s | Actual: %s%s\n",
                        fmt(tc.expected), fmt(result), threw ? " (exception thrown)" : "");
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    /**
     * Formats arrays, linked lists and other objects for readable test output.
     */
    private static String fmt(Object o) {
        if (o instanceof int[]) return Arrays.toString((int[]) o);
        if (o instanceof long[]) return Arrays.toString((long[]) o);
        if (o instanceof ListNode) return ListNode.toList((ListNode) o).toString();
        return String.valueOf(o);
    }
}
