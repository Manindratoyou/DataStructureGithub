package com.manindra.linkedlist;

public class CircularLinkedListInsertBegin {

    public static void main(String[] args) {
        CNode head=null;
        head=insertBegin(head,10);
        head=insertBegin(head,20);
        head=insertBegin(head,30);
        printCircularListSolTwo(head);
        head=insertBeginSolutionTwo(head,50);
        head=insertBeginSolutionTwo(head,60);
        head=insertBeginSolutionTwo(head,70);
        printCircularListSolTwo(head);
    }

    static CNode insertBegin(CNode head,int data){
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
    static CNode insertBeginSolutionTwo(CNode head,int data){
        CNode temp=new CNode(data);
        if (head==null) {
            temp.next=temp;
            return temp;
        }
        else {
            temp.next=head.next;
            head.next=temp;
            int t=head.data;
            head.data= temp.data;
            temp.data=t;
        }
        return head;
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
