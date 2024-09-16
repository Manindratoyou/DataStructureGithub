package com.manindra.iitp.lab5101;

//https://www.hackerrank.com/contests/tutorial-1-1723869106/challenges
public class MaxAndMinElement {

    public static void main(String[] args) {
        // Test case 1: Mixed positive and negative numbers
        int[] arr1 = {1, 3, -1, 5, 0, -7, 9};
        System.out.println("Test case 1: Max and Min:");
        findMaxAndMin(arr1);

        // Test case 2: All elements are the same
        int[] arr2 = {4, 4, 4, 4, 4};
        System.out.println("Test case 2: Max and Min:");
        findMaxAndMin(arr2);

        // Test case 3: Single element array
        int[] arr3 = {7};
        System.out.println("Test case 3: Max and Min:");
        findMaxAndMin(arr3);

        // Test case 4: Already sorted in ascending order
        int[] arr4 = {1, 2, 3, 4, 5};
        System.out.println("Test case 4: Max and Min:");
        findMaxAndMin(arr4);

        // Test case 5: Already sorted in descending order
        int[] arr5 = {10, 9, 8, 7, 6};
        System.out.println("Test case 5: Max and Min:");
        findMaxAndMin(arr5);
    }

    // Method to find and print the max and min elements in an array
    public static void findMaxAndMin(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty");
            return;
        }

        // Initialize max and min with the first element of the array
        int max = arr[0];
        int min = arr[0];

        // Traverse the array to find the max and min
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // Output the max and min elements
        System.out.println("Max: " + max + ", Min: " + min);
    }
}
