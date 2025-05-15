package com.manindra.tree_ds_and_bst;

public class RedBlackTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    class Node {
        int key;
        Node left, right, parent;
        boolean color;

        Node(int key) {
            this.key = key;
            this.color = RED;
        }
    }

    private Node root;

    // Left Rotate
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != null)
            y.left.parent = x;

        y.parent = x.parent;

        if (x.parent == null)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    // Right Rotate
    private void rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;

        if (x.right != null)
            x.right.parent = y;

        x.parent = y.parent;

        if (y.parent == null)
            root = x;
        else if (y == y.parent.right)
            y.parent.right = x;
        else
            y.parent.left = x;

        x.right = y;
        y.parent = x;
    }

    // Insert a new key
    public void insert(int key) {
        Node node = new Node(key);
        Node y = null;
        Node x = root;

        // Standard BST insertion
        while (x != null) {
            y = x;
            if (node.key < x.key)
                x = x.left;
            else
                x = x.right;
        }

        node.parent = y;
        if (y == null)
            root = node;
        else if (node.key < y.key)
            y.left = node;
        else
            y.right = node;

        // Fix Red-Black Tree
        insertFixup(node);
    }

    // Fix violations after insertion
    private void insertFixup(Node z) {
        while (z.parent != null && z.parent.color == RED) {
            if (z.parent == z.parent.parent.left) {
                Node y = z.parent.parent.right; // Uncle
                if (y != null && y.color == RED) {
                    // Case 1: Uncle is RED
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = RED;
                    z = z.parent.parent;
                } else {
                    // Case 2: Uncle is BLACK
                    if (z == z.parent.right) {
                        z = z.parent;
                        leftRotate(z);
                    }
                    // Case 3
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    rightRotate(z.parent.parent);
                }
            } else {
                Node y = z.parent.parent.left; // Uncle
                if (y != null && y.color == RED) {
                    // Case 1
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = RED;
                    z = z.parent.parent;
                } else {
                    // Case 2
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                    }
                    // Case 3
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    leftRotate(z.parent.parent);
                }
            }
        }
        root.color = BLACK;
    }

    // Inorder traversal
    public void inorder() {
        inorderHelper(root);
        System.out.println();
    }

    private void inorderHelper(Node node) {
        if (node != null) {
            inorderHelper(node.left);
            System.out.print("(" + node.key + ", " + (node.color == RED ? "R" : "B") + ") ");
            inorderHelper(node.right);
        }
    }

    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();

        int[] values = {10, 20, 30, 15, 25, 5, 1};
        for (int val : values) {
            rbt.insert(val);
            System.out.print("Inorder after inserting " + val + ": ");
            rbt.inorder();
        }
    }
}

