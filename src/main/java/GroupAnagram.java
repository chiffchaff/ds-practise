import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//LeetCode 49
public class GroupAnagram {


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        List<List<String>> output = null;
        if(strs != null) {

            for (String str : strs) {
                int[] freqArray = new int[26];
                // Step1 : Create Frequency array
                for (char ch : str.toCharArray()) {
                    int temp = ch - 'a';
                    freqArray[temp] = freqArray[temp] + 1;
                }

                //Step 2: Creating key for group map
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < freqArray.length; i++) {
                    if (freqArray[i] > 0) {
                        int tempCh = 'a' + i;
                        sb.append(freqArray[i]).append((char) tempCh);
                    }
                }
                List<String> lists = groupMap.get(sb.toString());
                if (lists == null) {
                    lists = new ArrayList<>();
                }
                lists.add(str);
                groupMap.put(sb.toString(), lists);
            }

            output = new ArrayList<>();
            //Step 3: Output the result
            for (String keys : groupMap.keySet()) {
                output.add(groupMap.get(keys));
            }
        }
        return output;
    }


    @Test
    public void testing(){
//        String []input = {"eat","tea","tan","ate","nat","bat"};
        String []input = {"aaaaaaaaaaaab","baaaaaaaaaaaa","aaaaaaaaaaa","aaaaaaaaaaa","aaaaabaaaaa","aaaaaaaaaba"};
        System.out.println(groupAnagrams(input));
    }
}
