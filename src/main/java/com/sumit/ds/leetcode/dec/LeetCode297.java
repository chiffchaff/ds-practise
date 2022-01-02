package com.sumit.ds.leetcode.dec;


import org.junit.Test;

public class LeetCode297 {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder stringBuilder = new StringBuilder();

            return stringBuilder.toString();

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] tokens = data.split(",");
            TreeNode root = null;
            if(tokens.length>0){
                root = new TreeNode(Integer.valueOf(tokens[0]));
                TreeNode node = root;
                /**
                 * The number of nodes is equal to 2^𝑘−1 where 𝑘≥1. So the minimum level is 1, not 0.
                 *
                 * Thus the example is correct because it has 2 levels of depth: 2^2−1=3
                 */
                int i = 1;
                while(i<tokens.length){
                    node.left = new TreeNode(Integer.valueOf(tokens[i++]));
                    node.right = new TreeNode(Integer.valueOf(tokens[i++]));
                }
            }


            return root;
        }

        @Test
        public void testing(){
            String test1 = "";
        }

}

 class TreeNode {
    int val;
    TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }