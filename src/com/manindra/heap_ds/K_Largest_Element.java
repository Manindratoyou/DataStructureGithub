package com.manindra.heap_ds;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class K_Largest_Element {

    public static void main(String[] args) {

        int [] arr={5,15,10,20,8};
        int k=2;
        //op : 15,20
        firstKElements(arr,k);
        System.out.println();
        findKLargestElementsSolutionTwo(arr,k);

    }

    //solution 1 sort and print last k elements
    //Time Complexity: O(n log n)
    //Auxiliary Space: O(1) (if sorting is done in-place)
    static void findKLargestElements(int[] arr, int k) {
        // Sort the array in ascending order
        Arrays.sort(arr);

        // Print the last k elements
        for (int i = arr.length - k; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    //solution 2 maxHeap
    //Time Complexity: O(n + k log n)
    //Auxiliary Space: O(n) (due to the max-heap)
    static void findKLargestElementsSolutionTwo(int[] arr, int k) {
        // Create a max-heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all elements to the max-heap
        for (int num : arr) {
            maxHeap.add(num);
        }

        // Extract the top k elements
        for (int i = 0; i < k; i++) {
            System.out.print(maxHeap.poll() + " ");
        }
    }


    //Using Min-Heap (Given Solution):
    //Time Complexity: O(k + (n-k) log k) ≈ O(n log k)
    //Auxiliary Space: O(k) for the min-heap.
    static void firstKElements(int [] arr,int k){
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for (int i=0;i<k;i++){
            minHeap.add(arr[i]);
        }
        for (int i=k;i< arr.length;i++){
            if (minHeap.peek()>arr[i])
                continue;
            else {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        Iterator<Integer> itr=minHeap.iterator();
        while (itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
    }
}
