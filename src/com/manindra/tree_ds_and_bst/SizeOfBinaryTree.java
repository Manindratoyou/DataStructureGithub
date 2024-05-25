package com.manindra.tree_ds_and_bst;

public class SizeOfBinaryTree {

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
        System.out.println(size(root));

    }

    static int size(Node root) {
        if (root == null)
            return 0;
        else
            return 1 + size(root.left) + size(root.right);
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
