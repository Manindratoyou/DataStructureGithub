package com.manindra.linkedlist_leetcode;

public class InsertionSortList { //solution 147

    public static void main(String[] args) {
        // Test Case 1
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        System.out.println("Original list:");
        printList(head);

        ListNode sorted = insertionSortList(head);
        System.out.println("Sorted list:");
        printList(sorted);
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0); // New sorted list
        ListNode curr = head;

        while (curr != null) {
            ListNode prev = dummy;
            // Find where to insert curr in the sorted list
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            ListNode nextTemp = curr.next;
            // Insert curr between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;
            curr = nextTemp;
        }

        return dummy.next;
    }

    // Utility method to print list
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
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}

