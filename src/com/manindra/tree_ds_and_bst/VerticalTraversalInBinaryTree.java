package com.manindra.tree_ds_and_bst;

import java.util.*;

public class VerticalTraversalInBinaryTree {

                    /*
                    10
                  /  \
                20    30
               / \     \
             40   50    70

                  */

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(70);

        System.out.println("Vertical traversal of the binary tree:");
        verticalTraversal(root);
    }

    static void verticalTraversal(Node root) {
        // TreeMap to store the vertical order traversal
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        // Queue to store nodes and their horizontal distance
        Queue<Pair> queue = new LinkedList<>();

        // Initialize the queue with the root node at horizontal distance 0
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            Node node = temp.node;
            int hd = temp.horizontalDistance;

            // Add the node to the TreeMap at its corresponding horizontal distance
            if (map.containsKey(hd)) {
                map.get(hd).add(node.key);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(node.key);
                map.put(hd, list);
            }

            // If there's a left child, add it to the queue with horizontal distance -1 from current
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }
            // If there's a right child, add it to the queue with horizontal distance +1 from current
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        // Print the vertical order traversal
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            for (int value : entry.getValue()) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // Helper class to store nodes and their horizontal distance
    static class Pair {
        Node node;
        int horizontalDistance;

        Pair(Node node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }

    // Definition of the Node class
    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }
}
