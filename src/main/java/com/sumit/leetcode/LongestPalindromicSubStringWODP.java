package com.sumit.leetcode;

import org.junit.Test;
import org.testng.Assert;

public class LongestPalindromicSubStringWODP {
    public String longestPalindrome(String s) {
        int minSI=0;
        int maxEI=0;
        for(int i=0;i<s.length();i++){
            int si = i;
            int ei = i;
            while (si >=0 && ei < s.length()){
                if(s.charAt(si) == s.charAt(ei)){
                    System.out.println("Substring found :"+s.substring(si,ei+1));
                    if((maxEI-minSI) < (ei-si)){
                        minSI = si;
                        maxEI = ei;
                    }
                    si--;
                    ei++;
                }
                else{
                    break;
                }
            }
            si=i;
            if(si>0){
                ei = si;
                si = si-1;
                while (si >=0 && ei < s.length()){
                    if(s.charAt(si) == s.charAt(ei)){
                        System.out.println("Substring found :"+s.substring(si,ei+1));
                        if((maxEI-minSI) < (ei-si)){
                            minSI = si;
                            maxEI = ei;
                        }
                        si--;
                        ei++;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return s.substring(minSI,maxEI+1);
    }

    @Test
    public void testing(){
        Assert.assertEquals(longestPalindrome("aa"),"aa");
        Assert.assertEquals(longestPalindrome("aba"),"aba");
        Assert.assertEquals(longestPalindrome("abba"),"abba");
        Assert.assertEquals(longestPalindrome("abcba"),"abcba");
        Assert.assertEquals(longestPalindrome("abbadab"),"badab");
    }
}
