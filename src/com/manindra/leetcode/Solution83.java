package com.manindra.leetcode;

public class Solution83 { //83. Remove Duplicates from Sorted List

    public static void main(String[] args) {

        Solution83 solution83=new Solution83();
        //create a sample sorted linked list : 1->1->2->3->3
        ListNode head=new ListNode(1);
        head.next=new ListNode(1);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(3);
        head.next.next.next.next=new ListNode(3);

        System.out.println("Original Linked List");
        printLinkedList(head);

        ListNode result=solution83.deleteDuplicates(head);
        System.out.println("\nLinkedList After removing duplicates");
        printLinkedList(result);


    }

    ListNode deleteDuplicates(ListNode head){
        if (head==null || head.next==null) return head;

        ListNode current=head;
        while (current !=null && current.next !=null){
            if (current.val== current.next.val){
                //skip the next node by updating the current node's next pointer
                current.next=current.next.next;
            }else {
                //move the next node
                current=current.next;
            }
        }
        return head;
    }

    static void printLinkedList(ListNode head){
        ListNode current=head;
        while (current !=null){
            System.out.print(current.val+"->");
            current=current.next;
        }
        System.out.println("null");
    }

    private static class ListNode{
        int val;
        ListNode next;

        ListNode(){}
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }

    }
}
