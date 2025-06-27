package com.manindra.hashing_leetcode;

import java.util.*;

public class ConstructTreeFromPrePost { //solution 889

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postIndexMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1,
                postIndexMap);
    }

    private static TreeNode build(int[] pre, int preStart, int preEnd,
                                  int[] post, int postStart, int postEnd,
                                  Map<Integer, Integer> postIndexMap) {
        if (preStart > preEnd) return null;

        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd) return root;

        int leftRootVal = pre[preStart + 1];
        int idx = postIndexMap.get(leftRootVal);
        int leftSize = idx - postStart + 1;

        root.left = build(pre, preStart + 1, preStart + leftSize,
                post, postStart, idx,
                postIndexMap);

        root.right = build(pre, preStart + leftSize + 1, preEnd,
                post, idx + 1, postEnd - 1,
                postIndexMap);

        return root;
    }

    // Utility method for inorder traversal (for validation)
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        TreeNode root = constructFromPrePost(preorder, postorder);
        System.out.print("Inorder traversal: ");
        inorder(root); // Output: 4 2 5 1 6 3 7
    }
}

