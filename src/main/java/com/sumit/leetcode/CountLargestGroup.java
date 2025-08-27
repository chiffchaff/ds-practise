package com.sumit.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CountLargestGroup {
    public int countLargestGroup(int n) {
        Map<Integer,Integer> map = new HashMap();
        int maxSum = 0;
        for(int i=1;i<=n;i++){
            int sum=0;
            int num=i;
            while(num>0){
                sum+= num%10;
                num=num/10;
            }
            int freq = map.getOrDefault(sum,0)+1;
            map.put(sum,freq);
            maxSum=Math.max(maxSum,freq);
        }

        int count =0;
        for(int key:map.values()){
            if(key == maxSum)
                count++;
        }
        return count;
    }
    @Test
    public void testing(){
        System.out.println(countLargestGroup(13));
    }
}
