package com.manindra.tree_ds_and_bst;

import java.util.Map;
import java.util.TreeMap;

public class VerticalSumInBinaryTree {

    public static void main(String[] args) {
                    /*
                    10
                  /  \
                20    30
               / \     \
             40   50    70

                  */
        // Creating a sample binary tree
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(70);

        System.out.println("Vertical sums of the binary tree:");
        verticalSum(root);
    }

    static void verticalSumRecursively(Node node, int horizontalDistance, TreeMap<Integer, Integer> sumMap) {
        if (node == null) {
            return;
        }
        verticalSumRecursively(node.left, horizontalDistance - 1, sumMap);
        int currentSum = sumMap.getOrDefault(horizontalDistance, 0);
        sumMap.put(horizontalDistance, currentSum + node.key);
        verticalSumRecursively(node.right, horizontalDistance + 1, sumMap);
    }

    static void verticalSum(Node root) {
        TreeMap<Integer, Integer> sumMap = new TreeMap<>();
        verticalSumRecursively(root, 0, sumMap);

        for (Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
        System.out.println();
    }

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }
}
