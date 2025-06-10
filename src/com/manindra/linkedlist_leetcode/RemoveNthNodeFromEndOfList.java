package com.manindra.linkedlist_leetcode;

public class RemoveNthNodeFromEndOfList { //solution 19

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();

        // Test Case 1: Remove the last node
        ListNode head1 = createLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Original list: " + printList(head1));
        head1 = solution.removeNthFromEnd(head1, 1);
        System.out.println("After removing 1st node from the end: " + printList(head1));

        // Test Case 2: Remove the first node
        ListNode head2 = createLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Original list: " + printList(head2));
        head2 = solution.removeNthFromEnd(head2, 5);
        System.out.println("After removing 5th node from the end: " + printList(head2));

        // Test Case 3: Remove a middle node
        ListNode head3 = createLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Original list: " + printList(head3));
        head3 = solution.removeNthFromEnd(head3, 3);
        System.out.println("After removing 3rd node from the end: " + printList(head3));

        // Test Case 4: Single node list
        ListNode head4 = createLinkedList(new int[]{1});
        System.out.println("Original list: " + printList(head4));
        head4 = solution.removeNthFromEnd(head4, 1);
        System.out.println("After removing the only node: " + printList(head4));

        // Test Case 5: Two-node list, remove the second node
        ListNode head5 = createLinkedList(new int[]{1, 2});
        System.out.println("Original list: " + printList(head5));
        head5 = solution.removeNthFromEnd(head5, 1);
        System.out.println("After removing 1st node from the end: " + printList(head5));
    }

    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode firstPtr = dummy;
        ListNode secondPtr = dummy;

        // Move secondPtr n spaces ahead
        for (int i = 0; i < n; i++) {
            secondPtr = secondPtr.next;
        }

        // Move both now, until the next of secondPtr is null
        while(secondPtr.next != null) {
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        // We now have to remove the node next of firstPtr
        firstPtr.next = firstPtr.next.next;

        return dummy.next;
    }

    static ListNode createLinkedList(int[] values) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    static String printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }

    static class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
}

