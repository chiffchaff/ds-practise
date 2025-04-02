package com.sumit.leetcode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curNode = result;
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = ( l1 != null)?l1.val:0;
            int y = (l2 != null)? l2.val:0;
            int sum = x + y + carry;
            carry = sum / 10;
            curNode.next = new ListNode(sum%10);
            curNode = curNode.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry >0){
            curNode.next = new ListNode(carry);
        }
        return result.next;
    }


    public ListNode addTwoNumbers(ListNode p, ListNode q) {
        ListNode head = new ListNode(0);

        ListNode current = head;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            //System.out.println("carry: " + carry);
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
