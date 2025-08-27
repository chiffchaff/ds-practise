package com.sumit.ds.leetcode.aug2025;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        StringTokenizer st = new StringTokenizer(s);
        Map<Character, String> map = new HashMap();
        int i = 0;
        boolean result = true;
        while (st.hasMoreTokens() && i < chars.length) {
            String token = st.nextToken();
            if (!map.containsKey(chars[i])) {
                if(map.containsValue(token)){
                    result=false;
                    break;
                }
                map.put(chars[i], token);
            } else if (!map.get(chars[i]).equals(token)) {
                result = false;
                break;
            }
            i++;
        }

        if (i < chars.length || st.hasMoreTokens()) {
            result = false;
        }
        return result;
    }

    @Test
    public void testing() {
        String pattern = "abba";
        String s = "dog cat cat dog";
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern(pattern, s));
    }

    @Test
    public void testing1() {
        String pattern = "abba";
        String s = "dog dog dog dog";
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern(pattern, s));
    }

}
