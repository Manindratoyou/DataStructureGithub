package com.manindra.linkedlist_leetcode;

public class ReverseLinkedList {  // solution 206

    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Reverse the list
        ReverseLinkedList obj = new ReverseLinkedList();
        ListNode reversed = obj.reverseList(head);

        // Print the reversed list
        printList(reversed); // Expected: 5 -> 4 -> 3 -> 2 -> 1
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next; // Store the next node
            current.next = prev;          // Reverse the pointer of the current node
            prev = current;               // Move prev one step forward
            current = next;               // Move current one step forward
        }
        return prev; // 'prev' will be the new head of the reversed list
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }
}

