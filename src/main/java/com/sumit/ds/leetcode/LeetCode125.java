package com.sumit.ds.leetcode;

/**
 * https://leetcode.com/problems/valid-palindrome/
 * @author sumijaiswal
 */
public class LeetCode125 {
	public static boolean isPalindrome1(String s) {
		if(s==null || s.length()==0) return true;
		int l=0, r=s.length()-1;
		while(l<r){
			if(!Character.isLetterOrDigit(s.charAt(l))){
				++l;
			}else if(!Character.isLetterOrDigit(s.charAt(r))){
				--r;
			}else if(Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r))){
				return false;
			}else{
				++l;
				--r;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(LeetCode125.isPalindrome1("  "));
	}
}