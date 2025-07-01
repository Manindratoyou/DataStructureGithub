package com.manindra.tree_bst_leetcode;

public class LongestZigZagPath { //solution 1372

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.left.right = new TreeNode(1);
        root.right.left.right.right = new TreeNode(1);

        LongestZigZagPath obj = new LongestZigZagPath();
        System.out.println(obj.longestZigZag(root));  // Output: 3
    }


    private int maxLen = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;

        dfs(root.left, true, 1);  // Start left
        dfs(root.right, false, 1); // Start right

        return maxLen;
    }

    private void dfs(TreeNode node, boolean isLeft, int length) {
        if (node == null) return;

        maxLen = Math.max(maxLen, length);

        if (isLeft) {
            dfs(node.right, false, length + 1); // ZigZag: left -> right
            dfs(node.left, true, 1);            // Restart from same side
        } else {
            dfs(node.left, true, length + 1);   // ZigZag: right -> left
            dfs(node.right, false, 1);          // Restart from same side
        }
    }
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}

