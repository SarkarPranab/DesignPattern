package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ============================================================================
 * PROBLEM EXP-16: PRINT ODD AND EVEN NUMBERS USING TWO THREADS
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Design a multi-threaded coordination program where two threads alternate
 * sequentially to print (or collect) numbers from `1` to `N`.
 *
 * - Thread 1 (Odd Thread) must print only odd numbers (1, 3, 5, ...).
 * - Thread 2 (Even Thread) must print only even numbers (2, 4, 6, ...).
 * - The combined output must be strictly sequential (1, 2, 3, 4, ..., N).
 *
 * EXAMPLES:
 * Example 1:
 *   Input:  N = 10
 *   Output Sequence: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 *
 * CONSTRAINTS:
 * - 1 <= N <= 1000
 * - Solution must prevent thread starvation, deadlock, and race conditions.
 * - Handles N <= 0 safely by returning an empty sequence.
 * ============================================================================
 */
public class PrintOddEvenThreads {

    // ========================================================================
    // APPROACH 1: CLASSICAL SYNCHRONIZED BLOCK WITH WAIT / NOTIFY
    // ========================================================================

    /**
     * Approach 1: Synchronized Monitor Object (`wait()` and `notify()`)
     *
     * @implNote Use an explicit shared monitor object. Odd thread checks `counter % 2 == 0`
     *           and calls `wait()`. Even thread checks `counter % 2 != 0` and calls `wait()`.
     *           After printing/collecting, notify the waiting thread using `monitor.notify()`.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) for output collection
     */
    public List<Integer> printOddEvenWaitNotify(int maxNumber) {
        // TODO: Write solution here
        return new ArrayList<>();
    }

    // ========================================================================
    // APPROACH 2: REENTRANTLOCK WITH CONDITION VARIABLES
    // ========================================================================

    /**
     * Approach 2: Explicit Lock with `Condition` signal (`await()` / `signal()`)
     *
     * @implNote Use a `ReentrantLock` and a `Condition` variable (e.g., `isOddTurn`).
     *           Provides explicit thread signalling and flexible lock handling.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) for output collection
     */
    public List<Integer> printOddEvenLockCondition(int maxNumber) {
        // TODO: Write solution here
        return new ArrayList<>();
    }

    // ========================================================================
    // APPROACH 3: ATOMICBOOLEAN LOCK-FREE STATE TOGGLE (BUSY-WAIT LOOP)
    // ========================================================================

    /**
     * Approach 3: State-based signaling using `AtomicBoolean` / `volatile` state
     *
     * @implNote Maintain an `AtomicBoolean isOddTurn = new AtomicBoolean(true)` or `volatile` flag.
     *           Threads loop until `maxNumber` is reached, executing conditionally when
     *           their respective turn matches.
     * @targetTimeComplexity O(N)
     * @targetSpaceComplexity O(N) for output collection
     */
    public List<Integer> printOddEvenAtomicFlag(int maxNumber) {
        // TODO: Write solution here
        return new ArrayList<>();
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    static class TestCase {
        private final int id;
        private final int maxNumber;
        private final List<Integer> expected;
        private final String description;

        public TestCase(int id, int maxNumber, List<Integer> expected, String description) {
            this.id = id;
            this.maxNumber = maxNumber;
            this.expected = expected;
            this.description = description;
        }

        public int getId() { return id; }
        public int getMaxNumber() { return maxNumber; }
        public List<Integer> getExpected() { return expected; }
        public String getDescription() { return description; }
    }

    public static void main(String[] args) {
        PrintOddEvenThreads solver = new PrintOddEvenThreads();

        List<Integer> expected10 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expected5 = List.of(1, 2, 3, 4, 5);

        TestCase[] testCases = new TestCase[]{
                new TestCase(1, 10, expected10, "Standard sequence up to 10"),
                new TestCase(2, 5, expected5, "Odd termination count at 5"),
                new TestCase(3, 1, List.of(1), "Single element sequence"),
                new TestCase(4, 0, List.of(), "Zero max number boundary check"),
                new TestCase(5, -5, List.of(), "Negative max number safety check")
        };

        System.out.println("================================================================================");
        System.out.println(" RUNNING CONCURRENT TEST SUITE: EXP-16 PRINT ODD & EVEN NUMBERS USING TWO THREADS");
        System.out.println("================================================================================");

        runApproach("1. Classical Synchronized Monitor Object (wait / notify)", solver::printOddEvenWaitNotify, testCases);
        runApproach("2. ReentrantLock with Condition Variables", solver::printOddEvenLockCondition, testCases);
        runApproach("3. AtomicBoolean / Volatile State Toggle", solver::printOddEvenAtomicFlag, testCases);
    }

    @FunctionalInterface
    interface OddEvenMethod {
        List<Integer> execute(int maxNumber);
    }

    /**
     * Executes test cases, verifies thread sequence ordering, and measures duration.
     */
    private static void runApproach(String name, OddEvenMethod method, TestCase[] testCases) {
        System.out.printf("\n--- Approach: %s ---\n", name);
        int passed = 0;
        long totalDurationNano = 0;

        for (TestCase tc : testCases) {
            long startTime = System.nanoTime();
            List<Integer> result = method.execute(tc.getMaxNumber());
            long durationNano = System.nanoTime() - startTime;

            totalDurationNano += durationNano;

            boolean isCorrect = Objects.equals(result, tc.getExpected());
            if (isCorrect) {
                passed++;
                System.out.printf("  [PASS] Test #%d (%s) | Execution Time: %.3f ms\n",
                        tc.getId(), tc.getDescription(), durationNano / 1_000_000.0);
            } else {
                System.out.printf("  [FAIL] Test #%d (%s)\n", tc.getId(), tc.getDescription());
                System.out.printf("         Expected: %s\n", tc.getExpected());
                System.out.printf("         Actual:   %s\n", result);
            }
        }

        System.out.printf("Summary: %d/%d Passed | Total Execution Time: %.3f ms\n",
                passed, testCases.length, totalDurationNano / 1_000_000.0);
    }
}