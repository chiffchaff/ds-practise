package com.sumit.techdose.assignments.mathalgo;

import org.junit.Test;

/**
 * https://leetcode.com/problems/prime-palindrome/description/
 */
public class PrimePalindrome {

    @Test
    public void testing(){
        int n =31;
        int result = findPrimePalindrome(n);
        System.out.println("First Prime Palindrome greater than or equal to "+n+" is:"+result);

    }

    private boolean isPrime(int n){
        boolean result = true;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                result=false;
                break;
            }
        }
        return result;
    }

    private int findPrimePalindrome(int n) {
        int num = 3;
        while(true){
            if(isPalindrome(num) && isPrime(num)){
                return num;
            }
            num++;
        }
    }

    private boolean isPalindrome(int num) {
        String str = Integer.toString(num);
        int len = str.length();
        if(len<=1)
                return false;
        for(int i=0;i<len/2;i++){
            if(str.charAt(i) != str.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }
}
