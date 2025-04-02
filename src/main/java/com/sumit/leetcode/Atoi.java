package com.sumit.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Atoi {
    //public int myAtoi(String s) {
//        for(int i=0;i<s.length();i++){
//        int counter=1;
//        int ans=1;
//        for(int i=0;i<s.length();i++){
//            char ch = s.charAt(i);
//            System.out.println("Char :"+ch);
//            if(counter == 1 && (ch == '-' || ch == '+')){
//                if(ch == '-'){
//                    ans *=-1;
//                }
//                else if(ch =='+'){
//                    ans *=1;
//                }
//                System.out.println("Ans :"+ans);
//            } else if((ch - '0') >=0 && (ch -'0')<=9){//all digits
//                if((ch -'0') != 0 && counter == 1){
//                    if(counter !=1){
//                        ans = ans * counter + (ch -'0');
//                    }
//                    else{
//                        ans = ans * (ch -'0');
//                    }
//                }
//                else{
//                    ans = ans * counter + (ch -'0');
//                }
//                System.out.println("Ans :"+ans);
//                counter*=10;
//            }
//            else if(ch == ' '){ //ignore white spaces
//                System.out.println("skipping at i:"+i);
//                System.out.println("Ans :"+ans);
//                continue;
//            }
//            else{ //not valid character
//                System.out.println("Invalid at i:"+i);
//                break;
//            }
//            System.out.println("Ans :"+ans);
//        }
//        return ans;
//    }
//    @Test
//    public void testing(){
//        String in ="   -042";
//        Assert.assertEquals(-42,myAtoi(in));
//
//    }
}
