package com.manindra.linkedlist_leetcode;

public class MergeNodes { //solution 2181

    public static void main(String[] args) {
        // Input: 0 -> 3 -> 1 -> 0 -> 4 -> 5 -> 2 -> 0
        ListNode head = new ListNode(0,
                new ListNode(3,
                        new ListNode(1,
                                new ListNode(0,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(2,
                                                                new ListNode(0))))))));

        MergeNodes obj = new MergeNodes();
        ListNode result = obj.mergeNodes(head);
        printList(result); // Output: 4 -> 11 -> null
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0); // Dummy head for result list
        ListNode current = dummy;

        ListNode node = head.next; // Skip the first 0
        int sum = 0;

        while (node != null) {
            if (node.val != 0) {
                sum += node.val;
            } else {
                // End of current segment
                current.next = new ListNode(sum);
                current = current.next;
                sum = 0;
            }
            node = node.next;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
