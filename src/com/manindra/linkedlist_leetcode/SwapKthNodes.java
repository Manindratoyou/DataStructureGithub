package com.manindra.linkedlist_leetcode;


public class SwapKthNodes { //solution 1721


    public static void main(String[] args) {
        // Example: head = [1,2,3,4,5], k = 2 → swap 2nd and 4th nodes
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        int k = 2;
        ListNode result = swapNodes(head, k);

        System.out.print("After Swap: ");
        printList(result);
    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        for (int i = 1; i < k; i++) {
            curr = curr.next;
        }

        ListNode a = curr;
        ListNode b = head;
        while (curr != null && curr.next != null) {
            curr = curr.next;
            b = b.next;
        }

        int temp = a.val;
        a.val = b.val;
        b.val = temp;

        return head;
    }

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
        ListNode(int val) {
            this.val = val;
        }
    }
}

