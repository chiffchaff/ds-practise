package com.sumit.ds;

import org.junit.Test;

public class PrintAllSubString {

    public void subStrings(String s, int idx, StringBuilder result){
        if(idx == s.length()){
            System.out.println(result);
            return;
        }
        subStrings(s,idx+1,result); //Exclude case
        //Include Case
        result.append(s.charAt(idx));
        subStrings(s,idx+1,result);
        result.deleteCharAt(result.length()-1);
    }

    @Test
    public void testing(){
        String input ="abc";
        StringBuilder sb = new StringBuilder();
        subStrings(input,0,sb);
    }
}
