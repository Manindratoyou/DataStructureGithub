package com.manindra.leetcodemedium_2;

import java.util.ArrayList;
import java.util.List;

public class OddEvenLinkedList { // Solution 328

    public static void main(String[] args) {
        // Create a test case: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print the original list
        System.out.println("Original list:");
        printList(head);

        // Rearrange the list
        OddEvenLinkedList solution = new OddEvenLinkedList();
        head = solution.oddEvenList(head);

        // Print the rearranged list
        System.out.println("Rearranged list:");
        printList(head);
    }

    ListNode oddEvenList(ListNode head) { // TC: O(n), AS: O(1)
        if (head == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    ListNode oddEvenList2(ListNode head) { // TC: O(n), AS: O(n)
        if (head == null) return head;

        List<ListNode> oddNodes = new ArrayList<>();
        List<ListNode> evenNodes = new ArrayList<>();
        ListNode current = head;
        int index = 1;

        // Split nodes into odd and even indexed lists
        while (current != null) {
            if (index % 2 == 1) {
                oddNodes.add(current);
            } else {
                evenNodes.add(current);
            }
            current = current.next;
            index++;
        }

        // Combine odd and even nodes
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        for (ListNode node : oddNodes) {
            tail.next = node;
            tail = tail.next;
        }
        for (ListNode node : evenNodes) {
            tail.next = node;
            tail = tail.next;
        }

        // Ensure the last node points to null
        tail.next = null;

        return dummyHead.next;
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
