package com.manindra.linkedlist;

public class SegregateEvenOdd {

    public static void main(String[] args) {
        // Example usage
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printLinkedList(head);

        Node segregatedHead = segregate(head);

        System.out.println("Segregated Linked List:");
        printLinkedList(segregatedHead);
    }

    static Node segregate(Node head){
        Node evenStart = null, evenEnd = null, oddStart = null, oddEnd = null;

        for (Node curr = head; curr != null; curr = curr.next) {
            int x = curr.data;
            if (x % 2 == 0) {
                if (evenStart == null) {
                    evenStart = curr;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = curr;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddStart == null) {
                    oddStart = curr;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = curr;
                    oddEnd = oddEnd.next;
                }
            }
        }
        if (oddStart == null || evenStart == null)
            return head;
        evenEnd.next = oddStart;
        oddEnd.next = null;
        return evenStart;
    }

    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
