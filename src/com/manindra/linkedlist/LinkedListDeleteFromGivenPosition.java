package com.manindra.linkedlist;

public class LinkedListDeleteFromGivenPosition {

    static Node head = null;
    public static void main(String[] args) {

        head=insertAtBegin(head,80);
        head=insertAtBegin(head,90);
        head=insertAtBegin(head,100);
        printList(head);
        System.out.println();
        head=deleteFromGivenPosition(2);
        printList(head);
    }

   static Node deleteFromGivenPosition(int position){
        if (position==1) return head.next;
        else {
            Node previous=head;
            int count=1;
            while (count<position-1){
                previous=previous.next;
                count++;
            }
            Node current=previous.next;
            previous.next=current.next;
        }
        return head;
   }

    static Node insertAtBegin(Node head, int data){
        Node temp=new Node(data);
        temp.next=head;
        return temp;
    }
    static void printList(Node head){ //Tc 0(n) , A.s 0(n)
        Node current=head;
        while (current!=null){
            System.out.print(current.data+ "->");
            current=current.next;
        }
        System.out.println("null");
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
