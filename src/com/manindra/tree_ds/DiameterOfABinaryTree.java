package com.manindra.tree_ds;

import java.util.HashMap;
import java.util.Map;

public class DiameterOfABinaryTree {

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
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(70);

        //System.out.println("Diameter of the binary tree: " + diameterSolutionOne(root));
        //System.out.println("Diameter of the binary tree: " + diameterSolutionTwo(root));

        Map<Node, Integer> heightMap = new HashMap<>();
        precomputeHeight(root, heightMap);

        System.out.println("Diameter of the binary tree: " + diameterSolutionThree(root, heightMap));

    }


    static int diameterSolutionOne(Node root) {
        if (root == null)
            return 0;

        // Calculate height of left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Calculate diameter through the current node
        int currentDiameter = leftHeight + rightHeight + 1;

        // Recursively find the diameter in left and right subtrees
        int leftDiameter = diameterSolutionOne(root.left);
        int rightDiameter = diameterSolutionOne(root.right);

        // Return the maximum of diameter through the current node,
        // diameter in left subtree, and diameter in right subtree
        return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
    }

    static int diameterSolutionTwo(Node root) { //0(n^2)
        if (root == null)
            return 0;

        int d1 = 1 + height(root.left) + height(root.right);
        int d2 = diameterSolutionTwo(root.left);
        int d3 = diameterSolutionTwo(root.right);
        return Math.max(d1, Math.max(d2, d3));
    }

    //=============================================================//
    static void precomputeHeight(Node root, Map<Node, Integer> heightMap) {
        if (root == null)
            return;

        heightMap.put(root, height(root));
        precomputeHeight(root.left, heightMap);
        precomputeHeight(root.right, heightMap);
    }

    static int diameterSolutionThree(Node root, Map<Node, Integer> heightMap) {
        if (root == null)
            return 0;

        // Calculate height of left and right subtrees
        int leftHeight = heightMap.getOrDefault(root.left, 0);
        int rightHeight = heightMap.getOrDefault(root.right, 0);

        // Calculate diameter through the current node
        int currentDiameter = leftHeight + rightHeight + 1;

        // Recursively find the diameter in left and right subtrees
        int leftDiameter = diameterSolutionThree(root.left, heightMap);
        int rightDiameter = diameterSolutionThree(root.right, heightMap);

        // Return the maximum of diameter through the current node,
        // diameter in left subtree, and diameter in right subtree
        return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
    }
    //

    static int height(Node root) {
        if (root == null)
            return 0;
        else
            return Math.max(height(root.left), height(root.right)) + 1;
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
