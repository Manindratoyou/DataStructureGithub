package com.manindra.tree_leetcode;

public class BSTFromPreorder { //solution 1008

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = bstFromPreorder(preorder);
        System.out.println("Inorder traversal of constructed BST:");
        inorderTraversal(root);  // Output should be sorted: 1 5 7 8 10 12
    }

    static int index = 0;

    public static TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return build(preorder, Integer.MAX_VALUE);
    }

    private static TreeNode build(int[] preorder, int bound) {
        if (index == preorder.length || preorder[index] > bound)
            return null;

        TreeNode root = new TreeNode(preorder[index++]);
        root.left = build(preorder, root.val);
        root.right = build(preorder, bound);
        return root;
    }

    // Helper method to print inorder traversal
    private static void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
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

