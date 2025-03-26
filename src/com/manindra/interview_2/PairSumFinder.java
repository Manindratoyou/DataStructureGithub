package com.manindra.interview_2;

import java.util.*;

public class PairSumFinder {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 7};
        int k = 8;
        findPairs(arr, k);
        System.out.println();
        List<int[] > list=findPairs2(arr,k);

        for (int[] l: list)
            System.out.println(Arrays.toString(l));
    }

    public static void findPairs(int[] arr, int k) {
        Set<Integer> seen = new HashSet<>();
        Set<String> result = new HashSet<>(); // To store unique pairs

        for (int num : arr) {
            int complement = k - num;
            if (seen.contains(complement)) {
                // Ensure the pair is stored in a consistent order (min, max)
                result.add(Math.min(num, complement) + "," + Math.max(num, complement));
            }
            seen.add(num);
        }

        // Print the result
        System.out.println(result);
    }

    public static List<int[]> findPairs2(int[] arr, int k) {
        List<int[]> pairs = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    pairs.add(new int[]{arr[i], arr[j]});
                }
            }
        }

        return pairs;
    }
}

