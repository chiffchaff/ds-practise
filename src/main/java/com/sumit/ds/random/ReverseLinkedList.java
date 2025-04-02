package com.sumit.ds.random;

public class ReverseLinkedList {


    public static void printListNode(ListNode node){
        System.out.println("Printing List Node Elements");
        System.out.print("\t");
        while(node != null){
            System.out.print(node.value+" -> ");
            node = node.next;
        }
        System.out.println("NULL");
        System.out.println("-- END ---");
    }

    /**
     * ReverseLinkedList using recursion
     * Recursion uses extra stack space,
     * Use Iterative approach for more memory-efficiency
     *
     * @param node
     * @return
     */
    public static ListNode reverseListUsingRecursion(ListNode node){
        if(node == null || node.next == null)
            return node;
        ListNode head = reverseListUsingRecursion(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }

    public static ListNode reverseListUsingIteration(ListNode node){
        ListNode current = node;
        ListNode prev = null;

        while(current != null){
            ListNode tempNext = current.next;
            current.next = prev;
            prev = current;
            current = tempNext;
        }
        return prev;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode listNode = head;

        listNode.next = new ListNode(2);
        listNode = listNode.next;

        listNode.next = new ListNode(3);
        listNode = listNode.next;

        listNode.next = new ListNode(4);
        listNode = listNode.next;

        printListNode(head);

        ListNode temp = cloneLL(head);
        printListNode(temp);

        ListNode reversedHead = reverseListUsingRecursion(temp);
        System.out.println("--- Reversed List using Recursion --- ");
        printListNode(reversedHead);

        reversedHead = reverseListUsingIteration(head);
        System.out.println("--- Reversed List using Iteration--- ");
        printListNode(reversedHead);


    }

    private static ListNode cloneLL(ListNode node) {
        ListNode head = new ListNode(-1); // dummy
        ListNode temp = head;
        while(node != null){
            temp.next = new ListNode(node.value);
            temp = temp.next;
            node=node.next;
        }
        return head.next;
    }
}

class ListNode{
    ListNode next=null;
    int value;
    public ListNode(int value){
        this.value=value;
    }
}
