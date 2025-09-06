package com.sumit.ds.leetcode.sep2025.d4;

import org.junit.Test;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/design-hashset/description/
 */
public class MyHashSet {
    int size = 1003;//Choose prime number
    LinkedList<Integer> [] myset = null;

    public MyHashSet() {
        myset = new LinkedList[size];
    }

    public void add(int key) {
        int index = key % size;
        if(myset[index] == null)
            myset[index] = new LinkedList<>();
        if(!contains(key)){
            myset[index].add(Integer.valueOf(key)); // Ensure we pass Integer object to add function
        }
    }

    public void remove(int key) {
        int index = key % size;
        if(contains(key)){
            myset[index].remove(Integer.valueOf(key)); //Ensure we pass Integer object to remove function
        }
    }

    public boolean contains(int key) {
        int index = key % size;
        return myset[index]!=null?myset[index].contains(key):false;
    }

    @Test
    public void testing(){
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2));
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));
    }
}
