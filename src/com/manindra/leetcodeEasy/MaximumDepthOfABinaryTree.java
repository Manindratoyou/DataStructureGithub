package com.manindra.leetcodeEasy;


class MaximumDepthOfABinaryTree { //solution 104

    public static void main(String[] args) {
        // Test cases
        // Test Case 1: Null tree
        MaximumDepthOfABinaryTree.TreeNode nullTree = null;
        System.out.println("Test Case 1: " + MaximumDepthOfABinaryTree.maxDepth(nullTree));

        // Test Case 2: Single node tree
        MaximumDepthOfABinaryTree.TreeNode singleNodeTree = new MaximumDepthOfABinaryTree.TreeNode(5);
        System.out.println("Test Case 2: " + MaximumDepthOfABinaryTree.maxDepth(singleNodeTree));

        // Test Case 3: Provided tree [3,9,20,null,null,15,7]
        MaximumDepthOfABinaryTree.TreeNode root = new MaximumDepthOfABinaryTree.TreeNode(3);
        root.left = new MaximumDepthOfABinaryTree.TreeNode(9);
        root.right = new MaximumDepthOfABinaryTree.TreeNode(20);
        root.right.left = new MaximumDepthOfABinaryTree.TreeNode(15);
        root.right.right = new MaximumDepthOfABinaryTree.TreeNode(7);

        System.out.println("Test Case 3: " + MaximumDepthOfABinaryTree.maxDepth(root));
    }

    static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
