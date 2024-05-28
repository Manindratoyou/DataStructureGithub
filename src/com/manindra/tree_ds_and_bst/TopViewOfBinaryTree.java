package com.manindra.tree_ds_and_bst;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {

    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(70);

        System.out.println("Vertical traversal of the binary tree:");
        topView(root);
    }

    static void topView(Node root) {
        Queue<Pair> pairQueue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        pairQueue.add(new Pair(root, 0));
        while (pairQueue.isEmpty() == false) {
            Pair p = pairQueue.poll();
            Node current = p.node;
            int hd = p.horizontalDistance;
            if (map.containsKey(hd) == false)
                map.put(hd, current.key);
            if (current.left != null)
                pairQueue.add(new Pair(current.left, hd - 1));
            if (current.right != null)
                pairQueue.add(new Pair(current.right, hd + 1));
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            System.out.print(m.getValue()+"  ");
        }
    }

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
