package com.sumit.ds.surya.assignments.day3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, print all the character combinations
 * Soln: Using bit wise operation, to come up with all the combinations
 * 1. Generate masks from the range of 0 to 2 power of N. N being the length of string
 * 2. check what bits are set in the mask by looping from 0 to N -1
 * 3. if the bit is set ( mask && (1<< bit to check)) != 0 )
 * 4. include the character in the combination string
 *
 * Time Complexity = O(N * 2 power of N)
 */
public class PrintAllCombinations {
    @Test
    public void testing(){
        String s = "abc";
        System.out.println(getCombinations(s));
    }

    private List<String> getCombinations(String s) {
        List<String> res = new ArrayList<>();
        int powerofTwo = (1<<s.length());
        for(int mask=0;mask< powerofTwo;mask++){
            String temp = "";
            for(int j=0;j< s.length();j++){
                if((mask & (1<<j)) != 0){
                    temp +=s.charAt(j);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
