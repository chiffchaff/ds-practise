package com.sumit.ds.random;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final Map<String, Node> cache;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
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
            cache.remove(key);
        }

        // If the cache is full, remove the least recently used node
        if (cache.size() == capacity) {
            cache.remove(getLRUKey());
        }

        // Add the new node to the cache
        cache.put(key, node);
    }

    private String getLRUKey() {
        String lruKey = null;
        long oldestTimestamp = Long.MAX_VALUE;

        for (Map.Entry<String, Node> entry : cache.entrySet()) {
            Node node = entry.getValue();
            if (node.timestamp < oldestTimestamp) {
                oldestTimestamp = node.timestamp;
                lruKey = entry.getKey();
            }
        }

        return lruKey;
    }

    private static class Node {
        String key;
        String value;
        long timestamp;

        Node(String key, String value, long timestamp) {
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
        }
    }

}
