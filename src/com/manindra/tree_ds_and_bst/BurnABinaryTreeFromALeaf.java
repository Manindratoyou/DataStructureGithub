package com.manindra.tree_ds_and_bst;

public class BurnABinaryTreeFromALeaf {

    public static void main(String[] args) {

        // Creating the binary tree
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(70);

        // Leaf node from which to start burning
        int leafNode = 50;

        // Distance object to store the burning time
        Distance distance = new Distance(-1);

        // Calculate burning time
        burnTime(root, leafNode, distance);

        // Output the maximum burning time
        System.out.println("Maximum burning time: " + result);
    }


    static int result = 0;

    static int burnTime(Node root, int leaf, Distance distance) {
        if (root == null)
            return 0;
        if (root.key == leaf) {
            distance.val = 0;
            return 1;
        }
        Distance sDistance = new Distance(-1), rDistance = new Distance(-1);
        int leftHeight = burnTime(root.left, leaf, sDistance);
        int rightHeight = burnTime(root.right, leaf, rDistance);

        if (sDistance.val != -1) {
            distance.val = sDistance.val + 1;
            result = Math.max(result, distance.val + rightHeight);
        } else if (rDistance.val != -1) {
            distance.val = rDistance.val + 1;
            result = Math.max(result, distance.val + leftHeight);
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    static class Distance {
        int val;

        Distance(int d) {
            val = d;
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
