package com.sumit.ds.leetcode.apr2023;

import com.sumit.ds.random.BuildBinaryTree;
import com.sumit.ds.random.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class LeetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode node) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        int level = 0;
        boolean flag = false;
        if(node != null){
            list.add(node);
            while(!list.isEmpty()){
                List<Integer> dataAtLevel = new ArrayList<>();
                for(int i=0;i<Math.pow(2,level) && !list.isEmpty();i++){
                    TreeNode curr = list.remove(0);
                    if(curr != null) {
                        dataAtLevel.add(curr.val);
                        list.add(curr.left);
                        list.add(curr.right);
                    }
                }
                level++;
                if(flag){
                   Collections.reverse(dataAtLevel);
                }
                flag = !flag;
                result.add(dataAtLevel);
            }
        }
        return result;
    }

    @Test
    public void test(){
//        int [] input = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int [] input = {1,2,-1,3,-1,4,-1,5};
        BuildBinaryTree buildBinaryTree = new BuildBinaryTree();
        TreeNode root = buildBinaryTree.buildTree(input);
        buildBinaryTree.preOrderTraversal(root);

        System.out.println(zigzagLevelOrder(root));

    }
}
