package com.sumit.ds.algoexpert;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int p = 0;
        boolean result = false;
        for (int i = 0; i < array.size(); i++) {
            if (p < sequence.size() && array.get(i) == sequence.get(p)) {
                p = p + 1;
            } else if (p >= sequence.size()) {
                break;
            }
        }
        if (p  == sequence.size())
            result = true;
        return result;
    }

    @org.junit.Test
    public void test() {
        Integer[] array = {5,1,22,25,6,-1,8,10};
        Integer [] seq = {1,6,-1,10};
        System.out.println(isValidSubsequence(Arrays.asList(array),Arrays.asList(seq)));
    }
}
