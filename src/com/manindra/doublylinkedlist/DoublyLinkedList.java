package com.manindra.doublylinkedlist;

public class DoublyLinkedList {

    public static void main(String[] args) {

        DoublyLinkedList dll=new DoublyLinkedList();
        dll.insertFirst(10);
        dll.insertFirst(4);
        dll.insertFirst(12);

        dll.displayForward();
        dll.displayBackward();
    }

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

    //insert the node at the beginning of dll
    public void insertFirst(int value){
        ListNode newNode=new ListNode(value);
        if (isEmpty())
            tail=newNode;
            else {
            head.previous = newNode;
        }
            newNode.next=head;
            head=newNode;
            length++;
    }

    public void displayForward(){
        if (head==null)
            return;
        ListNode temp=head;
        while (temp!=null){
            System.out.print(temp.data+ "-->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void displayBackward() {
        if (tail == null)
            return;
        ListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.previous;
        }
        System.out.println("null");
    }

}
