package com.manindra.linkedlist;

import java.util.HashSet;

public class IntersectionPointLinkedList {

    public static void main(String[] args) {
        // Creating linked list 1
        Node head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(15);
        head1.next.next.next.next = new Node(30);

        // Creating linked list 2
        Node head2 = new Node(10);
        head2.next = head1.next.next.next; // Making it intersect with the first list

        System.out.println("Intersection point: " + getIntersection(head1, head2));

    }


    static int getIntersection(Node head1, Node head2) {
        HashSet<Node> nodeHashSet = new HashSet<>();
        Node current = head1;
        // Store all nodes of the first linked list in a HashSet
        while (current != null) {
            nodeHashSet.add(current);
            current = current.next;
        }
        // Traverse the second linked list and check if any node is already present in the HashSet
        current = head2;
        while (current != null) {
            if (nodeHashSet.contains(current))
                return current.data; // Intersection point found, return the data of the node
            current = current.next;
        }
        return -1; // No intersection point found
    }
}
