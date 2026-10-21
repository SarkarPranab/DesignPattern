package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ============================================================================
 * PROBLEM EXP-15: THREAD-SAFE SINGLETON
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Implement a Thread-Safe Singleton class in Java ensuring that only one
 * instance of the class is created across a multi-threaded application runtime.
 *
 * REQUIREMENT CHECKLIST:
 * 1. Private constructor to prevent direct instantiation.
 * 2. High-performance concurrent access without synchronization bottlenecks on read operations.
 * 3. Prevention against instruction reordering issues (memory visibility).
 * 4. Verification harness that spawns multiple concurrent threads attempting to
 *    fetch instances simultaneously.
 * ============================================================================
 */
public class ThreadSafeSingletonArena {

    // ========================================================================
    // APPROACH 1: LAZY DOUBLE-CHECKED LOCKING (VOLATILE + SYNCHRONIZED)
    // ========================================================================

    /**
     * Approach 1: Double-Checked Locking (DCL)
     *
     * @implNote Uses a volatile instance variable to prevent instruction reordering.
     *           First check avoids unnecessary locking overhead after instantiation;
     *           second check inside synchronized block ensures atomic initialization.
     * @targetTimeComplexity O(1)
     * @targetSpaceComplexity O(1)
     */
    public static class DoubleCheckedSingleton {
        private static volatile DoubleCheckedSingleton instance;

        private DoubleCheckedSingleton() {
            // Private constructor prevents instantiation
        }

        public static DoubleCheckedSingleton getInstance() {
            // TODO: Write solution here (Double-Checked Locking implementation)
            return null;
        }
    }

    // ========================================================================
    // APPROACH 2: BILL PUGH STATIC INNER HELPER CLASS (RECOMMENDED LAZY)
    // ========================================================================

    /**
     * Approach 2: Bill Pugh Singleton Implementation
     *
     * @implNote Leverages the Java Language Specification (JLS) class-loading mechanism.
     *           The inner static helper class `InstanceHolder` is loaded into memory only
     *           when `getInstance()` is called for the first time, providing lazy loading
     *           and thread-safety without explicit synchronization locks.
     * @targetTimeComplexity O(1)
     * @targetSpaceComplexity O(1)
     */
    public static class BillPughSingleton {

        private BillPughSingleton() {
            // Private constructor prevents instantiation
        }

        private static class InstanceHolder {
            private static final BillPughSingleton INSTANCE = new BillPughSingleton();
        }

        public static BillPughSingleton getInstance() {
            // TODO: Write solution here (Return BillPugh static instance holder)
            return null;
        }
    }

    // ========================================================================
    // APPROACH 3: ENUM SINGLETON (EFFECTIVE JAVA BEST PRACTICE)
    // ========================================================================

    /**
     * Approach 3: Enum Singleton
     *
     * @implNote As recommended by Joshua Bloch (Effective Java), Enum singletons provide
     *           implicit thread safety, guarantee lazy initialization handled by the JVM,
     *           and inherently protect against reflection and serialization attacks.
     * @targetTimeComplexity O(1)
     * @targetSpaceComplexity O(1)
     */
    public enum EnumSingleton {
        INSTANCE;

        public static EnumSingleton getInstance() {
            // TODO: Write solution here (Return Enum instance)
            return null;
        }
    }

    // ========================================================================
    // APPROACH 4: EAGER INITIALIZATION
    // ========================================================================

    /**
     * Approach 4: Eager Initialization
     *
     * @implNote Instance is created at class-loading time by the JVM. Inherently thread-safe,
     *           ideal for lightweight singletons that are guaranteed to be used.
     * @targetTimeComplexity O(1)
     * @targetSpaceComplexity O(1)
     */
    public static class EagerSingleton {
        private static final EagerSingleton INSTANCE = new EagerSingleton();

        private EagerSingleton() {
            // Private constructor prevents instantiation
        }

        public static EagerSingleton getInstance() {
            // TODO: Write solution here (Return static pre-allocated instance)
            return null;
        }
    }

    // ========================================================================
    // CONCURRENT MULTI-THREADED TEST HARNESS
    // ========================================================================

    public static void main(String[] args) throws InterruptedException {
        System.out.println("================================================================================");
        System.out.println(" RUNNING CONCURRENT TEST SUITE: EXP-15 THREAD-SAFE SINGLETON");
        System.out.println("================================================================================");

        int threadCount = 50;

        testConcurrentAccess("1. Double-Checked Locking Singleton", DoubleCheckedSingleton::getInstance, threadCount);
        testConcurrentAccess("2. Bill Pugh Static Inner Helper Class", BillPughSingleton::getInstance, threadCount);
        testConcurrentAccess("3. Enum Singleton (Effective Java Best Practice)", EnumSingleton::getInstance, threadCount);
        testConcurrentAccess("4. Eager Initialization Singleton", EagerSingleton::getInstance, threadCount);
    }

    /**
     * Spawns parallel threads simultaneously using `CountDownLatch` and verifies that
     * all threads receive the exact same reference identity (`System.identityHashCode`).
     */
    private static <T> void testConcurrentAccess(String approachName, InstanceSupplier<T> supplier, int threadCount) throws InterruptedException {
        System.out.printf("\n--- Approach: %s ---\n", approachName);

        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch finishLatch = new CountDownLatch(threadCount);

        List<T> instances = Collections.synchronizedList(new ArrayList<>());
        long startTime = System.nanoTime();

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                try {
                    startLatch.await(); // Wait for simultaneous release
                    T instance = supplier.get();
                    if (instance != null) {
                        instances.add(instance);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    finishLatch.countDown();
                }
            });
        }

        startLatch.countDown(); // Fire simultaneous thread execution
        boolean completed = finishLatch.await(5, TimeUnit.SECONDS);
        long durationNano = System.nanoTime() - startTime;
        executorService.shutdown();

        if (!completed) {
            System.out.println("  [FAIL] Test timed out waiting for threads.");
            return;
        }

        Set<Integer> uniqueIdentityHashCodes = new HashSet<>();
        for (T inst : instances) {
            uniqueIdentityHashCodes.add(System.identityHashCode(inst));
        }

        boolean passed = (instances.size() == threadCount) && (uniqueIdentityHashCodes.size() == 1);

        if (passed) {
            System.out.printf("  [PASS] Concurrent Threads: %d | Unique Instances Created: %d | Time: %.3f ms\n",
                    threadCount, uniqueIdentityHashCodes.size(), durationNano / 1_000_000.0);
            System.out.printf("         Shared Reference Identity Hash: %s\n", uniqueIdentityHashCodes.iterator().next());
        } else {
            System.out.printf("  [FAIL] Concurrent Threads: %d | Total Fetched: %d | Unique Instances: %d\n",
                    threadCount, instances.size(), uniqueIdentityHashCodes.size());
            System.out.println("         Violation: Multiple distinct instances created or null references returned under concurrency.");
        }
    }

    @FunctionalInterface
    interface InstanceSupplier<T> {
        T get();
    }
}