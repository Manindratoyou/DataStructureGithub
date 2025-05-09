package com.manindra.linkedlist_leetcode;

public class LinkedListCycle { //solution 141

    // Method to detect cycle using Floyd's Tortoise and Hare
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();

        //  Test Case 1: List with a cycle
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates a cycle back to node2

        System.out.println("Test Case 1 (Cycle): " + solution.hasCycle(node1)); // true

        //  Test Case : Single node, cycle to itself
        ListNode selfCycle = new ListNode(99);
        selfCycle.next = selfCycle;
        System.out.println("Test Case 4 (Single Node, Self Cycle): " + solution.hasCycle(selfCycle)); // true
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

