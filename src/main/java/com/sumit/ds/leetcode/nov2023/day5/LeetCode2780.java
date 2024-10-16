package com.sumit.ds.leetcode.nov2023.day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode2780 {

    public int minimumIndex(List<Integer> nums) {
        //Store frequency of each integer in hashmap
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 0); //Initialization of hashmap for easy computation of integer with max frequency
        int max = 0, m = nums.size(); //keep track of integer with max frequency

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);

            if (map.get(n) > map.get(max))
                max = n;
        }
        //Iterate over the list of integers again and find out if the integer with max frequency satisfies the dominant split criteria
        int freq = 0;
        for (int i=0; i<m; i++) {
            if (nums.get(i) == max) {
                freq++;

                if (freq * 2 > i + 1 && (map.get(max) - freq) * 2 > (m - i - 1))
                    return i;
            }
        }
        return -1;
    }


}
