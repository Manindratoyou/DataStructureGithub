package com.manindra.leetcodeEasy;

public class ReverseLinkedList { //solution 206

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;     // Store the next node
            current.next = prev;     // Reverse the pointer
            prev = current;          // Move prev forward
            current = next;          // Move current forward
        }
        return prev; // New head of reversed list
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test case 1: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head1);

        ListNode reversed1 = reverseList(head1);
        System.out.print("Reversed List: ");
        printList(reversed1);

        // Test case 2: Single node
        ListNode head2 = new ListNode(42);
        System.out.print("\nOriginal List: ");
        printList(head2);

        ListNode reversed2 = reverseList(head2);
        System.out.print("Reversed List: ");
        printList(reversed2);

        // Test case 3: Empty list
        ListNode head3 = null;
        System.out.print("\nOriginal List: ");
        printList(head3);

        ListNode reversed3 = reverseList(head3);
        System.out.print("Reversed List: ");
        printList(reversed3);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}

