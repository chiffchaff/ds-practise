package com.sumit.ds.random;

import com.sumit.ds.leetcode.apr2023.LeetCode655;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class BuildBinaryTree {



    public TreeNode buildTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        return buildTreeHelper(arr,0);
    }

    private TreeNode buildTreeHelper(int[] arr,int idx) {
        if(idx >= arr.length || arr[idx] == -1){
            return null;
        }
        TreeNode root = new TreeNode(arr[idx]);
        root.left = buildTreeHelper(arr,2*idx+1);
        root.right = buildTreeHelper(arr,2*idx+2);
        return root;
    }

    /**
     * PreOrder Traversal without recursion
     * @param n
     */
    public void preOrderTraversal1(TreeNode n){
        if(n == null)
            return;
        Stack<TreeNode> st = new Stack<>();
        st.push(n);
        while(!st.isEmpty()){
            TreeNode n1 = st.pop();
            System.out.println(n1.val);

            if(n1.right != null){
                st.push(n1.right);
            }
            if (n1.left != null) {
                st.push(n1.left);
            }
        }
    }
    public void preOrderTraversal(TreeNode node){
        if(node == null)
            return ;
        System.out.println(node.val);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void postOrderTraversal1(TreeNode node){
        if(node == null)
            return;
        Stack<TreeNode> st = new Stack<>();
        st.push(node);
        while(!st.isEmpty()){
            TreeNode currNode = st.pop();
            if(currNode.right != null){
                st.push(currNode.right);
            }

        }

    }
    public void postOrderTraversal(TreeNode node){
        if(node == null)
            return ;
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
        System.out.println(node.val);
    }

    public void inOrderTraversal(TreeNode node){
        if(node == null)
            return ;
        preOrderTraversal(node.left);
        System.out.println(node.val);
        preOrderTraversal(node.right);
    }

    public int getHeight(TreeNode node){
        if(node == null)
            return 0;
        if(node.right == null && node.left == null)
            return 0;
        return 1+Math.max(getHeight(node.left),getHeight(node.right));
    }

    public List<List<String>> printArrayAsMatrix(TreeNode node){
        List<List<String>> ret = new ArrayList<>();
        if(node == null)
            return null;
        int height = getHeight(node);
        int totCol = (int)Math.pow(2,height+1)-1;

        // for each row
        int indx = (totCol - 1) / 2;
        String[] arr = new String[totCol];
        Arrays.fill(arr, "");
        arr[indx] = String.valueOf(node.val);
        ret.add(Arrays.asList(arr));
        fillList(node, height, totCol, 0, indx, ret);
        return ret;
    }

    private void fillList(TreeNode root, int height, int colCount, int parentRow, int parentCol, List<List<String>> ret) {
        if (root.left == null && root.right == null) {
            return;
        }
        int currentRow = parentRow + 1;
        if (ret.size() <= currentRow) {
            String[] arr = new String[colCount];
            Arrays.fill(arr, "");
            ret.add(Arrays.asList(arr));
        }
        List<String> curList = ret.get(currentRow);
        int leftChildCol = parentCol - (int) Math.pow(2, height - parentRow - 1);
        int rightChildCol = parentCol + (int) Math.pow(2, height - parentRow - 1);

        if (root.left != null) {
            curList.set(leftChildCol, String.valueOf(root.left.val));
            fillList(root.left, height, colCount, currentRow, leftChildCol, ret);
        }

        if (root.right != null) {
            curList.set(rightChildCol, String.valueOf(root.right.val));
            fillList(root.right, height, colCount, currentRow, rightChildCol, ret);
        }
    }

    @Test
    public void testBuildBTree(){
//        int []input = {1,2,3,4,5,6,-1};
        int []input = {1,2,3,4,-1};
        BuildBinaryTree bbt = new BuildBinaryTree();
        TreeNode root = bbt.buildTree(input);
        System.out.println(root);

        System.out.println("PreOrder Traversal");
        preOrderTraversal(root);

        System.out.println("Post Traversal");
        postOrderTraversal(root);

        System.out.println("InOrder Traversal");
        inOrderTraversal(root);

        System.out.println("Height of Tree:" + getHeight(root));

        System.out.println("Print Tree Node Matrix");
        System.out.println(printArrayAsMatrix(root));
    }
}
