package com.manindra.binary_tree_ds;

public class Insert_In_BinarySearchTree {

    public static void main(String[] args) {
        // Create an empty Binary Search Tree
        Node root = null;

        // Test recursive insertion
        root = insert(root, 10);
        insert(root, 5);
        insert(root, 15);
        insert(root, 3);
        insert(root, 7);
        insert(root, 12);
        insert(root, 20);
        System.out.println("In-order traversal after recursive insertion:");
        inOrderTraversal(root);

        // Create another empty Binary Search Tree for iterative insertion
        Node rootIterative = null;

        // Test iterative insertion
        rootIterative = insertIterative(rootIterative, 10);
        insertIterative(rootIterative, 5);
        insertIterative(rootIterative, 15);
        insertIterative(rootIterative, 3);
        insertIterative(rootIterative, 7);
        insertIterative(rootIterative, 12);
        insertIterative(rootIterative, 20);
        System.out.println("\nIn-order traversal after iterative insertion:");
        inOrderTraversal(rootIterative);
    }

    static Node insert(Node root, int key) { //recursive
        if (root == null)
            return new Node(key);
        if (root.key > key)
            root.left = insert(root.left, key);
        else if (root.key < key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    static Node insertIterative(Node root, int key) {
        Node temp = new Node(key);
        Node parent = null, current = root;
        while (current != null) {
            parent = current;
            if (current.key > key)
                current = current.left;
            else if (current.key < key) {
                current = current.right;
            } else
                return root;
        }
        if (parent == null)
            return temp;
        if (parent.key > key)
            parent.left = temp;
        else
            parent.right = temp;
        return root;
    }

    static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.key + " ");
            inOrderTraversal(root.right);
        }
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
