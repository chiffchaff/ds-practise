package com.sumit.test;
/**
 * Given a non-negative integer num, 
 * repeatedly add all its digits until the result has only one digit.
	1+2+7+9 = 19
	1+9 = 10
	1+0 = 1
 * @author sumijaiswal
 *
 */
public class DigitSum {
	
	public static int sum(int num){
		if((num / 10) == 0)
			return num;
		String strNum = Integer.toString(num);
		int total = 0;
		for(int i=0;i<strNum.length();i++){
			/**
			 * ::::::::IMPORTANT:::::
			 * total +=strNum.charAt(i); 
			 * will give incorrect result. As charAt(i) returns ASCII code of the numeric character.
			 * Ex: character 1 in Ascii = 49
			 * => total = total + strNum.charAt(0) = 0 + 49 = 49
			 * instead of total = total + 1 = 1;
			 */
			total += Character.getNumericValue(strNum.charAt(i));
		}
		return sum(total);
	}
	
	public static void main(String[] args) {
		System.out.println(sum(1279));
	}
}
