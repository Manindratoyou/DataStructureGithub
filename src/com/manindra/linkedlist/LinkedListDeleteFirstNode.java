package com.manindra.linkedlist;

public class LinkedListDeleteFirstNode {

    public static void main(String[] args) {
        Node head = null;
        head=insertAtBegin(head,80);
        head=insertAtBegin(head,90);
        head=insertAtBegin(head,100);
        printList(head);
        System.out.println(" ");
        //head=deleteHead(head);
        head=deleteHeadSolTwo(head);
        printList(head);
    }

    static Node deleteHead(Node head){
        if (head==null) return null;
        else return head.next;
    }
    static Node deleteHeadSolTwo(Node head){
        if (head==null) return null;

        Node temp=head;
        head=head.next;
        temp.next=null;
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
