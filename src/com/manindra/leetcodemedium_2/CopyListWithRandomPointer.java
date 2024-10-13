package com.manindra.leetcodemedium_2;

public class CopyListWithRandomPointer { //solution 138

    public static void main(String[] args) {
        // Create the original list with random pointers
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Set up the random pointers
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        // Create an object of the class and call the method
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();
        Node copiedListHead = solution.copyRandomList(node1);

        // Print the original and copied lists
        System.out.println("Original List:");
        printList(node1);

        System.out.println("\nCopied List:");
        printList(copiedListHead);
    }

    Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head; // Create new list w/ same values
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        curr = head; // Copy the random pointers
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        curr = head; // Separate the two lists
        Node newHead = head.next;
        Node newCurr = newHead;
        while (curr != null) {
            curr.next = newCurr.next;
            curr = curr.next;
            if (curr != null) {
                newCurr.next = curr.next;
                newCurr = newCurr.next;
            }
        }

        return newHead;
    }

    // Helper method to print the list (both values and random pointers)
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            int randomVal = (curr.random != null) ? curr.random.val : -1;
            System.out.println("Node Value: " + curr.val + ", Random Pointer Value: " + randomVal);
            curr = curr.next;
        }
    }

    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
