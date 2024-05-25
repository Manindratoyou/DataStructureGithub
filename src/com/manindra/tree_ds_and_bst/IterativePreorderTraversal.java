package com.manindra.tree_ds_and_bst;

import java.util.Stack;

public class IterativePreorderTraversal {

    public static void main(String[] args) {

         /*
         10
        /  \
      20    30
           / \
         40   50

         */

        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        iterativePreorder(root);
        System.out.println();
        iterativePreorderSpaceOptimized(root);

    }

    static void iterativePreorder(Node root) {
        if (root == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (stack.isEmpty() == false) {
            Node current = stack.pop();
            System.out.print(current.key + " ");
            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);
        }
    }

    static void iterativePreorderSpaceOptimized(Node root) {
        if (root == null)
            return;
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                System.out.print(current.key + " ");
                if (current.right != null)
                    stack.push(current.right);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
            }
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
