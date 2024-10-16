package com.sumit.ds.leetcode.may2023;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LRU Cache
 */
public class LeetCode146New {
    @Test
    public void testing(){
//        ["LRUCache","get","put","get","put","put","get","get"]
//        [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]

        LRUCache1 lr = new LRUCache1(2);
        System.out.println(lr.get(2));
        lr.put(2,6);
        System.out.println(lr.get(1));
        lr.put(1,5);
        lr.put(1,2);
        System.out.println(lr.get(1));
        System.out.println(lr.get(2));
    }
}

class Node1 implements Comparable<Node> {
    int key;
    int value;
    long timestamp;

    public Node1(int key,int value){
        this.key = key;
        this.value = value;
        this.timestamp = System.currentTimeMillis();
    }

    public int compareTo(Node other){
        return Long.compare(this.timestamp,other.timestamp);
    }
}
 class LRUCache1 {
    PriorityQueue<Node> pq;
    Map<Integer,Node> map;
    int capacity;
    public LRUCache1(int capacity) {
        this.pq = new PriorityQueue<>(capacity);
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        int value = -1;
        if(map.containsKey(key)){
            Node node = map.get(key);
            pq.remove(node);
            node.timestamp = System.currentTimeMillis();
            pq.offer(node);
            value = node.value;
        }
        return value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            pq.remove(node);
            map.remove(key);
        }
        if(map.size() >=capacity){
            Node node = pq.poll();
            map.remove(node.key);
        }
        Node newNode = new Node(key,value);
        pq.offer(newNode);
        map.put(key,newNode);
    }
}
