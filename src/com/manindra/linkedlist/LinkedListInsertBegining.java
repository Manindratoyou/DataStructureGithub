package com.manindra.linkedlist;

public class LinkedListInsertBegining {

    Node head;
    public void insertAtBegin(int data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }

    static Node insertAtBegin1(Node head,int data){
        Node temp=new Node(data);
        temp.next=head;
        return temp;
    }
     void printList(){
        Node current=head;
        while (current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
    }
    static void printList1(Node head){
        Node current=head;
        while (current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
    }

    public static void main(String[] args) {

        LinkedListInsertBegining ls=new LinkedListInsertBegining();
        /*ls.insertAtBegin(10);
        ls.insertAtBegin(20);
        ls.insertAtBegin(30);
        ls.insertAtBegin(40);
        ls.insertAtBegin(50);*/
        Node head = null;
        head=insertAtBegin1(head,80);
        head=insertAtBegin1(head,90);
        head=insertAtBegin1(head,100);
        printList1(head);
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
