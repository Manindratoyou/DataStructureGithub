package com.manindra.leetcodemedium_2;

public class HouseRobberIII {

    public static void main(String[] args) {
        // Test cases
        // Case 1:
        //      3
        //     / \
        //    2   3
        //     \   \
        //      3   1
        // Maximum loot = 3 + 3 + 1 = 7
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(1);
        System.out.println("Maximum loot for case 1: " + rob(root1)); // Expected output: 7

        // Case 2:
        //      3
        //     / \
        //    4   5
        //   / \   \
        //  1   3   1
        // Maximum loot = 4 + 3 + 5 = 12
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(1);
        System.out.println("Maximum loot for case 2: " + rob(root2)); // Expected output: 12
    }

    static int rob(TreeNode root) {

        int[] options = travel(root);
        return Math.max(options[0], options[1]);
    }

    static int[] travel(TreeNode root) {
        // Base case. just return {0,0} as you cannot rob anything
        if (root == null)
            return new int[2];

        int[] left_node_choices = travel(root.left);
        int[] right_node_choices = travel(root.right);
        int[] options = new int[2];

        // Store value if looted in [0]
        options[0] = root.val + left_node_choices[1] + right_node_choices[1];

        // Store value if skipped in [1]
        options[1] = Math.max(left_node_choices[0], left_node_choices[1]) +
                Math.max(right_node_choices[0], right_node_choices[1]);

        return options;
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

}
