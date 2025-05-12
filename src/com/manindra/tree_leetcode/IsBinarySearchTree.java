package com.manindra.tree_leetcode;

import java.util.LinkedList;
import java.util.List;

public class IsBinarySearchTree { //solution 98

    public static void main(String[] args) {
        // Create a test case for a valid BST:
        //       2
        //      / \
        //     1   3
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        // Create a test case for an invalid BST:
        //       5
        //      / \
        //     1   4
        //        / \
        //       3   6
        TreeNode invalidRoot = new TreeNode(5);
        invalidRoot.left = new TreeNode(1);
        invalidRoot.right = new TreeNode(4);
        invalidRoot.right.left = new TreeNode(3);
        invalidRoot.right.right = new TreeNode(6);

        IsBinarySearchTree solution = new IsBinarySearchTree();

        // Validate the BSTs
        System.out.println("Is the first tree a valid BST? " + solution.isValidBST(root)); // Expected: true
        System.out.println("Is the second tree a valid BST? " + solution.isValidBST(invalidRoot)); // Expected: false
    }

    boolean isValidBST(TreeNode root) {
        List<Integer> inOrderList = new LinkedList<>();
        helper(root, inOrderList);

        for (int i = 1; i < inOrderList.size(); i++) {
            // Check if new element is smaller than or equal to the previous element
            if (inOrderList.get(i) <= inOrderList.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    void helper(TreeNode treeNode, List<Integer> inOrderList) {
        if (treeNode == null) {
            return;
        }

        helper(treeNode.left, inOrderList);
        inOrderList.add(treeNode.val);
        helper(treeNode.right, inOrderList);
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
