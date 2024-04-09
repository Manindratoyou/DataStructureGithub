package com.manindra.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class PalindromePrograms {

    public static void main(String[] args) {
        // Palindrome linked list
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(2);
        list.next.next.next.next = new ListNode(1);
        System.out.println("Is Palindrome (Linked List): " + isPalindrome(list));

        // Palindrome string
        String str = "RADAR";
        System.out.println("Is Palindrome (String): " + isPalindrome(str));

        // Palindrome linked list using array
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(2);
        list1.next.next.next.next = new ListNode(1);
        System.out.println("Is Palindrome (Array): " + isPalindromeUsingArray(list1));
    }

    // Palindrome linked list
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val)
                return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null, current = head, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Palindrome string
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    // Palindrome linked list using array
    public static boolean isPalindromeUsingArray(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        int left = 0, right = values.size() - 1;
        while (left < right) {
            if (!values.get(left).equals(values.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}

