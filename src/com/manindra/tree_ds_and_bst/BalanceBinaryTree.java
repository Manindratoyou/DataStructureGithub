package com.manindra.tree_ds_and_bst;

public class BalanceBinaryTree {

     /*
    A balanced binary tree is a binary tree in which the heights of the two subtrees of any node never
    differ by more than one
     */

    public static void main(String[] args) {
        // Constructing a balanced binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        /*
       1
     /   \
    2     3
   / \   / \
  4   5 6   7

         */

        // Testing the naive approach
        System.out.println("Naive approach: " + isBalanced(root));

        // Testing the optimized approach
        System.out.println("Optimized approach: " + (isBalancedSolutionTwo(root) != -1));
    }

    static boolean isBalanced(Node root) { //tc O(n^2)
        if (root == null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    static int height(Node root) {
        if (root == null)
            return 0;
        else
            return 1 + Math.max(height(root.left), height(root.right));
    }

    static int isBalancedSolutionTwo(Node root) { //tc O(n)

        if (root == null)
            return 0;
        int leftHeight = isBalancedSolutionTwo(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = isBalancedSolutionTwo(root.right);
        if (rightHeight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) + 1;
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
