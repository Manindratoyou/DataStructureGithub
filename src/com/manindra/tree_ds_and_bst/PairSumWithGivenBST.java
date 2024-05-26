package com.manindra.tree_ds_and_bst;

import java.util.ArrayList;
import java.util.HashSet;

public class PairSumWithGivenBST {

    public static void main(String[] args) {
        // Creating a sample binary search tree
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);

        int targetSum = 33;

        if (isPairPresent(root, targetSum)) {
            System.out.println("Pair with the given sum is found.");
        } else {
            System.out.println("Pair with the given sum is not found.");
        }
    }

    static ArrayList<Integer> treeToList(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return list;
        }
        treeToList(root.left, list);
        list.add(root.key);  // Fix: Adding the key to the list during inorder traversal
        treeToList(root.right, list);
        return list;
    }

    static boolean isPairPresent(Node root, int target) {
        ArrayList<Integer> elements = new ArrayList<>();
        treeToList(root, elements);

        int start = 0;
        int end = elements.size() - 1;
        while (start < end) {
            int sum = elements.get(start) + elements.get(end);
            if (sum == target) {
                System.out.println("Pair found: " + elements.get(start) + " " + elements.get(end));
                return true;
            }
            if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return false;
    }

    static boolean isPairSum(Node root, int sum, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }
        if (isPairSum(root.left, sum, set)) {
            return true;
        }
        if (set.contains(sum - root.key)) {
            return true;
        } else {
            set.add(root.key);
        }
        return isPairSum(root.right, sum, set);
    }

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }
}
