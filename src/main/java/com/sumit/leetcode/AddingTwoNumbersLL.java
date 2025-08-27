package com.sumit.leetcode;
//2
//
public class AddingTwoNumbersLL {
    public ListNode addTwoNumbers(ListNode p, ListNode q) {
        ListNode head=new ListNode(0);

        ListNode current=head;
        int carry=0;
        while(p!=null || q!=null){
            int x=(p!=null)? p.val:0;
            int y=(q!=null)? q.val:0;
            int sum=x+y+carry;
            carry=sum/10;
            //System.out.println("carry: " + carry);
            current.next=new ListNode(sum % 10);
            current=current.next;
            if(p!=null){
                p=p.next;
            }
            if(q!=null){
                q=q.next;
            }
        }
        if(carry>0){
            current.next=new ListNode(carry);
        }
        return head.next;
    }
}
