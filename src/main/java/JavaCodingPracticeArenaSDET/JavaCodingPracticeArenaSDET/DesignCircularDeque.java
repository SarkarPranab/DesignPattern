package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

/**
 * ============================================================================
 * PROBLEM EXP-43: DESIGN CIRCULAR DEQUE
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Design your implementation of the circular double-ended queue (deque).
 *
 * Implement the `MyCircularDeque` class:
 * - `MyCircularDeque(int k)` Initializes the deque with a maximum size of `k`.
 * - `boolean insertFront()` Adds an item at the front of Deque. Return true if the operation is successful, or false otherwise.
 * - `boolean insertLast()` Adds an item at the rear of Deque. Return true if the operation is successful, or false otherwise.
 * - `boolean deleteFront()` Deletes an item from the front of Deque. Return true if the operation is successful, or false otherwise.
 * - `boolean deleteLast()` Deletes an item from the rear of Deque. Return true if the operation is successful, or false otherwise.
 * - `int getFront()` Returns the front item from the Deque. If the deque is empty, return `-1`.
 * - `int getRear()` Returns the last item from Deque. If the deque is empty, return `-1`.
 * - `boolean isEmpty()` Returns true if the deque is empty, or false otherwise.
 * - `boolean isFull()` Returns true if the deque is full, or false otherwise.
 *
 * CONSTRAINTS:
 * - 1 <= k <= 1000
 * - 0 <= value <= 1000
 * - At most 2000 calls will be made to insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull.
 * ============================================================================
 */
public class DesignCircularDeque {

    /**
     * Circular Deque implementation using a fixed-size array and pointer wrapping.
     */
    public static class MyCircularDeque {
        private final int[] data;
        private int head;
        private int tail;
        private int count;
        private final int capacity;

        public MyCircularDeque(int k) {
            this.capacity = k;
            this.data = new int[k];
            this.head = 0;
            this.tail = 0;
            this.count = 0;
        }

        /**
         * Adds an item at the front of Deque.
         * @targetTimeComplexity O(1)
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            head = (head - 1 + capacity) % capacity;
            data[head] = value;
            count++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque.
         * @targetTimeComplexity O(1)
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            data[tail] = value;
            tail = (tail + 1) % capacity;
            count++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque.
         * @targetTimeComplexity O(1)
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            head = (head + 1) % capacity;
            count--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque.
         * @targetTimeComplexity O(1)
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            tail = (tail - 1 + capacity) % capacity;
            count--;
            return true;
        }

        /**
         * Returns the front item from the Deque.
         * @targetTimeComplexity O(1)
         */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return data[head];
        }

        /**
         * Returns the last item from Deque.
         * @targetTimeComplexity O(1)
         */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return data[(tail - 1 + capacity) % capacity];
        }

        /**
         * Checks whether the deque is empty.
         * @targetTimeComplexity O(1)
         */
        public boolean isEmpty() {
            return count == 0;
        }

        /**
         * Checks whether the deque is full.
         * @targetTimeComplexity O(1)
         */
        public boolean isFull() {
            return count == capacity;
        }
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-43 DESIGN CIRCULAR DEQUE");
        System.out.println("================================================================================");

        long startTime = System.nanoTime();

        MyCircularDeque circularDeque = new MyCircularDeque(3); // Set size to 3
        boolean r1 = circularDeque.insertLast(1);  // return true
        boolean r2 = circularDeque.insertLast(2);  // return true
        boolean r3 = circularDeque.insertFront(3); // return true
        boolean r4 = circularDeque.insertFront(4); // return false, queue is full
        int rearVal = circularDeque.getRear();     // return 2
        boolean isFull = circularDeque.isFull();   // return true
        boolean delLast = circularDeque.deleteLast(); // return true
        boolean r5 = circularDeque.insertFront(4); // return true
        int frontVal = circularDeque.getFront();   // return 4

        long durationNano = System.nanoTime() - startTime;

        boolean testPassed = (r1 && r2 && r3 && !r4 && rearVal == 2 && isFull && delLast && r5 && frontVal == 4);

        if (testPassed) {
            System.out.printf("  [PASS] MyCircularDeque Operations Test | Execution Time: %.3f ms\n", durationNano / 1_000_000.0);
            System.out.println("         Verified double-ended insertions, deletions, bounds, and wrapping successfully.");
        } else {
            System.out.printf("  [FAIL] MyCircularDeque Operations Test\n");
            System.out.printf("         Expected: r1=true, r2=true, r3=true, r4=false, rear=2, full=true, delLast=true, r5=true, front=4\n");
            System.out.printf("         Actual:   r1=%b, r2=%b, r3=%b, r4=%b, rear=%d, full=%b, delLast=%b, r5=%b, front=%d\n",
                    r1, r2, r3, r4, rearVal, isFull, delLast, r5, frontVal);
        }

        System.out.println("Summary: Test completed.");
    }
}