package com.manindra.binary_tree_ds;

/*
A binary search tree (BST) is a binary tree where every node in the left subtree is less than the root,
and every node in the right subtree is of a value greater than the root
 */
public class SearchIn_BinarySearchTree {

    public static void main(String[] args) {
        // Create a sample Binary Search Tree
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(20);

        // Test the search function
        int keyToSearch = 7;
        //boolean isKeyPresent = search(root, keyToSearch);
        boolean isKeyPresent = searchIterative(root, keyToSearch);
        System.out.println("Is key " + keyToSearch + " present in the BST? " + isKeyPresent);
    }

    static boolean search(Node root, int key) { //recursive approach
        if (root == null)
            return false;
        else if (root.key == key) {
            return true;
        } else if (root.key < key) {
            return search(root.right, key);
        } else
            return search(root.left, key);
    }

    static boolean searchIterative(Node root, int key) {
        while (root!=null){
            if (root.key==key)
                return true;
            else if (root.key<key) {
                root=root.right;
            }else
                root=root.left;
        }
        return false;
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
