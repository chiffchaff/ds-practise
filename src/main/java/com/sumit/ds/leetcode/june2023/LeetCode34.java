package com.sumit.ds.leetcode.june2023;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        List<Integer> output = new ArrayList();
        while(start < end){
            int mid = start + (end - start)/2;
            if(nums[mid] > target){ // target should be on the left of target
                end = mid;
            }
            else{
                start=mid;
            }

            if(checkAndAddTargetIndexes(mid,nums,target,output))
                break;
        }

        //Convert list to int
        return listToInt(output);
    }

    private int[] listToInt(List<Integer> output){
        int [] out = new int[output.size()];
        if(output != null){
            for(int i=0;i<output.size();i++){
                out[i] = output.get(i);
            }
        }
        return out;
    }

    public boolean checkAndAddTargetIndexes(int mid,int []nums,int target,List<Integer> output){
        boolean result = false;
        if(nums[mid] == target){
            int i = mid;
            while(i>0){
                if(nums[i]==target){
                    output.add(i);
                    i--;
                }else{
                    break;
                }
            }

            i = mid+1;
            while(i<nums.length){
                if(nums[i] == target){
                    output.add(i);
                    i++;
                }
                else{
                    break;
                }
            }
            result = true;
        }
        return result;
    }

    @Test public void test(){
        int [] in={5,7,7,8,8,10};
//        int target = 8;
        int target = 6;
        int [] out = searchRange(in,target);
        System.out.println(Arrays.toString(out));
    }
}
