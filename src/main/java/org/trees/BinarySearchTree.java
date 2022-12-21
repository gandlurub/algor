package org.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BinarySearchTree {

    public static void main(String args[]){

        Node node = null;
        Node root = null;

        int[] values =  new int[]{44,17,8,32,28,29,88,65,54,82,76,80,97,93};

        for (int i=0;i< values.length;i++){

             node = insert(root,values[i]);
                root = node;


        }

        System.out.println("Binary Search values are :: "+ Arrays.toString(values));

         node = search(root,97);
        if(node != null)
            System.out.println("value found :: "+node.value);
        else
            System.out.println("value found :: "+node);

         node = min(root);
        if(node != null)
            System.out.println("min value found :: "+node.value);

        node = max(root);
        if(node != null)
            System.out.println("min value found :: "+node.value);

        node = delete(root,32);
        System.out.println("Node deleted");

    }

    public static Node insert(Node root,int value){

        Node node = new Node(value,null,null,null);

        if(root == null){
            return node;
        }

        Node pre = null;
        Node current = root;
        while(current != null){

            if(current.value == value){
                System.out.println("Value exists :: "+ value);
                return root;
            } else if(current.value > value){
                pre = current;
                current = current.left;
            } else if(current.value < value){
                pre = current;
                current = current.right;
            }

        }

        if(pre.value > value){
            pre.left = node;
        } else if(pre.value < value) {
            pre.right = node;
        }


        return root;

        }


        public static Node search(Node root,int value){

          Node node = null;
          if(root == null){
              return null;
          }

          Node current = root;
          while(current != null){
              if(current.value == value){
                  return current;
              } else if(current.value > value){
                  current = current.left;
              } else if(current.value < value){
                  current = current.right;
              }
          }
        return null;
        }

       public static Node min(Node root){
        if(root == null){
            return null;
        }

        Node prev = null;
        Node current = root;

          while(current != null){
              prev = current;
              current = current.left;
          }
        return prev;
       }


       public static Node max(Node root){
        if(root == null){
            return null;
        }

        Node prev = null;
        Node current = root;

        while(current != null){
            prev = current;
            current = current.right;

        }
         return prev;
       }


       public static Node delete(Node root,int value){

          if (root == null){
              return root;
          }

          Node current = root;
          Node prev = null;
          while(current != null){

              if(current.value == value){
                  break;
              } else if(current.value < value){
                  prev = current;
                  current = current.right;
              } else if(current.value > value){
                  prev = current;
                  current = current.left;
              }

          }

         /* if node is a child node */
          if(current.left == null && current.right == null){
              if(prev.value < value){
                  prev.right = null;
              } else if (prev.value > value){
                  prev.left = null;
              }
          }

          /* if a node has one child node */
           Node child = null;
          if(current.left == null && current.right != null) {
                child = current.right;
          } else if(current.left != null && current.right == null){
              child = current.left;
          }

          if(prev.left == current){
              prev.left = child;
          } else if(prev.right == current){
              prev.right = child;
          }



          return root;
       }

}