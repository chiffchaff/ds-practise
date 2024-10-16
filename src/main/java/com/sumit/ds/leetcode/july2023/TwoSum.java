package com.sumit.ds.leetcode.july2023;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        // get Complements hashmap
        Map<Integer, Integer> map = new HashMap();
        int findOtherPair = Integer.MIN_VALUE;
        boolean foundAns = false;
        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];
            if (findOtherPair == complement) {
                ans[1] = i;
                foundAns = true;
                break;
            } else if ((complement * 2) == target) {
                ans[0] = i;
                findOtherPair = complement;
            } else {
                map.put(target - nums[i], i);
            }

        }

        //get the complements pair
        if (!foundAns) {
            for (int i : map.keySet()) {
                if (map.containsKey(target - i)) {
                    ans[0] = map.get(i);
                    ans[1] = map.get(target - i);
                    break;
                }
            }
        }
        return ans;
    }

    @Test public void testAns(){
        int nums[] ={-10,-1,-18,-19};
        int target = -19;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
}
