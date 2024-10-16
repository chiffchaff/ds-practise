package com.sumit.ds.surya.assignments.day5;

import java.util.Arrays;
import java.util.List;

public class SegmentTree {

    List<Integer> st; //segTree

    public static void main(String args[]){
        int n=6;
        List<Integer> arr = Arrays.asList(1,3,2,-2,4,5);
        //st.resize(4*n+1);
        int st_idx =   1;
        int start=0,end=n-1;
        buildSegmentTree(st_idx,arr,start,end);
        System.out.println("Printing segment tree");
        for(int i=0;i<4*n;i++) {
            System.out.println(arr.get(i));
        }
    }
    public static void buildSegmentTree(int st_idx, List<Integer> arr, int start, int end){

    }
}
