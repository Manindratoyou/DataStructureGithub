package com.manindra.iitp.lab5101;

/*
Given a sorted array with repeating integers. You need to find the first occurrence, last occurrence, and count of a given key in the array. USE ONLY BINARY SEARCH. Your algorithm should run in LogN time. If the element is not present print -1 -1 0.

Input Format

n: size of integer array

list of integers

x: element

Constraints

N<=1000000

Output Format

first occurrence last occurrence frequency

Sample Input 0

11
1 2 2 2 3 4 5 5 5 5 6
5
Sample Output 0

6 9 4
*/
public class RepeatingIntegers {

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {1, 2, 2, 2, 3, 4, 5, 5, 5, 5, 6};
        int x1 = 5;
        runTestCase(arr1, x1);  // Expected output: 6 9 4

        // Test case 2
        int[] arr2 = {1, 1, 1, 1, 1, 1, 1};
        int x2 = 1;
        runTestCase(arr2, x2);  // Expected output: 0 6 7

        // Test case 3
        int[] arr3 = {2, 4, 6, 8, 10};
        int x3 = 5;
        runTestCase(arr3, x3);  // Expected output: -1 -1 0

        // Test case 4
        int[] arr4 = {1, 3, 5, 7, 9, 11, 13};
        int x4 = 7;
        runTestCase(arr4, x4);  // Expected output: 3 3 1
    }

    private static void runTestCase(int[] arr, int x) {
        int firstOccurrence = findFirstOccurrence(arr, x);
        int lastOccurrence = findLastOccurrence(arr, x);

        if (firstOccurrence == -1) {
            System.out.println("-1 -1 0");
        } else {
            int count = lastOccurrence - firstOccurrence + 1;
            System.out.println(firstOccurrence + " " + lastOccurrence + " " + count);
        }
    }

    private static int findFirstOccurrence(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                result = mid;
                high = mid - 1; // Continue searching to the left
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private static int findLastOccurrence(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                result = mid;
                low = mid + 1; // Continue searching to the right
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}
