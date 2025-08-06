package com.manindra.tree_bst_leetcode;

import java.util.*;

public class ConvertSortedListToBST { //solution 109

    public static void main(String[] args) {
        int[] input = {-10, -3, 0, 5, 9};
        ListNode head = createLinkedList(input);

        System.out.println("=== Approach 1: Using Array ===");
        TreeNode bst1 = sortedListToBST_ArrayApproach(head);
        preorder(bst1); // Output might be: 0 -10 -3 5 9

        // Recreate list since it's already traversed
        head = createLinkedList(input);

        System.out.println("\n\n=== Approach 2: Fast/Slow Pointer ===");
        TreeNode bst2 = sortedListToBST_PointerApproach(head);
        preorder(bst2); // Output might be: 0 -10 -3 5 9
    }

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // Definition for binary tree node.
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // ========= Approach 1: Convert to Array and Build BST =========
    public static TreeNode sortedListToBST_ArrayApproach(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        return buildBSTFromArray(values, 0, values.size() - 1);
    }

    private static TreeNode buildBSTFromArray(List<Integer> nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = buildBSTFromArray(nums, left, mid - 1);
        root.right = buildBSTFromArray(nums, mid + 1, right);
        return root;
    }

    // ========= Approach 2: Fast/Slow Pointer (Optimal) =========
    public static TreeNode sortedListToBST_PointerApproach(ListNode head) {
        return buildBSTFromList(head, null);
    }

    private static TreeNode buildBSTFromList(ListNode head, ListNode tail) {
        if (head == tail) return null;

        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = buildBSTFromList(head, slow);
        root.right = buildBSTFromList(slow.next, tail);
        return root;
    }

    // Helper: Convert array to linked list
    private static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper: Print BST in Preorder to verify structure
    private static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }


}

