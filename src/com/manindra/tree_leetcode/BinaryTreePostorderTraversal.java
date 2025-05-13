package com.manindra.tree_leetcode;

import java.util.*;

public class BinaryTreePostorderTraversal { //solution 145

    public static void main(String[] args) {
        // Example: [1,null,2,3]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        BinaryTreePostorderTraversal obj = new BinaryTreePostorderTraversal();
        List<Integer> result = obj.postorderTraversal(root);
        System.out.println("Postorder Traversal: " + result); // Output: [3, 2, 1]
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, List<Integer> result) {
        if (node == null) return;

        postorder(node.left, result);     // Visit left
        postorder(node.right, result);    // Visit right
        result.add(node.val);             // Visit root
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}
