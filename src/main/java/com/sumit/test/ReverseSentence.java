package com.sumit.test;

public class ReverseSentence {
	
	public static void main(String[] args) {
		String input = "This is simple";
		String arr[] = input.split(" ");
		for(int a=arr.length-1;a>=0;a--){
			System.out.print(arr[a]+" ");
		}
	}
}
