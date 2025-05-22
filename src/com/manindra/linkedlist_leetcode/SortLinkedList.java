package com.manindra.linkedlist_leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortLinkedList { //solution 148

    public static void main(String[] args) {
        SortLinkedList solution = new SortLinkedList();

        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        System.out.print("Original List: ");
        printList(head);

        ListNode sorted = solution.sortList(head);
        System.out.print("Sorted List: ");
        printList(sorted);
    }

    public ListNode sortList(ListNode head) {
        // Base case
        if (head == null || head.next == null) return head;

        // Step 1: Split the list into two halves
        ListNode mid = getMid(head);
        ListNode left = head;
        ListNode right = mid;

        // Step 2: Recursively sort each half
        left = sortList(left);
        right = sortList(right);

        // Step 3: Merge the two sorted halves
        return merge(left, right);
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = (slow == null) ? head : slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null; // Cut the list
        return mid;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if (l1 != null) temp.next = l1;
        if (l2 != null) temp.next = l2;

        return dummy.next;
    }

    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;

        // Step 1: Convert to list
        List<Integer> values = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        // Step 2: Sort values
        Collections.sort(values);

        // Step 3: Rebuild list
        curr = head;
        for (int val : values) {
            curr.val = val;
            curr = curr.next;
        }

        return head;
    }

    // ✅ Helper to print the list
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
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

