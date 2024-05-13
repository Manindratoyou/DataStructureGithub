package com.manindra.tree_ds;

public class ConvertBinaryTree_To_Doubly_Linked_List {

    public static void main(String[] args) {
        /*
         Constructing the binary tree:
              10
             /  \
           20    30
          / \     \
        40   50    70
         */
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right = new Node(30);
        root.right.right = new Node(70);

        // Convert binary tree to doubly linked list
        Node head = binaryTree_To_Doubly_Linked_List(root);

        // Print the doubly linked list
        System.out.println("Doubly linked list after conversion:");
        printDoublyLinkedList(head);
    }

    static Node previous = null;
    static Node binaryTree_To_Doubly_Linked_List(Node root) {
        if (root == null)
            return root;
        Node head = binaryTree_To_Doubly_Linked_List(root.left);
        if (previous == null)
            head = root;
        else {
            root.left = previous;
            previous.right = root;
        }
        previous = root;
        binaryTree_To_Doubly_Linked_List(root.right);
        return head;
    }

    static void printDoublyLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.key + " ");
            current = current.right;
        }
        System.out.println();
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
