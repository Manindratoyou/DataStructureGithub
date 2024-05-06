package com.manindra.dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumOfAllSubarrayOfSizeK {

    public static void main(String[] args) {

        int[] arr = {10, 8, 5, 12, 15, 7, 6};
        int k = 3;
        printMax(arr, k);
        System.out.println();
        printMaxEfficient(arr,k);
    }

    static void printMax(int[] arr, int k) { //0(n^2)

        for (int i = 0; i < arr.length - k + 1; i++) {
            int max = arr[i];

            for (int j = i + 1; j < i + k; j++) {
                max = Math.max(arr[j], max);
            }
            System.out.print(max + " ");
        }
    }

    static void printMaxEfficient(int[] arr, int k) {

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()])
                deque.removeLast();

            deque.addLast(i);
        }
        for (int i = k; i <= arr.length; ++i) {
            System.out.print(arr[deque.peek()] + " ");

            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.removeFirst();
            }
            while (i < arr.length && !deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }

            if (i < arr.length) {
                deque.addLast(i);
            }
        }
    }

}
