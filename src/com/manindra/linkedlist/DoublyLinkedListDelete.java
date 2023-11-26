package com.manindra.linkedlist;

public class DoublyLinkedListDelete {

    public static void main(String[] args) {

        DNode head = null;
        head = insertBegin(head, 70);
        head = insertBegin(head, 80);
        head = insertBegin(head, 90);
        printDoublyLinkedList(head);
        head=deleteHead(head);
        printDoublyLinkedList(head);
    }

    static DNode deleteHead (DNode head){
        if (head==null || head.next==null) return null;
        else {
            head=head.next;
            head.previous=null;
            return head;
        }
    }


    static DNode insertBegin(DNode head, int data) {
        DNode temp = new DNode(data);
        temp.next = head;
        if (head != null) head.previous = temp;
        return temp;
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
