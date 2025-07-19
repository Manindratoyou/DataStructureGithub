package com.manindra.array_leetcode2;

public class PeakIndexInMountainArray { //solution 852

    public static void main(String[] args) {
        int[] arr = {0, 2, 4, 6, 5, 3, 1};
        System.out.println(peakIndexInMountainArray(arr)); // Output: 3
    }

    public static int peakIndexInMountainArray(int[] arr) { //Solution 1: Linear Scan
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1; // This won't be hit due to constraints.
    }

    public static int peakIndexInMountainArray2(int[] arr) { //Solution 2: Binary Search (Optimal)
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // Peak is on the right
                left = mid + 1;
            } else {
                // Peak is on the left or at mid
                right = mid;
            }
        }

        return left; // or right (both same)
    }


}
