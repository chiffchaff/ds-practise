package com.sumit.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchArrayInItem {
    public boolean checkIfExist1(int[] arr) {
        List<Integer> st = new ArrayList();
        for(int i=0;i<arr.length;i++){
            st.add(arr[i]);
            if(arr[i] != 0 && (st.contains(arr[i]*2) || (arr[i]%2==0 && st.contains(arr[i]/2)))){
//            if((st.contains(arr[i]*2) || (arr[i]%2==0 && st.contains(arr[i]/2)))){
                System.out.println("arr[i]" + arr[i]);
                return true;
            }
        }
        return false;
    }

    public boolean checkIfExist(int[] arr) {
        Set<Integer> st = new HashSet();
        for(int i=0;i<arr.length;i++){
            if((st.contains(arr[i]*2) || (arr[i]%2==0 && st.contains(arr[i]/2)))){
                return true;
            }
            st.add(arr[i]);
        }
        return false;
    }
    @Test
    public void testing(){
//        int in[] ={-2,0,10,-19,4,6,-8};
        int in[] ={0,0};
        System.out.println(checkIfExist(in));
    }
}
