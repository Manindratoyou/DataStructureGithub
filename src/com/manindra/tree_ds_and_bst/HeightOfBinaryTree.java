package com.manindra.tree_ds_and_bst;

public class HeightOfBinaryTree {

    public static void main(String[] args) {

        /*
         10
        /  \
      20    30
           / \
         40   50

         */

        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        System.out.println(height(root));

    }

    static int height(Node root) {
        if (root == null)
            return 0;
        else
            return Math.max(height(root.left), height(root.right)) + 1;
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
