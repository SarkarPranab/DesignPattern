package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * ============================================================================
 * PROBLEM EXP-32: INTERSECTION OF TWO LINKED LISTS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given the heads of two singly linked-lists `headA` and `headB`, return the node
 * at which the two lists intersect. If the two linked lists have no intersection
 * at all, return `null`.
 *
 * EXAMPLES:
 * Example 1:
 *   Input: intersectVal = 8, listA = [4, 1, 8, 4, 5], listB = [5, 6, 1, 8, 4, 5], skipA = 2, skipB = 3
 *   Output: Intersected at '8'
 *
 * Example 2:
 *   Input: intersectVal = 2, listA = [1, 9, 1, 2, 4], listB = [3, 2, 4], skipA = 3, skipB = 1
 *   Output: Intersected at '2'
 *
 * Example 3:
 *   Input: intersectVal = 0, listA = [2, 6, 4], listB = [1, 5], skipA = 3, skipB = 2
 *   Output: null (No intersection)
 *
 * CONSTRAINTS:
 * - The number of nodes of listA is in the range [0, 3 * 10^4].
 * - The number of nodes of listB is in the range [0, 3 * 10^4].
 * - 1 <= Node.val <= 10^5
 * - 0 <= skipA <= listA.length
 * - 0 <= skipB <= listB.length
 * - Handles null heads safely by returning `null`.
 * ============================================================================
 */
public class IntersectionOfTwoLinkedLists {

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
    }

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Two-Pointer Traversal Switch (Optimal O(1) Space)
     *
     * @implNote Traverse both lists with pointers `pA` and `pB`. When pointer reaches the end
     *           of its list, redirect it to the head of the opposing list. If an intersection
     *           exists, they will meet at the intersection node in at most two passes.
     * @targetTimeComplexity O(N + M)
     * @targetSpaceComplexity O(1)
     */
    public ListNode getIntersectionNodeTwoPointers(ListNode headA, ListNode headB) {
        // TODO: Write solution here
        return null;
    }

    /**
     * Approach 2: HashSet Visited Reference Tracker
     *
     * @implNote Traverse `headA` and store all node references in a `HashSet<ListNode>`.
     *           Traverse `headB`, checking if any node is already present in the set.
     * @targetTimeComplexity O(N + M)
     * @targetSpaceComplexity O(N) auxiliary space
     */
    public ListNode getIntersectionNodeHashSet(ListNode headA, ListNode headB) {
        // TODO: Write solution here
        return null;
    }

    /**
     * Approach 3: Length Difference Alignment
     *
     * @implNote Calculate lengths of both lists (`lenA` and `lenB`). Advance the pointer
     *           of the longer list by `Math.abs(lenA - lenB)` steps, then traverse both
     *           lists in tandem until pointers match.
     * @targetTimeComplexity O(N + M)
     * @targetSpaceComplexity O(1)
     */
    public ListNode getIntersectionNodeLengthAligned(ListNode headA, ListNode headB) {
        // TODO: Write solution here
        return null;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final ListNode headA;
        private final ListNode headB;
        private final ListNode expectedIntersection;
        private final String description;

        public TestCase(int id, ListNode headA, ListNode headB, ListNode expectedIntersection, String description) {
            this.id = id;
            this.headA = headA;
            this.headB = headB;
            this.expectedIntersection = expectedIntersection;
            this.description = description;
        }

        public int getId() { return id; }
        public ListNode getHeadA() { return headA; }
        public ListNode getHeadB() { return headB; }
        public ListNode getExpectedIntersection() { return expectedIntersection; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists solver = new IntersectionOfTwoLinkedLists();

        // Construct test intersections manually for precise validation
        // Shared intersection: 8 -> 4 -> 5
        ListNode common = new ListNode(8, new ListNode(4, new ListNode(5)));

        // List A: 4 -> 1 -> (common)
        ListNode headA1 = new ListNode(4, new ListNode(1, common));
        // List B: 5 -> 6 -> 1 -> (common)
        ListNode headB1 = new ListNode(5, new ListNode(6, new ListNode(1, common)));

        // Disjoint lists
        ListNode headA2 = new ListNode(2, new ListNode(6, new ListNode(4)));
        ListNode headB2 = new ListNode(1, new ListNode(5));

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, headA1, headB1, common, "Standard intersecting lists at node value 8"),
                new TestCase(2, headA2, headB2, null, "Disjoint lists with no intersection"),
                new TestCase(3, null, headB1, null, "Null headA safety check"),
                new TestCase(4, headA1, null, null, "Null headB safety check"),
                new TestCase(5, null, null, null, "Both null heads check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-32 INTERSECTION OF TWO LINKED LISTS");
        System.out.println("================================================================================");

        runApproach("1. Two-Pointer Traversal Switch", solver::getIntersectionNodeTwoPointers, testCases);
        runApproach("2. HashSet Visited Reference Tracker", solver::getIntersectionNodeHashSet, testCases);
        runApproach("3. Length Difference Alignment", solver::getIntersectionNodeLengthAligned, testCases);
    }

    /**
     * Executes test cases, compares actual intersection node reference against expected, and logs timing.
     */
    private static void runApproach(String name, BiFunction<ListNode, ListNode, ListNode> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            ListNode result = method.apply(tc.getHeadA(), tc.getHeadB());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = (result == tc.getExpectedIntersection());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected Node Val: %s | Actual Node Val: %s\n",
                        tc.getExpectedIntersection() != null ? String.valueOf(tc.getExpectedIntersection().val) : "null",
                        result != null ? String.valueOf(result.val) : "null");
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}