package com.manindra.linkedlist;

 class Node{
    int data;
    Node next;

    Node(int x){
        data=x;
        next=null;
    }
}

public class LinkedListExampleTwo {


    public static void main(String[] args) {

        Node head=new Node(10);
        head.next=new Node(20);
        head.next.next=new Node(30);
        head.next.next.next=new Node(40);
        printList(head);
    }

    static void printList(Node head){ //Tc 0(n) , A.s 0(n)
        Node current=head;
        while (current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
    }
}
