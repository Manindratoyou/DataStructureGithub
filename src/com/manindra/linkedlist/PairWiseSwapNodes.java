package com.manindra.linkedlist;

public class PairWiseSwapNodes {

    public static void main(String[] args) {
        // Example usage
        // Creating a linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printLinkedList(head);

        // Performing pairwise swap
        //head = pairWiseSwap(head);
        head = pairWiseSwapSolutionTwo(head);

        System.out.println("Linked List after Pairwise Swapping:");
        printLinkedList(head);
    }

    static Node pairWiseSwap(Node head) {
        Node current = head;
        while (current != null && current.next != null) {
            // Swapping data of current and next nodes
            int temp = current.data;
            current.data = current.next.data;
            current.next.data = temp;

            // Moving current pointer to next-next node
            current = current.next.next;
        }
        return head;
    }

    static Node pairWiseSwapSolutionTwo(Node head) {
        // Check if the list is empty or contains only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers for swapping
        Node current = head.next.next;
        Node previous = head;
        head = head.next;
        head.next = previous;

        // Perform pairwise swapping for remaining nodes
        while (current != null && current.next != null) {
            // Swap nodes
            previous.next = current.next;
            previous = current;
            Node next = current.next.next;
            current.next.next = current;
            current = next;
        }

        // Link the remaining node if the list contains an odd number of nodes
        previous.next = current;

        return head;
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
