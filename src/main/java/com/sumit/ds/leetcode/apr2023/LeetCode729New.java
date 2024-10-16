package com.sumit.ds.leetcode.apr2023;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode729New {
    List<int[]> bookings = new ArrayList<>();
    public LeetCode729New() {

    }

    public boolean book(int start, int end) {
        for(int[] booking:bookings){
            if(Math.max(start,booking[0]) < Math.min(end,booking[1]))
                return false;
        }
        bookings.add(new int[]{start,end});
        return true;
    }

    @Test
    public void testing(){
        LeetCode729New leetCode729New = new LeetCode729New();
        System.out.println(leetCode729New.book(10,20));
        System.out.println(leetCode729New.book(20,30));
        System.out.println(leetCode729New.book(15,30));
    }
}
