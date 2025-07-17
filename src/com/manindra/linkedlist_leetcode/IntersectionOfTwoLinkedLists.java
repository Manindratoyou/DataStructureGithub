package com.manindra.linkedlist_leetcode;

import java.util.HashSet;
import java.util.Set;
/*
List A: 1 → 3
               ↘
                 8 → 10
               ↗
List B:     2 →

 */
public class IntersectionOfTwoLinkedLists { //solution 160

    public static void main(String[] args) {
        // Shared part
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(10);

        // List A: 1 -> 3 -> 8 -> 10
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(3);
        headA.next.next = intersect;

        // List B: 2 -> 8 -> 10 (intersect shared)
        ListNode headB = new ListNode(2);
        headB.next = intersect;

        //ListNode result = getIntersectionNodeSet(headA, headB);
        ListNode result = getIntersectionNode(headA, headB);
        System.out.println(result != null ? "Intersection at: " + result.data : "No intersection");
    }

    static ListNode getIntersectionNodeSet(ListNode headA, ListNode headB) { //use this

        if (headA == null) return headA;
        if (headB == null) return headB;

        Set<ListNode> set = new HashSet<>();

        while (headA != null) {

            set.add(headA);
            headA = headA.next;
        }

        ListNode result = null;

        while (headB != null) {
            if (set.contains(headB))
                return headB;

            headB = headB.next;
        }

        return result;
    }

    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = getListLength(headA);
        int lenB = getListLength(headB);

        while (lenA > lenB) {
            lenA--;
            headA = headA.next;
        }
        //2 while loop - any one will be executed at a time
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

    static int getListLength(ListNode head) {
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
