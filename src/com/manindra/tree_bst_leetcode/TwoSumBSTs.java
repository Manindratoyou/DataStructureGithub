package com.manindra.tree_bst_leetcode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumBSTs { //solution 1214

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);

        int target = 5;

        System.out.println(twoSumBSTs(root1, root2, target)); // Output: true
    }

    public static boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set = new HashSet<>();
        inorder(root1, set);
        return dfs(root2, set, target);
    }

    private static void inorder(TreeNode node, Set<Integer> set) {
        if (node == null) return;
        inorder(node.left, set);
        set.add(node.val);
        inorder(node.right, set);
    }

    private static boolean dfs(TreeNode node, Set<Integer> set, int target) {
        if (node == null) return false;
        if (set.contains(target - node.val)) return true;
        return dfs(node.left, set, target) || dfs(node.right, set, target);
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}

