package com.manindra.linkedlist_leetcode;

import java.util.*;

public class NextGreaterNodeInLinkedList { //solution 1019

    // Main method for testing
    public static void main(String[] args) {
        NextGreaterNodeInLinkedList solution = new NextGreaterNodeInLinkedList();
        int[] input = {2, 1, 5};
        ListNode head = createLinkedList(input);
        int[] output = solution.nextLargerNodes(head);

        System.out.println(Arrays.toString(output)); // Output: [5, 5, 0]
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> values = new ArrayList<>();

        // Step 1: Convert LinkedList to ArrayList
        ListNode curr = head;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        int[] result = new int[values.size()];
        Stack<Integer> stack = new Stack<>(); // store indices

        // Step 2: Use stack to find next greater
        for (int i = 0; i < values.size(); i++) {
            while (!stack.isEmpty() && values.get(i) > values.get(stack.peek())) {
                int index = stack.pop();
                result[index] = values.get(i);
            }
            stack.push(i);
        }

        return result;
    }

    // Helper method to create linked list from array
    public static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

}

