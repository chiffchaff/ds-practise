package com.sumit.ds.leetcode.dec;

/**
 * https://leetcode.com/problems/reverse-string/
 * @author sumijaiswal
 *
 */
public class LeetCode344 {
	public static String reverseString(String s) {
        //String reverse = "";
        StringBuilder sb = new StringBuilder();
        if(s!=null){
            for(int i=s.length()-1;i>=0;i--){
                //reverse= reverse+s.charAt(i);
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(LeetCode344.reverseString("hello"));
	}
}