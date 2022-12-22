package org.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

    public static void main(String[] args){

        Node node;
        Node root = null;

        int[] values =  new int[]{44,17,8,32,28,29,88,65,54,82,76,80,97,93};

        for (int i :values) {
            node = BinarySearchTree.insert(root,values[i]);
            root = node;
        }

        breadthFirstSearch(root);
        root = depthFirstSearch(root);

        System.out.println(root
        );


    }

    /* Print nodes in level order traversal */
    public static void breadthFirstSearch(Node root){

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

             Node node = queue.poll();
             System.out.print(" "+node.value);

             if(node.right != null) {
                 queue.add(node.right);
             }
             if(node.left != null){
                 queue.add(node.left);
             }
        }

    }

    public static Node depthFirstSearch(Node root){

        if(root == null){
            return null;
        }

        /* For Pre-Order  traversal */
        //System.out.print(" "+root.value);
        if(root.left != null) {
            depthFirstSearch(root.left);
        }

        /* For In-Order traversal */
        //System.out.print(" "+root.value);
        if(root.right != null) {
            depthFirstSearch(root.right);
        }

        /* For Post-Order traversal */
        System.out.print(" "+root.value);

        return  root;
    }

}
