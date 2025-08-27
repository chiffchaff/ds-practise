package com.sumit.ds.leetcode.mar2023;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target - nums[i])){
                return new int[] {i, map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    public static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

    @Test
    public void testing(){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
//        int[] result = findTwoSum(nums, target);
        int[] result = twoSum(nums, target);
        System.out.println("Indices of elements whose sum equals target: " + Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = findTwoSum(nums, target);
        System.out.println("Indices of elements whose sum equals target: " + Arrays.toString(result));
    }
}
