package com.manindra.leetcodemedium_2;

public class LinkedListCycleII { // solution 142

    public static void main(String[] args) {
        // Test case 1: Linked list with a cycle
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Cycle starts at node with value 2

        LinkedListCycleII solution = new LinkedListCycleII();
        ListNode cycleNode = solution.detectCycle(head);

        if (cycleNode != null) {
            System.out.println("Cycle detected at node with value: " + cycleNode.data); // Expected: 2
        } else {
            System.out.println("No cycle detected");
        }

        // Test case 2: Linked list without a cycle
        ListNode headNoCycle = new ListNode(1);
        headNoCycle.next = new ListNode(2);

        ListNode noCycleNode = solution.detectCycle(headNoCycle);

        if (noCycleNode != null) {
            System.out.println("Cycle detected at node with value: " + noCycleNode.data);
        } else {
            System.out.println("No cycle detected"); // Expected: No cycle detected
        }
    }

    // Detects the cycle in a linked list using the two-pointer method
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head, fast = head;

        // Detect the cycle by advancing slow and fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet, there is a cycle
            if (slow == fast) {
                // Move one pointer to the head and move both pointers one step at a time
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow; // The node where both pointers meet is the cycle start
            }
        }

        return null; // No cycle detected
    }

    // Definition of ListNode class
    static class ListNode {
        private int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
}

