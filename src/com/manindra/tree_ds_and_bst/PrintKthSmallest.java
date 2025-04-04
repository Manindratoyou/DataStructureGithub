package com.manindra.tree_ds_and_bst;

import java.util.Arrays;

public class PrintKthSmallest { //Efficient

    public static Node insert(Node root, int x) {
        if (root == null)
            return new Node(x);

        if (x < root.data) {
            root.left = insert(root.left, x);
            root.lCount++;
        } else if (x > root.data)
            root.right = insert(root.right, x);
        return root;
    }

    public static Node kthSmallest(Node root, int k) {
        if (root == null)
            return null;

        int count = root.lCount + 1;
        if (count == k)
            return root;

        if (count > k)
            return kthSmallest(root.left, k);

        return kthSmallest(root.right, k - count);
    }

    public static void main(String args[]) {
        Node root = null;
        int keys[] = {20, 8, 22, 4, 12, 10, 14};
        System.out.println(Arrays.toString(keys));

        for (int x : keys)
            root = insert(root, x);

        int k = 4;
        Node res = kthSmallest(root, k);
        if (res == null)
            System.out.println("There are less "
                    + "than k nodes in the BST");
        else
            System.out.println("K-th " + k + " Smallest"
                    + " Element is " + res.data);
    }

    static class Node {
        int data;
        Node left, right;
        int lCount;

        Node(int x) {
            data = x;
            left = right = null;
            lCount = 0;
        }
    }
}
