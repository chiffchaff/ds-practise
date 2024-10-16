package com.sumit.ds.leetcode.apr2024;

import org.junit.Test;

import java.util.*;

/**
 * Questions asked during meta virtual Screening round at meta on 1st April 2024
 * https://leetcode.com/problems/word-break/description/
 */
public class WordBreak {
    List<String> dict = Arrays.asList("pen", "my");
    Map<Integer, Boolean> mem = new HashMap<>();

    /**
     * Using recursion
     * O(2 to the power of N)
     *
     * @param s
     * @param pos
     * @return
     */
    public boolean wb(String s, int pos) {
        System.out.println("Checking if dictionary contains string :" + s.substring(pos, s.length()));
        if (pos >= s.length()) {
            System.out.println("Substring: contains: true");
            return true; //base condition
        }

        for (int i = pos + 1; i <= s.length(); ++i) {
            String sub = s.substring(pos, i);
            System.out.println("SubString :" + sub + " contains:" + dict.contains(sub));
            if (dict.contains(sub) && wb(s, i))
                return true;
        }
        return false;
    }

    /**
     * Using recursion and memoization
     * Time Complexity (N square . N)
     * N square - because of recursive calls
     * then N because substring has N time complexity
     *
     * @param s
     * @param pos
     * @return
     */
    public boolean wbWithMemo(String s, int pos) {
        System.out.println("Checking if dictionary contains string :" + s.substring(pos, s.length()));
        if (pos >= s.length()) return true; //base condition
        if (mem.containsKey(pos)) return mem.get(pos);

        for (int i = pos + 1; i <= s.length(); ++i) {
            String sub = s.substring(pos, i);
            System.out.println("SubString :" + sub + " contains:" + dict.contains(sub));
            if (dict.contains(sub) && wbWithMemo(s, i)) {
                mem.put(pos, Boolean.TRUE);
                return true;
            }
        }
        return false;
    }

    @Test
    public void testing() {
        String s = "mypenmy";
        dict = Arrays.asList("pen", "my");
//        System.out.println(wb(s,0));

        s = "applepieapple";
        dict = Arrays.asList("apple", "pie");
//        System.out.println(wb(s,0));

        s = "abcd";
        dict = Arrays.asList("a", "b", "c", "d", "ab", "bc", "abc");
//        System.out.println(wb(s,0));

        s = "leetcode";
        dict = Arrays.asList("leet", "code");
//        System.out.println(wb(s,0));

        s = "catsandog";
        dict = Arrays.asList("cats", "dog", "sand", "and", "cat");
//        System.out.println(wb(s,0));

        s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        dict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        System.out.println(wb(s, 0));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();
        return canConstruct(s, wordDict, map);
    }

    private boolean canConstruct(String s, List<String> wordDict, Map<String, Boolean> map) {
        if (map.containsKey(s))
            return map.get(s);
        if (s.isEmpty())
            return true;
        for (String str : wordDict) {
            if (s.startsWith(str) && canConstruct(s.substring(str.length()), wordDict, map)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }

    public static boolean wordBreak1(String s, List<String> wordDict) {
        if (null == s || "".equalsIgnoreCase(s.trim())) {
            return false;
        }

        s = s.trim();

        Map<String, Boolean> words = new HashMap<String, Boolean>();
        Stack<String> wordStack = new Stack<String>();

        for (String word : wordDict) {
            words.put(word, true);
        }

        int startIndex = s.length() - 1;

        while (startIndex >= 0) {
            if (words.get(s) != null) {
                return true;
            }
            String tempStr = s.substring(startIndex, s.length());

            if(words.get(tempStr) != null) {
                wordStack.push(tempStr);
                s = s.substring(0, startIndex);
            }

            startIndex--;
        }

        if ("".equalsIgnoreCase(s)) {
            return true;
        }

        return false;
    }

    @Test
    public void testing1() {
        String s = "mypenmyy";
        dict = Arrays.asList("pen", "my","y");
        mem.clear();
//        System.out.println("Result:"+wbWithMemo(s,0));
        System.out.println("Result:"+wordBreak1(s,dict));
        System.out.println("Result:"+wordBreak(s,dict));
        System.out.println("Result:"+wbWithMemo(s,0));

        s = "applepieapple";
        dict = Arrays.asList("apple", "pie");
        mem.clear();
//        System.out.println("Result:"+wbWithMemo(s,0));

        s = "abcd";
        dict = Arrays.asList("a", "b", "c", "d", "ab", "bc", "abc");
        mem.clear();
//        System.out.println("Result:"+wbWithMemo(s,0));

        s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        dict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        mem.clear();
//        System.out.println(wb(s,0));
//        System.out.println(wordBreak(s, dict));
    }
}
