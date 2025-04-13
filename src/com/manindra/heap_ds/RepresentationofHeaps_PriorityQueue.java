package com.manindra.heap_ds;

import java.util.PriorityQueue;

public class RepresentationofHeaps_PriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(5);
        pq.add(15);
        System.out.println("Min element: " + pq.poll()); // Extracts the smallest element
    }
}
