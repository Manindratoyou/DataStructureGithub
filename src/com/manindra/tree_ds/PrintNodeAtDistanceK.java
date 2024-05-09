package com.manindra.tree_ds;

public class PrintNodeAtDistanceK {

    public static void main(String[] args) {

        /*
         10
        /  \
      20    30
     / \     \
   40   50    70

         */

        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right = new Node(30);
        root.right.right = new Node(70);

        int k = 2;
        printKDistance(root, k);

    }

    static void printKDistance(Node root, int k) {
        if (root == null)
            return;
        if (k == 0)
            System.out.print(root.key + " ");
        else {
            printKDistance(root.left, k - 1);
            printKDistance(root.right, k - 1);
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
