package com.manindra.tree_leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree { //solution 101

    public static void main(String[] args) {
        // Test case 1: Symmetric tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);


        System.out.println(isSymmetric(root1));
        // Output: true

        // Test case 2: Asymmetric tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);


        System.out.println(isSymmetric(root2)); // Output: false
    }


    // iterative method to determine if a binary tree is symmetric
    // using 2 queues
    static boolean isSymmetric(TreeNode root) {

        if (root == null) return true;

        Queue<TreeNode> leftTree = new LinkedList<>();
        Queue<TreeNode> rightTree = new LinkedList<>();

        leftTree.add(root.left);
        rightTree.add(root.right);

        while (!leftTree.isEmpty() && !rightTree.isEmpty()) {

            TreeNode leftNode = leftTree.poll();
            TreeNode rightNode = rightTree.poll();

            if (leftNode == null && rightNode == null) continue;

            if (leftNode == null || rightNode == null) return false;

            if (leftNode.val != rightNode.val) return false;

            // Pushing order is very important
            leftTree.add(leftNode.left);
            leftTree.add(leftNode.right);
            rightTree.add(rightNode.right);
            rightTree.add(rightNode.left);
        }

        return true;
    }

    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
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

        /*TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }*/
    }
}
