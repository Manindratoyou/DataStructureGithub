package com.manindra.linkedlist;

public class LinkedListInsertAtGivenPosition {

    Node head;
    public void insertAtGivenPosition(int position,int data){
       Node newNode=new Node(data);
       if (position==1){
           newNode.next=head;
           head=newNode;
       }else {
           Node previous=head;
           int count=1;
           while (count<position-1){
               previous=previous.next;
               count++;
           }
           Node current=previous.next;
           previous.next=newNode;
           newNode.next=current;
       }
    }

    static Node insertAtGivenPosition1(Node head, int position,int data){
        Node temp=new Node(data);
        if (position==1){
            temp.next=head;
            return temp;
        }
        Node current=head;
        for (int i=1;i<=position-2 && current!=null;i++)
            current=current.next;
        if (current==null) //out of position
            return head;
        temp.next=current.next;
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

        LinkedListInsertAtGivenPosition ls=new LinkedListInsertAtGivenPosition();
        ls.insertAtGivenPosition(1,10);
        ls.insertAtGivenPosition(2,20);
        ls.insertAtGivenPosition(3,30);
        ls.insertAtGivenPosition(4,40);
        ls.insertAtGivenPosition(5,50);
        ls.printList();
        /*Node head = null;
        head=insertAtGivenPosition1(head,1,80);
        head=insertAtGivenPosition1(head,2,90);
        head=insertAtGivenPosition1(head,3,100);
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
