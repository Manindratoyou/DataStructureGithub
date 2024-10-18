package com.manindra.tree_ds_and_bst;

public class PrintKthSmallest2 { //Naive

    public static void main(String args[]) {
        Node root = new Node(15);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.right = new Node(20);
        root.right.left = new Node(18);
        root.right.left.left = new Node(16);
        root.right.right = new Node(80);
        int k = 3;

        System.out.print("Kth Smallest: ");
        printKth(root, k);
    }

    static int count = 0;

    public static void printKth(Node root, int k) {
        if (root != null) {
            printKth(root.left, k);
            count++;
            if (count == k) {
                System.out.print(root.key);
                return;
            }
            printKth(root.right, k);
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
