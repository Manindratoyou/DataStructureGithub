package com.manindra.tree_leetcode;

import java.util.Stack;

public class BSTFromPreorderIterative { //solution 1008

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = bstFromPreorder(preorder);
        System.out.println("Inorder traversal of constructed BST:");
        inorderTraversal(root); // Output: 1 5 7 8 10 12
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            TreeNode parent = stack.peek();

            // Find the right parent to attach this node
            while (!stack.isEmpty() && preorder[i] > stack.peek().val) {
                parent = stack.pop();
            }

            if (preorder[i] < parent.val) {
                parent.left = node;
            } else {
                parent.right = node;
            }

            stack.push(node);
        }

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

