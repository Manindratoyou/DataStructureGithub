package com.manindra.tree_ds_and_bst;

public class ChildrenSumProperty {

    public static void main(String[] args) {

        /*

        20
       /  \
      8    12
     / \     \
    3   5    12

     */


        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(12);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(12);
        System.out.println(isSum(root));

    }

    static boolean isSum(Node root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        int sum = 0;
        if (root.left != null)
            sum += root.left.key;
        if (root.right != null)
            sum += root.right.key;
        return root.key == sum && isSum(root.left) && isSum(root.right);
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
