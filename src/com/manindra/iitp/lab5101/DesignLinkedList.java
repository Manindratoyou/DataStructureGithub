package com.manindra.iitp.lab5101;

public class DesignLinkedList {

    public static void main(String[] args) {
        // Test case 1: Normal linked list
        Node head1 = null;
        head1 = addNode(head1, 10);
        head1 = addNode(head1, 20);
        head1 = addNode(head1, 30);
        System.out.println("Test case 1: Linked list elements:");
        printLinkedList(head1);

        // Test case 2: Linked list with one element
        Node head2 = null;
        head2 = addNode(head2, 5);
        System.out.println("Test case 2: Linked list elements:");
        printLinkedList(head2);

        // Test case 3: Empty linked list (should print nothing)
        Node head3 = null;
        System.out.println("Test case 3: Linked list elements:");
        printLinkedList(head3);

        // Test case 4: Linked list with duplicate elements
        Node head4 = null;
        head4 = addNode(head4, 100);
        head4 = addNode(head4, 100);
        head4 = addNode(head4, 200);
        System.out.println("Test case 4: Linked list elements:");
        printLinkedList(head4);
    }

    // Method to add a node to the linked list
    public static Node addNode(Node head, int value) {
        if (head == null) {
            return new Node(value);
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(value);
        return head;
    }

    // Method to print the linked list
    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

}
