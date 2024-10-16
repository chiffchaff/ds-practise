package com.sumit.ds.leetcode.apr2023;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

/**
 * 3. Longest Substring Without Repeating Characters
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        int maxCount = 0;
        int count =0;
        List<Character> chList = new ArrayList<>();
        List<List<Character>> allUniqueChars = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(!chList.contains(s.charAt(i))){
                chList.add(s.charAt(i));
                count++;
            }
            else{
                maxCount = Math.max(count,maxCount);
                allUniqueChars.add(new ArrayList<>(chList));
                do{

                }while(s.charAt(i) != chList.remove(0));
                chList.add(s.charAt(i));
                count=chList.size();
            }
        }
        allUniqueChars.add(new ArrayList<>(chList));
        System.out.println("Input: "+s+ " :SubString with unique Chars:"+allUniqueChars);
        return Math.max(count,maxCount);
    }

    @ParameterizedTest
//    @CsvSource({"abcabcbb","bbbbb","ewkewek","pwwkew","pwwkewlen"})
    @CsvSource({"qrsvbspk"})
    public void testThis(String s){
        System.out.println("input:"+s +" :len:"+lengthOfLongestSubstring(s));
    }
}
