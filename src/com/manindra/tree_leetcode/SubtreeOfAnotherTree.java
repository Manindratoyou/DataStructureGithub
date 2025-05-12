package com.manindra.tree_leetcode;

public class SubtreeOfAnotherTree { //solution 572

    public static void main(String[] args) {
        // Create the main tree:
        //       3
        //      / \
        //     4   5
        //    / \
        //   1   2
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        // Create the subtree:
        //     4
        //    / \
        //   1   2
        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        SubtreeOfAnotherTree solution = new SubtreeOfAnotherTree();
        boolean result = solution.isSubtree(root, subRoot);

        // Print the result
        System.out.println("Is subRoot a subtree of root? " + result); // Expected: true
    }

    boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String fullTree = preOrderTraversal(root);
        String subTree = preOrderTraversal(subRoot);

        return fullTree.contains(subTree);
    }

    String preOrderTraversal(TreeNode node) {
        if (node == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder("^");
        sb.append(node.val);
        sb.append(preOrderTraversal(node.left));
        sb.append(preOrderTraversal(node.right));

        return sb.toString();
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
