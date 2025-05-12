package com.manindra.tree_leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution938 { //Range Sum of BST

    /*
          10
         /  \
        5    15
       / \     \
      3   7    18

     */

    public static void main(String[] args) {
        // Sample test case 1
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(7);
        root1.right.right = new TreeNode(18);

        int low1 = 7;
        int high1 = 15;
        System.out.println("Test Case 1: " + rangeSumBST(root1, low1, high1)); // Output: 32
        System.out.println("Test Case 1: " + rangeSumBST2(root1, low1, high1)); // Output: 32

        // Sample test case 2
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(7);
        root2.right.right = new TreeNode(18);

        int low2 = 5;
        int high2 = 10;
        System.out.println("Test Case 2: " + rangeSumBST(root2, low2, high2)); // Output: 23
    }

    static int rangeSumBST(TreeNode root,int low,int high){
        if (root==null)
            return 0;
        int sum=0;

        //explore the left subtree
        if (root.val>low)
            sum+=rangeSumBST(root.left,low,high);

        //if value is in range add it to sum
        if (root.val>=low && root.val<=high)
            sum+= root.val;

        //explore the right subtree only if required
        if (root.val<high)
            sum+=rangeSumBST(root.right,low,high);

        return sum;

    }

    // Function to calculate the range sum of BST using level-order traversal (BFS)
    static int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null)
            return 0;

        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // If current node's value is within the range, add it to the sum
            if (current.val >= low && current.val <= high) {
                sum += current.val;
            }

            // Add left child to the queue if it might have nodes within the range
            if (current.left != null && current.val > low) {
                queue.add(current.left);
            }

            // Add right child to the queue if it might have nodes within the range
            if (current.right != null && current.val < high) {
                queue.add(current.right);
            }
        }

        return sum;
    }



}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
