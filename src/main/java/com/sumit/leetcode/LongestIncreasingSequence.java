package com.sumit.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSequence {
    public int lengthofLIS(int [] nums){
        int n = nums.length;
        List<Integer> lis = new ArrayList<>();
        for(int i =0;i<n;i++){
            int lb =lowerBound(lis,nums[i]);
            if(lb == lis.size()){
                lis.add(nums[i]);
            }
            else{
                lis.add(lb,nums[i]);
            }
        }
        return lis.size();
    }

    private int lowerBound(List<Integer> lis, int num) {
        int result = 0;
        if(lis != null && lis.size() > 0){
            int low = 0;
            int high = lis.size()-1;
            int mid = low + (high-low)/2;
            while(low<high){
                if(lis.get(mid)<num){
                    low = mid+1;
                }
                else{
                    high = mid;
                }
            }
            result = low;
        }
        return result;
    }
}
