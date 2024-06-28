package com.manindra.leetcodemedium_2;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal { //solution 103

    public static void main(String[] args) {
        // Create a test case:
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        BinaryTreeZigzagLevelOrderTraversal solution = new BinaryTreeZigzagLevelOrderTraversal();
        List<List<Integer>> result = solution.zigzagLevelOrder(root);

        // Print the zigzag level order traversal
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }

    List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> zigzag = new ArrayList<>();
        if (root == null) return zigzag;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            Stack<Integer> reverseStack = new Stack<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // Check flag
                if (flag)
                    reverseStack.add(node.val);
                else
                    level.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            flag = !flag;

            // Pop all elements from stack
            while (!reverseStack.isEmpty())
                level.add(reverseStack.pop());

            zigzag.add(level);
        }

        return zigzag;
    }

    List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();
        if (root == null) return zigzag;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (flag)
                    level.addFirst(node.val); // Add to the front if flag is true
                else
                    level.add(node.val); // Add to the end if flag is false

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            flag = !flag;
            zigzag.add(level);
        }

        return zigzag;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int k) {
            val = k;
            left = right = null;
        }
    }
}
