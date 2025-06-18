package com.manindra.leetcodemedium_2;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumBinaryTree { //solution 1161

    // Test cases
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(0);
        root1.left.left = new TreeNode(7);
        root1.left.right = new TreeNode(-8);
        System.out.println(maxLevelSum(root1)); // Output: 2

        TreeNode root2 = new TreeNode(-100);
        root2.left = new TreeNode(-200);
        root2.right = new TreeNode(-300);
        root2.left.left = new TreeNode(-20);
        root2.left.right = new TreeNode(-5);
        root2.right.left = new TreeNode(-10);
        System.out.println(maxLevelSum(root2)); // Output: 1
    }

    public static int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int currentLevel = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                levelSum += current.val;

                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }

            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = currentLevel;
            }

            currentLevel++;
        }
        System.out.println(maxSum);

        return maxLevel;
    }

    // Helper TreeNode class
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }


}

