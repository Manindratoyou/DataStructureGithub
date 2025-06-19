package com.manindra.leetcodeEasy;

public class ConvertBinaryLinkedList { //solution 1290

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 0, 1};
        ListNode head1 = createList(arr1);
        printList(head1);  // Output: 101
        System.out.println("Decimal: " + getDecimalValue(head1)); // Output: 5

        // Test Case 2
        int[] arr2 = {0};
        ListNode head2 = createList(arr2);
        printList(head2);  // Output: 0
        System.out.println("Decimal: " + getDecimalValue(head2)); // Output: 0

        // Test Case 3
        int[] arr3 = {1, 1, 1, 1};
        ListNode head3 = createList(arr3);
        printList(head3);  // Output: 1111
        System.out.println("Decimal: " + getDecimalValue(head3)); // Output: 15
    }

    public static int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) {
            result = result * 2 + head.val;  // Shift left and add current bit
            head = head.next;
        }
        return result;
    }

    public int getDecimalValue2(ListNode head) {
        StringBuilder sb=new StringBuilder();
        while (head!= null) {
            sb.append(head.val);
            head=head.next;
        }
        System.out.println(sb);
        return Integer.parseInt(sb.toString(),2);
    }

    public static ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : values) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }


    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
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

