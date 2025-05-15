package com.manindra.tree_bst_leetcode;

public class InsertIntoBST { //solution 701

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    // Helper to print inorder (sorted order)
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        InsertIntoBST obj = new InsertIntoBST();

        /*
         Input:
             4
            / \
           2   7
          / \
         1   3
         val = 5

         Output BST (inorder): 1 2 3 4 5 7
        */

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root = obj.insertIntoBST(root, 5);
        obj.inorder(root);  // Expected output: 1 2 3 4 5 7
    }
}

