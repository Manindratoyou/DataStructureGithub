package com.manindra.backtracking_leetcode;

import java.util.*;

public class BinaryTreePaths { //solution 257

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        dfs(root, "", result);
        return result;
    }

    private static void dfs(TreeNode node, String path, List<String> result) {
        if (node == null) return;

        // Append current node value to path
        path += node.val;

        // If it's a leaf, add to result
        if (node.left == null && node.right == null) {
            result.add(path);
        } else {
            // Continue traversing
            path += "->";
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }
    }

    public static void main(String[] args) {
        // Test Case:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> paths = binaryTreePaths(root);
        System.out.println("Binary Tree Paths: " + paths);
    }
}

