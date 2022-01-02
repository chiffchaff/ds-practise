package com.sumit.ds.recursion.practise;

import org.junit.Test;

public class factorial {

    public int factR(int i){
        if(i==1)
            return 1;
        return i * factR(i-1);
    }

    public int fact(int i){
        int output = 1;
        for(int a=i;a>0;a--){
            output*=a;
        }
        return output;
    }

    @Test
    public void test(){
        int input=5;
        System.out.println(factR(input));
        System.out.println(fact(input));
    }
}
