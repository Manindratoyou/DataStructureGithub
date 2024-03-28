package com.manindra.linkedlist;

public class DetectAndRemoveLoop {

    public static void main(String[] args) {

        Node head=new Node(15);
        head.next=new Node(10);
        head.next.next=new Node(12);
        head.next.next.next=new Node(20);
        head.next.next.next.next=head.next;
        detectAndRemoveLoop(head);
        printList1(head);


    }

    static void detectAndRemoveLoop(Node head){
        Node slow=head,fast=head;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if (slow==fast)
                break;
        }
        if (slow!=fast)
            return;
        slow=head;
        while (slow.next!=fast.next){
            slow=slow.next;
            fast=fast.next;
        }
        fast.next=null;
    }



    /*  void printList(){
        Node current=head;
        while (current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
    }*/
    static void printList1(Node head){
        Node current=head;
        while (current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
    }
}
