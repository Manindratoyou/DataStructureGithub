package com.manindra.linkedlist;

public class LinkedListDeleteLastNode {

    public static void main(String[] args) {

        ListNode head=new ListNode(10);
        head.next=new ListNode(20);
        head.next.next=new ListNode(30);
        printList(head);
        System.out.println();
        //head=deleteLast(head);
        head=deleteLastSolTwo(head);
        printList(head);
    }

    static ListNode deleteLast(ListNode head){
        if (head==null) return null;
        if (head.next==null) return null;
        ListNode current=head;
        while (current.next.next !=null){
            current=current.next;
        }
        current.next=null;
        return head;
    }
    static ListNode deleteLastSolTwo(ListNode head){
        if (head==null || head.next==null) return null;
        ListNode current=head;
        ListNode previous=null;
        while (current.next !=null){
            previous=current;
            current=current.next;
        }
        previous.next=null;// break the chain
        return head;
    }

    static void printList(ListNode head){
        ListNode current=head;
        while (current !=null){
            System.out.print(current.val+ "->");
            current=current.next;
        }
        System.out.println("null");
    }

    private static class ListNode{

        private int val;

        ListNode next;

        ListNode(){}

        ListNode (int val){
            this.val=val;
        }
    }
}
