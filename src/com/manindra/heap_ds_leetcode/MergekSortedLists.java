package com.manindra.heap_ds_leetcode;

import java.util.PriorityQueue;

public class MergekSortedLists { //solution23

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //use a priority queue (min heap) to keep track of the smallest node
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        //add the head nodes of all lists to the priority queue
        for (ListNode list : lists) {
            if (list != null)
                minHeap.offer(list);
        }
        //create a dummy node to simplify the code
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        //process the nodes from the priorith queue
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            //move tto the next node in the list and add it to the priority queue
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
