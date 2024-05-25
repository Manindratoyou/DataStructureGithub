package com.manindra.tree_ds_and_bst;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLineByLine {

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

        //printLevelSolutionOne(root);
        printLevelSolutionTwo(root);

    }

    static void printLevelSolutionOne(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (queue.size() > 1) {
            Node current = queue.poll();
            if (current == null) {
                System.out.println();
                queue.add(null);
                continue;
            }
            System.out.print(current.key + " ");
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
    }

    static void printLevelSolutionTwo(Node root) { //TC 0(n) AS 0(w)

        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (queue.isEmpty() == false) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node current = queue.poll();
                System.out.print(current.key + " ");
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
            System.out.println();
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
