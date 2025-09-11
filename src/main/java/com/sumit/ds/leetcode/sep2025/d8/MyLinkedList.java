package com.sumit.ds.leetcode.sep2025.d8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MyLinkedList {
    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node newNode = new Node(val);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }


    public static Integer[] runTest(String[] operations, int[][] arguments) {
        MyLinkedList list = null;
        Integer[] results = new Integer[operations.length];

        for (int i = 0; i < operations.length; i++) {
            String operation = operations[i];
            int[] args = arguments[i];

            switch (operation) {
                case "MyLinkedList":
                    list = new MyLinkedList();
                    results[i] = null;
                    break;
                case "addAtHead":
                    list.addAtHead(args[0]);
                    results[i] = null;
                    break;
                case "addAtTail":
                    list.addAtTail(args[0]);
                    results[i] = null;
                    break;
                case "addAtIndex":
                    list.addAtIndex(args[0], args[1]);
                    results[i] = null;
                    break;
                case "get":
                    results[i] = list.get(args[0]);
                    break;
                case "deleteAtIndex":
                    list.deleteAtIndex(args[0]);
                    results[i] = null;
                    break;
                default:
                    results[i] = null;
                    break;
            }
        }

        return results;
    }


    @Test
    public void testing3() {
        String[] operations = {"MyLinkedList", "addAtHead", "get", "addAtHead", "addAtHead", "deleteAtIndex", "addAtHead", "get", "get", "get", "addAtHead", "deleteAtIndex"};
        int[][] arguments = {{}, {4}, {1}, {1}, {5}, {3}, {7}, {3}, {3}, {3}, {1}, {4}};
        Integer[] expected = new Integer[]{null, null, -1, null, null, null, null, 4, 4, 4, null, null};
        Integer[] results = runTest(operations, arguments);
        System.out.println(Arrays.toString(results));
        Assert.assertArrayEquals(expected, results);
    }

    @Test
    public void testing() {
        String[] operations = {"MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"};
        int[][] arguments = {{}, {1}, {3}, {1, 2}, {1}, {1}, {1}};
        Integer[] expected = new Integer[]{null, null, null, null, 2, null, 3};
        Integer[] results = runTest(operations, arguments);
        System.out.println(Arrays.toString(results));
        Assert.assertArrayEquals(expected, results);
    }

    /**
     * ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
     * [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
     */
    @Test
    public void testing1() {
        String[] operations = {"MyLinkedList", "addAtHead", "addAtHead", "addAtHead", "addAtIndex", "deleteAtIndex", "addAtHead", "addAtTail", "get", "addAtHead", "addAtIndex", "addAtHead"};
        int[][] arguments = {{}, {7}, {2}, {1}, {3, 0}, {2}, {6}, {4}, {4}, {4}, {5, 0}, {6}};
        Integer[] expected = new Integer[]{null, null, null, null, null, null, null, null, 4, null, null, null};
        Integer[] results = runTest(operations, arguments);
        System.out.println(Arrays.toString(results));
        Assert.assertArrayEquals(expected, results);
    }

    /**
     * ["MyLinkedList","deleteAtIndex"]
     * [[],[0]]
     */
    @Test
    public void testing2() {
        String[] operations = {"MyLinkedList", "deleteAtIndex"};
        int[][] arguments = {{}, {0}};
        Integer[] expected = new Integer[]{null, null};
        Integer[] results = runTest(operations, arguments);
        System.out.println(Arrays.toString(results));
        Assert.assertArrayEquals(expected, results);
    }

    /**
     * ["MyLinkedList","addAtHead","deleteAtIndex"]
     * [[],[1],[0]]
     */
    @Test
    public void testing4() {
        String[] operations = {"MyLinkedList", "addAtHead", "deleteAtIndex"};
        int[][] arguments = {{}, {1}, {0}};
        Integer[] expected = new Integer[]{null, null, null};
        Integer[] results = runTest(operations, arguments);
        System.out.println(Arrays.toString(results));
        Assert.assertArrayEquals(expected, results);
    }
}