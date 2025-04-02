package com.sumit.techdose.assignments.heap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//Leetcode 23
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        ListNode current = result;

        List<PriorityQueue<Integer>> priorityQueueList = new ArrayList<>();
        if(lists != null) {
            // Step1 : Build min heap for all the list of nodes
            for (ListNode ln : lists) {
                if (ln != null) {
                    PriorityQueue<Integer> priorityQueue = buildPriorityQueue(ln);
                    priorityQueueList.add(priorityQueue);
                }
            }
            //Step 2: Find min element amongst the priority queue list
            PriorityQueue<Integer> minPQ = null;
            while (!priorityQueueList.isEmpty()) {
                for (PriorityQueue pq : priorityQueueList) {
                    if (minPQ != null && !minPQ.isEmpty() && !pq.isEmpty()) {
                        if ((Integer) pq.peek() < minPQ.peek()) {
                            minPQ = pq;
                        }
                    } else
                        minPQ = pq;
                }
                current = addListNode(minPQ.poll(), current);
                if (minPQ.isEmpty()) {
                    priorityQueueList.remove(minPQ);
                }
            }
        }
        return result.next;
    }

    private ListNode addListNode(Integer value,ListNode node) {
            node.next = new ListNode(value);

        return node.next;
    }

    private PriorityQueue<Integer> buildPriorityQueue(ListNode ln) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(a-b));
        while(ln != null){
            pq.add(ln.val);
            ln=ln.next;
        }
        return pq;
    }

    @Test
    public void testing(){
        int [][] input = {{1,4,5},{1,3,4},{2,6}};
        ListNode[] listNodes = new ListNode[input.length];
        for(int i =0;i<input.length;i++){
            ListNode ln = buildListNode(input[i]);
            listNodes[i]=ln;
        }

        mergeKLists(listNodes);

    }

    private ListNode buildListNode(int[] ints) {
        ListNode head = new ListNode();
        ListNode curr = head;
        if(ints != null){
            for(int i=0;i<ints.length;i++){
                curr.next = new ListNode(ints[i]);
                curr = curr.next;
            }
        }
        return head.next;
    }


}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }