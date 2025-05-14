package com.manindra.tree_bst_leetcode;

public class BalancedBinaryTree { // solution 110

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        System.out.println(isBalanced(root)); // false
    }

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1; // not balanced

        int right = checkHeight(node.right);
        if (right == -1) return -1; // not balanced

        if (Math.abs(left - right) > 1) return -1; // current node is not balanced

        return Math.max(left, right) + 1;
    }

    // TreeNode definition
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}

