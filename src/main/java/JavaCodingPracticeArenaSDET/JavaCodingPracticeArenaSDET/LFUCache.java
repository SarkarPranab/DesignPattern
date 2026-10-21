package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * ============================================================================
 * PROBLEM EXP-41: LFU CACHE
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 *
 * Implement the `LFUCache` class:
 * - `LFUCache(int capacity)` Initializes the object with the `capacity` of the data structure.
 * - `int get(int key)` Gets the value of the `key` if the key exists in the cache, otherwise returns `-1`.
 * - `void put(int key, int value)` Update the value of the key if present, or insert the key if
 *   not already present. When the cache reaches its capacity, invalidate and remove the least
 *   frequently used key before inserting a new item. For ties (keys with the same frequency),
 *   the least recently used key is invalidated.
 *
 * The functions `get` and `put` must each run in $O(1)$ average time complexity.
 *
 * CONSTRAINTS:
 * - 0 <= capacity <= 10^4
 * - 0 <= key <= 10^5
 * - 0 <= value <= 10^9
 * - At most 2 * 10^5 calls will be made to `get` and `put`.
 * ============================================================================
 */
public class LFUCache {

    private final int capacity;
    private int minFreq;
    private final Map<Integer, Integer> valMap;
    private final Map<Integer, Integer> freqMap;
    private final Map<Integer, LinkedHashSet<Integer>> freqToListMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.valMap = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.freqToListMap = new HashMap<>();
    }

    /**
     * Get value by key in $O(1)$ time.
     */
    public int get(int key) {
        if (!valMap.containsKey(key)) {
            return -1;
        }
        incrementFrequency(key);
        return valMap.get(key);
    }

    /**
     * Put key-value pair in LFU cache in $O(1)$ time.
     */
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        if (valMap.containsKey(key)) {
            valMap.put(key, value);
            incrementFrequency(key);
            return;
        }

        if (valMap.size() >= capacity) {
            // Evict LFU item (and LRU among ties via LinkedHashSet iterator)
            LinkedHashSet<Integer> minFreqList = freqToListMap.get(minFreq);
            if (minFreqList != null && !minFreqList.isEmpty()) {
                int evictKey = minFreqList.iterator().next();
                minFreqList.remove(evictKey);
                valMap.remove(evictKey);
                freqMap.remove(evictKey);
            }
        }

        // Insert new key with frequency 1
        valMap.put(key, value);
        freqMap.put(key, 1);
        minFreq = 1;

        LinkedHashSet<Integer> freqList = freqToListMap.get(1);
        if (freqList == null) {
            freqList = new LinkedHashSet<>();
            freqToListMap.put(1, freqList);
        }
        freqList.add(key);
    }

    private void incrementFrequency(int key) {
        int freq = freqMap.get(key);
        freqMap.put(key, freq + 1);

        LinkedHashSet<Integer> oldList = freqToListMap.get(freq);
        oldList.remove(key);

        if (freq == minFreq && oldList.isEmpty()) {
            minFreq++;
        }

        LinkedHashSet<Integer> newList = freqToListMap.get(freq + 1);
        if (newList == null) {
            newList = new LinkedHashSet<>();
            freqToListMap.put(freq + 1, newList);
        }
        newList.add(key);
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-41 LFU CACHE");
        System.out.println("================================================================================");

        long startTime = System.nanoTime();

        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache={1=1}
        lfulPut(lfu, 2, 2);   // cache={1=1, 2=2}
        int v1 = lfu.get(1);     // return 1 (freq of 1 becomes 2)
        lfu.put(3, 3);   // evicts key 2 (freq 1), cache={1=1, 3=3}
        int v2 = lfu.get(2);     // returns -1 (not found)
        int v3 = lfu.get(3);     // return 3 (freq of 3 becomes 2)
        lfu.put(4, 4);   // evicts key 1 (tie-breaker: LRU between 1 and 3, key 1 evicted), cache={3=3, 4=4}
        int v4 = lfu.get(1);     // return -1 (not found)
        int v5 = lfu.get(3);     // return 3
        int v6 = lfu.get(4);     // return 4

        long durationNano = System.nanoTime() - startTime;

        boolean testPassed = (v1 == 1 && v2 == -1 && v3 == 3 && v4 == -1 && v5 == 3 && v6 == 4);

        if (testPassed) {
            System.out.printf("  [PASS] LFUCache Operations Test | Execution Time: %.3f ms\n", durationNano / 1_000_000.0);
            System.out.println("         Verified frequency counting, capacity eviction, and tie-breaking successfully.");
        } else {
            System.out.printf("  [FAIL] LFUCache Operations Test\n");
            System.out.printf("         Expected: v1=1, v2=-1, v3=3, v4=-1, v5=3, v6=4\n");
            System.out.printf("         Actual:   v1=%d, v2=%d, v3=%d, v4=%d, v5=%d, v6=%d\n", v1, v2, v3, v4, v5, v6);
        }

        System.out.println("Summary: Test completed.");
    }

    private static void lfulPut(LFUCache cache, int key, int val) {
        cache.put(key, val);
    }
}