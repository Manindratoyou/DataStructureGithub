package com.manindra.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution234 { // Palindrome Linked List

    public static void main(String[] args) {
        // Create a sample linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        Solution234 solution = new Solution234();

        //System.out.println(solution.isPalindrome(head));
        System.out.println(isPalindromeSolutionTwo(head));
        System.out.println(isPalindromeUsingStack(head));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        ListNode prev = null;
        ListNode current = slow;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Compare the first and second halves of the linked list
        ListNode firstHalf = head;
        ListNode secondHalf = prev;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // Solution using ArrayList
    static boolean isPalindromeSolutionTwo(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int start = 0, end = list.size() - 1;
        while (start < end) {
            if (!list.get(start).equals(list.get(end))) return false;
            start++;
            end--;
        }
        return true;
    }

    // Solution using Stack
    static boolean isPalindromeUsingStack(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head, fast = head;

        // Push elements onto stack until middle is reached
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // If odd number of elements, skip the middle element
        if (fast != null) {
            slow = slow.next;
        }

        // Compare elements from the second half with stack
        while (slow != null) {
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}