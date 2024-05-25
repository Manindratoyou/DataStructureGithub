package com.manindra.tree_ds_and_bst;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

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
        System.out.println(maxWidth(root));

    }

    static int maxWidth(Node root) {
        if (root == null)
            return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (queue.isEmpty() == false) {
            int count = queue.size();
            result = Math.max(count, result);
            for (int i = 0; i < count; i++) {
                Node current = queue.poll();
                //System.out.print(current.key + " ");
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
            //System.out.println();
        }
        return result;
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
