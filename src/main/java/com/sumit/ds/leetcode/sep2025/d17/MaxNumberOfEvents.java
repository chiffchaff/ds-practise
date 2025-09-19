package com.sumit.ds.leetcode.sep2025.d17;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxNumberOfEvents {
    public int maxEvents(int[][] events) {
        int n = events.length;
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans=0;
        for(int i =1,j=0;i<=maxDay;i++){
            while(j<n && events[j][0] <=i){
                pq.offer(events[j][1]);
                j++;
            }
            while(!pq.isEmpty() && pq.peek() < i){
                pq.poll();
            }
            if(!pq.isEmpty()){
                pq.poll();
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void testing(){
        MaxNumberOfEvents m = new MaxNumberOfEvents();
        Assert.assertEquals(3,m.maxEvents(new int[][] {{1,2},{2,3},{3,4}}));
        Assert.assertEquals(4,m.maxEvents(new int[][] {{1,2},{2,3},{3,4},{1,2}}));
    }
}
