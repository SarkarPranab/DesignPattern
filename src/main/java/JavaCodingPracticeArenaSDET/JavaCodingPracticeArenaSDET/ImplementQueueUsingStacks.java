package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * ============================================================================
 * PROBLEM EXP-27: IMPLEMENT QUEUE USING STACKS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Implement a first in, first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue
 * (`push`, `peek`, `pop`, and `empty`).
 *
 * Implement the `MyQueue` class:
 * - `void push(int x)` Pushes element x to the back of the queue.
 * - `int pop()` Removes the element from the front of the queue and returns it.
 * - `int peek()` Returns the element at the front of the queue.
 * - `boolean empty()` Returns true if the queue is empty, false otherwise.
 *
 * CONSTRAINTS:
 * - 1 <= x <= 9
 * - At most 100 calls will be made to `push`, `pop`, `peek`, and `empty`.
 * - All the calls to `pop` and `peek` are valid.
 * ============================================================================
 */
public class ImplementQueueUsingStacks {

    /**
     * MyQueue data structure using two Stacks.
     */
    public static class MyQueue {
        private final Deque<Integer> inputStack;
        private final Deque<Integer> outputStack;

        public MyQueue() {
            this.inputStack = new ArrayDeque<>();
            this.outputStack = new ArrayDeque<>();
        }

        /**
         * Push element x to the back of queue.
         * @targetTimeComplexity O(1)
         */
        public void push(int x) {
            // TODO: Write solution here
        }

        /**
         * Removes the element from the front of the queue and returns it.
         * @targetTimeComplexity Amortized O(1)
         */
        public int pop() {
            // TODO: Write solution here
            return -1;
        }

        /**
         * Get the front element.
         * @targetTimeComplexity Amortized O(1)
         */
        public int peek() {
            // TODO: Write solution here
            return -1;
        }

        /**
         * Returns whether the queue is empty.
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
        System.out.println(" RUNNING TEST SUITE: EXP-27 IMPLEMENT QUEUE USING STACKS");
        System.out.println("================================================================================");

        MyQueue queue = new MyQueue();

        long startTime = System.nanoTime();

        queue.push(1);
        queue.push(2);
        int peekVal = queue.peek(); // returns 1
        int popVal = queue.pop();   // returns 1
        boolean isEmpty = queue.empty(); // returns false

        long durationNano = System.nanoTime() - startTime;

        boolean testPassed = (peekVal == 1 && popVal == 1 && !isEmpty);

        if (testPassed) {
            System.out.printf("  [PASS] MyQueue Operations Test | Execution Time: %.3f ms\n", durationNano / 1_000_000.0);
            System.out.println("         Operations verified: push(1), push(2), peek()=1, pop()=1, empty()=false");
        } else {
            System.out.printf("  [FAIL] MyQueue Operations Test\n");
            System.out.printf("         Expected peek: 1, pop: 1, empty: false\n");
            System.out.printf("         Actual   peek: %d, pop: %d, empty: %b\n", peekVal, popVal, isEmpty);
        }

        System.out.println("Summary: Test completed.");
    }
}