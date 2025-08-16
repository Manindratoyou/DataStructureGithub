package com.manindra.tree_bst_leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class AllNodesDistanceKBinaryTree { //solution 863

    public static void main(String[] args) {
        // Build example tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode target = root.left; // node 5
        System.out.println(distanceK(root, target, 2)); // [7, 4, 1]
    }


    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParentMap(root, parent);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);

        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (dist == K) {
                List<Integer> ans = new ArrayList<>();
                for (TreeNode node : queue) ans.add(node.val);
                return ans;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // Explore neighbors (left, right, parent)
                if (node.left != null && visited.add(node.left)) queue.add(node.left);
                if (node.right != null && visited.add(node.right)) queue.add(node.right);
                if (parent.containsKey(node) && visited.add(parent.get(node)))
                    queue.add(parent.get(node));
            }
            dist++;
        }
        return new ArrayList<>();
    }

    public static List<Integer> distanceK2(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParentMap(root, parent);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);

        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (dist == K) {
                return queue.stream().map(node -> node.val).collect(Collectors.toList());
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && visited.add(node.left)) queue.add(node.left);
                if (node.right != null && visited.add(node.right)) queue.add(node.right);
                if (parent.containsKey(node) && visited.add(parent.get(node)))
                    queue.add(parent.get(node));
            }
            dist++;
        }
        return Collections.emptyList();
    }

    // Step 1: Map each node -> parent

    private static void buildParentMap(TreeNode root, Map<TreeNode, TreeNode> parent) {
        if (root == null) return;
        if (root.left != null) {
            parent.put(root.left, root);
            buildParentMap(root.left, parent);
        }
        if (root.right != null) {
            parent.put(root.right, root);
            buildParentMap(root.right, parent);
        }
    }

    // TreeNode definition
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }
}

