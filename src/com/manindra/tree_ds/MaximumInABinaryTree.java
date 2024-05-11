package com.manindra.tree_ds;

public class MaximumInABinaryTree {

    public static void main(String[] args) {

        /*
         10
        /  \
      20    30
     / \     \
   40   50    70

         */

        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right = new Node(30);
        root.right.right = new Node(70);
        System.out.println(getMax(root));

    }

    static int getMax(Node root){
        if (root==null)
            return Integer.MIN_VALUE;
        else
            return Math.max(root.key, Math.max(getMax(root.left),getMax(root.right)));
    }


    static class Node {

        int key;
        Node left;
        Node right;

        Node(int k) {
            key = k;
            left = right = null;
        }
    }
}
