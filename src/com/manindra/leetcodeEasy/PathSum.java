package com.manindra.leetcodeEasy;

import java.util.Stack;

public class PathSum { //solution 112

    public static void main(String[] args) {
        // Create a binary tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int sum = 22; // Sum to check

        // Check if the binary tree has a path with the given sum
        PathSum pathSum = new PathSum();
        boolean result = pathSum.hasPathSum(root, sum);

        System.out.println("Does the tree have a path with sum " + sum + "? " + result);
    }



    boolean hasPathSum(TreeNode root, int sum) {

        if (root == null)
            return false;

        // Create 2 stacks for the path and the sums
        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sumPath = new Stack<>();

        path.push(root);
        sumPath.push(root.val);

        while (!path.isEmpty()) {
            TreeNode temp = path.pop();
            int tempVal = sumPath.pop();

            // If a child node and we find the sum total, return true
            if (temp.left == null && temp.right == null && tempVal == sum)
                return true;

            if (temp.right != null) {
                path.push(temp.right);
                sumPath.push(temp.right.val + tempVal);
            }

            if (temp.left != null) {
                path.push(temp.left);
                sumPath.push(temp.left.val + tempVal);
            }

        }

        return false;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}