package com.sumit.ds.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * Given a singly linked list, determine if it is a palindrome.
 * @author sumijaiswal
 */
public class LeetCode234 {

	/**
	 * Steps:
	 * 1. Read the characters from the node and form the string. Meanwhile add each individual characters in stack
	 * 2. Pop the stack to form the reverse string from the characters
	 * 3. Compare the string and the reverse string. If both match, => its a palindrome
	 */
	public static boolean isPalindrome1(ListNode head) {
		boolean result = false;
		if(head == null || (head !=null && head.next == null)) return true;
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack();

			ListNode tmp = head;
			while(tmp != null){
				sb.append(tmp.val);
				stack.push((char)tmp.val);
				tmp = tmp.next;
			}
			char tmpArr[] = new char[sb.length()];
			int i =0;
			while(!stack.isEmpty()){
				tmpArr[i++] = stack.pop();
			}
			//result = (sb.toString().equals(sb1.toString()));

		return result;
	}

	public static void main(String[] args) {
		ListNode ln = new ListNode(0);
		ln.next = new ListNode(0);
		System.out.println(LeetCode234.isPalindrome1(ln));
	}
}

class ListNode {
 int val;
 ListNode next;
 ListNode(int x) { val = x; }
 }
