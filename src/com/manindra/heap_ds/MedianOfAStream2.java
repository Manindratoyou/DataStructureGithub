package com.manindra.heap_ds;

public class MedianOfAStream2 { // Augmented BST

    public static void main(String[] args) {

        Node root = null;
        double[] inputNumbers = new double[]{25, 7, 10, 15, 20};
        int count = 0;
        for (double number : inputNumbers) {
            count++;
            root = insert(root, number);
            double median;
            if (count % 2 == 0) {
                median = (findKthSmallest(root, count / 2).data + findKthSmallest(root, count / 2 + 1).data) / 2;
            } else {
                median = findKthSmallest(root, (count + 1) / 2).data;
            }
            System.out.println(median);
        }
    }

    // Insert a new node into the BST and update the left subtree count
    static Node insert(Node root, double value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
            root.leftCount++;
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    // Find the Kth smallest element in the BST
    static Node findKthSmallest(Node root, int k) {
        if (root == null) {
            return null;
        }
        int currentRank = root.leftCount + 1;
        if (currentRank == k) {
            return root;
        }
        if (currentRank > k) {
            return findKthSmallest(root.left, k);
        } else {
            return findKthSmallest(root.right, k - currentRank);
        }
    }

    // Node class to represent each node in the BST
    static class Node {
        double data;
        Node left, right;
        int leftCount;

        Node(double value) {
            data = value;
            left = right = null;
            leftCount = 0;
        }
    }
}
