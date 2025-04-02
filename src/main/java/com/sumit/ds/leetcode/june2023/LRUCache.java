package com.sumit.ds.leetcode.june2023;

/*
 * Sift Online Coding Interview : 1st Round
 */

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Design and implement a Least Recently Used cache to reduce database queries to a Users table.
 * Support get and put methods
 */

class User {
    public int id;
    public String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Node implements Comparable<Node>{
    User user;
    long timestamp;

    public Node(User user){
        this.user = user;
        this.timestamp = System.currentTimeMillis();
    }

    public int compareTo(Node other){
        return Long.compare(this.timestamp,other.timestamp);
    }

    public User getUser(){
        return this.user;

    }
}


class LRUCache{
    Map<Integer, Node> cache ;
    PriorityQueue <Node> pq ;
    int capacity;

    public LRUCache(int capacity){
        this.pq= new PriorityQueue<>(capacity);
        this.cache = new HashMap<>();
        this.capacity = capacity;
    }
    /**
     -
     */
    public User get(int id){
        User user = null;
        if(cache.containsKey(id)){
            Node node = cache.get(id);
            pq.remove(node);
            node.timestamp = System.currentTimeMillis();
            pq.offer(node);
            user = node.getUser();
        }
        return user;
    }

    public void put(User user){
        System.out.println("PQ size :"+pq.size());
        //make space if cache is full
        if(pq.size() >= capacity){
            Node node = pq.poll(); //get the least recently used element
            System.out.println("Node for removal :"+node.user.name);

            cache.remove(node.user.id);
            System.out.println("cache size after removal :"+ cache.size());
        }
        Node node = new Node(user);
        pq.offer(node);
        cache.put(user.id, node);
        System.out.println("Final PQ size :"+pq.size());
        System.out.println("cache size after removal :"+ cache.size());
    }


}


class Solution {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        User user1 = new User(1,"Sumit");
        lruCache.put(user1);


        User user2 = new User(2,"Mark");
        lruCache.put(user2);

        System.out.println(lruCache.get(user1.id).name);
        System.out.println(lruCache.get(user2.id).name);


        User user3 = new User(3,"Amit");
        lruCache.put(user3);
        System.out.println(lruCache.get(user3.id).name);

        User user4 = new User(4,"Test");
        lruCache.put(user4);

        System.out.println(lruCache.get(user4.id).name);


        System.out.println(lruCache.get(user1.id));

    }
}