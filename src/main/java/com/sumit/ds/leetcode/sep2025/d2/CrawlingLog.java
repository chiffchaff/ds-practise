package com.sumit.ds.leetcode.sep2025.d2;

import org.junit.Assert;
import org.junit.Test;
import java.util.Stack;

/**
 * https://leetcode.com/problems/crawler-log-folder/description/
 */
public class CrawlingLog {

    /**
     * TC = O(n)
     * SC = O(n)
     * @param logs
     * @return
     */
    public int minOperations(String[] logs) {
        Stack<Integer> stack = new Stack();
        stack.push(0);// root folder can always be reached within 0 steps
        for(int i=0;i<logs.length;i++){
            String log = logs[i];
            if("../".equals(log)){
                if(stack.peek() > 0) {
                    stack.pop();
                }
            }
            else if("./".equals(log)){
                //Do Nothing
            }
            else{
                stack.push(stack.peek()+1); //go to child folder
            }
        }
        return stack.peek();
    }

    /**
     * TC = O(n)
     * SC = O(1)
     * @param logs
     * @return
     */
    public int minOperations1(String[] logs) {
        int count = 0;// root folder can always be reached within 0 steps
        for(int i=0;i<logs.length;i++){
            String log = logs[i];
            if("../".equals(log)){
                if(count > 0) {
                    count--;
                }
            }
            else if("./".equals(log)){
                //Do Nothing
            }
            else{
                count++; //go to child folder
            }
        }
        return count;
    }



    @Test
    public void testing(){
        CrawlingLog cl = new CrawlingLog();
        Assert.assertEquals(2,cl.minOperations(new String[]{"d1/","d2/","../","d21/","./"}));
        Assert.assertEquals(3,cl.minOperations(new String[]{"d1/","d2/","./","d3/","../","d31/"}));
        Assert.assertEquals(0,cl.minOperations(new String[]{"d1/","../","../","../"}));
        Assert.assertEquals(0,cl.minOperations(new String[]{"d1/","../","../","../"}));
        Assert.assertEquals(0,cl.minOperations(new String[]{"./","../","./"}));


        Assert.assertEquals(2,cl.minOperations1(new String[]{"d1/","d2/","../","d21/","./"}));
        Assert.assertEquals(3,cl.minOperations1(new String[]{"d1/","d2/","./","d3/","../","d31/"}));
        Assert.assertEquals(0,cl.minOperations1(new String[]{"d1/","../","../","../"}));
        Assert.assertEquals(0,cl.minOperations1(new String[]{"d1/","../","../","../"}));
        Assert.assertEquals(0,cl.minOperations1(new String[]{"./","../","./"}));
    }
}
