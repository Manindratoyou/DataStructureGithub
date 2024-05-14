package com.manindra.tree_ds;

import java.util.*;

public class ConstructBinaryTreeFrom_InOrderAndPreOrder2 {

    public static void main(String[] args) {
        int[] inOrder = {40, 20, 50, 10, 30, 80, 70, 90};
        int[] preOrder = {10, 20, 40, 50, 30, 70, 80, 90};

        Node treeRoot = buildTree(inOrder, preOrder);
        inOrder(treeRoot);
    }

    static int preIndex = 0;

    static Node buildTree(int[] inOrder, int[] preOrder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            indexMap.put(inOrder[i], i);
        }
        return buildTreeHelper(inOrder, preOrder, 0, inOrder.length - 1, indexMap);
    }

    static Node buildTreeHelper(int[] inOrder, int[] preOrder, int inStart, int inEnd, Map<Integer, Integer> indexMap) {
        if (inStart > inEnd) {
            return null;
        }
        int rootVal = preOrder[preIndex++];
        Node root = new Node(rootVal);
        int inIndex = indexMap.get(rootVal);
        root.left = buildTreeHelper(inOrder, preOrder, inStart, inIndex - 1, indexMap);
        root.right = buildTreeHelper(inOrder, preOrder, inIndex + 1, inEnd, indexMap);
        return root;
    }

    static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int k) {
            key = k;
            left = right = null;
        }
    }
}

