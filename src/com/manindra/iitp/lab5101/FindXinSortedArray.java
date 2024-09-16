package com.manindra.iitp.lab5101;

//https://www.hackerrank.com/contests/tutorial-1-1723869106/challenges
public class FindXinSortedArray {

    public static void main(String[] args) {
        // Test case 1: Target is present in the array
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int target1 = 4;
        System.out.println("Test case 1 result: " + binarySearch(arr1, target1));

        // Test case 2: Target is not present in the array
        int[] arr2 = {10, 20, 30, 40, 50};
        int target2 = 25;
        System.out.println("Test case 2 result: " + binarySearch(arr2, target2));

        // Test case 3: Target is the first element
        int[] arr3 = {100, 200, 300, 400, 500};
        int target3 = 100;
        System.out.println("Test case 3 result: " + binarySearch(arr3, target3));

        // Test case 4: Target is the last element
        int[] arr4 = {11, 22, 33, 44, 55};
        int target4 = 55;
        System.out.println("Test case 4 result: " + binarySearch(arr4, target4));

        // Test case 5: Empty array
        int[] arr5 = {};
        int target5 = 5;
        System.out.println("Test case 5 result: " + binarySearch(arr5, target5));
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;  // Calculate mid to avoid overflow

            if (arr[mid] == target) {
                return mid;  // Target found, return its index
            } else if (arr[mid] < target) {
                left = mid + 1;  // Target is on the right side
            } else {
                right = mid - 1;  // Target is on the left side
            }
        }

        return -1;  // Target not found
    }
}
