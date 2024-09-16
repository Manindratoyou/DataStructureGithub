package com.manindra.iitp.lab5101;

public class InsertionSort101 {

    public static void main(String[] args) {
        // Test case 1: Array with positive integers
        int[] arr1 = {5, 2, 9, 1, 5, 6};
        System.out.println("Test case 1: Sorted array:");
        insertionSort(arr1);
        printArray(arr1);

        // Test case 2: Array with negative integers
        int[] arr2 = {-3, -1, -7, -4, -5};
        System.out.println("Test case 2: Sorted array:");
        insertionSort(arr2);
        printArray(arr2);

        // Test case 3: Array with a single element
        int[] arr3 = {10};
        System.out.println("Test case 3: Sorted array:");
        insertionSort(arr3);
        printArray(arr3);

        // Test case 4: Array with duplicate elements
        int[] arr4 = {2, 5, 3, 3, 2};
        System.out.println("Test case 4: Sorted array:");
        insertionSort(arr4);
        printArray(arr4);

        // Test case 5: Already sorted array
        int[] arr5 = {1, 2, 3, 4, 5};
        System.out.println("Test case 5: Sorted array:");
        insertionSort(arr5);
        printArray(arr5);
    }

    // Function to perform insertion sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements that are greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Helper function to print the sorted array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
