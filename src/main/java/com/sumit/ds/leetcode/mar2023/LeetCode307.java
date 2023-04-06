package com.sumit.ds.leetcode.mar2023;

public class LeetCode307 {
    static int [] st;
    public LeetCode307(int[] nums) {
        int n = nums.length;
        st = new int[4 * n +1];
        int st_idx = 1;
        int start=0;
        int end=n-1;

        //PreProcess
        buildSegmentTree(st_idx,nums,start,end);

    }

    private void buildSegmentTree(int st_Idx, int[] arr, int start, int end) {
        if(start>end) return;
        if(start==end){//leafnode
            st[st_Idx] = arr[start];
        }
        //InternalNode
        int mid = start * (end - start)/2;
        buildSegmentTree(2*st_Idx,arr,start,mid);
        buildSegmentTree(2*st_Idx+1,arr,mid+1,end);
        st[st_Idx] = st[2*st_Idx] + st[2*st_Idx+1];
    }

    public void update(int index, int val) {

    }

//    public int sumRange(int left, int right) {
//
//    }

    public static void main(String args[]){
        int ints[] = {1,4,5,6,7,10};
        System.out.println("\n Segment Tree");
        for(int i=0;i<=4*ints.length;i++){
            System.out.print(st[i]);
        }
    }
}
