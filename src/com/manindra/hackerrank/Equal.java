package com.manindra.hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Equal {

    public static void main(String[] args) {
        Equal equal = new Equal();

        // Test case 1
        int[] arr1 = {2, 2, 3, 7};
        int result1 = equal.equalArrayBased(arr1);
        System.out.println("Test Case 1 Result: " + result1); // Expected output: 2

        // Test case 2
        int[] arr2 = {10, 7, 12};
        int result2 = equal.equalArrayBased(arr2);
        System.out.println("Test Case 2 Result: " + result2); // Expected output: 3

        // Test case 3
        int[] arr3 = {2, 2, 5};
        int result3 = equal.equalArrayBased(arr3);
        System.out.println("Test Case 3 Result: " + result3); // Expected output: 1

        System.out.println("=============================");
        Equal equal2 = new Equal();

        // Test case 1
        List<Integer> list1 = Arrays.asList(2, 2, 3, 7);
        int resultList1 = equal.equalListBased(list1);
        System.out.println("Test Case 1 Result: " + resultList1); // Expected output: 2

        // Test case 2
        List<Integer> list2 = Arrays.asList(10, 7, 12);
        int resultList2 = equal.equalListBased(list2);
        System.out.println("Test Case 2 Result: " + resultList2); // Expected output: 3

        // Test case 3
        List<Integer> list3 = Arrays.asList(2, 2, 5);
        int resultList3 = equal.equalListBased(list3);
        System.out.println("Test Case 3 Result: " + resultList3); // Expected output: 1
    }

    int equalArrayBased(int[] arr) {

        // Store all the possibilities
        int[] possibilities = new int[5];

        // Start with the minimum element
        int minimum = Arrays.stream(arr).min().getAsInt();

        for (int i = 0; i < possibilities.length; i++) {

            for (int k : arr) {
                int diff = k - minimum;
                int stepsRequired = diff / 5 + (diff % 5) / 2 + ((diff % 5) % 2) / 1;
                possibilities[i] += stepsRequired;
            }
            minimum--;
        }

        // Return the minimum number out of all the possibilities
        return Arrays.stream(possibilities).min().getAsInt();
    }



    public int equalListBased(List<Integer> arr) {
        // Store all the possibilities
        int[] possibilities = new int[5];

        // Start with the minimum element
        int minimum = Collections.min(arr);

        for (int i = 0; i < possibilities.length; i++) {
            for (int k : arr) {
                int diff = k - minimum;
                int stepsRequired = diff / 5 + (diff % 5) / 2 + ((diff % 5) % 2) / 1;
                possibilities[i] += stepsRequired;
            }
            minimum--;
        }

        // Return the minimum number out of all the possibilities
        return Arrays.stream(possibilities).min().getAsInt();
    }
}

