package com.manindra.leetcodemedium_2;

import java.util.HashMap;

public class DeleteDuplicatesUnsortedList { //solution 1836

    public static void main(String[] args) {
        // Test Case: [4,3,2,3,1,2,5] → Output: [4,1,5]
        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        head = removeDuplicatesUnsorted(head);

        System.out.print("After Removing Duplicates: ");
        printList(head);
    }

    public static ListNode removeDuplicatesUnsorted(ListNode head) {
        if (head == null) return null; // Edge case: empty list

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        ListNode curr = head;

        // First pass: Count occurrences of each value
        while (curr != null) {
            freqMap.put(curr.val, freqMap.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }

        // Second pass: Remove duplicates
        ListNode dummy = new ListNode(0); // Dummy node to handle head deletion
        dummy.next = head;
        ListNode prev = dummy;
        curr = head;

        while (curr != null) {
            if (freqMap.get(curr.val) > 1) { // If value appears more than once, remove it
                prev.next = curr.next;
            } else {
                prev = prev.next; // Move prev forward
            }
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

