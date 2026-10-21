package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

/**
 * ============================================================================
 * PROBLEM EXP-37: REVERSE NODES IN K-GROUP
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given the `head` of a linked list, reverse the nodes of the list `k` at a time,
 * and return the modified list.
 *
 * `k` is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of `k` then left-out nodes, in the end,
 * should remain as they are.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  head = [1 -> 2 -> 3 -> 4 -> 5], k = 2
 *   Output: 2 -> 1 -> 4 -> 3 -> 5
 *
 * Example 2:
 *   Input:  head = [1 -> 2 -> 3 -> 4 -> 5], k = 3
 *   Output: 3 -> 2 -> 1 -> 4 -> 5
 *
 * CONSTRAINTS:
 * - The number of nodes in the list is `n`.
 * - 1 <= k <= n <= 5000
 * - 0 <= Node.val <= 1000
 * - Handles null heads and k=1 safely.
 * ============================================================================
 */
public class ReverseNodesInKGroup {

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
     * Approach 1: Iterative Pointer Group Reversal with Dummy Head (Optimal O(1) Space)
     *
     * @implNote Use a dummy head. For each group of `k` nodes, first check if at least `k`
     *           nodes remain. If so, reverse the `k`-node sublist iteratively and reconnect
     *           with preceding and succeeding segments.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public ListNode reverseKGroupIterative(ListNode head, int k) {
        // TODO: Write solution here
        return null;
    }

    /**
     * Approach 2: Recursive k-Group Reversal
     *
     * @implNote Check if there are at least `k` nodes remaining. If yes, reverse the first `k`
     *           nodes, recursively call for the remaining sublist, and attach the tail.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N/k) call stack memory
     */
    public ListNode reverseKGroupRecursive(ListNode head, int k) {
        // TODO: Write solution here
        return null;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] input;
        private final int k;
        private final List<Integer> expected;
        private final String description;

        public TestCase(int id, int[] input, int k, List<Integer> expected, String description) {
            this.id = id;
            this.input = input;
            this.k = k;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getInput() { return input; }
        public int getK() { return k; }
        public List<Integer> getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup solver = new ReverseNodesInKGroup();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{1, 2, 3, 4, 5}, 2, List.of(2, 1, 4, 3, 5), "Reverse groups of 2 with odd tail"),
                new TestCase(2, new int[]{1, 2, 3, 4, 5}, 3, List.of(3, 2, 1, 4, 5), "Reverse groups of 3 with two remaining nodes"),
                new TestCase(3, new int[]{1, 2, 3, 4}, 4, List.of(4, 3, 2, 1), "Reverse full list when k equals length"),
                new TestCase(4, new int[]{1, 2}, 1, List.of(1, 2), "k=1 leaves list unchanged"),
                new TestCase(5, null, 2, List.of(), "Null head safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-37 REVERSE NODES IN K-GROUP");
        System.out.println("================================================================================");

        runApproach("1. Iterative Pointer Group Reversal", solver::reverseKGroupIterative, testCases);
        runApproach("2. Recursive k-Group Reversal", solver::reverseKGroupRecursive, testCases);
    }

    /**
     * Executes test cases, compares actual reversed k-group list output against expected, and logs timing.
     */
    private static void runApproach(String name, BiFunction<ListNode, Integer, ListNode> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            ListNode head = ListNode.fromArray(tc.getInput());

            long startTime = System.nanoTime();
            ListNode modifiedHead = method.apply(head, tc.getK());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            List<Integer> actual = ListNode.toList(modifiedHead);

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