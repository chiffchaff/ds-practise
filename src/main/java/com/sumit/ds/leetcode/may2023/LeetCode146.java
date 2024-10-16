package com.sumit.ds.leetcode.may2023;

import java.util.*;

/**
 * LRU Cache
 * https://leetcode.com/problems/lru-cache/
 */
public class LeetCode146 {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);result.add("null");
        lruCache.put(2,2);result.add("null");
        result.add(String.valueOf(lruCache.get(1)));
        lruCache.put(3,3);result.add("null");
        result.add(String.valueOf(lruCache.get(2)));
        lruCache.put(4,4);result.add("null");
        result.add(String.valueOf(lruCache.get(1)));
        result.add(String.valueOf(lruCache.get(3)));
        result.add(String.valueOf(lruCache.get(4)));

        System.out.println(result);
    }
}

class Node implements Comparable<Node>{
    int key;
    int value;
    long timestamp;
    public Node(int key,int value){
        this.key = key;
        this.value = value;
        this.timestamp = System.currentTimeMillis();
    }

    public int compareTo(Node other){
        return Long.compare(this.timestamp,other.timestamp);
    }
}
class LRUCache {
    Map<Integer,Node> cache ;
    PriorityQueue<Node> minHeap ;
    int capacity;
    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        minHeap = new PriorityQueue<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        int result = -1;
        if(cache.containsKey(key)){
            Node currNode = cache.get(key);
            minHeap.remove(currNode);
            currNode.timestamp = System.currentTimeMillis();
            result = currNode.value;
        }
        return result;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node currNode = cache.get(key);
            minHeap.remove(currNode);
        }

        if(cache.size() < capacity){
            Node removeNode = minHeap.poll();
            cache.remove(removeNode);
        }

        Node newNode = new Node(key,value);
        minHeap.offer(newNode);
        cache.put(key,newNode);
    }
}