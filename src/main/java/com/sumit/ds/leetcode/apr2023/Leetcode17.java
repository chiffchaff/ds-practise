package com.sumit.ds.leetcode.apr2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Leetcode17 {

    private static final Map<Character, String> digitToLetters = null;
//    Map.Entry(
//            '2', "abc",
//            '3', "def",
//            '4', "ghi",
//            '5', "jkl",
//            '6', "mno",
//            '7', "pqrs",
//            '8', "tuv",
//            '9', "wxyz"
//    );

        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if (digits.isEmpty()) {
                return result;
            }
            backtrack(result, new StringBuilder(), digits, 0);
            return result;
        }

        private void backtrack(List<String> result, StringBuilder sb, String digits, int index) {
            if (index == digits.length()) {
                result.add(sb.toString());
                return;
            }
            String letters = digitToLetters.get(digits.charAt(index));
            for (int i = 0; i < letters.length(); i++) {
                sb.append(letters.charAt(i));
                backtrack(result, sb, digits, index + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }


}
