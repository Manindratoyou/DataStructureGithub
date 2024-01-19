package com.manindra.leetcode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        // Create linked list 1: 1 -> 2 -> 3 -> 6 -> 7
        ListNode commonNode = new ListNode(6, new ListNode(7));
        ListNode headA = new ListNode(1, new ListNode(2, new ListNode(3, commonNode)));

        // Create linked list 2: 4 -> 5 -> 6 -> 7
        ListNode headB = new ListNode(4, new ListNode(5, commonNode));

        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();

        // Test with Set approach
        ListNode intersectionNodeSet = solution.getIntersectionNodeSet(headA, headB);
        System.out.println("Intersection Node (Set): " + (intersectionNodeSet != null ? intersectionNodeSet.data : "No intersection"));

        // Test with optimized approach
        ListNode intersectionNodeOptimized = solution.getIntersectionNode(headA, headB);
        System.out.println("Intersection Node (Optimized): " + (intersectionNodeOptimized != null ? intersectionNodeOptimized.data : "No intersection"));
    }

    public ListNode getIntersectionNodeSet(ListNode headA, ListNode headB) {

        if (headA == null) return headA;
        if (headB == null) return headB;

        Set<ListNode> nodeAddress = new HashSet<>();

        while (headA != null) {

            nodeAddress.add(headA);
            headA = headA.next;
        }

        ListNode result = null;

        while (headB != null) {
            if (nodeAddress.contains(headB))
                return headB;

            headB = headB.next;
        }

        return result;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = getListLength(headA);
        int lenB = getListLength(headB);

        while (lenA > lenB) {
            lenA--;
            headA = headA.next;
        }

        while (lenB > lenA) {
            lenB--;
            headB = headB.next;
        }

        // Now both heads are at same distance from intersection
        // Start moving them both until they meet
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int getListLength(ListNode head) {
        int len = 0;

        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }



    static class ListNode{
        int data;
        public ListNode next;
        public ListNode(int data){
            this.data=data;
        }
        ListNode(int data, ListNode next){
            this.data=data;
            this.next=next;
        }
    }

}
