package org.trees;

public class Node {

    int value;
    Object payload;
    Node left;
    Node right;

    public Node(int value, Object payload, Node left, Node right) {
        this.value = value;
        this.payload = payload;
        this.left = left;
        this.right = right;
    }


}
