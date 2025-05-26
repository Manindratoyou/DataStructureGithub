package com.manindra.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SubArrayExample1 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        printAllSubarrays(arr);
        System.out.println();

        List<List<Integer>> result = getAllSubarrays(arr);
        System.out.println("Subarrays as list: " + result);
        System.out.println();

        printAllSubsets(arr);
        System.out.println();

        printAllSubarraysStream(arr);
    }


    // 1. Print All Subarrays (Contiguous)
    public static void printAllSubarrays(int[] arr) {
        int n = arr.length;
        System.out.println("All subarrays:");
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                for (int k = start; k <= end; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }


    //2. Return All Subarrays as List of Lists
    public static List<List<Integer>> getAllSubarrays(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                List<Integer> sub = new ArrayList<>();
                for (int k = start; k <= end; k++) {
                    sub.add(arr[k]);
                }
                result.add(sub);
            }
        }

        return result;
    }

    //3. Print All Non-Contiguous Subsets (Power Set)
    public static void printAllSubsets(int[] arr) {
        int n = arr.length;
        int total = 1 << n; // 2^n subsets

        System.out.println("All non-contiguous subsets:");
        for (int mask = 0; mask < total; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(arr[i]);
                }
            }
            System.out.println(subset);
        }
    }

    public static void printAllSubarraysStream(int[] arr) {
        int n = arr.length;

        System.out.println("All subarrays using streams:");
        IntStream.range(0, n).forEach(start ->
                IntStream.range(start, n).forEach(end ->
                        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, start, end + 1)))
                )
        );
    }


}
