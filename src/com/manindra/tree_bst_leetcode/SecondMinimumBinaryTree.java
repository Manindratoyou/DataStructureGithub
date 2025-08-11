package com.manindra.tree_bst_leetcode;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class SecondMinimumBinaryTree { //solution 671

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(findSecondMinimumValue(root)); // Output: 5
    }

    public static int findSecondMinimumValue(TreeNode root) { //Recursive DFS
        if (root == null) return -1;
        int min = root.val;
        return dfs(root, min);
    }

    private static int dfs(TreeNode node, int min) {
        if (node == null) return -1;

        if (node.val > min) return node.val;

        int left = dfs(node.left, min);
        int right = dfs(node.right, min);

        if (left == -1) return
                right;
        if (right == -1) return
                left;

        return Math.min(left, right);
    }

    public static int findSecondMinimumValue2(TreeNode root) { //Using a TreeSet
        Set<Integer> set = new TreeSet<>();
        traverse(root, set);

        if (set.size() < 2) return -1;

        return new ArrayList<>(set).get(1);
    }

    private static void traverse(TreeNode node, Set<Integer> set) {
        if (node == null) return;
        set.add(node.val);
        traverse(node.left, set);
        traverse(node.right, set);
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}

