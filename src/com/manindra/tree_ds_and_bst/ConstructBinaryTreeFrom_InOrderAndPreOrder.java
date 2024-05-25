package com.manindra.tree_ds_and_bst;

public class ConstructBinaryTreeFrom_InOrderAndPreOrder {

    public static void main(String[] args) {

        int[] inOrder = {40, 20, 50, 10, 30, 80, 70, 90};
        int[] preOrder = {10, 20, 40, 50, 30, 70, 80, 90};

        int n = inOrder.length;
        Node treeRoot = constructTree(inOrder, preOrder, 0, n - 1);
        inOrder(treeRoot);

        /*
    10
   / \
  20  30
 /   / \
40  70  80
   /     \
  50      90

         */
    }

    static int preIndex = 0;

    static Node constructTree(int[] in, int[] pre, int start, int end) {
        if (start > end)
            return null;
        Node root = new Node(pre[preIndex++]);
        int inIndex = start;
        for (int i = start; i <= end; i++) {
            if (in[i] == root.key) {
                inIndex = i;
                break;
            }
        }
        root.left = constructTree(in, pre, start, inIndex - 1);
        root.right = constructTree(in, pre, inIndex + 1, end);

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
