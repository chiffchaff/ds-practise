package com.sumit.techdose.assignments.linkedlist;

import org.junit.Test;

import java.util.PriorityQueue;

public class MergeKSortedList1 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode resultHead = new ListNode();
        ListNode temp = resultHead;
        //Create a min heap of size K and push each of the head elements of list
        //and pop top of the heap and move the head of the linked list to next element
        PriorityQueue<ListNodeIndex> priorityQueue = new PriorityQueue<>((a,b)->(a.listNode.val-b.listNode.val));
        //initialize min heap with first K header List nodes
        int emptyCount=0;
        for(int i=0;i<lists.length;i++){
            if(lists[i] != null){
                priorityQueue.add(new ListNodeIndex(lists[i],i));
            }
            else{
                ++emptyCount;
            }
        }
        
        
        while(emptyCount<lists.length){
            if(!priorityQueue.isEmpty()){
                ListNodeIndex tempListNode = priorityQueue.poll();
                temp.next = new ListNode(tempListNode.listNode.val,null);
                temp=temp.next;
                lists[tempListNode.index] =lists[tempListNode.index].next;
                if(lists[tempListNode.index]!=null){
                    priorityQueue.add(new ListNodeIndex(lists[tempListNode.index],tempListNode.index));
                }
                else{
                    ++emptyCount;
                }
            }
        }
        return resultHead.next;
    }

    @Test
    public void testing(){
        //[[1,4,5],[1,3,4],[2,6]]
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1,new ListNode(4,new ListNode(5)));
        lists[1] = new ListNode(1,new ListNode(3,new ListNode(4)));
        lists[2] = new ListNode(2,new ListNode(6));

        ListNode result = mergeKLists(lists);
        System.out.println("Output");
        while(result!=null){
            System.out.print(result.val+"->");
            result=result.next;
        }
        System.out.print("null");

    }
}

class ListNodeIndex{
    ListNode listNode;
    int index;
    ListNodeIndex(ListNode listNode, int index){
        this.index = index;
        this.listNode = listNode;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
