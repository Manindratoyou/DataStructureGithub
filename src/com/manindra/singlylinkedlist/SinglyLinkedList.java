package com.manindra.singlylinkedlist;

public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        SinglyLinkedList sll=new SinglyLinkedList();
        /*sll.head=new ListNode(10);
        ListNode second=new ListNode(1);
        ListNode third=new ListNode(8);
        ListNode fourth=new ListNode(11);
        sll.head.next=second;
        second.next=third;
        third.next=fourth;*/

        //sll.insertFirst(11);
        //sll.insertFirst(8);
        //sll.insertFirst(1);

        //sll.insertLast(11);
        //sll.insertLast(8);
        //sll.insertLast(1);

        sll.insertAtGivenPosition(1,11);
        sll.insertAtGivenPosition(2,8);
        sll.insertAtGivenPosition(3,1);
        sll.display();
        System.out.println("length is "+sll.findLength());
    }
    public void insertFirst(int value){
        ListNode newNode=new ListNode(value);
        newNode.next=head;
        head=newNode;
    }
    public void insertLast(int value){
        ListNode newNode=new ListNode(value);
        if (head==null){
            head=newNode;
            return;
        }
        ListNode current=head;
        while (null!=current.next){
            current=current.next;
        }
        current.next=newNode;
    }

    public void insertAtGivenPosition(int position,int value){

        ListNode node=new ListNode(value);

        if (position==1){
            node.next=head;
            head=node;
        }else {
            ListNode previous=head;
            int count=1;
            while (count<position-1){
                previous=previous.next;
                count++;
            }
            ListNode current=previous.next;
            previous.next=node;
            node.next=current;
        }
    }
    public void display(){
        ListNode current=head;
        while (current!=null){
            System.out.print(current.data +"->");
            current=current.next;
        }
        System.out.println("null");
    }
    public int findLength(){
        if (head==null)
            return 0;
        int count=0;
        ListNode current=head;
        while (current !=null){
            count++;
            current=current.next;
        }
        return count;
    }
}
