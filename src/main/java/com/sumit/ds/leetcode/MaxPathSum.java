package com.sumit.ds.leetcode;

import com.sumit.ds.random.TreeNode;
import org.junit.Test;

/**
 * LeetCode 124
 */
public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{Integer.MIN_VALUE};
        return maxPathSumH(root,result);
    }

    public int maxPathSumH(TreeNode node, int[] result){
        if(node == null){
            return result[0];
        }
        int left = maxPathSumH(node.left,result);
        int right = maxPathSumH(node.right,result);
        int ms = Math.max(Math.max(left,right)+node.val,node.val);
        int mlr = Math.max(ms,left+right+node.val);
        result[0] = Math.max(mlr,result[0]);
        return ms;
    }

    @Test
    public void testing(){
        TreeNode node = new TreeNode(1);
        node.left=new TreeNode(2);
        node.right = new TreeNode(3);
        System.out.println(maxPathSum(node));
    }

    @Test
    public void testing1(){
        //[-10,9,20,null,null,15,7]
        TreeNode node = new TreeNode(-10);
        node.left=new TreeNode(9);
        node.right=new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(maxPathSum(node));


    }
}
