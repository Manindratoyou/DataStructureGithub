package com.manindra.linkedlist;

public class CircularLinkedListInsertLast {

    public static void main(String[] args) {
        CNode head=null;
        head=insertEnd(head,10);
        head=insertEnd(head,20);
        head=insertEnd(head,30);
        head=insertEnd(head,40);
        head=insertEndSolutionTwo(head,50);
        head=insertEndSolutionTwo(head,60);
        printCircularListSolTwo(head);
    }

    static CNode insertEnd(CNode head,int data){
        CNode temp=new CNode(data);
        if (head==null){
            temp.next=temp;
            return temp;
        }
        else {
            CNode current=head;
            while (current.next !=head) {
                current = current.next;
            }
                current.next=temp;
                temp.next=head;
        }
        return head;
    }
    static CNode insertEndSolutionTwo(CNode head,int data){
        CNode temp=new CNode(data);
        if (head==null){
            temp.next=temp;
            return temp;
        }else {
            //insert temp after head
            temp.next = head.next;
            head.next = temp;
            //swapping
            int t = temp.data;
            temp.data = head.data;
            head.data = t;
            //temp is now new head
            return temp;
        }
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
