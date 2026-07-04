package com.manindra.tree_leetcode;

import java.util.*;

//solution 297
public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {

        SerializeAndDeserializeBinaryTree codec =
                new SerializeAndDeserializeBinaryTree();

        // ================= Test Case 1 =================
        //       1
        //      / \
        //     2   3
        //        / \
        //       4   5

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);

        System.out.println("===== Test Case 1 =====");
        String serialized1 = codec.serialize(root1);
        System.out.println("Serialized: " + serialized1);

        TreeNode deserialized1 = codec.deserialize(serialized1);
        System.out.print("Deserialized Tree: ");
        printLevelOrder(deserialized1);

        // ================= Test Case 2 =================
        // Empty Tree

        System.out.println("\n===== Test Case 2 =====");
        TreeNode root2 = null;
        String serialized2 = codec.serialize(root2);
        System.out.println("Serialized: \"" + serialized2 + "\"");

        TreeNode deserialized2 = codec.deserialize(serialized2);
        System.out.print("Deserialized Tree: ");
        printLevelOrder(deserialized2);

        // ================= Test Case 3 =================
        // Single Node

        TreeNode root3 = new TreeNode(10);

        System.out.println("\n===== Test Case 3 =====");
        String serialized3 = codec.serialize(root3);
        System.out.println("Serialized: " + serialized3);

        TreeNode deserialized3 = codec.deserialize(serialized3);
        System.out.print("Deserialized Tree: ");
        printLevelOrder(deserialized3);

        // ================= Test Case 4 =================
        // Left Skewed Tree
        //
        //      1
        //     /
        //    2
        //   /
        //  3
        // /
        //4

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(3);
        root4.left.left.left = new TreeNode(4);

        System.out.println("\n===== Test Case 4 =====");
        String serialized4 = codec.serialize(root4);
        System.out.println("Serialized: " + serialized4);

        TreeNode deserialized4 = codec.deserialize(serialized4);
        System.out.print("Deserialized Tree: ");
        printLevelOrder(deserialized4);

        // ================= Test Case 5 =================
        // Right Skewed Tree
        //
        //1
        // \
        //  2
        //   \
        //    3
        //     \
        //      4

        TreeNode root5 = new TreeNode(1);
        root5.right = new TreeNode(2);
        root5.right.right = new TreeNode(3);
        root5.right.right.right = new TreeNode(4);

        System.out.println("\n===== Test Case 5 =====");
        String serialized5 = codec.serialize(root5);
        System.out.println("Serialized: " + serialized5);

        TreeNode deserialized5 = codec.deserialize(serialized5);
        System.out.print("Deserialized Tree: ");
        printLevelOrder(deserialized5);
    }

    // Encodes a tree to a single string using level-order traversal.
    String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (sb.length() > 0) sb.append(',');
            if (node == null) {
                sb.append('n');
            } else {
                sb.append(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        String[] parts = data.split(",");
        if (parts.length == 0 || parts[0].equals("n")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < parts.length) {
            TreeNode parent = q.poll();

            // Left child
            if (i < parts.length && !parts[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(parts[i]));
                parent.left = left;
                q.offer(left);
            }
            i++;

            // Right child
            if (i < parts.length && !parts[i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(parts[i]));
                parent.right = right;
                q.offer(right);
            }
            i++;
        }

        return root;
    }

    // Print tree in level order
    static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is Empty");
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                System.out.print("null ");
                continue;
            }

            System.out.print(node.val + " ");

            if (node.left != null || node.right != null) {
                q.offer(node.left);
                q.offer(node.right);
            }
        }

        System.out.println();
    }


    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}