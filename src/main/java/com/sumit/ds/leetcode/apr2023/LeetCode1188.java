package com.sumit.ds.leetcode.apr2023;

/**
 * 1188. Design Bounded Blocking Queue
 */
public class LeetCode1188 {

    private int[] queue;
    private int capacity;
    private int size;
    private int front;
    private int rear;

    public LeetCode1188(int capacity) {
        this.queue = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    public synchronized void enqueue(int element) throws InterruptedException {
        while (this.size == this.capacity) {
            wait();
        }
        this.rear = (this.rear + 1) % this.capacity;
        this.queue[this.rear] = element;
        this.size++;
        notifyAll();
    }

    public synchronized int dequeue() throws InterruptedException {
        while (this.size == 0) {
            wait();
        }
        int element = this.queue[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        notifyAll();
        return element;
    }

    public synchronized int size() {
        return this.size;
    }


}
