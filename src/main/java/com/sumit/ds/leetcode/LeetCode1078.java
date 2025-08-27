package com.sumit.ds.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String [] strs = text.split(" ");
        List<String> output = new ArrayList();
        if(strs.length >2){
            for(int i=2;i<strs.length;i++){
                if(strs[i-2].equals(first) && strs[i-1].equals(second)){
                    output.add(strs[i]);
                }
            }
        }
        return output.toArray(new String[0]);
    }
    @Test
    public void testing(){
        String input="alice is a good girl she is a good student";
        String first="a";
        String second ="good";
        System.out.println(Arrays.toString(findOcurrences(input,first,second)));
    }

    @Test
    public void testing1(){
        String input="we will we";
        String first="we";
        String second ="will";
        System.out.println(Arrays.toString(findOcurrences(input,first,second)));
    }
}
