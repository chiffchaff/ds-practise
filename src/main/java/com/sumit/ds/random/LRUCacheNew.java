package com.sumit.ds.random;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCacheNew {

    private final Map<String, Node> cache;
    private final PriorityQueue<Node> minHeap;
    private final int capacity;

    public LRUCacheNew(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.minHeap = new PriorityQueue<>(capacity);
    }

    public String get(String key) {
        Node node = cache.get(key);
        if (node == null || node.timestamp > System.currentTimeMillis()) {
            return null;
        }
        return node.value;
    }

    public void put(String key, String value) {
        long timestamp = System.currentTimeMillis();
        Node node = new Node(key, value, timestamp);

        // Check if the key is already present in the cache
        if (cache.containsKey(key)) {
            Node existingNode = cache.get(key);
            if (existingNode.timestamp > timestamp) {
                return;
            }
            minHeap.remove(existingNode);
            cache.remove(key);
        }

        // If the cache is full, remove the least recently used node
        if (cache.size() == capacity) {
            Node lruNode = minHeap.poll();
            cache.remove(lruNode.key);
        }

        // Add the new node to the cache and the min heap
        cache.put(key, node);
        minHeap.offer(node);
    }

    private static class Node implements Comparable<Node> {
        String key;
        String value;
        long timestamp;

        Node(String key, String value, long timestamp) {
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.timestamp, other.timestamp);
        }
    }

}
