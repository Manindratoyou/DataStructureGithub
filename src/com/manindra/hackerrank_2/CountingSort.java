package com.manindra.hackerrank_2;

import java.util.*;

public class CountingSort {

    public static List<Integer> countingSort(List<Integer> arr) {
        // Create a frequency array with 100 elements initialized to 0

        int[] frequency = new int[100];

        // Count occurrences of each number
        for (int num : arr) {
            frequency[num]++;
        }

        // Convert the frequency array to a List and return
        List<Integer> result = new ArrayList<>();
        for (int count : frequency) {
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {


        List<Integer> arr = Arrays.asList(63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56, 9, 5);

        // Call the countingSort function and print the result
        List<Integer> result = countingSort(arr);
        System.out.println(result);
    }
}

