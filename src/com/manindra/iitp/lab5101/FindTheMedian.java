package com.manindra.iitp.lab5101;

import java.util.ArrayList;
import java.util.List;

public class FindTheMedian {

    public static void main(String[] args) {
        // Test case 1
        List<Integer> arr1 = new ArrayList<>();
        arr1.add(0);
        arr1.add(1);
        arr1.add(2);
        arr1.add(4);
        arr1.add(6);
        arr1.add(5);
        arr1.add(3);
        System.out.println("Median of arr1: " + findMedian(arr1)); // Expected output: 3

        // Test case 2
        List<Integer> arr2 = new ArrayList<>();
        arr2.add(10);
        arr2.add(7);
        arr2.add(8);
        arr2.add(9);
        arr2.add(1);
        arr2.add(5);
        System.out.println("Median of arr2: " + findMedian(arr2)); // Expected output: 7 (after sorting, it becomes [1, 5, 7, 8, 9, 10])

        // Test case 3
        List<Integer> arr3 = new ArrayList<>();
        arr3.add(20);
        arr3.add(30);
        arr3.add(10);
        arr3.add(40);
        arr3.add(50);
        System.out.println("Median of arr3: " + findMedian(arr3)); // Expected output: 30
    }

    public static int findMedian(List<Integer> arr) {
        // Convert List to array
        int[] array = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            array[i] = arr.get(i);
        }

        // Perform quick sort on the array
        quickSort(array, 0, array.length - 1);

        // Return the middle element (median)
        return array[array.length / 2];
    }

    // Quick Sort implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition function for Quick Sort
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
