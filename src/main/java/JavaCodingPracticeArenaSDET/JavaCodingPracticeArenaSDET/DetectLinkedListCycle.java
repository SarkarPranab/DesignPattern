package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

/**
 * ============================================================================
 * PROBLEM EXP-30: DETECT CYCLE IN A LINKED LIST
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given `head`, the head of a linked list, determine if the linked list has
 * a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that
 * can be reached again by continuously following the `next` pointer.
 *
 * Return `true` if there is a cycle in the linked list. Otherwise, return `false`.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  head = [3, 2, 0, -4], pos = 1 (tail connects to node index 1)
 *   Output: true
 *
 * Example 2:
 *   Input:  head = [1, 2], pos = 0 (tail connects to node index 0)
 *   Output: true
 *
 * Example 3:
 *   Input:  head = [1], pos = -1 (no cycle)
 *   Output: false
 *
 * CONSTRAINTS:
 * - The number of the nodes in the list is in the range [0, 10^4].
 * - -10^5 <= Node.val <= 10^5
 * - `pos` is -1 or a valid index in the linked-list.
 * - Handles null head safely by returning `false`.
 * ============================================================================
 */
public class DetectLinkedListCycle {

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

        /**
         * Helper utility to construct a linked list with an optional cycle at `pos`.
         */
        public static ListNode fromArrayWithCycle(int[] arr, int pos) {
            if (arr == null || arr.length == 0) return null;
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;
            ListNode cycleTarget = null;

            for (int i = 0; i < arr.length; i++) {
                curr.next = new ListNode(arr[i]);
                curr = curr.next;
                if (i == pos) {
                    cycleTarget = curr;
                }
            }

            if (pos != -1 && cycleTarget != null) {
                curr.next = cycleTarget;
            }

            return dummy.next;
        }
    }

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Floyd's Cycle-Finding Algorithm (Tortoise and Hare - Optimal Space)
     *
     * @implNote Use two pointers: `slow` (moves 1 step) and `fast` (moves 2 steps).
     *           If a cycle exists, `fast` will eventually meet `slow`. If `fast` or
     *           `fast.next` reaches `null`, no cycle exists.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public boolean hasCycleFloyd(ListNode head) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 2: HashSet Visited Tracker
     *
     * @implNote Traverse the linked list and store each visited node reference in a
     *           `HashSet<ListNode>`. If a node is already present in the set, a cycle exists.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) auxiliary space
     */
    public boolean hasCycleHashSet(ListNode head) {
        // TODO: Write solution here
        return false;
    }

    /**
     * Approach 3: Visited Flag / Node Mutation (Destructive)
     *
     * @implNote Traverse list, marking visited nodes by mutating values or setting a flag
     *           (note: modifies original node structure).
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public boolean hasCycleFlag(ListNode head) {
        // TODO: Write solution here
        return false;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int[] input;
        private final int pos;
        private final boolean expected;
        private final String description;

        public TestCase(int id, int[] input, int pos, boolean expected, String description) {
            this.id = id;
            this.input = input;
            this.pos = pos;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int[] getInput() { return input; }
        public int getPos() { return pos; }
        public boolean getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        DetectLinkedListCycle solver = new DetectLinkedListCycle();

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, new int[]{3, 2, 0, -4}, 1, true, "Standard cycle connected at position 1"),
                new TestCase(2, new int[]{1, 2}, 0, true, "Cycle connected back to head (position 0)"),
                new TestCase(3, new int[]{1}, -1, false, "Single node without cycle"),
                new TestCase(4, new int[]{1, 2, 3, 4}, -1, false, "Linear acyclic list"),
                new TestCase(5, new int[]{}, -1, false, "Empty list check"),
                new TestCase(6, null, -1, false, "Null head safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-30 DETECT CYCLE IN A LINKED LIST");
        System.out.println("================================================================================");

        runApproach("1. Floyd's Tortoise and Hare Algorithm", solver::hasCycleFloyd, testCases);
        runApproach("2. HashSet Visited Tracker", solver::hasCycleHashSet, testCases);
        runApproach("3. Visited Flag Mutation", solver::hasCycleFlag, testCases);
    }

    /**
     * Executes test cases, compares actual boolean output against expected, and logs timing.
     */
    private static void runApproach(String name, Predicate<ListNode> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            ListNode head = ListNode.fromArrayWithCycle(tc.getInput(), tc.getPos());

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