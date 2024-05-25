package com.manindra.tree_ds_and_bst;

/*
A complete binary tree is a special type of binary tree where all the levels of the tree are filled
completely except the lowest level nodes which are filled from as left as possible.
 */
public class CountNodesInCompleteBinaryTree {

    public static void main(String[] args) {
        /*
        1
       / \
      2   3
     / \ /
    4  5 6

         */
        // Creating a sample complete binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        // Testing countNodes method
        int count1 = countNodes(root);
        System.out.println("Number of nodes using countNodes method: " + count1);

        // Testing countNodesSolutionTwo method
        int count2 = countNodesSolutionTwo(root);
        System.out.println("Number of nodes using countNodesSolutionTwo method: " + count2);
    }


    static int countNodes(Node root) { //tc 0(n) works for every tree
        if (root == null)
            return 0;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }

    static int countNodesSolutionTwo(Node root) {
        int leftHeight = 0, rightHeight = 0;
        Node current = root;
        while (current != null) {
            leftHeight++;
            current = current.left;
        }
        current = root;
        while (current != null) {
            rightHeight++;
            current = current.right;
        }
        if (leftHeight == rightHeight)
            return (int) (Math.pow(2, leftHeight) - 1);
        return 1 + countNodesSolutionTwo(root.left) + countNodesSolutionTwo(root.right);
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
