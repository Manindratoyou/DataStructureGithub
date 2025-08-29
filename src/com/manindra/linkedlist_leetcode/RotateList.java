package com.manindra.linkedlist_leetcode;

public class RotateList { //solution 61

    public static void main(String[] args) {
        RotateList solution = new RotateList();

        // Create list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        ListNode rotated = solution.rotateRight(head, k);
        printList(rotated); // Output: 4 5 1 2 3
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find length
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // Step 2: Connect last node to head (make circular)
        temp.next = head;

        // Step 3: Find new head position
        k = k % length;
        int stepsToNewHead = length - k;

        // Step 4: Move to new tail
        ListNode newTail = temp;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        // Step 5: Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // Helper to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


}

