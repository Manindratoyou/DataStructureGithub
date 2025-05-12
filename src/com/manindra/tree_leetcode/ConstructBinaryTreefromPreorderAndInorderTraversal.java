package com.manindra.tree_leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderAndInorderTraversal { // solution 105

    public static void main(String[] args) {
        ConstructBinaryTreefromPreorderAndInorderTraversal solution = new ConstructBinaryTreefromPreorderAndInorderTraversal();

        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};

        TreeNode root = solution.buildTree(preOrder, inOrder);
        System.out.println("Inorder traversal of the constructed tree:");
        printInOrder(root); // Expected output: 9 3 15 20 7
    }

    TreeNode buildTree(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inOrderIndexMap.put(inOrder[i], i);
        }

        return splitTree(preOrder, inOrderIndexMap, 0, 0, inOrder.length - 1);
    }

    private TreeNode splitTree(int[] preOrder, Map<Integer, Integer> inOrderIndexMap,
                               int rootIndex, int left, int right) {

        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[rootIndex]);
        int mid = inOrderIndexMap.get(preOrder[rootIndex]);

        root.left = splitTree(preOrder, inOrderIndexMap, rootIndex + 1, left, mid - 1);
        root.right = splitTree(preOrder, inOrderIndexMap, rootIndex + (mid - left) + 1, mid + 1, right);

        return root;
    }

    TreeNode buildTree2(int[] preOrder, int[] inOrder) {

        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++)
            inOrderIndexMap.put(inOrder[i], i);

        return splitTree(preOrder, inOrderIndexMap,
                0, 0, inOrder.length - 1);
    }

    private TreeNode splitTree2(int[] preOrder, Map<Integer, Integer> inOrderIndexMap,
                                int rootIndex, int left, int right) {

        TreeNode root = new TreeNode(preOrder[rootIndex]);

        // Create left and right subtree
        int mid = inOrderIndexMap.get(preOrder[rootIndex]);
        if (mid > left)
            root.left = splitTree2(preOrder, inOrderIndexMap,
                    rootIndex + 1, left, mid - 1);
        if (mid < right)
            root.right = splitTree2(preOrder, inOrderIndexMap,
                    rootIndex + mid - left + 1, mid + 1, right);
        return root;
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

    static void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.val + " ");
            printInOrder(node.right);
        }
    }
}
