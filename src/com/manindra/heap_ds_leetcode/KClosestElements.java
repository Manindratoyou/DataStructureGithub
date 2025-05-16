package com.manindra.heap_ds_leetcode;

import java.util.*;

public class KClosestElements { //solution 658

    public static void main(String[] args) {
        KClosestElements obj = new KClosestElements();
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4, x = 3;
        System.out.println(obj.findClosestElements(arr, k, x)); // Output: [1, 2, 3, 4]
        System.out.println(obj.findClosestElements2(arr, k, x)); // Output: [1, 2, 3, 4]
        System.out.println(obj.findClosestElements3(arr, k, x)); // Output: [1, 2, 3, 4]
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;

        while (low < high) {
            int mid = (low + high) / 2;

            // Compare distances: x - arr[mid] vs arr[mid + k] - x
            if (x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public List<Integer> findClosestElements3(int[] arr, int k, int x) { //works for unsorted array also
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> {
                    if (a[0] == b[0])
                        return a[1] - b[1];  // break tie by value

                    return a[0] - b[0]; // sort by difference
                }
        );

        for (int num : arr) {
            int diff = Math.abs(num - x);
            minHeap.offer(new int[]{diff, num});
        }

        List<Integer> result = new ArrayList<>();
        while (k-- > 0 && !minHeap.isEmpty()) {
            result.add(minHeap.poll()[1]);
        }

        Collections.sort(result); // Final output must be sorted
        return result;
    }

}

