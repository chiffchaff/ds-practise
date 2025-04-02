package com.sumit.ds.random;


import java.util.LinkedList;
import java.util.Queue;

public class BTreeBFS {


    public static void main(String[] args) {
        BTreeBFS.TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);

        System.out.print("Inorder Traversal :");
        inOrderTraversal(treeNode);

        System.out.print("\nPreorder Traversal :");
        preOrderTraversal(treeNode);

        System.out.print("\nPostOrder Traversal :");
        postOrderTraversal(treeNode);

        System.out.print("\nBFS Traversal :");
        BFSTraversal(treeNode);
    }

    private static void BFSTraversal(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(treeNode != null){
            queue.offer(treeNode);
        }
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.value+" ");
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);

        }
    }

    private static void postOrderTraversal(TreeNode treeNode) {
        if(treeNode == null)
            return;
        postOrderTraversal(treeNode.left);
        postOrderTraversal(treeNode.right);
        System.out.print(treeNode.value+" ");
    }

    private static void preOrderTraversal(TreeNode treeNode) {
        if(treeNode == null)
            return;
        System.out.print(treeNode.value+ " ");
        preOrderTraversal(treeNode.left);
        preOrderTraversal(treeNode.right);
    }

    private static void inOrderTraversal(TreeNode treeNode) {
        if(treeNode == null)
            return;
        inOrderTraversal(treeNode.left);
        System.out.print(treeNode.value+ " ");
        inOrderTraversal(treeNode.right);
    }



    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value){
            this.value = value;
        }
    }

}

