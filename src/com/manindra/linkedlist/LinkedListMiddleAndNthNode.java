package com.manindra.linkedlist;

public class LinkedListMiddleAndNthNode {

    public static void main(String[] args) {
        Node head = null;
        head=insertAtBegin(head,40);
        head=insertAtBegin(head,30);
        head=insertAtBegin(head,25);
        head=insertAtBegin(head,20);
        head=insertAtBegin(head,10);
        printList(head);
        System.out.println("=");
        printMiddle(head);
        printMiddleSolutionTwo(head);
        printNthFromEnd(head,2);
        printNthFromEndSolutionTwo(head,2);

    }

    static void printMiddle(Node head){
        if (head==null) return;
        int count=0;
        Node current;
        for (current=head;current!=null;current=current.next){
            count++;
        }
        current=head;
        for (int i=0;i<count/2;i++)
            current=current.next;

        System.out.println(current.data);
    }

    static void printMiddleSolutionTwo(Node head){
        if (head==null) return;

        Node slow=head,fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println(slow.data);
    }

    static void printNthFromEnd(Node head,int n){
        int length=0;
        for (Node current=head;current!=null;current=current.next)
            length++;
        if (length<n) return;
        Node current=head;
        for (int i=1;i<length-n+1;i++)
            current=current.next;
        System.out.println(current.data);
    }

    //using two pointer approach
    static void printNthFromEndSolutionTwo(Node head,int n){

        if (head==null) return;
        Node first=head;
        for (int i=0;i<n;i++){
            if (first==null) return;
            first=first.next;
        }
        Node second=head;
        while (first!=null){
            second=second.next;
            first=first.next;
        }
        System.out.println(second.data);
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
