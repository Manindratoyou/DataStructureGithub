package com.manindra.linkedlist;

public class LinkedListInsertLast {
    Node head;
    public void insertAtLast(int data){
        Node newNode=new Node(data);
        if (head==null)
            head=newNode;
        Node current=head;
        while (current.next !=null)
            current=current.next;
        current.next=newNode;
        newNode.next=null;
    }

    static Node insertAtLast1(Node head, int data){
        Node temp=new Node(data);
        if (head==null)
            return temp;
        Node current=head;
        while (current.next !=null)
            current=current.next;
        current.next=temp;
        return head;
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

        LinkedListInsertLast ls=new LinkedListInsertLast();
        ls.insertAtLast(10);
        ls.insertAtLast(20);
        ls.insertAtLast(30);
        ls.insertAtLast(40);
        ls.insertAtLast(50);
        ls.printList();
      /*  Node head = null;
        head=insertAtBegin1(head,80);
        head=insertAtBegin1(head,90);
        head=insertAtBegin1(head,100);
        printList1(head);*/
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
