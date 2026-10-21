package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * ============================================================================
 * PROBLEM EXP-28: IMPLEMENT STACK USING QUEUES
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Implement a last-in-first-out (LIFO) stack using only two queues.
 * The implemented stack should support all the functions of a normal stack
 * (`push`, `top`, `pop`, and `empty`).
 *
 * Implement the `MyStack` class:
 * - `void push(int x)` Pushes element x to the top of the stack.
 * - `int pop()` Removes the element on the top of the stack and returns it.
 * - `int top()` Returns the element on the top of the stack.
 * - `boolean empty()` Returns true if the stack is empty, false otherwise.
 *
 * CONSTRAINTS:
 * - 1 <= x <= 9
 * - At most 100 calls will be made to `push`, `pop`, `top`, and `empty`.
 * - All the calls to `pop` and `top` are valid.
 * ============================================================================
 */
public class ImplementStackUsingQueues {

    /**
     * MyStack data structure using Queues.
     */
    public static class MyStack {
        private final Queue<Integer> queue1;
        private final Queue<Integer> queue2;

        public MyStack() {
            this.queue1 = new ArrayDeque<>();
            this.queue2 = new ArrayDeque<>();
        }

        /**
         * Push element x onto stack.
         * @targetTimeComplexity O(N) or O(1) depending on push vs pop strategy
         */
        public void push(int x) {
            // TODO: Write solution here
        }

        /**
         * Removes the element on the top of the stack and returns it.
         * @targetTimeComplexity O(1) or O(N)
         */
        public int pop() {
            // TODO: Write solution here
            return -1;
        }

        /**
         * Get the top element.
         * @targetTimeComplexity O(1) or O(N)
         */
        public int top() {
            // TODO: Write solution here
            return -1;
        }

        /**
         * Returns whether the stack is empty.
         * @targetTimeComplexity O(1)
         */
        public boolean empty() {
            // TODO: Write solution here
            return true;
        }
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-28 IMPLEMENT STACK USING QUEUES");
        System.out.println("================================================================================");

        MyStack stack = new MyStack();

        long startTime = System.nanoTime();

        stack.push(1);
        stack.push(2);
        int topVal = stack.top();   // returns 2
        int popVal = stack.pop();   // returns 2
        boolean isEmpty = stack.empty(); // returns false

        long durationNano = System.nanoTime() - startTime;

        boolean testPassed = (topVal == 2 && popVal == 2 && !isEmpty);

        if (testPassed) {
            System.out.printf("  [PASS] MyStack Operations Test | Execution Time: %.3f ms\n", durationNano / 1_000_000.0);
            System.out.println("         Operations verified: push(1), push(2), top()=2, pop()=2, empty()=false");
        } else {
            System.out.printf("  [FAIL] MyStack Operations Test\n");
            System.out.printf("         Expected top: 2, pop: 2, empty: false\n");
            System.out.printf("         Actual   top: %d, pop: %d, empty: %b\n", topVal, popVal, isEmpty);
        }

        System.out.println("Summary: Test completed.");
    }
}