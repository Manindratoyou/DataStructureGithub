package com.manindra.tree_ds_and_bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversalSpiralForm { //level order

    public static void main(String[] args) {
        TreeTraversalSpiralForm tree = new TreeTraversalSpiralForm();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Spiral traversal using first method:");
        printSpiral(root);
        System.out.println();

        System.out.println("Spiral traversal using second method:");
        printSpiralSolutionTwo(root);
        System.out.println();
    }


    static void printSpiral(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        boolean reverse = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node current = queue.poll();
                if (reverse) stack.push(current.key);
                else System.out.print(current.key + " ");
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            if (reverse) {
                while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
            }
            reverse = !reverse;
        }
    }
    static void printSpiralSolutionTwo(Node root) {
        if (root == null)
            return;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Node temp = stack1.pop();
                System.out.print(temp.key + " ");
                // First push the left child, then the right child to ensure right child is processed first
                if (temp.left != null)
                    stack2.push(temp.left);
                if (temp.right != null)
                    stack2.push(temp.right);
            }
            while (!stack2.isEmpty()) {
                Node temp = stack2.pop();
                System.out.print(temp.key + " ");
                // First push the right child, then the left child to ensure left child is processed first
                if (temp.right != null)
                    stack1.push(temp.right);
                if (temp.left != null)
                    stack1.push(temp.left);
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
