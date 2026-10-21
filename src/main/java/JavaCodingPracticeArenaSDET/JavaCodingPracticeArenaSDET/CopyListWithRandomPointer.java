package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * ============================================================================
 * PROBLEM EXP-38: COPY LIST WITH RANDOM POINTER
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * A linked list of length `n` is given such that each node contains an additional
 * random pointer, which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly `n` brand new
 * nodes, where each new node has its value set to the value of its corresponding original node.
 * Both the `next` and `random` pointer of the new nodes should point to new nodes in the copied list
 * such that the pointers in the original list and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 *
 * Return the head of the copied linked list.
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *   Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * CONSTRAINTS:
 * - 0 <= n <= 1000
 * - -10^4 <= Node.val <= 10^4
 * - Node.random is null or is pointing to some node in the linked list.
 * - Handles null heads safely by returning `null`.
 * ============================================================================
 */
public class CopyListWithRandomPointer {

    /**
     * Definition for a Node with random pointer.
     */
    public static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        /**
         * Helper utility to construct a cloned list representation for testing.
         */
        public static List<List<Object>> toList(Node head) {
            List<List<Object>> result = new ArrayList<>();
            Map<Node, Integer> nodeToIndex = new HashMap<>();
            Node curr = head;
            int idx = 0;
            while (curr != null) {
                nodeToIndex.put(curr, idx++);
                curr = curr.next;
            }

            curr = head;
            while (curr != null) {
                List<Object> nodePair = new ArrayList<>();
                nodePair.add(curr.val);
                nodePair.add(curr.random != null ? nodeToIndex.get(curr.random) : null);
                result.add(nodePair);
                curr = curr.next;
            }
            return result;
        }
    }

    // ========================================================================
    // SOLUTION METHODS (TO BE IMPLEMENTED)
    // ========================================================================

    /**
     * Approach 1: Interweaving Clone Nodes in-place (Optimal O(1) Space)
     *
     * @implNote 1. Create a copy of each node and insert it directly after its original node.
     *           2. Assign random pointers for copy nodes: `copy.random = original.random.next`.
     *           3. Restore original list structure and extract the copied linked list.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(1)
     */
    public Node copyRandomListInterweave(Node head) {
        // TODO: Write solution here
        return null;
    }

    /**
     * Approach 2: HashMap Mapping (Original Node -> Copied Node)
     *
     * @implNote Use a `HashMap<Node, Node>` to map original nodes to their newly created clones.
     *           First pass creates all nodes and populates the map. Second pass wires `next`
     *           and `random` pointers using map lookups.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) map storage
     */
    public Node copyRandomListHashMap(Node head) {
        // TODO: Write solution here
        return null;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final Node inputHead;
        private final String description;

        public TestCase(int id, Node inputHead, String description) {
            this.id = id;
            this.inputHead = inputHead;
            this.description = description;
        }

        public int getId() { return id; }
        public Node getInputHead() { return inputHead; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer solver = new CopyListWithRandomPointer();

        // Construct test case 1: [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, n1, "Standard multi-node list with complex random pointers"),
                new TestCase(2, null, "Null head safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-38 COPY LIST WITH RANDOM POINTER");
        System.out.println("================================================================================");

        runApproach("1. Interweaving Clone Nodes (O(1) Space)", solver::copyRandomListInterweave, testCases);
        runApproach("2. HashMap Mapping", solver::copyRandomListHashMap, testCases);
    }

    /**
     * Executes test cases, compares structural clone equivalence against original, and logs timing.
     */
    private static void runApproach(String name, Function<Node, Node> method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            Node copiedHead = method.apply(tc.getInputHead());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            List<List<Object>> originalStructure = Node.toList(tc.getInputHead());
            List<List<Object>> copiedStructure = Node.toList(copiedHead);

            boolean isCorrect = Objects.equals(originalStructure, copiedStructure);
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected: %s\n", originalStructure);
                System.out.printf("         Actual:   %s\n", copiedStructure);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}