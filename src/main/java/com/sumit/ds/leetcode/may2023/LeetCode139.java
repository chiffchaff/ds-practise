package com.sumit.ds.leetcode.may2023;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> set = new HashSet<>();
        for(String ss : wordDict)
            set.add(ss.length());
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i = 0; i < len; i++){
            for(Integer l : set){
                if(i + l <= s.length())
                    if(wordDict.contains(s.substring(i, i + l))) dp[i + l] |= dp[i];
            }
        }
        return dp[s.length()];
    }

    @Test
    public void testing(){
        {
            String input = "leetcode";
            String[] dict = {"leet", "code"};
            System.out.println(wordBreak(input, Arrays.asList(dict)));
        }
        {
            String input = "applepenapple";
            String[] dict = {"applepenapple", "pen"};
            System.out.println(wordBreak(input, Arrays.asList(dict)));
        }
        {
            String input = "catsandog";
            String[] dict = {"cats", "dog", "sand", "and", "cat"};
            System.out.println(wordBreak(input, Arrays.asList(dict)));
        }

    }
}
