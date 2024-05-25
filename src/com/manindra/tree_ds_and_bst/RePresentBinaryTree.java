package com.manindra.tree_ds_and_bst;

public class RePresentBinaryTree {

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
        root.left.left = new Node(40);

        // Print the binary tree
        System.out.println("Binary Tree Representation:");
        printBinaryTree(root);
    }

    // Method to print binary tree
    static void printBinaryTree(Node node) {
        if (node == null)
            return;

        // Print the node value
        System.out.print(node.key + " ");

        // Recursively print left and right subtrees
        printBinaryTree(node.left);
        printBinaryTree(node.right);
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
