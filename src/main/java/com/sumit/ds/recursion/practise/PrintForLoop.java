package com.sumit.ds.recursion.practise;

/**
 * Apply recursion for printing numbers in sequencial order
 */
public class PrintForLoop {
	/**
	 * Print Numbers in ascending order and then descending order
	 * @param n
	 */
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
