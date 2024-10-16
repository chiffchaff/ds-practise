package com.sumit.ds.leetcode.apr2023;

import java.util.TreeMap;

class LeetCode729 {
    private TreeMap<Integer, Integer> calendar;

    public LeetCode729() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // Get the interval that comes before the new interval
        Integer prev = calendar.floorKey(start);

        // Get the interval that comes after the new interval
        Integer next = calendar.ceilingKey(start);

        // Check if there is any overlap with the previous interval
        if (prev != null && calendar.get(prev) > start) {
            return false;
        }

        // Check if there is any overlap with the next interval
        if (next != null && end > next) {
            return false;
        }

        // Add the new interval to the calendar
        calendar.put(start, end);
        return true;
    }
}
