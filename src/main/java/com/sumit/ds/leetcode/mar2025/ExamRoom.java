package com.sumit.ds.leetcode.mar2025;

import java.util.PriorityQueue;

//LeetCode 855 : https://leetcode.com/problems/exam-room/description/
import java.util.*;

public class ExamRoom {
    private int N;
    private PriorityQueue<Interval> pq;
    private Set<Interval> intervalSet;
    private TreeSet<Integer> seated;

    public ExamRoom(int N) {
        this.N = N;
        this.pq = new PriorityQueue<>((a, b) -> {
            int distA = a.getDistance(N);
            int distB = b.getDistance(N);
            if (distA != distB) return distB - distA; // max-heap by distance
            return a.start - b.start; // tie-breaker: smaller seat number
        });
        this.intervalSet = new HashSet<>();
        this.seated = new TreeSet<>();

        // Initial empty room
        addInterval(new Interval(-1, N));
    }

    public int seat() {
        while (!pq.isEmpty()) {
            Interval interval = pq.poll();
            if (!intervalSet.contains(interval)) continue; // stale interval

            intervalSet.remove(interval);
            int seat;
            if (interval.start == -1) {
                seat = 0;
            } else if (interval.end == N) {
                seat = N - 1;
            } else {
                seat = interval.start + (interval.end - interval.start) / 2;
            }

            // Add new intervals after seating
            addInterval(new Interval(interval.start, seat));
            addInterval(new Interval(seat, interval.end));
            seated.add(seat);
            return seat;
        }
        return -1; // fallback
    }

    public void leave(int p) {
        seated.remove(p);
        Integer lower = seated.lower(p);
        Integer higher = seated.higher(p);

        int start = lower == null ? -1 : lower;
        int end = higher == null ? N : higher;

        // Remove adjacent intervals
        removeInterval(new Interval(start, p));
        removeInterval(new Interval(p, end));

        // Merge them
        addInterval(new Interval(start, end));
    }

    // Helpers

    private void addInterval(Interval interval) {
        pq.offer(interval);
        intervalSet.add(interval);
    }

    private void removeInterval(Interval interval) {
        intervalSet.remove(interval);
    }

    private static class Interval {
        int start, end;
        Interval(int s, int e) { this.start = s; this.end = e; }

        int getDistance(int N) {
            if (start == -1) return end;
            if (end == N) return N - 1 - start;
            return (end - start) / 2;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Interval)) return false;
            Interval other = (Interval) o;
            return this.start == other.start && this.end == other.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}