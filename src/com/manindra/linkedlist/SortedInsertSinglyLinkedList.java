package com.manindra.linkedlist;

public class SortedInsertSinglyLinkedList {


    public static void main(String[] args) {
        Node head = null;
        head=insertAtBegin(head,40);
        head=insertAtBegin(head,30);
        head=insertAtBegin(head,20);
        head=insertAtBegin(head,10);
        //printList(head);
        head=sortedInsert(head,25);
        printList(head);

    }

    static Node sortedInsert(Node head,int x){
        Node temp = new Node(x);

        // Case: Insert at the beginning
        if (head == null || x < head.data) {
            temp.next = head;
            return temp; // Update the head to the new node
        }

        // Traverse the list to find the correct position for insertion
        Node current = head;
        while (current.next != null && current.next.data < x) {
            current = current.next;
        }

        // Insert the new node
        temp.next = current.next;
        current.next = temp;

        return head; // Return the original head
    }

    static Node insertAtBegin(Node head, int data){
        Node temp=new Node(data);
        temp.next=head;
        return temp;
    }
    static void printList(Node head){ //Tc 0(n) , A.s 0(n)
        Node current=head;
        while (current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
    }

    static class Node{

        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

}
