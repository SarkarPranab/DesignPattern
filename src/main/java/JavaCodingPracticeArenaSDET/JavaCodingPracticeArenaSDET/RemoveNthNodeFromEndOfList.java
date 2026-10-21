package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

/**
 * ============================================================================
 * PROBLEM EXP-34: REMOVE NTH NODE FROM END OF LIST
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given the `head` of a linked list, remove the `n`-th node from the end of the
 * list and return its head.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  head = [1 -> 2 -> 3 -> 4 -> 5], n = 2
 *   Output: 1 -> 2 -> 3 -> 5
 *
 * Example 2:
 *   Input:  head = [1], n = 1
 *   Output: []
 *
 * Example 3:
 *   Input:  head = [1 -> 2], n = 1
 *   Output: 1
 *
 * CONSTRAINTS:
 * - The number of nodes in the list is `sz`.
 * - 1 <= sz <= 30
 * - 0 <= Node.val <= 100
 * - 1 <= n <= sz
 * - Handles null heads safely.
 * ============================================================================
 */
public class RemoveNthNodeFromEndOfList {

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
     * Approach 1: Two-Pointer Single Pass with Dummy Head (Optimal O(N) Time, O(1) Space)
     *
     * @implNote Create a dummy head pointing to `head`. Use two pointers (`fast` and `slow`)
     *           initially at dummy. Advance `fast` by `n + 1` steps. Then advance both `fast`
     *           and `slow` concurrently until `fast` reaches `null`. `slow.next` will be the target
     *           node to remove. Perform deletion via `slow.next = slow.next.next`.
     * @targetTimeComplexity O(N) single pass
     * @targetSpaceComplexity O(1)
     */
    public ListNode removeNthFromEndTwoPointers(ListNode head, int n) {
        // TODO: Write solution here
        return null;
    }

    /**
     * Approach 2: Two-Pass Length Calculation
     *
     * @implNote First pass: compute total length `L` of the linked list. Second pass: traverse
     *           to the `(L - n)`-th node from the start and remove its successor.
     * @targetTimeComplexity O(N) two passes
     * @targetSpaceComplexity O(1)
     */
    public ListNode removeNthFromEndTwoPass(ListNode head, int n) {
        // TODO: Write solution here
        return null;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] input;
        private final int n;
        private final List<Integer> expected;
        private final String description;

        public TestCase(int id, int[] input, int n, List<Integer> expected, String description) {
            this.id = id;
            this.input = input;
            this.n = n;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getInput() { return input; }
        public int getN() { return n; }
        public List<Integer> getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList solver = new RemoveNthNodeFromEndOfList();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{1, 2, 3, 4, 5}, 2, List.of(1, 2, 3, 5), "Remove 2nd node from end (value 4)"),
                new TestCase(2, new int[]{1}, 1, List.of(), "Remove only node in list"),
                new TestCase(3, new int[]{1, 2}, 1, List.of(1), "Remove last node of two-node list"),
                new TestCase(4, new int[]{1, 2}, 2, List.of(2), "Remove head node of two-node list"),
                new TestCase(5, null, 1, List.of(), "Null head safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-34 REMOVE NTH NODE FROM END OF LIST");
        System.out.println("================================================================================");

        runApproach("1. Two-Pointer Single Pass with Dummy Head", solver::removeNthFromEndTwoPointers, testCases);
        runApproach("2. Two-Pass Length Calculation", solver::removeNthFromEndTwoPass, testCases);
    }

    /**
     * Executes test cases, compares actual output list against expected, and logs timing.
     */
    private static void runApproach(String name, BiFunction<ListNode, Integer, ListNode> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            ListNode head = ListNode.fromArray(tc.getInput());

            long startTime = System.nanoTime();
            ListNode modifiedHead = method.apply(head, tc.getN());
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