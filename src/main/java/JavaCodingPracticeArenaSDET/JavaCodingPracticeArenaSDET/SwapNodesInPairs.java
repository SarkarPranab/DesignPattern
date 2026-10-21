package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM EXP-36: SWAP NODES IN PAIRS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  head = [1 -> 2 -> 3 -> 4]
 *   Output: 2 -> 1 -> 4 -> 3
 *
 * Example 2:
 *   Input:  head = []
 *   Output: []
 *
 * Example 3:
 *   Input:  head = [1]
 *   Output: 1
 *
 * CONSTRAINTS:
 * - The number of nodes in the list is in the range [0, 100].
 * - 0 <= Node.val <= 100
 * - Handles null and single-node heads safely.
 * ============================================================================
 */
public class SwapNodesInPairs {

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
     * Approach 1: Iterative Pointer Swapping with Dummy Head (Optimal O(1) Space)
     *
     * @implNote Use a dummy head node. Maintain a `prev` pointer before each pair of nodes
     *           to be swapped (`first` and `second`). Re-link pointers iteratively:
     *           `prev.next = second`, `first.next = second.next`, `second.next = first`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public ListNode swapPairsIterative(ListNode head) {
        // TODO: Write solution here
        return null;
    }

    /**
     * Approach 2: Recursive Pair Swapping
     *
     * @implNote Base case: if `head == null || head.next == null`, return `head`.
     *           Identify `first = head` and `second = head.next`.
     *           Set `first.next = swapPairsRecursive(second.next)` and `second.next = first`.
     *           Return `second`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) call stack memory
     */
    public ListNode swapPairsRecursive(ListNode head) {
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
        SwapNodesInPairs solver = new SwapNodesInPairs();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{1, 2, 3, 4}, List.of(2, 1, 4, 3), "Even number of nodes swap pair"),
                new TestCase(2, new int[]{1, 2, 3}, List.of(2, 1, 3), "Odd number of nodes swap pair leaving last intact"),
                new TestCase(3, new int[]{1}, List.of(1), "Single node list check"),
                new TestCase(4, new int[]{}, List.of(), "Empty list check"),
                new TestCase(5, null, List.of(), "Null head safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-36 SWAP NODES IN PAIRS");
        System.out.println("================================================================================");

        runApproach("1. Iterative Pointer Swapping", solver::swapPairsIterative, testCases);
        runApproach("2. Recursive Pair Swapping", solver::swapPairsRecursive, testCases);
    }

    /**
     * Executes test cases, compares actual swapped list output against expected, and logs timing.
     */
    private static void runApproach(String name, Function<ListNode, ListNode> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            ListNode head = ListNode.fromArray(tc.getInput());

            long startTime = System.nanoTime();
            ListNode swappedHead = method.apply(head);
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            List<Integer> actual = ListNode.toList(swappedHead);

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