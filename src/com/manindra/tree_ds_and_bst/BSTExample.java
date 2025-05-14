package com.manindra.tree_ds_and_bst;

public class BSTExample {

    // Insert a value into the BST
    public TreeNode insert(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val < root.val)
            root.left = insert(root.left, val);
        else if (val > root.val)
            root.right = insert(root.right, val); // skip duplicates
        return root;
    }

    public TreeNode insertIterative(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) return newNode;

        TreeNode current = root;
        TreeNode parent = null;

        while (current != null) {
            parent = current;
            if (val < current.val) {
                current = current.left;
            } else if (val > current.val) {
                current = current.right;
            } else {
                // Value already exists, skip duplicates
                return root;
            }
        }

        if (val < parent.val) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        return root;
    }

    // Search for a value in the BST
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;
        if (val < root.val)
            return searchBST(root.left, val);

        return searchBST(root.right, val);
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null && root.val != val) {
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }


    public static void main(String[] args) {
        BSTExample bst = new BSTExample();
        TreeNode root = null;

        // Insert values into the BST
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values) {
            root = bst.insert(root, val);
        }

        // Search for a value
        int searchVal = 60;
        //int searchVal = 99;
        TreeNode result = bst.searchBST(root, searchVal);
        //TreeNode result = bst.searchBST2(root, searchVal);

        if (result != null) {
            System.out.println("Value " + searchVal + " found in the BST.");
        } else {
            System.out.println("Value " + searchVal + " not found in the BST.");
        }
    }

    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }
}

