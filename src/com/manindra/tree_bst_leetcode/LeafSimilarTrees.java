package com.manindra.tree_bst_leetcode;

import java.util.*;

public class LeafSimilarTrees { //solution 872
    /*
    Tree 1:           Tree 2:

    3                 3
   / \               / \
  5   1             5   1
 / \   \           /   / \
6   2   9         6   7   4
   / \
  7   4

Leaf values Tree 1: [6,7,4,9]
Leaf values Tree 2: [6,7,4,9] → ✅ True

     */

    public static void main(String[] args) {
        // Tree 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right.right = new TreeNode(9);

        // Tree 2
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.right.left = new TreeNode(7);
        root2.right.right = new TreeNode(4);
        root2.left.right = null;

        System.out.println("Are trees leaf-similar? " + leafSimilar(root1, root2)); // true
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private static void getLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        }
        getLeaves(node.left, leaves);
        getLeaves(node.right, leaves);
    }

    public static boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = getLeafSequenceIterative(root1);
        List<Integer> leaves2 = getLeafSequenceIterative(root2);
        return leaves1.equals(leaves2);
    }

    private static List<Integer> getLeafSequenceIterative(TreeNode root) {
        List<Integer> leaves = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node != null) {
                if (node.left == null && node.right == null) {
                    leaves.add(node.val);
                } else {
                    // Push right first so left is processed first
                    if (node.right != null) stack.push(node.right);
                    if (node.left != null) stack.push(node.left);
                }
            }
        }

        return leaves;
    }

}

