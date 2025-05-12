package com.manindra.tree_leetcode;

public class MaximumBinaryTree { //solution 654

    public static void main(String[] args) {
        MaximumBinaryTree tree = new MaximumBinaryTree();
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = tree.constructMaximumBinaryTree(nums);

        // Print the tree in pre-order traversal to verify
        tree.preOrderTraversal(root);
    }

    TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null)
            return null;
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) return null;

        // Identify max index
        int idxMax = start;
        for (int i = start + 1; i <= end; i++)
            if (nums[i] > nums[idxMax])
                idxMax = i;

        // Create a root
        TreeNode root = new TreeNode(nums[idxMax]);

        // Assign left and right children
        root.left = build(nums, start, idxMax - 1);
        root.right = build(nums, idxMax + 1, end);

        return root;
    }

    private void preOrderTraversal(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int k) {
            val = k;
            left = right = null;
        }
    }
}
