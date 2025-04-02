import org.junit.Test;

//Leetcode 387
public class FristUniqueCharacter {
    public int firstUniqChar(String s) {
        int []freqArr = new int[26];
        for(int ch:s.toCharArray()){
            freqArr[ch-'a']++;
        }
        int result=-1;
        for(int i=0;i<s.length();i++){
            if(freqArr[s.charAt(i)-'a'] == 1){
                result=i;
                break;
            }
        }
        return result;
    }

    @Test
    public void testing(){
        String input = "leetcode";
         input = "loveleetcode";
         input = "abab";
        System.out.println(firstUniqChar(input));
    }
}
