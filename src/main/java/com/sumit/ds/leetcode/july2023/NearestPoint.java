package com.sumit.ds.leetcode.july2023;

/**
 * /*
 *  * Problem: Given a list of n points, each with coordinates (x,y), return the k-closest points to the origin (0,0).
 *
 *  distance(x, y) = abs(x) + abs(y);
 *  distance(x1, y1, x2, y2) = abs(x1-x2) + abs(y1-y2);
 *
 *  [list of distances from (x,y)] - top K closest
 *
 *
 * input: {list of points}
 *
 * Max Heap (k) -
 *
 * list of distances from (x,y)
 *


*
        *import java.io.*;
 *import java.util.*;
 *
         * /*
  *  * To execute Java, please define "static void main" on a class
  *  * named Solution.
  *  *
  *  * If you need more classes, simply define them inline.

class Point {
 *
    int x;
 *
    int y;
 *
         *

    public Point(int x, int y) {
 *this.x = x;
 *this.y = y;
 *}
 *
         *
         *
}
 *
         *
         *public MyComparator implements Comparator<Point>{
        *
        *Point target;
        *
        *public MyComparator(Point target){
        *this.target=target;
        *}
        *
        *public int compareTo(Point a,Point b){
        *return Integer.compare(Solution.getDistance(a,target),
        *Solution.getDistance(b,target));
        *}
        *}
        *
        *

class Solution {
 *
    PriorityQueue<Point> pq = null;
 *
         *

    public static void main(String[] args) {
 *List<Point> points = new ArrayList<>();
 *points.add(new Point(1, 2));
 *
 *int x = 0;
 *int y = 0;
 *Point target = new Point(x, y);
 *
 *int k = 10;
 *pq = new PriorityQueue<>(k, new MyComparator(target));
 *
 *List<Point> kNearestPoints = getNearestPoints(points, target, k);
 *}
 *
         *

    public List<Point> getNearestPoints(List<Point> points, Point target, int k) {
 *List<Point> kNearest = new ArrayList<>();
 *
 *for (Point p : points) {
 *if (pq.size() > k) {
 *pq.poll();
 *}
 *pq.offer(p);
 *}
 *
 *while (pq.size() > 0) {
 *kNearest.add(pq.poll());
 *}
 *
 *return kNearest;
 *
 *
 *}
 *
         *
         *

    public static int getDistance(Point p, Point target) {
 *return Math.abs(p.x - target.x) + Math.abs(p.y - target.y);
 *}
 *
         *
}
 *
         *
         * // Your previous Plain Text content is preserved below:
         *
         * // This is just a simple shared plaintext pad, with no execution capabilities.
         *
         * // When you know what language you'd like to use for your interview,
         * // simply choose it from the dots menu on the tab, or add a new language
         * // tab using the Languages button on the left.
         *
         * // You can also change the default language your pads are created with
         * // in your account settings: https://app.coderpad.io/settings
         *
         * // Enjoy your interview!
 */
public class NearestPoint {
}
