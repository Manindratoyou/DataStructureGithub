package com.manindra.hackerrank_2;

import java.util.*;

public class GoodlandElectricity {

    public static int pylons(int k, List<Integer> arr) {
        int n = arr.size();
        int i = 0;
        int plants = 0;

        while (i < n) {
            int plantPos = -1;

            // Search from right to left within the range [i + k - 1, i - k + 1]
            for (int j = Math.min(i + k - 1, n - 1); j >= Math.max(i - k + 1, 0); j--) {
                if (arr.get(j) == 1) {
                    plantPos = j;
                    break;
                }
            }

            if (plantPos == -1) {
                return -1;  // No valid position found
            }

            plants++;
            i = plantPos + k;  // Jump to the next uncovered city
        }

        return plants;
    }

    public static void main(String[] args) {
        List<Integer> arr1 = Arrays.asList(0, 1, 1, 1, 1, 0);
        int k1 = 2;
        System.out.println(pylons(k1, arr1));  // Output: 2

        List<Integer> arr2 = Arrays.asList(0, 0, 0, 1, 0, 0);
        int k2 = 2;
        System.out.println(pylons(k2, arr2));  // Output: -1
    }
}

