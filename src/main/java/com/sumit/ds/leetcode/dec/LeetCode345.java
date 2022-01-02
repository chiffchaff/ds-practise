package com.sumit.ds.leetcode.dec;

import java.util.Arrays;
import java.util.List;

/**
 * Reverse Vowels of a String
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 * @author sumijaiswal
 *
 */
public class LeetCode345 {
	public static String reverseVowels(String s) {
		String returnString = null;
		if (s != null && s.length() > 1) {
			char[] sarr = s.toCharArray();
			int tempIndex = 0;
			char vowelFound = ' ';
			List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
			for (int i = sarr.length - 1; i >= 0; i--) {
				if (vowels.contains(sarr[i])) {
					if (vowelFound == ' ') {
						vowelFound = sarr[i];
						tempIndex = i;
					} else {
						char temp = sarr[i];
						// tempIndex = i;
						sarr[i] = vowelFound;
						vowelFound = temp;
					}
				}
			}
			if (vowelFound != ' ')
				sarr[tempIndex] = vowelFound;
			returnString = new String(sarr);
		} else
			returnString = s;

		return returnString;
	}

	public static String reverseVowels2(String s) {
		String returnStr = null;
		if(s != null && s.length() > 1){
			List<Character> vowels = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
			int start = 0;
			int end = s.length() -1;
			char [] input = s.toCharArray();
			while(start < end){
				while(start < end && !vowels.contains(input[start])){
					start++;
				}
				while(start < end && !vowels.contains(input[end])){
					end--;
				}
				swap(input,start,end);
				start++;
				end--;
			}
			returnStr = new String(input);
			
		}else{
			returnStr = s;
		}
			
		
		return returnStr;
	}

	

	private static void swap(char[] input, int start, int end) {
		char tmp = input[start];
		input[start] = input[end];
		input[end] = tmp;
		
	}

	public static String reverseVowels1(String s) {
		if (s == null || s.length() == 0)
			return s;
		String vowels = "aeiouAEIOU";
		char[] chars = s.toCharArray();
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {

			while (start < end && !vowels.contains(chars[start] + "")) {
				start++;
			}

			while (start < end && !vowels.contains(chars[end] + "")) {
				end--;
			}

			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;

			start++;
			end--;
		}
		return new String(chars);
	}

	public static void main(String[] args) {
		System.out.println(LeetCode345.reverseVowels1("helo let"));
		System.out.println(LeetCode345.reverseVowels1("race car"));
		System.out.println(LeetCode345.reverseVowels2("race car"));

	}
}
