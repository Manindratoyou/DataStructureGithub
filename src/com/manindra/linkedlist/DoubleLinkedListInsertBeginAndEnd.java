package com.manindra.linkedlist;

public class DoubleLinkedListInsertBeginAndEnd {

    public static void main(String[] args) {
        DNode head = null;
        head = insertBegin(head, 70);
        head = insertBegin(head, 80);
        head = insertBegin(head, 90);
        printDoublyLinkedList(head);

        head = insertEnd(head, 20);
        head = insertEnd(head, 30);
        head = insertEnd(head, 40);
        printDoublyLinkedList(head);
    }

    static DNode insertBegin(DNode head, int data) {
        DNode temp = new DNode(data);
        temp.next = head;
        if (head != null) head.previous = temp;
        return temp;
    }
    static DNode insertEnd(DNode head, int data) {
        DNode temp = new DNode(data);
        if (head==null) return temp;
        DNode current=head;
        while (current.next!=null) current=current.next;
        current.next=temp;
        temp.previous=current;
        return head;
    }


    private static class DNode {
        int data;
        DNode previous;
        DNode next;

        DNode(int d) {
            data = d;
            previous = null;
            next = null;
        }
    }

    private static void printDoublyLinkedList(DNode head) {
        DNode current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println(); // Move to the next line after printing the list
    }
}
