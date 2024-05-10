package com.manindra.tree_ds;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal { //or breadth first search

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
        printLevel(root);

    }

    static void printLevel(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.isEmpty() == false) {
            Node current = queue.poll();
            System.out.print(current.key+" ");
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
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
