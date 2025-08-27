package com.sumit.ds.leetcode.aug2025;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/description/?envType=company&envId=intuit&favoriteSlug=intuit-six-months
 */
public class CharFrequencyUnique {
    public int minDeletions(String s) {
        Map<Character,Integer> cf = new HashMap<>();
        for(char ch:s.toCharArray()){
            cf.put(ch,cf.getOrDefault(ch,0)+1);
        }
        int result =0;
        Set<Integer> unique = new HashSet<>();
        for(int freq:cf.values()){
            while(freq >0 && unique.contains(freq)){
                freq--;
                result++;
            }
            unique.add(freq);
        }
        return result;
    }

    @Test
    public void testing(){
        CharFrequencyUnique cu = new CharFrequencyUnique();
        Assert.assertEquals(1,cu.minDeletions("aabb"));
        Assert.assertEquals(0,cu.minDeletions("aab"));
        Assert.assertEquals(2,cu.minDeletions("aaabbbcc"));
        Assert.assertEquals(2,cu.minDeletions("ceabaacb"));
    }
}
