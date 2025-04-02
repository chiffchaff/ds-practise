package com.sumit.leetcode;

import org.junit.Test;

public class ReverseInt {

    public int reverse1(int x) {
        int reversed = 0;
        int pop = 0;
        while(x != 0){
            pop = x%10; //Extract last digit
            x = x/10; //Remove last digit

            if(reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE/10 && pop > 7 ) || (reversed < Integer.MIN_VALUE/10) ||(reversed == Integer.MIN_VALUE/10 && pop < -8)){
                return 0;
            }
            reversed = reversed * 10 + pop;
        }
        return reversed;
    }

    public int reverse(int x) {
        int reversed = 0;  // Store the reversed integer
        int pop;           // Temporary variable for the last digit

        while (x != 0) {
            pop = x % 10; // Extract the last digit
            x /= 10;      // Remove the last digit from x

            // Overflow/Underflow check
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7))
                return 0; // Overflow
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && pop < -8))
                return 0; // Underflow

            reversed = reversed * 10 + pop; // Update reversed number
        }

        return reversed; // Return the reversed number
    }
    @Test
    public void testing(){
        int input = -123;
        System.out.println(reverse(input));
        System.out.println(reverse1(input));
    }
}