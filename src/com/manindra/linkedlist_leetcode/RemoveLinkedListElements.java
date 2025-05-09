package com.manindra.linkedlist_leetcode;

public class RemoveLinkedListElements { //solution 203

    public static void main(String[] args) {

        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        printList(head);
        System.out.println();
        head = removeElements(head, 20);
        printList(head);

    }

    static ListNode removeElements(ListNode head, int val) {

        // Create a dummy head node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = dummy;
        while (curr.next != null) {

            // Check if the value matches
            if (curr.next.val == val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }

        // Return the head
        return dummy.next;
    }

    static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    static class ListNode {

        private int val;

        private ListNode next;

        ListNode(int value) {
            this.val = value;
            this.next = null;
        }
    }
}
