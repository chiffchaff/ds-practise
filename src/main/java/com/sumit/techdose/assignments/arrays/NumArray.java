package com.sumit.techdose.assignments.arrays;

import java.util.ArrayList;
import java.util.List;

//LeetCode 303
public class NumArray {
    List<Integer> prefixSum = new ArrayList<>();
    public NumArray(){

    }
    public NumArray(int[] nums) {
        if(nums!=null && nums.length>0){
            prefixSum.add(0,nums[0]);
            for(int i=1;i<nums.length;i++){
                prefixSum.add(i,prefixSum.get(i-1)+nums[i]);
            }
        }
        System.out.println(prefixSum);
    }

    public int sumRange(int left, int right) {
        int result = Integer.MIN_VALUE;
        if(left>=0 && right <=prefixSum.size()) {
            if (left == 0) {
                result = prefixSum.get(right);
            }
            else{
                result = prefixSum.get(right) - prefixSum.get(left-1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0,2));
        System.out.println(obj.sumRange(2,5));
        System.out.println(obj.sumRange(0,5));
    }
}
