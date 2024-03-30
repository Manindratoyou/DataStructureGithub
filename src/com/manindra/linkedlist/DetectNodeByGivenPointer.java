package com.manindra.linkedlist;

public class DetectNodeByGivenPointer {

    public static void main(String[] args) {

        // Creating a linked list with four nodes
        Node head = new Node(10);  // First node with data 10
        head.next = new Node(20);  // Second node with data 20
        Node ptr = new Node(30);   // Third node with data 30
        head.next.next = ptr;      // Linking the third node to the second node
        head.next.next.next = new Node(25);  // Creating the fourth node and linking it

        printList1(head);// Printing the list before node detection
        System.out.println();
        detectNode(ptr);   // Calling the method to detect the node
        printList1(head);  // Printing the list after node detection
    }

    static void detectNode(Node ptr){
        if(ptr != null && ptr.next != null) {  // Check if ptr and ptr.next are not null
            Node temp = ptr.next;    // Storing the next node of the given pointer
            ptr.data = temp.data;    // Copying the data of the next node to the current node
            ptr.next = temp.next;    // Adjusting the next pointer of the current node to skip the next node
        } else {
            System.out.println("Cannot detect node. Pointer is null or points to the last node.");
        }
    }

    static void printList1(Node head){
        Node current=head;
        while (current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
    }
}
