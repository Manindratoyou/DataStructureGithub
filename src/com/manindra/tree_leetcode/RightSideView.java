package com.manindra.tree_leetcode;

import java.util.*;

public class RightSideView { //solution 199

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int lastValue = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                lastValue = node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(lastValue);
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1:
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);
        System.out.println("Right side view: " + rightSideView(root1));  // [1, 3, 4]

        // Test Case 2:
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);
        System.out.println("Right side view: " + rightSideView(root2));  // [1, 2, 3]

        // Test Case 3:
        TreeNode root3 = null;
        System.out.println("Right side view: " + rightSideView(root3));  // []

        // Test Case 4:
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(3);
        System.out.println("Right side view: " + rightSideView(root4));  // [1, 2, 3]
    }
}

