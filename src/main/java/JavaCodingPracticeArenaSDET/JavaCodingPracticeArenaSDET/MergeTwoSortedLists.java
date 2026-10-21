package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

/**
 * ============================================================================
 * PROBLEM EXP-29: MERGE TWO SORTED LISTS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * You are given the heads of two sorted singly linked lists `list1` and `list2`.
 * Merge the two lists into one sorted list. The list should be made by splicing
 * together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  list1 = [1 -> 2 -> 4], list2 = [1 -> 3 -> 4]
 *   Output: [1 -> 1 -> 2 -> 3 -> 4 -> 4]
 *
 * Example 2:
 *   Input:  list1 = [], list2 = []
 *   Output: []
 *
 * Example 3:
 *   Input:  list1 = [], list2 = [0]
 *   Output: [0]
 *
 * CONSTRAINTS:
 * - The number of nodes in both lists is in the range [0, 50].
 * - -100 <= Node.val <= 100
 * - Both `list1` and `list2` are sorted in non-decreasing order.
 * - Handles null heads safely.
 * ============================================================================
 */
public class MergeTwoSortedLists {

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
     * Approach 1: Iterative Pointer Merging with Dummy Head (Optimal Space/Time)
     *
     * @implNote Create a dummy node pointer. Compare heads of `list1` and `list2`, attaching
     *           the smaller node to the merged tail pointer and advancing. Append any
     *           remaining nodes when one list is exhausted.
     * @targetTimeComplexity O(N + M)
     * @targetSpaceComplexity O(1) in-place pointer manipulation
     */
    public ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
        // TODO: Write solution here
        return null;
    }

    /**
     * Approach 2: Recursive Functional Merging
     *
     * @implNote Base cases: if `list1 == null` return `list2`; if `list2 == null` return `list1`.
     *           Recursively compare values: `list1.val < list2.val` sets `list1.next = merge(list1.next, list2)`
     *           and returns `list1`.
     * @targetTimeComplexity O(N + M)
     * @targetSpaceComplexity O(N + M) call stack memory
     */
    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
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
        MergeTwoSortedLists solver = new MergeTwoSortedLists();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{1, 2, 4}, new int[]{1, 3, 4}, List.of(1, 1, 2, 3, 4, 4), "Standard interwoven sorted lists"),
                new TestCase(2, new int[]{}, new int[]{}, List.of(), "Both lists empty"),
                new TestCase(3, new int[]{}, new int[]{0}, List.of(0), "First list empty, second has single node"),
                new TestCase(4, new int[]{5}, new int[]{1, 2, 3}, List.of(1, 2, 3, 5), "Lists with differing lengths"),
                new TestCase(5, null, null, List.of(), "Null safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-29 MERGE TWO SORTED LISTS");
        System.out.println("================================================================================");

        runApproach("1. Iterative Pointer Merging", solver::mergeTwoListsIterative, testCases);
        runApproach("2. Recursive Functional Merging", solver::mergeTwoListsRecursive, testCases);
    }

    /**
     * Executes test cases, converts output list to array, compares against expected, and logs timing.
     */
    private static void runApproach(String name, BiFunction<ListNode, ListNode, ListNode> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            ListNode l1 = ListNode.fromArray(tc.getInput1());
            ListNode l2 = ListNode.fromArray(tc.getInput2());

            long startTime = System.nanoTime();
            ListNode mergedHead = method.apply(l1, l2);
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            List<Integer> actual = ListNode.toList(mergedHead);

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