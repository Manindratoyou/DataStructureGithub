package com.manindra.leetcodemedium_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DiameterOfABinaryTree { //solution 543

    public static void main(String[] args) {
        DiameterOfABinaryTree solution = new DiameterOfABinaryTree();

        // Test case 1
        TreeNode root1 = new TreeNode(1);
        root1.setLeft(new TreeNode(2));
        root1.setRight(new TreeNode(3));
        root1.left.setLeft(new TreeNode(4));
        root1.left.setRight(new TreeNode(5));
        System.out.println("Diameter of test case 1: " + solution.diameterOfBinaryTree(root1)); // Expected: 3

        // Test case 2
        TreeNode root2 = new TreeNode(1);
        root2.setLeft(new TreeNode(2));
        root2.left.setLeft(new TreeNode(3));
        root2.left.left.setLeft(new TreeNode(4));
        root2.left.left.left.setLeft(new TreeNode(5));
        System.out.println("Diameter of test case 2: " + solution.diameterOfBinaryTree(root2)); // Expected: 4

        // Test case 3
        TreeNode root3 = new TreeNode(1);
        root3.setLeft(new TreeNode(2));
        root3.setRight(new TreeNode(3));
        root3.right.setLeft(new TreeNode(4));
        root3.right.setRight(new TreeNode(5));
        root3.right.right.setRight(new TreeNode(6));
        root3.right.right.right.setRight(new TreeNode(7));
        System.out.println("Diameter of test case 3: " + solution.diameterOfBinaryTree(root3)); // Expected: 5
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

    int diameter = 0;

    public int diameterOfBinaryTree2(TreeNode root) {

        longestPath(root);
        return diameter;
    }

    private int longestPath(TreeNode root) {
        if (root == null)
            return 0;
        int leftLongestPath = longestPath(root.left);
        int rightLongestPath = longestPath(root.right);
        diameter = Math.max(leftLongestPath + rightLongestPath, diameter);
        return Math.max(leftLongestPath, rightLongestPath) + 1;

    }

    static class TreeNode {

        int data;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int val) {
            this.data = val;
        }

        void setLeft(TreeNode left) {
            this.left = left;
        }

        void setRight(TreeNode right) {
            this.right = right;
        }
    }

}

