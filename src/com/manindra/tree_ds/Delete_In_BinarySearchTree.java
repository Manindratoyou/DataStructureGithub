package com.manindra.tree_ds;

public class Delete_In_BinarySearchTree {

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        System.out.println("In-order traversal of the initial tree:");
        inOrderTraversal(root);
        System.out.println();

        int keyToDelete = 50;
        root = deleteNode(root, keyToDelete);

        System.out.println("In-order traversal after deleting " + keyToDelete + ":");
        inOrderTraversal(root);
        System.out.println();
    }

    static Node deleteNode(Node root, int x) {
        if (root == null)
            return root;
        if (root.key > x)
            root.left = deleteNode(root.left, x);
        else if (root.key < x) {
            root.right = deleteNode(root.right, x);
        } else {
            if (root.left == null)
                return root.right;
            else if (root.right == null) {
                return root.left;
            } else {
                Node succ = getSuccessor(root);
                root.key = succ.key;
                root.right = deleteNode(root.right, succ.key);
            }
        }
        return root;
    }

    static Node getSuccessor(Node current) {
        current = current.right;
        while ((current != null && current.left != null))
            current = current.left;
        return current;
    }

    static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.key + " ");
            inOrderTraversal(root.right);
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
