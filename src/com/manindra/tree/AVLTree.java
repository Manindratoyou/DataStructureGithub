package com.manindra.tree;

class AVLTree {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Test insertion
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.println("In-order traversal after insertion:");
        tree.inOrder(); // Expected: 10 20 25 30 40 50

        // Test deletion
        tree.delete(40);
        System.out.println("In-order traversal after deletion of 40:");
        tree.inOrder(); // Expected: 10 20 25 30 50

        // Test search
        System.out.println("Search 25: " + tree.search(25)); // Expected: true
        System.out.println("Search 40: " + tree.search(40)); // Expected: false
    }

    // Node class to represent elements of the tree
    static class Node {
        int key;       // Value of the node
        int height;    // Height of the node
        Node left;     // Left child
        Node right;    // Right child

        Node(int key) {
            this.key = key;
            this.height = 1; // New node is initially at height 1
        }
    }

    private Node root; // Root of the AVL tree

    // Helper function to get the height of a node
    private int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    // Helper function to calculate the balance factor of a node
    private int getBalanceFactor(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    // Right rotation (RR case)
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotation (LL case)
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Insert a key into the AVL tree
    public void insert(int key) {
        root = insertNode(root, key);
    }

    private Node insertNode(Node node, int key) {
        // Perform normal BST insertion
        if (node == null) return new Node(key);

        if (key < node.key)
            node.left = insertNode(node.left, key);
        else if (key > node.key)
            node.right = insertNode(node.right, key);
        else
            return node; // Duplicates not allowed

        // Update height of the current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get balance factor to check if the node is unbalanced
        int balance = getBalanceFactor(node);

        // Four cases to handle imbalance
        // Left Left (LL) Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right (RR) Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right (LR) Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left (RL) Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node; // Return the unchanged node pointer
    }

    // Delete a key from the AVL tree
    public void delete(int key) {
        root = deleteNode(root, key);
    }

    private Node deleteNode(Node root, int key) {
        // Perform normal BST deletion
        if (root == null) return root;

        if (key < root.key)
            root.left = deleteNode(root.left, key);
        else if (key > root.key)
            root.right = deleteNode(root.right, key);
        else {
            // Node with one or no child
            if ((root.left == null) || (root.right == null)) {
                Node temp = (root.left != null) ? root.left : root.right;

                // No child case
                if (temp == null) {
                    root = null;
                } else { // One child case
                    root = temp;
                }
            } else {
                // Node with two children: Get the inorder successor (smallest in right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's value to this node
                root.key = temp.key;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.key);
            }
        }

        // If the tree had only one node
        if (root == null) return root;

        // Update height of the current node
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get balance factor
        int balance = getBalanceFactor(root);

        // Four cases to handle imbalance
        // Left Left (LL) Case
        if (balance > 1 && getBalanceFactor(root.left) >= 0)
            return rightRotate(root);

        // Left Right (LR) Case
        if (balance > 1 && getBalanceFactor(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right (RR) Case
        if (balance < -1 && getBalanceFactor(root.right) <= 0)
            return leftRotate(root);

        // Right Left (RL) Case
        if (balance < -1 && getBalanceFactor(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Search a key in the AVL tree
    public boolean search(int key) {
        return searchNode(root, key) != null;
    }

    private Node searchNode(Node node, int key) {
        if (node == null || node.key == key)
            return node;

        if (key < node.key)
            return searchNode(node.left, key);

        return searchNode(node.right, key);
    }

    // In-order traversal to print the AVL tree
    public void inOrder() {
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.key + " ");
            inOrderTraversal(node.right);
        }
    }

}

