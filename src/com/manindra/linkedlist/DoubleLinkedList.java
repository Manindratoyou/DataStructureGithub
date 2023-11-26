package com.manindra.linkedlist;

public class DoubleLinkedList {

    public static void main(String[] args) {

        DNode head=new DNode(10);
        DNode temp1=new DNode(20);
        DNode temp2=new DNode(30);
        head.next=temp1;
        temp1.previous=head;
        temp1.next=temp2;
        temp2.previous=temp1;
        printDoublyLinkedList(head);
    }

    private static class DNode{
        int data;
        DNode previous;
        DNode next;

        DNode(int d){
            data=d;
            previous=null;
            next=null;
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
