package com.manindra.linkedlist_leetcode;

public class ReverseEvenLengthGroups { //solution 2074

    public static void main(String[] args) {
        ListNode head = createList(new int[]{1, 2, 3, 4, 5, 6});
        printList(reverseEvenLengthGroups(head)); // Output: 1 -> 3 -> 2 -> 4 -> 5 -> 6

        head = createList(new int[]{1, 1, 0, 6});
        printList(reverseEvenLengthGroups(head)); // Output: 1 -> 0 -> 1 -> 6
    }



    public static ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;
        int groupSize = 1;

        while (current != null) {
            ListNode groupStart = current;
            int count = 0;

            // Count actual number of nodes in the current group
            while (count < groupSize && current != null) {
                current = current.next;
                count++;
            }

            // Check if this group should be reversed
            if (count % 2 == 0) {
                // Reverse the group of 'count' nodes starting at groupStart
                ListNode nextGroup = current;
                ListNode prevNode = nextGroup;
                ListNode node = groupStart;

                for (int i = 0; i < count; i++) {
                    ListNode temp = node.next;
                    node.next = prevNode;
                    prevNode = node;
                    node = temp;
                }

                prev.next = prevNode;
                prev = groupStart;
            } else {
                for (int i = 0; i < count; i++) {
                    prev = prev.next;
                }
            }

            groupSize++;
        }

        return dummy.next;
    }

    // Helper: Create Linked List
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0), current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper: Print List
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

}

