package com.sumit.test;


import org.testng.annotations.Test;

/**
 * LeetCode 75
 */
public class StringCompression {


    public int compress(char[] chars) {
        StringBuffer sb = new StringBuffer();
        if (chars.length > 0) {
            char ch = chars[0];
            int count = 1;
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == ch) {
                    count++;
                } else {
                    if (count == 1) {
                        sb.append(ch);
                    } else {
                        sb.append(ch).append(count);
                    }
                    ch = chars[i];
                    count = 1;
                }
            }
            if(count > 0)
                sb.append(ch).append(count);
            else
                sb.append(ch);
        }
        System.out.println(sb.toString());
        return sb.length();
    }

    @Test
    public void test(){
        //char input[] ={'a','a','b','b','c','c','c'};
        char input[] ={'a'};
        compress(input);
    }
}