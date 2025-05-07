package com.manindra.leetcodeEasy;

public class DeleteNodeInLinkedList { //solution 237

    public static void deleteNode(ListNode node) {
        if (node == null || node.next == null)
            return; // just safety check
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // Helper to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    // Helper to find the first node with a given value
    public static ListNode findNode(ListNode head, int value) {
        while (head != null) {
            if (head.val == value) return head;
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        // Construct list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        System.out.print("Original list: ");
        printList(head);

        // Let's delete node with value 5
        ListNode nodeToDelete = findNode(head, 5);
        if (nodeToDelete != null) {
            deleteNode(nodeToDelete);
        }

        System.out.print("After deleting node with value 5: ");
        printList(head);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}

