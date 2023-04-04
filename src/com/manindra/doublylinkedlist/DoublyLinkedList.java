package com.manindra.doublylinkedlist;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    public DoublyLinkedList(){
        this.head=null;
        this.tail=null;
        this.length=0;
    }

    private class ListNode{
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data){
            this.data=data;
        }
    }

    public boolean isEmpty(){
        return length==0;//or head==null
    }
    public int length(){
        return length;
    }
    //up ------------impl of doublylinkedlist------------------
    //=========================================================



}
