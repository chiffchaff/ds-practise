package com.sumit.techdose.assignments.arrays;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        if (nums != null && nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);//inplace sorting

        for (int i = 0; i < nums.length; i++) {
            int x = i;//Fixed
            int y = i + 1;//Left
            int z = nums.length - 1; //right
            while (y < z) {
                int sum = nums[x] + nums[y] + nums[z];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[x], nums[y], nums[z]));

                    y++;
                    z--;
                } else if (sum < 0) {
                    y++;
                } else if (sum > 0) {
                    z--;
                }
            }
        }
        return result.stream().collect(Collectors.toList());
    }

    @Test
    public void test() {
        int nums[] = {-1, 0, 1, 2, -1, -4};
//        int nums[] = {0,0,0,0};
//        int nums[] = {-2,-1,-1,0,1,1,2}; //[[-2,0,2],[-1,0,1],[-1,-1,2]]
//        int nums[] = {-2,0,1,1,2};//[[-2,0,2],[-2,1,1]]
//        int nums[] = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};//[[-2,0,2],[-2,1,1]]
        System.out.println(threeSum(nums));
    }

}