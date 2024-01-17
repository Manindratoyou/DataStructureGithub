package com.manindra.linkedlist;

import java.util.ArrayList;

public class LinkedListReverse {

    static Node head;

    public static void main(String[] args) {

        LinkedListReverse ls=new LinkedListReverse();
        ls.insertAtLast(10);
        ls.insertAtLast(20);
        ls.insertAtLast(30);
        ls.insertAtLast(40);
        ls.insertAtLast(50);
        printList1(head);
        System.out.println();
        //reverseList(head);
        //head=reverseListSolutionTwo(head);
        //head=reverseListSolutionThree(head);
        //head=reverseListSolutionFour(head,null);
        //head=reverseListKSize(head,3);
        head=reverseListKSizeSolutionTwo(head,3);
        printList1(head);

    }

    static Node reverseList(Node head){
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (Node current=head;current!=null;current=current.next){
            arrayList.add(current.data);
        }

        for (Node current=head;current!=null;current=current.next){
            current.data=arrayList.remove(arrayList.size()-1);
        }
        return head;
    }

    static Node reverseListSolutionTwo(Node head) {
        Node current = head;
        Node previous = null;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    static Node reverseListSolutionThree(Node head) {
        if (head==null ||head.next==null) return head;

        Node rest_head=reverseListSolutionThree(head.next);

        Node rest_tail=head.next;
        rest_tail.next=head;
        head.next=null;

        return rest_head;
    }

    static Node reverseListSolutionFour(Node current,Node previous) {
        if (current==null) return previous;
        Node next=current.next;
        current.next=previous;

        return reverseListSolutionFour(next,current);
    }

    static Node reverseListKSize(Node head,int k) {
        Node current=head,next=null,previous=null;
        int count=0;
        while (current!=null && count<k){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
            count++;
        }
        if (next!=null){
            Node rest_head=reverseListKSize(next,k);
            head.next=rest_head;
        }
        return previous;
    }

    static Node reverseListKSizeSolutionTwo(Node head, int k) {
        Node current = head, previousFirst = null;
        boolean isFirstPass = true;

        while (current != null) {
            Node first = current, previous = null;
            int count = 0;

            while (current != null && count < k) {
                Node next = current.next;
                current.next = previous;
                previous = current;
                current = next;
                count++;
            }

            if (isFirstPass) {
                head = previous;
                isFirstPass = false;
            } else {
                // Corrected the assignment to connect the reversed part with the previous part
                previousFirst.next = previous;
            }

            // Save the last node of the reversed part for connecting with the next reversed part
            previousFirst = first;
        }

        return head;
    }
    static void removeDuplicates(Node head) {
       Node current=head;
       while (current!=null || current.next!=null){
           if (current.data== current.next.data)
               current.next=current.next.next;
           else
               current=current.next;
       }
    }


    public void insertAtLast(int data){
        Node newNode=new Node(data);
        if (head==null)
            head=newNode;
        Node current=head;
        while (current.next !=null)
            current=current.next;
        current.next=newNode;
        newNode.next=null;
    }
    static void printList1(Node head){
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

