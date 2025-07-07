package com.manindra.tree_leetcode;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeInPost { //Solution 106

    public static void main(String[] args) {
        int[] inorder =   {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = buildTree(inorder, postorder);
        printInOrder(root);  // Output: 9 3 15 20 7
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;

        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderIndexMap.put(inorder[i], i);

        return helper(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1,
                inorderIndexMap);
    }

    private static TreeNode helper(int[] inorder, int inStart, int inEnd,
                                   int[] postorder, int postStart, int postEnd,
                                   Map<Integer, Integer> inMap) {

        if (inStart > inEnd || postStart > postEnd)
            return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int inRootIndex = inMap.get(rootVal);
        int numsLeft = inRootIndex - inStart;

        root.left = helper(inorder, inStart, inRootIndex - 1,
                postorder, postStart, postStart + numsLeft - 1,
                inMap);

        root.right = helper(inorder, inRootIndex + 1, inEnd,
                postorder, postStart + numsLeft, postEnd - 1,
                inMap);

        return root;
    }

    // Optional: Inorder print to verify
    public static void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

}

