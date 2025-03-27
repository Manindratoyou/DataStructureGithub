package com.manindra.leetcodemedium_2;

public class DeleteDuplicatesFromSortedListII { // solution 82

    public static void main(String[] args) {
        // Test case: Input: [1,2,3,3,4,4,5] → Output: [1,2,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        head = deleteDuplicates(head);

        System.out.print("After Removing Duplicates: ");
        printList(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            // If current node is a duplicate
            if (curr.next != null && curr.val == curr.next.val) {
                // Move to the last duplicated node
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                // Skip the duplicated nodes
                prev.next = curr.next;
            } else {
                // Found a unique node
                prev = prev.next;
            }
            // Move to the next node
            curr = curr.next;
        }

        return dummy.next;
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
