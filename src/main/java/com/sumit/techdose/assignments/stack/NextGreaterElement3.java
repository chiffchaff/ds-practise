package com.sumit.techdose.assignments.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement3 {
    public int nextGreaterElement(int n) {
        int answer = -1;
        if(n<10)
            return answer;


        //Step1 : Create NGE array
        int input[] = getInputArray(n);
        Stack<Integer> st = new Stack<>();
        int [] nge = new int[input.length];
        System.out.println("Input array :"+Arrays.toString(input));
        //Fill nge with -1;
        Arrays.fill(nge,-1);
        for(int i=0;i<input.length;i++){
            if(st.isEmpty()){
                st.push(i);
            }
            //Monotonically decreasing element
            while(!st.isEmpty() && input[st.peek()]<input[i]){
                nge[st.pop()]=i;
            }
            st.push(i);
        }
        System.out.println("NGE Array:"+Arrays.toString(nge));

        //Step2 : Swap to get the nextGreater Element
        int j=input.length-1;
        while(j>=0 && nge[j]==-1){
            j--;
        }
        if(j ==-1){
            answer = -1;
        }
        else{


            int tempArray[] = Arrays.copyOfRange(input,j+1,input.length);
            Arrays.sort(tempArray);

            //Swap the jth element with first element in the sorted array
            int temp = input[j];
            input[j]=input[j+1];
            input[j+1]=temp;
            System.out.println("after swap ::"+Arrays.toString(input));


            for(int i=0;i<tempArray.length;i++){
                input[++j]=tempArray[i];
            }

            answer = recreateNumber(input);
            if(answer<0)
                answer = -1;
        }
        return answer;
    }

    private int recreateNumber(int[] input) {
        int len = input.length;
        int res = input[0];
        for(int i=1;i<len;i++){
            res = res*10+input[i];
        }
        return res;
    }

    private int[] getInputArray(int n) {
        Stack<Integer> st = new Stack<>();
        while(n >0){
            st.push(n%10);
            n /=10;
        }
        int res[] = new int[st.size()];
        int i=0;
        while(!st.isEmpty()){
            res[i++]=st.pop();
        }
        return res;
    }

    @Test
    public void testing(){
        int input = 12;
        input = 2975431; //9275431
        input = 29754831; //29758431
        input = 230241; //230412
        input = 2147483486; //-2147483450
        input = 2147483476; //2147483647
        System.out.println(nextGreaterElement(input));
    }
    @Test
    public void testing1(){
        System.out.println(Integer.MAX_VALUE);
    }
}
