package com.manindra.tree_ds;

public class FloorIn_BinarySearchTree {

    public static void main(String[] args) {

        /*
         15
        /  \
      10    20
     / \   /  \
    8  12 17  25

         */
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(17);
        root.right.right = new Node(25);

        int x = 13;
        Node floorNode = floor(root, x);

        if (floorNode != null) {
            System.out.println("Floor value of " + x + " is: " + floorNode.key);
        } else {
            System.out.println("Floor value of " + x + " does not exist in the BST");
        }
    }

    static Node floor(Node root, int x) {
        Node result = null;
        while (root != null) {
            if (root.key == x)
                return root;
            else if (root.key > x) {
                root = root.left;
            } else {
                result = root;
                root = root.right;
            }
        }
        return result;
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
