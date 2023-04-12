package com.manindra.circularlinkedlist;

public class CircularSinglyLinkedList {

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
}
