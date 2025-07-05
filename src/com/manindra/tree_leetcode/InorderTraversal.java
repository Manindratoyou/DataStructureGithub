package com.manindra.tree_leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InorderTraversal { //solution 94

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new InorderTraversal().inorderTraversal(root)); // [1, 3, 2]
    }

    public List<Integer> inorderTraversal(TreeNode root) { //Recursive Approach
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorderHelper(root.left, result);
            result.add(root.val);
            inorderHelper(root.right, result);
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) { //Iterative Approach (Using Stack)
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

    public List<Integer> inorderTraversal3(TreeNode root) { //Morris Inorder Traversal (No Stack, No Recursion)
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                result.add(current.val);
                current = current.right;
            } else {
                TreeNode pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }

        return result;
    }

    public List<Integer> inorderTraversal4(TreeNode root) {
        return inorderStream(root).collect(Collectors.toList());
    }

    private Stream<Integer> inorderStream(TreeNode node) {
        if (node == null) return Stream.empty();
        return Stream.concat(
                Stream.concat(inorderStream(node.left), Stream.of(node.val)),
                inorderStream(node.right)
        );
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }
}

