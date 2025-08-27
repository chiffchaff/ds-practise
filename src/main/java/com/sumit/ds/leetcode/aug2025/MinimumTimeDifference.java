package com.sumit.ds.leetcode.aug2025;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/minimum-time-difference/
public class MinimumTimeDifference {
    public static int findMinDifference(List<String> timePoints) {
        TreeSet<Integer> set = new TreeSet();
        int minDiff = Integer.MAX_VALUE;
        for(String tp : timePoints){
            int minutes = getMinutes(tp);
            if(!set.add(minutes)){
                return 0; //if set already has the given minutes, diff will be zero
            }
        }

        Integer prev = null;
        for (Integer current : set) {
            if(prev != null){
                minDiff = Math.min(minDiff,current-prev);
            }
            prev = current;
        }

        // Check circular difference
        int first = set.first();
        int last = set.last();
        minDiff = Math.min(minDiff, (first + 1440) - last);

        return minDiff;
    }

    public static int getMinutes(String tp){
        char[] chars = tp.toCharArray();
        return Integer.valueOf(tp.substring(0,2)) * 60 + Integer.valueOf(tp.substring(3,5));
    }

    @Test
    public void testSimpleCase() {
        List<String> times = Arrays.asList("23:59", "00:00");
        assertEquals(1, MinimumTimeDifference.findMinDifference(times)); // across midnight
    }

    @Test
    public void testDuplicateTimes() {
        List<String> times = Arrays.asList("01:01", "01:01", "03:00");
        assertEquals(0, MinimumTimeDifference.findMinDifference(times)); // duplicate → min diff = 0
    }

    @Test
    public void testInOrderTimes() {
        List<String> times = Arrays.asList("00:00", "01:00", "02:00");
        assertEquals(60, MinimumTimeDifference.findMinDifference(times)); // min diff = 60 min
    }

    @Test
    public void testUnsortedInput() {
        List<String> times = Arrays.asList("12:30", "09:15", "06:45");
        assertEquals(165, MinimumTimeDifference.findMinDifference(times)); // min diff between 06:45 and 09:15
    }

    @Test
    public void testCloseTimesSameDay() {
        List<String> times = Arrays.asList("05:59", "06:00", "06:01");
        assertEquals(1, MinimumTimeDifference.findMinDifference(times)); // closest = 1 min
    }

    @Test
    public void testEdgeCaseMidnightWrapAround() {
        List<String> times = Arrays.asList("23:50", "00:05");
        assertEquals(15, MinimumTimeDifference.findMinDifference(times)); // across midnight
    }

    @Test
    public void testAllMinutesCovered() {
        List<String> times = Arrays.asList("00:00", "23:59");
        assertEquals(1, MinimumTimeDifference.findMinDifference(times)); // wrap around case
    }

    @Test
    public void testLargeGap() {
        List<String> times = Arrays.asList("00:00", "12:00");
        assertEquals(720, MinimumTimeDifference.findMinDifference(times)); // half day difference
    }

    @Test
    public void testSingleMinuteDifference() {
        List<String> times = Arrays.asList("08:00", "08:01");
        assertEquals(1, MinimumTimeDifference.findMinDifference(times)); // exactly 1 min diff
    }
}
