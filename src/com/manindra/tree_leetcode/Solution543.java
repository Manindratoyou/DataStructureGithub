package com.manindra.tree_leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

    1
   / \
  2   3
 / \
4   5

 */
public class Solution543 { // Diameter of Binary Tree

    public static void main(String[] args) {
        // Example usage
        Solution543 solution = new Solution543();

        // Creating a sample binary tree
        Solution543.TreeNode root = new Solution543.TreeNode(1);
        root.left = new Solution543.TreeNode(2);
        root.right = new Solution543.TreeNode(3);
        root.left.left = new Solution543.TreeNode(4);
        root.left.right = new Solution543.TreeNode(5);

        // Calculating the diameter of the binary tree
        int diameter = solution.diameterOfBinaryTree(root);

        // Printing the result
        System.out.println("Diameter of the binary tree: " + diameter);
    }

    public int diameterOfBinaryTree(TreeNode root) {

        Map<TreeNode, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        int diameter = 0;

        if (root != null)
            stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            // Fill up stack to perform post-order traversal
            if (node.left != null && !map.containsKey(node.left)) {
                stack.push(node.left);
            } else if (node.right != null && !map.containsKey(node.right)) {
                stack.push(node.right);
            } else {

                // Process the root, once left and right sub-tree have been processed
                stack.pop();
                int leftDepth = map.getOrDefault(node.left, 0);
                int rightDepth = map.getOrDefault(node.right, 0);

                // Put the max depth at a node in the map
                map.put(node, 1 + Math.max(leftDepth, rightDepth));

                // Update the max diameter found so far
                diameter = Math.max(diameter, leftDepth + rightDepth);
            }
        }
        return diameter;
    }

    private static class TreeNode {
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
