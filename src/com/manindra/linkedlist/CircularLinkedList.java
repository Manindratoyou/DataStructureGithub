package com.manindra.linkedlist;

public class CircularLinkedList {

    public static void main(String[] args) {
        CNode head=new CNode(10);
        head.next=new CNode(5);
        head.next.next=new CNode(20);
        head.next.next.next=new CNode(15);
        head.next.next.next=head;
        printCircularListSolOne(head);
        System.out.println();
        printCircularListSolTwo(head);
    }

    static void printCircularListSolOne(CNode head){
        if (head==null) return;
        System.out.print(head.data +" ");
        for (CNode r=head.next;r!=head;r=r.next)
            System.out.print(r.data+" ");
    }
    static void printCircularListSolTwo(CNode head){
        if (head==null) return;
       CNode r=head;
       do {
           System.out.print(r.data+" ");
           r=r.next;
       }while (r!=head);
    }

    private static class CNode{
        int data;
        CNode next;
        CNode(int d){
            data=d;
            next=null;
        }
    }
}
