package com.manindra.tree_ds;

import java.util.ArrayList;

public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        // Create a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Serialize the binary tree
        ArrayList<Integer> serialized = new ArrayList<>();
        serialize(root, serialized);
        System.out.println("Serialized binary tree:");
        System.out.println(serialized);

        // Deserialize the binary tree
        index = 0; // Reset index for deserialization
        Node deserializedRoot = deSerialize(serialized);

        // Print the in-order traversal of the deserialized binary tree
        System.out.println("In-order traversal of deserialized binary tree:");
        inOrder(deserializedRoot);
    }

    static final int EMPTY = -1;

    static void serialize(Node root, ArrayList<Integer> arrayList) {
        if (root == null) {
            arrayList.add(EMPTY);
            return;
        }
        arrayList.add(root.key);
        serialize(root.left, arrayList);
        serialize(root.right, arrayList);
    }

    static int index = 0;

    static Node deSerialize(ArrayList<Integer> arrayList) {
        if (index == arrayList.size())
            return null;
        int val = arrayList.get(index);
        index++;
        if (val == EMPTY)
            return null;
        Node root = new Node(val);
        root.left = deSerialize(arrayList);
        root.right = deSerialize(arrayList);
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
