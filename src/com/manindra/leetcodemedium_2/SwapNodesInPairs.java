package com.manindra.leetcodemedium_2;

public class SwapNodesInPairs { // Solution 24

    public static void main(String[] args) {
        // Create a test case: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Print the original list
        System.out.println("Original list:");
        printList(head);

        // Swap nodes in pairs
        SwapNodesInPairs solution = new SwapNodesInPairs();
        head = solution.swapPairs(head);

        // Print the swapped list
        System.out.println("Swapped list:");
        printList(head);
    }

    ListNode swapPairs(ListNode head) {
        // Create a dummy node to ease things
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode point = dummy;

        // Ensure nodes we are swapping are not null
        while (point.next != null && point.next.next != null) {
            // Identify nodes to swap
            ListNode swap1 = point.next;
            ListNode swap2 = point.next.next;

            // Actually swap
            swap1.next = swap2.next;
            swap2.next = swap1;

            // Prepare for next
            point.next = swap2;
            point = swap1;
        }

        // Return the start node
        return dummy.next;
    }

    static class ListNode {
        private int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
