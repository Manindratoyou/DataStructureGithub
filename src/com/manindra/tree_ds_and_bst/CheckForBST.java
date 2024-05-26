package com.manindra.tree_ds_and_bst;

public class CheckForBST { //In Order Traversal of Binary Search Tree is always sorted.

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(1);
        root.left.right = new Node(8);
        root.right.left = new Node(15);
        root.right.right = new Node(25);

        // Checking if the created tree is a BST
        //if (isBST(root)) {
        //if (isBSTSolutionTwo(root,Integer.MIN_VALUE,Integer.MAX_VALUE)) {
        if (isBSTSolutionThree(root)) {
            System.out.println("The tree is a BST.");
        } else {
            System.out.println("The tree is not a BST.");
        }
    }

    static int maxValue(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int result = node.key;
        int leftResult = maxValue(node.left);
        int rightResult = maxValue(node.right);
        if (leftResult > result) {
            result = leftResult;
        }
        if (rightResult > result) {
            result = rightResult;
        }
        return result;
    }

    static int minValue(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        int result = node.key;
        int leftResult = minValue(node.left);
        int rightResult = minValue(node.right);
        if (leftResult < result) {
            result = leftResult;
        }
        if (rightResult < result) {
            result = rightResult;
        }
        return result;
    }

    static boolean isBST(Node node) {
        if (node == null) {
            return true;
        }
        if (node.left != null && maxValue(node.left) > node.key) {
            return false;
        }
        if (node.right != null && minValue(node.right) < node.key) {
            return false;
        }
        if (!isBST(node.left) || !isBST(node.right)) {
            return false;
        }
        return true;
    }

    static boolean isBSTSolutionTwo(Node root ,int min,int max) {
        if (root==null)
            return true;
        return
                (root.key >min && root.key<max
                        &&isBSTSolutionTwo(root.left,min, root.key)
                        && isBSTSolutionTwo(root.right,root.key,max));
    }
    static int previous=Integer.MIN_VALUE;
    static boolean isBSTSolutionThree(Node root) {

        if (root==null) {
            return true;
        }
        if (isBSTSolutionThree(root.left)==false)
            return false;
        if (root.key<=previous)
            return false;
        previous= root.key;

        return isBSTSolutionThree(root.right);
    }

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }
}
