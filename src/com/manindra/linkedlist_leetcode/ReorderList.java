package com.manindra.linkedlist_leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReorderList { // LeetCode solution 143

    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        printList(head);

        // Reorder the list
        ReorderList solution = new ReorderList();

        solution.reorderListBrutForce(head);
        printList(head);

        //solution.reorderList(head);
        //printList(head); // Expected output: 1 -> 5 -> 2 -> 4 -> 3
    }

    void reorderListBrutForce(ListNode head) {
        if (head == null || head.next == null) return; // Base case

        // Step 1: Copy all nodes into a list
        List<ListNode> nodeList = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            nodeList.add(current);
            current = current.next;
        }

        // Step 2: Reorder using two pointers
        int start = 0, end = nodeList.size() - 1;
        while (start < end) {
            // Connect start node to end node
            nodeList.get(start).next = nodeList.get(end);
            start++;

            // Connect end node to the next start node
            if (start < end) {
                nodeList.get(end).next = nodeList.get(start);
            }
            end--;
        }

        // Step 3: Ensure the last node points to null
        nodeList.get(start).next = null;
    }

    void reorderList(ListNode head) {
        if (head == null || head.next == null) // base case
            return;

        // Find the middle of the list
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // Reverse the half after middle
        ListNode preMiddle = p1;
        ListNode preCurrent = p1.next;
        while (preCurrent.next != null) {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }

        // Start reordering
        p1 = head;
        p2 = preMiddle.next;
        while (p1 != preMiddle) {
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
