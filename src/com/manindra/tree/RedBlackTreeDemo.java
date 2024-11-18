package com.manindra.tree;

class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    class Node {
        int data;
        Node left, right, parent;
        boolean color; // RED or BLACK

        public Node(int data) {
            this.data = data;
            this.color = RED; // New nodes are always red
        }
    }

    private Node root;

    // Left Rotation
    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != null) y.left.parent = x;

        y.parent = x.parent;

        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;
    }

    // Right Rotation
    private void rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;

        if (x.right != null) x.right.parent = y;

        x.parent = y.parent;

        if (y.parent == null) {
            root = x;
        } else if (y == y.parent.left) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }

        x.right = y;
        y.parent = x;
    }

    // Insert a node
    public void insert(int data) {
        Node node = new Node(data);
        root = bstInsert(root, node);
        fixInsert(node);
    }

    // Regular BST Insert
    private Node bstInsert(Node root, Node node) {
        if (root == null) return node;

        if (node.data < root.data) {
            root.left = bstInsert(root.left, node);
            root.left.parent = root;
        } else if (node.data > root.data) {
            root.right = bstInsert(root.right, node);
            root.right.parent = root;
        }
        return root;
    }

    // Fix violations after insertion
    private void fixInsert(Node node) {
        Node parent = null, grandparent = null;

        while (node != root && node.color == RED && node.parent.color == RED) {
            parent = node.parent;
            grandparent = parent.parent;

            // Parent is the left child of grandparent
            if (parent == grandparent.left) {
                Node uncle = grandparent.right;

                if (uncle != null && uncle.color == RED) {
                    grandparent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandparent;
                } else {
                    if (node == parent.right) {
                        rotateLeft(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    rotateRight(grandparent);
                    boolean temp = parent.color;
                    parent.color = grandparent.color;
                    grandparent.color = temp;
                    node = parent;
                }
            } else { // Parent is the right child of grandparent
                Node uncle = grandparent.left;

                if (uncle != null && uncle.color == RED) {
                    grandparent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandparent;
                } else {
                    if (node == parent.left) {
                        rotateRight(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    rotateLeft(grandparent);
                    boolean temp = parent.color;
                    parent.color = grandparent.color;
                    grandparent.color = temp;
                    node = parent;
                }
            }
        }
        root.color = BLACK; // Root must always be black
    }

    // Print the tree (In-Order Traversal)
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public Node getRoot() {
        return root;
    }
}

// Driver Code
public class RedBlackTreeDemo {

    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        rbt.insert(10);
        rbt.insert(20);
        rbt.insert(30);
        rbt.insert(15);
        rbt.insert(25);

        System.out.println("In-Order Traversal of Red-Black Tree:");
        rbt.inOrder(rbt.getRoot());
    }
}

