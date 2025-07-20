package com.manindra.array_leetcode2;

import java.util.HashMap;
import java.util.Map;

public class ElementMoreThan25Percent { //solution 1287

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        System.out.println(findSpecialInteger(arr)); // Output: 6
    }

    public static int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int[] candidates = {
                arr[n / 4],
                arr[n / 2],
                arr[3 * n / 4]
        };

        for (int candidate : candidates) {
            int first = firstOccurrence(arr, candidate);
            int last = lastOccurrence(arr, candidate);
            if (last - first + 1 > n / 4) {
                return candidate;
            }
        }

        return -1; // Should never hit because problem guarantees one exists
    }

    // Binary search for first occurrence
    private static int firstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    // Binary search for last occurrence
    private static int lastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (arr[mid] <= target) low = mid;
            else high = mid - 1;
        }
        return low;
    }

    public static int findSpecialInteger2(int[] arr) {
        int n = arr.length, count = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
                if (count > n / 4) return arr[i];
            } else {
                count = 1;
            }
        }

        return arr[0]; // fallback, won't be hit due to constraints
    }


    public static int findSpecialInteger3(int[] arr) {
        int value = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > (25 * arr.length) / 100) {
                value = m.getKey();
            }
        }

        return value;
    }
}

