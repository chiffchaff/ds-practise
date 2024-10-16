import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// LeetCode 438
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s!= null && p!= null && s.length() >= p.length()){
            int []freqArrayp = computeFrequencyArray(p);
            int i = 0;int j = i+p.length()-1;
            int [] freqArrays = new int[26]; // for window size

            //precompute for 1st time for window size
            for(int start =i;start<=j;start++){
                int chint =  s.charAt(start) - 'a';
                freqArrays[chint]++;
            }

            while(j<s.length()){
                System.out.println("checking for chars in(i,j)::("+i+","+j+") :"+s.substring(i,j+1));
                if(Arrays.equals(freqArrays,freqArrayp)){
                      result.add(i);
                }
                int chint = s.charAt(i) - 'a';
                freqArrays[chint]--;
                i++;
                j = i + p.length() - 1;
                if(j<s.length()) {
                    chint = s.charAt(j) - 'a';
                    freqArrays[chint]++;
                }

            }

        }
        return result;
    }

    private int[] computeFrequencyArray(String s) {
        int [] frequencyArray = new int[26];
        for(char ch:s.toCharArray()){
            int intch = ch -'a';
            frequencyArray[intch]++;
        }
        return frequencyArray;
    }

    @Test
    public void testing(){
        String s = "cbaebabacd"; String p = "abc";

        s="abcbcabacba"; p ="abc";
        s="abab"; p ="ab";
        System.out.println(findAnagrams(s,p));
    }

}
