package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

/**
 * ============================================================================
 * PROBLEM EXP-42: DESIGN CIRCULAR QUEUE
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Design your implementation of the circular queue. The circular queue is a linear data
 * structure in which the operations are performed based on FIFO (First In First Out) principle
 * and the last position is connected back to the first position to make a circle.
 * It is also called "Ring Buffer".
 *
 * Implement the `MyCircularQueue` class:
 * - `MyCircularQueue(int k)` Initializes the object with the size of the queue to be `k`.
 * - `int front()` Gets the front item from the queue. If the queue is empty, return `-1`.
 * - `int rear()` Gets the last item from the queue. If the queue is empty, return `-1`.
 * - `boolean enQueue(int value)` Inserts an element into the circular queue. Return true if successful.
 * - `boolean deQueue()` Deletes an element from the circular queue. Return true if successful.
 * - `boolean isEmpty()` Checks whether the circular queue is empty or not.
 * - `boolean isFull()` Checks whether the circular queue is full or not.
 *
 * You must solve the problem without using the built-in queue data structure in your Java library.
 *
 * CONSTRAINTS:
 * - 1 <= k <= 1000
 * - 0 <= value <= 1000
 * - At most 3000 calls will be made to `enQueue`, `deQueue`, `front`, `rear`, `isEmpty`, and `isFull`.
 * ============================================================================
 */
public class DesignCircularQueue {

    /**
     * Circular Queue implementation using a fixed-size array.
     */
    public static class MyCircularQueue {
        private final int[] data;
        private int head;
        private int tail;
        private int count;
        private final int capacity;

        public MyCircularQueue(int k) {
            this.capacity = k;
            this.data = new int[k];
            this.head = 0;
            this.tail = -1;
            this.count = 0;
        }

        /**
         * Insert an element into the circular queue. Return true if successful.
         * @targetTimeComplexity O(1)
         */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            tail = (tail + 1) % capacity;
            data[tail] = value;
            count++;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if successful.
         * @targetTimeComplexity O(1)
         */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            head = (head + 1) % capacity;
            count--;
            return true;
        }

        /**
         * Get the front item from the queue.
         * @targetTimeComplexity O(1)
         */
        public int front() {
            if (isEmpty()) {
                return -1;
            }
            return data[head];
        }

        /**
         * Get the last item from the queue.
         * @targetTimeComplexity O(1)
         */
        public int rear() {
            if (isEmpty()) {
                return -1;
            }
            return data[tail];
        }

        /**
         * Checks whether the circular queue is empty.
         * @targetTimeComplexity O(1)
         */
        public boolean isEmpty() {
            return count == 0;
        }

        /**
         * Checks whether the circular queue is full.
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
        System.out.println(" RUNNING TEST SUITE: EXP-42 DESIGN CIRCULAR QUEUE");
        System.out.println("================================================================================");

        long startTime = System.nanoTime();

        MyCircularQueue q = new MyCircularQueue(3);
        boolean r1 = q.enQueue(1); // return True
        boolean r2 = q.enQueue(2); // return True
        boolean r3 = q.enQueue(3); // return True
        boolean r4 = q.enQueue(4); // return False (queue is full)
        int rearVal = q.rear();    // return 3
        boolean isFull = q.isFull(); // return True
        boolean deq = q.deQueue();  // return True
        boolean r5 = q.enQueue(4); // return True
        int frontVal = q.front();  // return 2
        int newRear = q.rear();    // return 4

        long durationNano = System.nanoTime() - startTime;

        boolean testPassed = (r1 && r2 && r3 && !r4 && rearVal == 3 && isFull && deq && r5 && frontVal == 2 && newRear == 4);

        if (testPassed) {
            System.out.printf("  [PASS] MyCircularQueue Operations Test | Execution Time: %.3f ms\n", durationNano / 1_000_000.0);
            System.out.println("         Verified circular buffer wrapping, enqueue, dequeue, front, and rear successfully.");
        } else {
            System.out.printf("  [FAIL] MyCircularQueue Operations Test\n");
            System.out.printf("         Expected: r1=true, r2=true, r3=true, r4=false, rear=3, full=true, deq=true, r5=true, front=2, newRear=4\n");
            System.out.printf("         Actual:   r1=%b, r2=%b, r3=%b, r4=%b, rear=%d, full=%b, deq=%b, r5=%b, front=%d, newRear=%d\n",
                    r1, r2, r3, r4, rearVal, isFull, deq, r5, frontVal, newRear);
        }

        System.out.println("Summary: Test completed.");
    }
}