package com.manindra.hackerrank_2;

import java.util.*;

public class CountingSort2 {

    public static List<Integer> countingSort(List<Integer> arr) {
        // Create a frequency array with size sufficient to cover the range of input values
        int[] frequency = new int[10];
        int[] frequency1 = new int[100];

        // Count occurrences of each number
        for (int num : arr) {
            frequency[num]++;
        }

        // Create the sorted list from the frequency array
        List<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < frequency.length; i++) {
            for (int count = 0; count < frequency[i]; count++) {
                sortedList.add(i);
            }
        }

        return sortedList;
    }

    public static void main(String[] args) {
        // Sample input
        List<Integer> arr = Arrays.asList(4, 3, 2, 1, 4, 2, 3);

        List<Integer> arr1 = Arrays.asList(63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56, 9, 5);

        // Call the countingSort function and print the result
        List<Integer> sortedList = countingSort(arr);
        System.out.println(sortedList);
    }
}

