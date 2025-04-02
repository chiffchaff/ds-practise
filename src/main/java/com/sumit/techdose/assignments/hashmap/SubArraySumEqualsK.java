package com.sumit.techdose.assignments.hashmap;

import org.junit.Test;

import java.util.*;

//Leetcode 560
public class SubArraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        //Create prefix sum for the given array and create hashmap with key = sum at index, value=index in the array
        int [] psum = new int[nums.length+1];
        psum[0]=0;
        Map<Integer,Integer> pmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            psum[i+1]=psum[i]+nums[i];
            pmap.put(psum[i+1],i);
        }
        //Find out subarray with sum = k
        List<List<Integer>> poutput = new ArrayList<>();
        int subArraySumCounter =0;
        for(int i=0;i<psum.length-1;i++){
            int end = psum[i]+k;
            if(pmap.containsKey(end)){
                List<Integer> integerList = new ArrayList<>();
                int endIndex = pmap.get(end);
                for(int j=i;j<=endIndex;j++) {
                    integerList.add(nums[j]);
                }
                poutput.add(integerList);
                subArraySumCounter++;
            }
        }
        System.out.println(poutput);
        System.out.println(subArraySumCounter);
        return subArraySumCounter;
    }

    @Test
    public void testing(){
//        int nums[] = {0,1}; k =1
//        int nums[] = {1,4,-3,5,2,7}; k =7
//        int nums[] = {1,1,1}; k =2
//        int nums[] = {1,2,3}; int k = 3;
//        int nums[] = {}; int k = 3;
        int nums[] = {-1,-1,1}; int k = 0;

        subarraySum(nums,k);
    }

}
