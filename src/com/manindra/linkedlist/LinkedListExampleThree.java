package com.manindra.linkedlist;

public class LinkedListExampleThree {

    static class Node{
        int data;
        Node next;

        Node(int data,Node next){
            this.data=data;
            this.next=next;
        }
    }

    public static void main(String[] args) {

        Node head=new Node(10,new Node(20,new Node(30,null)));
        printListRecursive(head);
    }

    static void printListRecursive(Node head){ //tc 0(n) as 0(n)
        if (head==null)
            return;
        System.out.print(head.data+" ");
        printListRecursive(head.next);
    }
}
