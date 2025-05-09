package com.manindra.linkedlist_leetcode;

public class DeleteMiddleNode { //solution 2095

    public static ListNode deleteMiddle(ListNode head) {
        // Edge case: single node
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Move fast 2x and slow 1x
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        // Delete the middle node
        prev.next = slow.next;

        return head;
    }

    // Test the method
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);

        printList(head);
        System.out.println("after deleting middle node");
        ListNode result = deleteMiddle(head);
        printList(result);  // Expected: 1 -> 3 -> 4 -> 1 -> 2 -> 6
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}

