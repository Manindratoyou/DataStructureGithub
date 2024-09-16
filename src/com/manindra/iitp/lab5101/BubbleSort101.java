package com.manindra.iitp.lab5101;

import java.util.Arrays;

public class BubbleSort101 {

    public static void main(String[] args) {
        // Test case 1: Random array
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(arr1));
        bubbleSort(arr1);
        System.out.println("Sorted array: " + Arrays.toString(arr1));

        // Test case 2: Array with negative numbers
        int[] arr2 = {-5, 3, 0, -2, 8, 7};
        System.out.println("Original array: " + Arrays.toString(arr2));
        bubbleSort(arr2);
        System.out.println("Sorted array: " + Arrays.toString(arr2));

        // Test case 3: Already sorted array
        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println("Original array: " + Arrays.toString(arr3));
        bubbleSort(arr3);
        System.out.println("Sorted array: " + Arrays.toString(arr3));

        // Test case 4: Array with all elements the same
        int[] arr4 = {7, 7, 7, 7, 7};
        System.out.println("Original array: " + Arrays.toString(arr4));
        bubbleSort(arr4);
        System.out.println("Sorted array: " + Arrays.toString(arr4));

        // Test case 5: Array with only one element
        int[] arr5 = {10};
        System.out.println("Original array: " + Arrays.toString(arr5));
        bubbleSort(arr5);
        System.out.println("Sorted array: " + Arrays.toString(arr5));
    }

    // Method to perform Bubble Sort on an array
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
