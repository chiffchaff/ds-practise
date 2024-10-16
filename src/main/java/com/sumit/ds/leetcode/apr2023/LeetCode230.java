package com.sumit.ds.leetcode.apr2023;
import com.sumit.ds.random.BuildBinaryTree;
import com.sumit.ds.random.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * Kth Smallest element in a BST
 */
public class LeetCode230 {

    //Using inorder traversal w/o recursion

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            count++;

            if (count == k) {
                return curr.val;
            }

            curr = curr.right;
        }

        return -1; // kth smallest element not found
    }

    //Implement using recursion
    public int kthSmallest1(TreeNode root, int k) {
        int[] count = new int[1];
        TreeNode result = kthSmallestHelper(root, k, count);
        return result.val;
    }

    private TreeNode kthSmallestHelper(TreeNode root, int k, int[] count) {
        if (root == null) {
            return null;
        }

        TreeNode left = kthSmallestHelper(root.left, k, count);

        if (left != null) {
            return left;
        }

        count[0]++;
        if (count[0] == k) {
            return root;
        }

        return kthSmallestHelper(root.right, k, count);
    }

    @Test
    public void testKthSmallest(){
        int []input ={1,2,3,4,5,6};
        BuildBinaryTree buildBinaryTree = new BuildBinaryTree();
        TreeNode root = buildBinaryTree.buildTree(input);
        int k =6;
        System.out.println(kthSmallest(root,k));
        System.out.println(kthSmallest1(root,k));
    }

}
