package com.sumit.test;

import org.w3c.dom.NodeList;

import java.util.Scanner;

public class ReverseLinkedList {
    /**
     * (I) 1 -> 2 -> null
     * (O) 2 -> 1 -> null
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while(cur != null){
            pre = cur;
            cur=next;
        }
        return pre;
    }

    public static void main(String[] args) {
        //List
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}