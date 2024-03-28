package com.manindra.linkedlist;

import java.util.HashSet;

public class LoopInLinkedList {

    public static void main(String[] args) {

        Node head=new Node(15);
        head.next=new Node(10);
        head.next.next=new Node(12);
        head.next.next.next=new Node(20);
        head.next.next.next.next=head.next;

        //if (isLoop(head))
        //if (isLoopUsingHashing(head))
        if (isLoopUsingFloydCycle(head))
            System.out.println("loop found");
        else
            System.out.println("No loop");
    }

    static boolean isLoop(Node head){
        Node temp=new Node(0);
        Node current=head;
        while (current!=null){
            if (current.next==null)
                return false;
            if (current.next==temp)
                return true;
            Node curr_next=current.next;
            current.next=temp;
            current=curr_next;
        }
        return false;
    }

    static boolean isLoopUsingHashing(Node head){
        HashSet<Node> nodeHashSet=new HashSet<>();
        for (Node current=head;current!=null;current=current.next){
            if (nodeHashSet.contains(current))
                return true;
            nodeHashSet.add(current);
        }
        return false;
    }

    static boolean isLoopUsingFloydCycle(Node head){
        Node slow_pointer=head,fast_pointer=head;
        while (fast_pointer!=null && fast_pointer.next!=null){
            slow_pointer=slow_pointer.next;
            fast_pointer=fast_pointer.next.next;

            if (slow_pointer==fast_pointer)
                return true;
        }
        return false;
    }
}
