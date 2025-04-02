package com.sumit.actualInterview.bill;

import org.junit.Test;

import java.util.Stack;

public class CompresString {
    public static String compressString(String input, int k){
        StringBuilder sb = new StringBuilder();
        Stack<CharClass> st = new Stack<>();
        CharClass cc = new CharClass(1,input.charAt(0));
        st.push(cc);
        sb.append(cc.ch);
        for(int i=1;i<input.length();i++){
            if(!st.isEmpty() && st.peek().ch == input.charAt(i)){ //if stack is non empty & top of the stack == current char, increase character count
                st.peek().count++;
                sb.append(cc.ch);
                if(st.peek().count == k){ //if the current character counter ==k, remove from stack
                    st.pop();
                    sb.delete(sb.length()-k,sb.length());//remove K characters from stringbuilder
                }
            }else{
                cc = new CharClass(1,input.charAt(i));
                st.push(cc);
                sb.append(cc.ch);
            }
        }
        return sb.toString();
    }

    static class CharClass{
        int count;
        Character ch;
        public CharClass(int count,Character ch){
            this.count=count;
            this.ch=ch;
        }
    }



    @Test
    public void testing(){
        String input ="aabbbacccbaa";//baa
        input="aabbcccbab"; //output b
        int k =3;
        System.out.println(compressString(input,k));
    }

    private static String supressString(String str, int k) {
        if(str.length() < k) {
            return str;
        }
        Character prev = '\0';
        Character curr = str.charAt(0);
        int cnt = 1;
        String result = "" + curr;
        for (int i = 1; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if(ch.equals(curr)){
                cnt++;
                result = result + ch;
                if(cnt >=  k) {
                    while (cnt > 0) {
                        result = result.substring(0, result.length() - 1);
                        cnt--;
                    }
                }
            } else {
                if(curr.equals(prev)) {
                    cnt = 2;
                } else {
                    prev = curr;
                    curr = ch;
                    cnt = 1;
                }
                result = result + curr;
            }
        }
        return result;
    }

}
