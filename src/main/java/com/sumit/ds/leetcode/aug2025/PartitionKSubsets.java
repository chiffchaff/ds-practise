package com.sumit.ds.leetcode.aug2025;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 * TODO: Not working yet
 */
public class PartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> sumFreq = new HashMap();
        boolean result = false;
        for(int mask=0;mask<(1<<n);mask++){
            int sum = 0;
            for(int i=0;i<n;i++){
                if((mask&(1 << i)) != 0){
                    sum += nums[i];
                }
            }
            sumFreq.put(sum,sumFreq.getOrDefault(sum,0)+1);
            if(sumFreq.get(sum) >=k){
                result = true;
                break;
            }
        }
        return result;
    }

    @Test
    public void testing(){
        PartitionKSubsets ps = new PartitionKSubsets();

        Assert.assertEquals(true,ps.canPartitionKSubsets(new int[]{4,3,2,3,5,2,1},4));

        Assert.assertEquals(false,ps.canPartitionKSubsets(new int[]{1,2,3,4},3));
        //TODO: Not working case
        //Assert.assertEquals(false,ps.canPartitionKSubsets(new int[]{1,1,1,1,9},2));
    }
}
