package com.sumit.test;

import java.util.*;

public class TraverseTree {

    public static void printTraversal(Node node){
        if(node == null)
            return;

        Queue<Node> nodeValueQueue = new LinkedList<>();
        Queue<Integer> nodeLevel = new LinkedList<>();

        Map<Integer, List<Integer>> res = new HashMap<>();

        // Traverse the tree
        nodeValueQueue.add(node);
        nodeLevel.add(0);

        while(!nodeValueQueue.isEmpty()){
           Node temp= nodeValueQueue.poll();
           int nodeLevelVal = nodeLevel.poll();
           if(temp.left != null) {
               nodeValueQueue.add(temp.left);
               nodeLevel.add(nodeLevelVal-1);
           }

            if(temp.right != null) {
                nodeValueQueue.add(temp.right);
                nodeLevel.add(nodeLevelVal+1);
            }


            if(res.containsKey(nodeLevelVal)){
                List<Integer> nodeLevelList = res.get(nodeLevelVal);
                nodeLevelList.add(temp.value);
                res.put(nodeLevelVal,nodeLevelList);
            }
            else{
                res.put(nodeLevelVal,Arrays.asList(temp.value));
            }

        }
        System.out.println(res);

    }



    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(4);
        node.left.right = new Node(5);

        node.right.left = new Node(6);
        node.right.right = new Node(7);

        node.left.left.left = new Node(8);
        node.left.left.right = new Node(9);

        node.right.right.left = new Node(10);
        node.right.right.right = new Node(11);

        printTraversal(node);
    }

}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }
}
