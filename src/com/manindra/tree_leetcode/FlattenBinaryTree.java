package com.manindra.tree_leetcode;

import java.util.Stack;

public class FlattenBinaryTree { //solution 114

    // Utility: Build test tree manually
    public TreeNode createTestTree1() {
        // Tree: [1,2,5,3,4,null,6]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        return root;
    }

    public TreeNode createTestTree2() {
        // Tree: [1,null,2,3]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }

    public TreeNode createTestTree3() {
        // Tree: [1]
        return new TreeNode(1);
    }

    public TreeNode createTestTree4() {
        // Tree: []
        return null;
    }

    public static void main(String[] args) {
        FlattenBinaryTree solution = new FlattenBinaryTree();

        // Test case 1
        TreeNode root1 = solution.createTestTree1();
        solution.flatten(root1);
        System.out.print("Flattened Tree 1: ");
        solution.printFlattenedList(root1); // Expected: 1 2 3 4 5 6

        // Test case 2
        TreeNode root2 = solution.createTestTree2();
        solution.flatten(root2);
        System.out.print("Flattened Tree 2: ");
        solution.printFlattenedList(root2); // Expected: 1 2 3

        // Test case 3
        TreeNode root3 = solution.createTestTree3();
        solution.flatten(root3);
        System.out.print("Flattened Tree 3: ");
        solution.printFlattenedList(root3); // Expected: 1

        // Test case 4
        TreeNode root4 = solution.createTestTree4();
        solution.flatten(root4);
        System.out.print("Flattened Tree 4: ");
        solution.printFlattenedList(root4); // Expected: (no output)
    }

    public void flatten(TreeNode root) { //Recursive Approach (Postorder)
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }

        temp.right = right;
    }

    public void flatten2(TreeNode root) { //Iterative Approach using Stack
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }

            if (!stack.isEmpty()) {
                current.right = stack.peek();
            }

            current.left = null;
        }
    }

    public void flatten3(TreeNode root) { //Morris Traversal (O(1) Space)
        TreeNode current = root;

        while (current != null) {
            if (current.left != null) {
                TreeNode rightmost = current.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                rightmost.right = current.right;
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }
    }

    // Method to print flattened tree as linked list (right-pointers only)
    public void printFlattenedList(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            if (root.left != null) {
                System.out.print("(ERROR: left child is not null!) ");
            }
            root = root.right;
        }
        System.out.println();
    }


    public class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}

