package com.sumit.leetcode;

import org.junit.Test;

public class LongestPalindromicSubString {
    public String longestPalindrome(String s) {
        int n = s.length();
        int [][] dp = new int[n][n];
        int pStart=0;
        int pEnd=0;
        //fill the diagonal and two character combination first
        for(int i=0;i<n;i++){
            dp[i][i]=1;
            if(i>0 && s.charAt(i-1) == s.charAt(i)){
                dp[i-1][i]=1;
                pStart=i-1; pEnd=i;
            }
        }

        for(int i=2;i<n;i++){
            for(int j=0;j<n-i;j++){
                int x=j; int y=j+i;
                if(s.charAt(x) == s.charAt(y) && dp[x+1][y-1] == 1){
                    dp[x][y]=1;
                    if((y-x) > (pEnd-pStart)){
                        pStart=x;
                        pEnd=y;
                    }
                }
            }
        }
        return s.substring(pStart,pEnd+1);
    }

    @Test
    public void testing(){
        String input ="babad";
        input="cbbd";
//        input="aaaaa";
        System.out.println(longestPalindrome(input));

    }

    @Test
    public void testing1(){
        System.out.println("Printing all the pairs ---");
        int n=5;
        for(int i=2;i<n;i++){
            System.out.println();
            System.out.print("(i,j)::");
            for(int j=0;j<n-i+1;j++){
                System.out.print("("+j+","+(j+i)+") :");
            }
        }
    }
}
