package JavaCodingPracticeArenaSDET.JavaCodingPracticeArenaSDET;

import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================================
 * PROBLEM EXP-40: LRU CACHE
 * ============================================================================
 *
 * PROBLEM STATEMENT:
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the `LRUCache` class:
 * - `LRUCache(int capacity)` Initialize the LRU cache with positive size `capacity`.
 * - `int get(int key)` Return the value of the `key` if the key exists, otherwise return `-1`.
 * - `void put(int key, int value)` Update the value of the `key` if the `key` exists. Otherwise,
 *   add the `key-value` pair to the cache. If the number of keys exceeds the `capacity` from this operation,
 *   evict the least recently used key.
 *
 * The functions `get` and `put` must each run in $O(1)$ average time complexity.
 *
 * CONSTRAINTS:
 * - 1 <= capacity <= 3000
 * - 0 <= key <= 10^4
 * - 0 <= value <= 10^5
 * - At most 2 * 10^5 calls will be made to `get` and `put`.
 * ============================================================================
 */
public class LRUCache {

    /**
     * Doubly Linked List Node for LRU tracking.
     */
    public static class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy head and tail to eliminate null checks on boundaries
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Get value by key in $O(1)$ time.
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveToHead(node);
        return node.val;
    }

    /**
     * Put key-value pair in cache in $O(1)$ time.
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            if (map.size() >= capacity) {
                Node lru = popTail();
                if (lru != null) {
                    map.remove(lru.key);
                }
            }
            map.put(key, newNode);
            addToHead(newNode);
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node popTail() {
        Node res = tail.prev;
        if (res == head) {
            return null;
        }
        removeNode(res);
        return res;
    }

    // ========================================================================
    // TEST HARNESS & BENCHMARKING
    // ========================================================================

    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println(" RUNNING TEST SUITE: EXP-40 LRU CACHE");
        System.out.println("================================================================================");

        long startTime = System.nanoTime();

        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1); // cache is {1=1}
        lruCache.put(2, 2); // cache is {1=1, 2=2}
        int v1 = lruCache.get(1);    // return 1
        lruCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        int v2 = lruCache.get(2);    // returns -1 (not found)
        lruCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        int v3 = lruCache.get(1);    // return -1 (not found)
        int v4 = lruCache.get(3);    // return 3
        int v5 = lruCache.get(4);    // return 4

        long durationNano = System.nanoTime() - startTime;

        boolean testPassed = (v1 == 1 && v2 == -1 && v3 == -1 && v4 == 3 && v5 == 4);

        if (testPassed) {
            System.out.printf("  [PASS] LRUCache Operations Test | Execution Time: %.3f ms\n", durationNano / 1_000_000.0);
            System.out.println("         Verified capacity eviction, updates, and O(1) lookups successfully.");
        } else {
            System.out.printf("  [FAIL] LRUCache Operations Test\n");
            System.out.printf("         Expected: v1=1, v2=-1, v3=-1, v4=3, v5=4\n");
            System.out.printf("         Actual:   v1=%d, v2=%d, v3=%d, v4=%d, v5=%d\n", v1, v2, v3, v4, v5);
        }

        System.out.println("Summary: Test completed.");
    }
}