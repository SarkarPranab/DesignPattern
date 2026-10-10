package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM: SINGLY LINKED LIST TRAVERSAL AND OPERATIONS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Given the head node of a singly linked list, traverse the list from start
 * to end, processing/collecting the integer values stored within each node.
 *
 * LINKED LIST NODE STRUCTURE:
 * - Each `Node` contains an integer data value (`num`) and a pointer reference (`nextRef`)
 *   to the next node in the sequence.
 * - The traversal terminates when `current == null`.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  10 -> 20 -> 30 -> 40 -> null
 *   Traversed Data: [10, 20, 30, 40]
 *
 * Example 2:
 *   Input:  100 -> null
 *   Traversed Data: [100]
 *
 * Example 3:
 *   Input:  null (Empty Linked List)
 *   Traversed Data: []
 *
 * CONSTRAINTS:
 * - 0 <= number of nodes <= 10^5
 * - -10^9 <= Node.data <= 10^9
 * ============================================================================
 */
public class SinglyLinkedListTraversal {

    /**
     * Node representation for a singly linked list.
     */
    public static class Node {
        private final int num;
        public Node nextRef;

        public Node(int data) {
            this.num = data;
            this.nextRef = null;
        }

        public int getData() {
            return num;
        }
    }

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Iterative Pointer Traversal (`while current != null`)
     *
     * @implNote Maintain a `current` node pointer starting at `head`. Iterate while
     *           `current != null`, collecting `current.getData()` into a `List<Integer>`
     *           and advancing `current = current.nextRef`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) for returned collection output
     */
    public List<Integer> traverseLinkedListIterative(Node head) {
        // TODO: Write iterative traversal solution here
        return Collections.emptyList();
    }

    /**
     * Approach 2: Recursive Pointer Traversal
     *
     * @implNote Base case: if `current == null`, return. Base step: collect `current.getData()`,
     *           then make a recursive call with `current.nextRef`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) recursion stack memory
     */
    public List<Integer> traverseLinkedListRecursive(Node head) {
        // TODO: Write recursive traversal solution here
        return Collections.emptyList();
    }

    /**
     * Approach 3: Helper Method to Calculate Linked List Length
     *
     * @implNote Traverse linked list and count total node elements.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public int getLinkedListLength(Node head) {
        // TODO: Write length calculation logic here
        return 0;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final Node head;
        private final List<Integer> expected;
        private final String description;

        public TestCase(int id, Node head, List<Integer> expected, String description) {
            this.id = id;
            this.head = head;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public Node getHead() { return head; }
        public List<Integer> getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        SinglyLinkedListTraversal solver = new SinglyLinkedListTraversal();

        // Build Test Case 1: 10 -> 20 -> 30 -> 40
        Node head1 = new Node(10);
        head1.nextRef = new Node(20);
        head1.nextRef.nextRef = new Node(30);
        head1.nextRef.nextRef.nextRef = new Node(40);

        // Build Test Case 2: Single node
        Node head2 = new Node(100);

        TestCase[] testCases = new TestCase[]{
//                new TestCase(1, head1, List.of(10, 20, 30, 40), "Standard 4-node Singly Linked List"),
//                new TestCase(2, head2, List.of(100), "Single-node Linked List"),
                new TestCase(3, null, Collections.emptyList(), "Null / Empty Linked List"),
                new TestCase(4, generateLargeLinkedList(100_000), generateExpectedLargeList(100_000), "Large stress test (100k nodes)")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: SINGLY LINKED LIST TRAVERSAL");
        System.out.println("================================================================================");

        runApproach("1. Iterative Pointer Traversal", solver::traverseLinkedListIterative, testCases);
        runApproach("2. Recursive Pointer Traversal", solver::traverseLinkedListRecursive, testCases);
    }

    /**
     * Executes test cases, compares actual vs expected traversal list output, and logs execution timing.
     */
    private static void runApproach(String name, Function<Node, List<Integer>> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            List<Integer> result = method.apply(tc.getHead());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Objects.equals(result, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected: %s\n", tc.getExpected().size() > 15 ? "[Large List]" : tc.getExpected());
                System.out.printf("         Actual:   %s\n", result != null && result.size() > 15 ? "[Large List]" : result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }

    private static Node generateLargeLinkedList(int size) {
        if (size <= 0) return null;
        Node head = new Node(0);
        Node current = head;
        for (int i = 1; i < size; i++) {
            current.nextRef = new Node(i);
            current = current.nextRef;
        }
        return head;
    }

    private static List<Integer> generateExpectedLargeList(int size) {
        List<Integer> expected = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            expected.add(i);
        }
        return expected;
    }
}