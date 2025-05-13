package com.manindra.tree_leetcode;
public class MinimumAbsoluteDifferenceBST {  //solution 530

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - prev));
        }
        prev = root.val;

        inOrder(root.right);
    }

    public static void main(String[] args) {
        // Construct the BST:
        //        4
        //       / \
        //      2   6
        //     / \
        //    1   3

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        MinimumAbsoluteDifferenceBST obj = new MinimumAbsoluteDifferenceBST();
        System.out.println("Minimum Absolute Difference: " + obj.getMinimumDifference(root)); // Output: 1
    }
}

