package com.manindra.tree;

import java.util.ArrayList;
import java.util.List;

class MWayTree {

    public static void main(String[] args) {
        MWayTree tree = new MWayTree(3); // Example: 3-Way Tree (M = 3)

        // Insert elements
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);
        tree.insert(30);
        tree.insert(7);
        tree.insert(17);

        // In-order traversal
        System.out.println("In-order traversal:");
        tree.inOrder();

        // Search for elements
        System.out.println("Search for 12: " + tree.search(12)); // Expected: true
        System.out.println("Search for 15: " + tree.search(15)); // Expected: false
    }

    static class Node {
        List<Integer> keys; // Keys in the node
        List<Node> children; // Children of the node
        boolean isLeaf; // Indicates whether the node is a leaf

        Node(boolean isLeaf) {
            this.keys = new ArrayList<>();
            this.children = new ArrayList<>();
            this.isLeaf = isLeaf;
        }
    }

    private Node root; // Root of the M-way tree
    private final int M; // Maximum number of children per node

    public MWayTree(int M) {
        if (M < 2) throw new IllegalArgumentException("M must be at least 2.");
        this.M = M;
        this.root = new Node(true); // Start with an empty tree
    }

    // Search for a key in the M-way tree
    public boolean search(int key) {
        return searchKey(root, key);
    }

    private boolean searchKey(Node node, int key) {
        int i = 0;

        // Find the position where the key might exist
        while (i < node.keys.size() && key > node.keys.get(i)) {
            i++;
        }

        // If the key matches, return true
        if (i < node.keys.size() && key == node.keys.get(i)) {
            return true;
        }

        // If it's a leaf, the key is not present
        if (node.isLeaf) {
            return false;
        }

        // Recur for the appropriate child
        return searchKey(node.children.get(i), key);
    }

    // Insert a key into the M-way tree
    public void insert(int key) {
        Node r = root;
        if (r.keys.size() == M - 1) { // If root is full, split it
            Node s = new Node(false);
            root = s;
            s.children.add(r);
            splitChild(s, 0, r);
            insertNonFull(s, key);
        } else {
            insertNonFull(r, key);
        }
    }

    private void insertNonFull(Node node, int key) {
        int i = node.keys.size() - 1;

        if (node.isLeaf) {
            // Insert the key into the sorted order
            node.keys.add(0); // Expand the list
            while (i >= 0 && key < node.keys.get(i)) {
                node.keys.set(i + 1, node.keys.get(i));
                i--;
            }
            node.keys.set(i + 1, key);
        } else {
            // Find the child that will receive the key
            while (i >= 0 && key < node.keys.get(i)) {
                i--;
            }
            i++;

            // Split the child if it's full
            if (node.children.get(i).keys.size() == M - 1) {
                splitChild(node, i, node.children.get(i));
                if (key > node.keys.get(i)) {
                    i++;
                }
            }
            insertNonFull(node.children.get(i), key);
        }
    }

    private void splitChild(Node parent, int index, Node child) {
        Node newChild = new Node(child.isLeaf);
        int mid = M / 2;

        // Transfer keys and children
        for (int j = mid + 1; j < child.keys.size(); j++) {
            newChild.keys.add(child.keys.get(j));
        }
        child.keys.subList(mid, child.keys.size()).clear();

        if (!child.isLeaf) {
            for (int j = mid + 1; j < child.children.size(); j++) {
                newChild.children.add(child.children.get(j));
            }
            child.children.subList(mid + 1, child.children.size()).clear();
        }

        // Insert new child into parent's children
        parent.children.add(index + 1, newChild);
        parent.keys.add(index, child.keys.remove(mid));
    }

    // In-order traversal of the M-way tree
    public void inOrder() {
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(Node node) {
        for (int i = 0; i < node.keys.size(); i++) {
            if (!node.isLeaf) {
                inOrderTraversal(node.children.get(i));
            }
            System.out.print(node.keys.get(i) + " ");
        }
        if (!node.isLeaf) {
            inOrderTraversal(node.children.get(node.keys.size()));
        }
    }
}

