package com.manindra.leetcodemedium_2;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree { // solution 226

    public static void main(String[] args) {
        // Create a sample tree:
        //      4
        //     / \
        //    2   7
        //   / \ / \
        //  1  3 6  9
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        InvertTree treeInverter = new InvertTree();

        // Invert the tree using the recursive method
        TreeNode invertedRootRecursive = treeInverter.invertTreeRecursive2(root);
        System.out.println("Inverted Tree (Recursive): ");
        printTree(invertedRootRecursive);

        // Reset the tree for iterative inversion
        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // Invert the tree using the iterative method
        TreeNode invertedRootIterative = treeInverter.invertTree(root);
        System.out.println("Inverted Tree (Iterative): ");
        printTree(invertedRootIterative);
    }

    static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    /*TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null)
            return null;

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTreeRecursive(root.left);
        invertTreeRecursive(root.right);

        return root;
    }*/
    TreeNode invertTreeRecursive2(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = invertTreeRecursive2(root.left);
        TreeNode right = invertTreeRecursive2(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final TreeNode node = queue.poll();

            // Swap nodes
            final TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // Add left and right of this node to the queue
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return root;
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
