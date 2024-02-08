package com.manindra.leetcode;

//binary tree range sum
public class Solution938 {

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


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
