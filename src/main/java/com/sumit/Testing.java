package com.sumit;

public class Testing {


    /**
     * Given a binary tree, write a function to check if it's a valid Binary Search Tree.
     *
     *     4
     *
     *   2   6
     *
     */

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left=new Node(2);
        root.right=new Node(5);
        Testing testing = new Testing();
        System.out.println(testing.isValidBST(root));
    }


    public boolean isValidBST(Node root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(Node node, long min, long max) {
        if (node == null) return true;
        if (node.value <= min || node.value >= max) return false; // Check bounds

        return validate(node.left, min, node.value) && validate(node.right, node.value, max);
    }



}


class Node {
    Node left;
    Node right;
    int value;

    public Node(int value) {
        this.value=value;
    }
}