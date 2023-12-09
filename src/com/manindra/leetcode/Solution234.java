package com.manindra.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution234 {

    public static void main(String[] args) {
        // Create a sample linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        // Create an instance of the Solution class
        Solution234 solution = new Solution234();

        // Check if the linked list is a palindrome
       // boolean isPalindrome = solution.isPalindrome(head);

        // Print the result
        /*if (isPalindrome) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }*/

        System.out.println(isPalindromeSolutionTwo(head));
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
        System.out.println(slow.val);//middle node

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

    //solution two
    static boolean isPalindromeSolutionTwo(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        List<Integer> list=new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        int start=0,end=list.size()-1;
        while (start<end){
            if (list.get(start)!=list.get(end)) return false;
            start++;end--;
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