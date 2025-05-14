package com.manindra.tree_bst_leetcode;

import java.util.*;

public class CousinsInBinaryTree { // solution 993

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        int x = 4, y = 5;
        System.out.println(isCousins(root, x, y)); // true
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean xFound = false, yFound = false;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                // Check if current node is parent of x and y
                if (current.left != null && current.right != null) {
                    int left = current.left.val;
                    int right = current.right.val;
                    if ((left == x && right == y) || (left == y && right == x)) {
                        return false; // same parent
                    }
                }

                if (current.left != null) {
                    queue.offer(current.left);
                    if (current.left.val == x) xFound = true;
                    if (current.left.val == y) yFound = true;
                }

                if (current.right != null) {
                    queue.offer(current.right);
                    if (current.right.val == x) xFound = true;
                    if (current.right.val == y) yFound = true;
                }
            }

            if (xFound && yFound) return true;
            if (xFound || yFound) return false; // found one but not both
        }

        return false;
    }

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
}

