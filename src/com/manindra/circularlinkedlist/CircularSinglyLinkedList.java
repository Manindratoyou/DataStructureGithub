package com.manindra.circularlinkedlist;

public class CircularSinglyLinkedList {

    public static void main(String[] args) {

        CircularSinglyLinkedList csll =new CircularSinglyLinkedList();
        csll.createCircularLinkedList();
        csll.display();

    }

    private ListNode last;
    private int length;

    public CircularSinglyLinkedList() {
        last=null;
        length=0;
    }

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data=data;
        }
    }

    public int length(){
        return length;
    }
    public boolean isEmpty(){
        return length==0;
    }

    //==implementation of circular singly linked list in java==//
    //=========================================================

    public void createCircularLinkedList(){
        ListNode first=new ListNode(5);
        ListNode second=new ListNode(6);
        ListNode third=new ListNode(9);
        ListNode fourth=new ListNode(15);

        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=first;

        last=fourth;
    }

    public void display(){
        if (last==null)
            return;
        ListNode first=last.next;
        while (first!=last) {
            System.out.print(first.data + " ");
            first=first.next;
        }
        System.out.print(first.data+ " ");
    }
}
