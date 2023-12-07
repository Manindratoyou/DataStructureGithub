package com.manindra.linkedlist;

public class CircularDoublyLinkedList {

    public static void main(String[] args) {
        Dll head=null;
        CircularDoublyLinkedList c=new CircularDoublyLinkedList();
        head=c.insertHead(head,5);
        head=c.insertHead(head,10);
        head=c.insertHead(head,53);
        printDllList(head);
    }

    private class Dll{
        int data;
        Dll previous;
        Dll next;

        Dll(int d){
            data=d;
            previous=null;
            next=null;
        }
    }

    Dll insertHead(Dll head, int data){

        Dll temp=new Dll(data);
        if(head==null) {
            temp.next=temp;
            temp.previous=temp;
            return temp;
        }
        temp.previous=head.previous;
        temp.next=head;
        head.previous.next=temp;
        return temp;
    }

    static void printDllList(Dll head){
        if (head==null) return;
        Dll r=head;
        do {
            System.out.println(r.data);
            r=r.next;
        }while (r!=head);
    }
}
