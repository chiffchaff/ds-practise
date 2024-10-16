package com.sumit.ds.leetcode.june2023;

import java.io.*;
import java.util.*;



/*

You are a N*N matrix
where
matrix[i][j] = 1 if  i is connected to j
matrix[i][j] = 0 if i is NOT connected to j

And also you are given weight array which tells weight associated with each node.
You need to return the cumulative weight of the each component

Input
{1, 0, 1, 0, 0},
{0, 1, 0, 1, 0},
{1, 0, 1, 0, 1},
{0, 1, 0, 1, 0},
{0, 0, 1, 0, 0}

Weight
{1, 2, 5, 1, 3}

Output
{9,3}

// two components
//{0,2,4}, {1, 3}

/*

[4, 6, 7, 10, 15, 40] target=8
it is called upper bound
it returns the next greater element and never the equal one


[4, 6, 7, 10, 15, 40] target=40
output = 6

[4, 6, 7, 10, 15, 40] target=12
output = 0

*/


/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
public class FindUpperBound {


    public static void main(String[] args) {
        int[] input = {4, 6, 7, 10, 15, 40};
        int target = 41;

        int output = findUpperBound(input, target);
        System.out.println("Upper Bound for target : "+ target +" out: " + output);
    }

    public static int findUpperBound(int[] in, int target) {
        int out = 0;
        if (in.length == 1) {
            if (in[0] > target) {
                out = 1;
            }
        } else {
            int start = 0;
            int end = in.length - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (in[mid] > target) { // target in left side
                    end = mid;

                } else {
                    start = mid + 1; //target on right side

                }
                if (checkInBetween(start, end, target, in)) {
                    out = end;
                    break;
                }
            }
        }

        return out;
    }

    public static boolean checkInBetween(int start, int end, int target, int[] in) {
        boolean result = false;
        if ((start + 1 == end || start == end) && in[start] <= target) {
            result = true;
        }
        return result;
    }


}

