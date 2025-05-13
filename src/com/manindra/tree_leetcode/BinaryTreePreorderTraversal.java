package com.manindra.tree_leetcode;

import java.util.*;

public class BinaryTreePreorderTraversal { //solution 144

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        BinaryTreePreorderTraversal obj = new BinaryTreePreorderTraversal();
        List<Integer> result = obj.preorderTraversal(root);
        System.out.println("Preorder Traversal: " + result); // Output: [1, 2, 3]
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        if (node == null) return;

        result.add(node.val);             // Visit root
        preorder(node.left, result);      // Traverse left
        preorder(node.right, result);     // Traverse right
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}

