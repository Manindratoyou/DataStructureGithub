package com.manindra.array;

public class MaximumSumSubArray {

    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; //The subarray [4,-1,2,1] has the largest sum 6.
        System.out.println(maxSumSolOne(arr, arr.length));
        System.out.println(maxSumSolTwo(arr1, arr.length));
    }

    static int maxSumSolOne(int[] arr, int n) {
        int result = arr[0];
        for (int i = 0; i < n; i++) {
            int current = 0;
            for (int j = i; j < n; j++) {
                current = current + arr[j];
                result = Math.max(result, current);
            }
        }
        return result;
    }

    static int maxSumSolTwo(int[] arr, int n) { //leet code solution 53
        int result = arr[0];
        int maxEnding = arr[0];
        for (int i = 1; i < n; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            result = Math.max(result, maxEnding);
        }
        return result;
    }
}
