package com.manindra.leetcode;

public class AddTwoNumbers { //solution2

    public static void main(String[] args) {

        //Example 1
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2); //result will be [7,0,8]
        printList(result);

        //Example 2
        l1 = new ListNode(0);
        l2 = new ListNode(0);
        result = solution.addTwoNumbers(l1, l2); //result will be [0]
        printList(result);

        //Example 3
        l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        result = solution.addTwoNumbers(l1, l2); //result will be [8,9,9,9,0,0,0,1]
        printList(result);

    }

    ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode ptr = result;

        int carry = 0;    // Set default carry

        while (l1 != null || l2 != null) {

            int sum = 0 + carry;    // Initialize sum

            if (l1 != null) {    // Use number from first list
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {    // Use number from 2nd list
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;    // Get sum and carry
            sum = sum % 10;
            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }

        if (carry == 1) ptr.next = new ListNode(1);

        return result.next;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " - >");
            current = current.next;
        }
        System.out.println("null");
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int data) {
            this.val = data;
        }

        ListNode(int data, ListNode next) {
            this.val = data;
            this.next = next;
        }
    }
}
