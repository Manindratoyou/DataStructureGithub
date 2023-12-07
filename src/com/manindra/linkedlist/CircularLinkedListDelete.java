package com.manindra.linkedlist;

public class CircularLinkedListDelete {

    public static void main(String[] args) {
        CNode head=null;
        head=insertBegin(head,10);
        head=insertBegin(head,20);
        head=insertBegin(head,30);
        printCircularListSolTwo(head);
        //head=deleteHead(head);
        head=deleteHeadSolutionTwo(head);
        head=deleteKthNode(head,2);
        printCircularListSolTwo(head);
    }

    static CNode deleteHead(CNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == head) {
            return null; // If there is only one node, set head to null
        }

        // Traverse the list to find the last node
        CNode current = head;
        while (current.next != head) {
            current = current.next;
        }

        // Update the last node's next pointer to skip the head
        current.next = head.next;

        // Move the head to the next node
        head = head.next;

        return head;
    }

    static CNode deleteHeadSolutionTwo(CNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == head) {
            return null; // If there is only one node, set head to null
        }
        head.data=head.next.data;
        head.next=head.next.next;

        return head;
    }
    static CNode deleteKthNode(CNode head,int k) {
        if (head == null) {
            return null;
        }
        if (k==1)
            return deleteHead(head);
        CNode current=head;
        for (int i=0;i<k-2;i++){
            current=current.next;
        }
        current.next=current.next.next;
        return head;
    }

    static CNode insertBegin(CNode head, int data){
        CNode temp=new CNode(data);
        if (head==null) temp.next=temp;
        else {
            CNode curr=head;
            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next=temp;
            temp.next=head;
        }
        return temp;
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
