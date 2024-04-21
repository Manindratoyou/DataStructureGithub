package com.manindra.leetcodeEasy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsBinaryTree { //leet code solution 637

    public static void main(String[] args) {

        // Creating a tree that looks like
        //            2
        TreeNode root = new TreeNode(2);

        // Adding left and right child
        //            2
        //          /  \
        //        8     4
        root.left = new TreeNode(8);
        root.right = new TreeNode(4);

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        // Adding more child to left node
        //            2
        //          /  \
        //        8     4
        //      /  \
        //     3   7
        leftNode.left = new TreeNode(3);
        leftNode.right = new TreeNode(7);

        // Adding child to right node
        //            2
        //          /  \
        //        8     4
        //      /  \     \
        //     3   7      1
        rightNode.right = new TreeNode(1);

        // Adding child to child of right node
        //            2
        //          /  \
        //        8     4
        //      /  \     \
        //     3   7      1
        //               /
        //              6
        rightNode.right.left = new TreeNode(6);

        System.out.println("level order traversal "+levelOrder(root));
        System.out.println("average of levels  "+averageOfLevels(root));

    }

    static List<Double> averageOfLevels(TreeNode root) {

        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.add(root);
        levelQueue.add(null);

        List<Double> avgList = new ArrayList<>();

        while (levelQueue.peek() != null) {

            double sum = 0;
            int nodes = 0;

            while (levelQueue.peek() != null) {

                TreeNode node = levelQueue.poll();
                sum += node.val;
                nodes++;

                if (node.left != null) levelQueue.add(node.left);
                if (node.right != null) levelQueue.add(node.right);
            }

            levelQueue.add(levelQueue.poll());
            avgList.add(sum / nodes);
        }

        return avgList;
    }

    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }

            result.add(currentLevel);
        }

        return result;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
