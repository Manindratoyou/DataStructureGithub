package com.manindra.leetcodeEasy;

import com.manindra.linkedlist.Node;

public class MiddleOfLinkedList { //solution 876

    public static void main(String[] args) {

        ListNode head=new ListNode(10);
        head.next=new ListNode(20);
        head.next.next=new ListNode(30);
        head.next.next.next=new ListNode(40);
        printList(head);
        ListNode result=middleNode(head);
        System.out.println();
        printList(result);

    }

    static ListNode middleNode(ListNode head) {

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        //travel until the fast pointer reaches the last node or null
        while (fastPointer != null && fastPointer.next!=null){

            //slow pointer moves one node
            slowPointer=slowPointer.next;
            //fast pointer moves two node
            fastPointer=fastPointer.next.next;
        }
        return slowPointer;
    }

    static void printList(ListNode head){
        ListNode current=head;
        while (current!=null){
            System.out.print(current.val+" ");
            current=current.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
