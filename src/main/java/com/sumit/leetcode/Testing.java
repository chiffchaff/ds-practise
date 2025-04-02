package com.sumit.leetcode;

import org.junit.Test;

public class Testing {
    public boolean isIsomorphic(String s, String t) {
        int []arr1 = new int[256];
        int []arr2 = new int[256];
        if(s.length() != t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(arr1[s.charAt(i)] != arr2[t.charAt(i)]){
                return false;
            }
            arr1[s.charAt(i)] = i+0;
            arr2[t.charAt(i)] = i+0;
        }
        return true;
    }

    @Test
    public void testing(){
        String in1 = "egg";
        String in2 = "add";
        System.out.println(isIsomorphic(in1,in2));
    }
}
