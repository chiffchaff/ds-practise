package com.sumit.ds.leetcode.apr2024;

import org.junit.Test;

public class StringCompression {
        public int compress(char[] chars) {
            if(chars == null){
                return 0;
            }

            int size = chars.length;
            if(size == 1){
                return 1;
            }
            StringBuilder sb = new StringBuilder();
            int count=1;
            char prev = chars[0];
            for(int i=1;i<size;i++){
                if(prev == chars[i]){
                    count++;
                }
                else{
                    if(count>1){
                        sb.append(String.valueOf(prev)+count);
                    }
                    else{
                        sb.append(prev);
                    }
                    prev=chars[i];
                    count=1;
                }
            }
            if(count > 1){
                sb.append(String.valueOf(prev)+count);
            }
            else{
                sb.append(prev);
            }
            System.out.println(sb.toString());
            return sb.toString().length();
        }


        @Test
        public void testing(){
            String input = "aabbccc";
            System.out.println(compress(input.toCharArray()));
        }
}
