package com.manindra.tree_leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthBinaryTree { //solution 111

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Testing the minimum depth calculation
        MinimumDepthBinaryTree solution = new MinimumDepthBinaryTree();
        int minDepth = solution.minDepth(root);
        System.out.println("Minimum depth of the binary tree: " + minDepth);
    }

    int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int depth = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // Level order traversal
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // If a leaf node is found, return depth
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    int minDepth2(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int leftDepth = root.left == null ? Integer.MAX_VALUE : minDepth2(root.left);
        int rightDepth = root.left == null ? Integer.MAX_VALUE : minDepth2(root.right);
        return Math.min(leftDepth, rightDepth) + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        /*TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }*/
    }
}
