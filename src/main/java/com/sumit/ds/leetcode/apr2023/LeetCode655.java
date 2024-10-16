package com.sumit.ds.leetcode.apr2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode655 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 0;
        }

        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
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


    public List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        int height = findHeight(root);
        int colCount = (int) Math.pow(2, height + 1) - 1;

        List<List<String>> ret = new ArrayList<>();

        // for each row
        int indx = (colCount - 1) / 2;
        String[] arr = new String[colCount];
        Arrays.fill(arr, "");

        arr[indx] = String.valueOf(root.val);
        ret.add(Arrays.asList(arr));
        fillList(root, height, colCount, 0, indx, ret);

        return ret;
    }
}


//    public List<List<String>> printTree(TreeNode root) {
//        // calculate the height of the tree
//        int height = getHeight(root);
//        // calculate the number of columns in the result array
//        int columns = (int) Math.pow(2, height) - 1;
//        // initialize the result array with empty strings
//        List<List<String>> result = new ArrayList<>();
//        for (int i = 0; i < height; i++) {
//            List<String> row = new ArrayList<>();
//            for (int j = 0; j < columns; j++) {
//                row.add("");
//            }
//            result.add(row);
//        }
//        // recursively fill in the values in the result array
//        fill(result, root, 0, 0, columns - 1);
//        return result;
//    }
//
//    // helper function to calculate the height of a binary tree
//    private int getHeight(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
//    }
//
//    // helper function to fill in the values in the result array
//    private void fill(List<List<String>> result, TreeNode node, int row, int left, int right) {
//        if (node == null) {
//            return;
//        }
//        // fill in the current node's value
//        int mid = (left + right) / 2;
//        result.get(row).set(mid, Integer.toString(node.val));
//        // fill in the left subtree
//        fill(result, node.left, row + 1, left, mid - 1);
//        // fill in the right subtree
//        fill(result, node.right, row + 1, mid + 1, right);
//    }
//
//
//}

/**
 *
 *     private int findHeight(TreeNode root) {
 *         if (root == null) {
 *             return 0;
 *         }
 *
 *         if (root.left == null && root.right == null) {
 *             return 0;
 *         }
 *
 *         return 1 + Math.max(findHeight(root.left), findHeight(root.right));
 *     }
 *
 *
 *     private void fillList(TreeNode root, int height, int colCount, int parentRow, int parentCol, List<List<String>> ret) {
 *         if (root.left == null && root.right == null) {
 *             return;
 *         }
 *
 *         int currentRow = parentRow + 1;
 *
 *         if (ret.size() <= currentRow) {
 *             String[] arr = new String[colCount];
 *             Arrays.fill(arr, "");
 *             ret.add(Arrays.asList(arr));
 *         }
 *
 *         List<String> curList = ret.get(currentRow);
 *         int leftChildCol = parentCol - (int)Math.pow(2, height-parentRow-1);
 *         int rightChildCol = parentCol + (int)Math.pow(2, height-parentRow-1);
 *
 *         if (root.left!= null) {
 *             curList.set(leftChildCol, String.valueOf(root.left.val));
 *             fillList(root.left, height, colCount, currentRow, leftChildCol, ret);
 *         }
 *
 *         if (root.right != null) {
 *             curList.set(rightChildCol, String.valueOf(root.right.val));
 *             fillList(root.right, height, colCount, currentRow, rightChildCol, ret);
 *         }
 *     }
 *
 *
 *     public List<List<String>> printTree(TreeNode root) {
 *         if (root == null) {
 *             return new ArrayList<>();
 *         }
 *
 *         int height = findHeight(root);
 *         int colCount = (int)Math.pow(2, height + 1) - 1;
 *
 *         List<List<String>> ret = new ArrayList<>();
 *
 *         // for each row
 *         int indx = (colCount-1)/2;
 *         String[] arr = new String[colCount];
 *         Arrays.fill(arr, "");
 *
 *         arr[indx] = String.valueOf(root.val);
 *         ret.add(Arrays.asList(arr));
 *         fillList(root, height, colCount, 0, indx, ret);
 *
 *         return ret;
 *     }
 *
 */