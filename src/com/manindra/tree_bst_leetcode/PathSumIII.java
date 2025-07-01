package com.manindra.tree_bst_leetcode;

import java.util.HashMap;

public class PathSumIII { //solution 437

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        System.out.println(new PathSumIII().pathSum(root, 8));  // Output: 3

    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return countPaths(root, targetSum) +
                pathSum(root.left, targetSum) +
                pathSum(root.right, targetSum);
    }

    private int countPaths(TreeNode node, long targetSum) {
        if (node == null) return 0;

        int count = 0;
        if (node.val == targetSum) count++;

        count += countPaths(node.left, targetSum - node.val);
        count += countPaths(node.right, targetSum - node.val);

        return count;
    }

    public int pathSum2(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);  // Base case

        return dfs(root, 0L, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currSum, int targetSum, HashMap<Long, Integer> prefixSumCount) {
        if (node == null) return 0;

        currSum += node.val;
        int count = prefixSumCount.getOrDefault(currSum - targetSum, 0);

        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

        count += dfs(node.left, currSum, targetSum, prefixSumCount);
        count += dfs(node.right, currSum, targetSum, prefixSumCount);

        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1); // backtrack

        return count;
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

