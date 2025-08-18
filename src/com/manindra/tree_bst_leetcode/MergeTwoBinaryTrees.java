package com.manindra.tree_bst_leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTrees { //solution 617

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        TreeNode merged = mergeTrees(t1, t2);

        System.out.print("Inorder of merged tree: ");
        inorder(merged);  // Output: 5 4 4 3 5 7
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{root1, root2});

        while (!queue.isEmpty()) {
            TreeNode[] nodes = queue.poll();
            TreeNode n1 = nodes[0], n2 = nodes[1];

            n1.val += n2.val; // merge values

            // Merge left
            if (n1.left != null && n2.left != null) {
                queue.add(new TreeNode[]{n1.left, n2.left});
            } else if (n1.left == null) {
                n1.left = n2.left;
            }

            // Merge right
            if (n1.right != null && n2.right != null) {
                queue.add(new TreeNode[]{n1.right, n2.right});
            } else if (n1.right == null) {
                n1.right = n2.right;
            }
        }
        return root1;
    }




    // TreeNode definition
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }
}

