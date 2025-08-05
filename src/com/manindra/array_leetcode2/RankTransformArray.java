package com.manindra.array_leetcode2;

import java.util.*;

public class RankTransformArray { //solution 1331

    public static void main(String[] args) {
        int[] arr = {40, 10, 20, 30};
        System.out.println(Arrays.toString(arrayRankTransform(arr)));  // Output: [4, 1, 2, 3]
    }

    public static int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : sorted) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }

    public static int[] arrayRankTransform2(int[] arr) {
        int n = arr.length;
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            int r = 1;
            for (int j = 0; j < n; j++) {
                if (arr[j] < arr[i]) r++;
            }
            rank[i] = r;
        }

        // Handle duplicates: adjust for equal values
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    rank[j] = rank[i];
                }
            }
        }

        return rank;
    }
}

