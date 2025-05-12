package com.manindra.tree_leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes { //solution 222

    /*
         1
       / \
      2   3
     / \
    4   5

     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        CountCompleteTreeNodes solution = new CountCompleteTreeNodes();
        int nodeCount = solution.countNodes(root);
        int nodeCount1 = solution.countNodes2(root);
        System.out.println("Total number of nodes: " + nodeCount); // Expected output: 5
        System.out.println("Total number of nodes: " + nodeCount1); // Expected output: 5
    }


    public int countNodes(TreeNode root) {

        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);

        if (leftDepth == rightDepth)
            return (int) Math.pow(2, leftDepth) - 1;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int rightDepth(TreeNode root) {
        int dep = 0;
        while (root != null) {
            root = root.right;
            dep++;
        }
        return dep;
    }

    private int leftDepth(TreeNode root) {
        int dep = 0;
        while (root != null) {
            root = root.left;
            dep++;
        }
        return dep;
    }

    public int countNodes2(TreeNode root) {
        if (root == null) return 0;

        // Initialize a queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;

        // Process all nodes level by level
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            count++;

            // Add left and right children to the queue if they exist
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        return count; // Total number of nodes
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
