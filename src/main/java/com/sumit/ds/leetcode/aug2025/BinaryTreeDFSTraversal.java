package com.sumit.ds.leetcode.aug2025;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}
public class BinaryTreeDFSTraversal {

    List<Integer> res = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public void inorder(TreeNode r){
        if(r == null)
            return;
        inorder(r.left);
        res.add(r.val);
        inorder(r.right);
    }

    public void preorder(TreeNode r){
        if(r == null)
            return;
        res.add(r.val);
        preorder(r.left);
        preorder(r.right);
    }

    public void postorder(TreeNode r){
        if(r == null)
            return;
        postorder(r.left);
        postorder(r.right);
        res.add(r.val);
    }

    public void bfsTraversalIterative(TreeNode r){
        result = new ArrayList<>();
        if(r == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(r);
        int level=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                if(i==0) result.add(new ArrayList<>());
                TreeNode temp = q.poll();
                result.get(level).add(temp.val);
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            level++;
        }
    }

    public void bfsTraversalIterative1(TreeNode r){
        result = new ArrayList<>();
        if(r == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(r);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                levelList.add(temp.val);
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            result.add(levelList);
        }
    }


    public void bfsTraversalRecurse(TreeNode r){
        result = new ArrayList<>();
        bfsRecurse(r,0,result);
    }

    public void bfsRecurse(TreeNode r,int level,List<List<Integer>> result){
        if(r == null)
            return;
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(r.val);

        bfsRecurse(r.left,level+1,result);
        bfsRecurse(r.right,level+1,result);
    }

    /**
     *              1
     *             / \
     *            2   3
     *           / \ / \
     *          4  5 6  7
     * @return
     */
    private TreeNode createTree() {
        TreeNode r = new TreeNode(1);
        r.left=new TreeNode(2);
        r.right = new TreeNode(3);
        r.left.left = new TreeNode(4);
        r.left.right = new TreeNode(5);
        r.right.left = new TreeNode(6);
        r.right.right = new TreeNode(7);
        return r;
    }

    /**
     *              1
     *             / \
     *            2   3
     *           / \ / \
     *          4  5 6  7
     * @return
     */
    private TreeNode createTree1() {
        TreeNode r = new TreeNode(1);
        r.left=new TreeNode(2);
        r.right = new TreeNode(3);
        r.left.right = new TreeNode(4);
        r.left.right.left = new TreeNode(5);
        return r;
    }

    @Test
    public void testing(){
        TreeNode r = createTree();

        // Test Inorder Traversal (L V R)
        res.clear();
        this.inorder(r);
        Assert.assertArrayEquals(new int[]{4,2,5,1,6,3,7},res.stream().mapToInt(Integer::intValue).toArray());

        // Test PreOrder Traversal (V L R) - Myself(v) then my children (L,R)
        res.clear();
        this.preorder(r);
        Assert.assertArrayEquals(new int[]{1,2,4,5,3,6,7},res.stream().mapToInt(Integer::intValue).toArray());

        // Test PostOrder Traversal - my children(L,R) then myself(v)
        res.clear();
        this.postorder(r);
        Assert.assertArrayEquals(new int[]{4,5,2,6,7,3,1},res.stream().mapToInt(Integer::intValue).toArray());


        // Test Inorder Traversal Iterative (L V R)
        res.clear();
        this.inorderIterative(r);
        Assert.assertArrayEquals(new int[]{4,2,5,1,6,3,7},res.stream().mapToInt(Integer::intValue).toArray());

        // Test PreOrder Traversal Iterative (V L R) - Myself(v) then my children (L,R)
        res.clear();
        this.preorderIterative(r);
        Assert.assertArrayEquals(new int[]{1,2,4,5,3,6,7},res.stream().mapToInt(Integer::intValue).toArray());

        // Test PostOrder Traversal Iterative - my children(L,R) then myself(v)
        res.clear();
        this.postorderIterative(r);
        Assert.assertArrayEquals(new int[]{4,5,2,6,7,3,1},res.stream().mapToInt(Integer::intValue).toArray());


        // Test BSF Traversal Recursive
        result.clear();
        int[][] expected = {{1}, {2, 3}, {4, 5, 6, 7}};

        this.bfsTraversalRecurse(r);
        int[][] actual = result.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        Assert.assertArrayEquals(expected, actual);



        // Test BSF Traversal Iterative
        result.clear();
        this.bfsTraversalIterative(r);
        actual = result.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        Assert.assertArrayEquals(expected, actual);

        // Test BSF Traversal Iterative
        result.clear();
        this.bfsTraversalIterative1(r);
        actual = result.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        Assert.assertArrayEquals(expected, actual);


    }

    @Test
    public void testing1(){
        TreeNode r = createTree1();
        res.clear();
        postorder(r);
        System.out.println(res);

        res.clear();
        postorderIterative(r);
        System.out.println(res);
    }

    private void inorderIterative1(TreeNode r) {
        if(r == null)
            return;
        Stack <TreeNode> st = new Stack<>();
        while(r != null || !st.isEmpty()){
            st.push(r);
            while(r.left != null){
                r = r.left;
                st.push(r);
            }
            st.pop();
            res.add(r.val);
            if(r.right != null){
                r =r.right;
                st.push(r);
            }
        }
    }

    private void inorderIterative(TreeNode r) {
        Stack <TreeNode> st = new Stack<>();
        while(r != null || !st.isEmpty()){
            // Go to the leftmost node
            while (r != null) {
                st.push(r);
                r = r.left;
            }
            // Pop and process
            r = st.pop();
            res.add(r.val);

            // Visit right subtree
            r = r.right;
        }
    }

    // LRV

    /**
     * Solution is to use two stacks
     * Use stack 1 (st1) to traverse the tree using iterative preorder traversal
     * In the visit step (processing - _V_LR), push the stack1 popped node from stack 1 to stack 2.
     * Finally, reverse of stack2 values is the post order traversal
     * @param r
     */
    private void postorderIterative(TreeNode r) {
        if(r == null) return;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(r);
        while(!st1.isEmpty()){
            TreeNode temp = st1.pop();
            st2.push(temp);

            if(temp.left!= null) st1.push(temp.left);
            if(temp.right!= null) st1.push(temp.right);
        }

        while(!st2.isEmpty()){
            res.add(st2.pop().val);
        }
    }

    // VLR
    private void preorderIterative(TreeNode r) {
        Stack<TreeNode> st = new Stack<>();
        while(r != null || !st.isEmpty()){
            while(r !=null){
                res.add(r.val);
                st.push(r);
                r=r.left;
            }
            TreeNode tmp = st.pop();
            r=tmp.right;
        }
    }

}
