package com.manindra.iitp.lab5101;

public class SecondLargest30 {

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {10, 20, 4, 5, 20};
        runTestCase(arr1);  // Expected output: 10

        // Test case 2
        int[] arr2 = {1, 1, 1, 1};
        runTestCase(arr2);  // Expected output: -1

        // Test case 3
        int[] arr3 = {2, 5, 5, 6};
        runTestCase(arr3);  // Expected output: 5

        // Test case 4
        int[] arr4 = {7, 8};
        runTestCase(arr4);  // Expected output: 7

        // Test case 5
        int[] arr5 = {3, 2, 1};
        runTestCase(arr5);  // Expected output: 2
    }

    private static void runTestCase(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] < largest) {
                secondLargest = arr[i];
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(secondLargest);
        }
    }
}
