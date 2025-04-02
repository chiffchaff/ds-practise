package com.sumit.techdose.assignments.hashmap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//Leetcode 3
public class SubStringNonRepeating {

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> charMap = new HashMap<>();
        int startp = 0;
        int endp =0;
        int maxLength = 0;
        int tempLength = 0;
        for(int i=0;i<s.length();i++){
            endp=i;
            char ch = s.charAt(i);
            if(charMap.containsKey(ch) && charMap.get(ch) >=startp){
                startp = charMap.get(ch);
                tempLength = endp - startp;
                maxLength = Math.max(tempLength,maxLength);
                startp = startp+1;
            }
            else
                tempLength = endp - startp+1;
            charMap.put(ch,endp);
        }
        maxLength = Math.max(tempLength,maxLength);
        return maxLength;
    }

    @Test
    public void teesting(){
        String input = "abcabcbb";
        int maxlength = lengthOfLongestSubstring(input);
        System.out.println(maxlength);
    }
}
