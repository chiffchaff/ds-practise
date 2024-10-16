package com.sumit.ds.leetcode.may2023;

import java.util.HashMap;
import java.util.Map;

/**
 * 1010. Pairs of Songs With Total Durations Divisible by 60
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 */
public class LeetCode1010 {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer,Integer> map = new HashMap<>();
        //Get mod frequency map
        for(int i=0;i<time.length;i++){
            int mod = time[i]%60;
            map.put(mod,map.getOrDefault(mod,0)+1);
        }

        return 0;
    }
}
