package com.manindra.tree_bst_leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CountGoodNodes { //solution 1448

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println("Good nodes count: " + goodNodes(root)); // Output: 4
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private static int dfs(TreeNode node, int maxSoFar) {
        if (node == null) return 0;

        int good = node.val >= maxSoFar ? 1 : 0;
        int newMax = Math.max(maxSoFar, node.val);

        good += dfs(node.left, newMax);
        good += dfs(node.right, newMax);

        return good;
    }

    public static int goodNodes2(TreeNode root) {
        if (root == null) return 0;

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, root.val));
        int count = 0;

        while (!stack.isEmpty()) {
            Pair current = stack.pop();
            TreeNode node = current.node;
            int maxSoFar = current.max;

            if (node.val >= maxSoFar) count++;

            int newMax = Math.max(maxSoFar, node.val);
            if (node.right != null) stack.push(new Pair(node.right, newMax));
            if (node.left != null) stack.push(new Pair(node.left, newMax));
        }

        return count;
    }

    public static int goodNodes3(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, root.val));
        int count = 0;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int maxSoFar = current.max;

            if (node.val >= maxSoFar) count++;

            int newMax = Math.max(maxSoFar, node.val);
            if (node.left != null) queue.offer(new Pair(node.left, newMax));
            if (node.right != null) queue.offer(new Pair(node.right, newMax));
        }

        return count;
    }

    static class Pair {
        TreeNode node;
        int max;
        Pair(TreeNode node, int max) {
            this.node = node;
            this.max = max;
        }
    }


}

