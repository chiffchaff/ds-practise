package com.sumit.ds.recursion.practise;

public class PrintForLoop {
	public void printNIntegers(int n){
		if(n == 0)
			return;
		System.out.println("a="+n);
		printNIntegers(n - 1);
		System.out.println("b="+n);
	}
	
	public static void main(String[] args) {
		PrintForLoop pl = new PrintForLoop();
		pl.printNIntegers(1);
	}
}
