package com.manindra.tree_ds_and_bst;

import java.util.Stack;

public class IterativeInorderTraversal {

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
        iterativeInorder(root);

    }

    static void iterativeInorder(Node root) {

        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || stack.isEmpty() == false) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.key + " ");
            current = current.right;
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
