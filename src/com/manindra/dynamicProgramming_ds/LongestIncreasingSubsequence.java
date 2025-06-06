package com.manindra.dynamicProgramming_ds;

public class LongestIncreasingSubsequence { //part1

    public static void main(String[] args) {

        int[] arr = {3, 4, 2, 8, 10, 5, 1}; //3 4 8 10
        int[] arr1 = {4, 10, 6, 5, 8, 11, 2, 20}; //4 6 8 11 20  or  4 5 8 11 20
        System.out.println(LIS(arr));
    }

    static int LIS(int[] arr) {
        int n = arr.length;
        int lis[] = new int[n];
        lis[0] = 1;
        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                //if (arr[i] > arr[j])
                if (arr[j] < arr[i])
                    lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }
        int result = lis[0];
        for (int i = 0; i < n; i++) {
            result = Math.max(lis[i], result);
        }
        return result;
    }
}
