package com.manindra.util;

//Java program to find the largest subarray with sum greater than k
/*
Input: arr[] = [-2, 1, 6, -3], k = 5
Output: 2
Explanation: The largest subarray with a sum greater than 5 is  {1, 6}.
 */
public class LargestSubarray {

    public static void main(String[] args) {
        int[] arr = {2, -3, 3, 2, 0, -1};
        int k = 3;
        System.out.println(largestSubarray(arr, k));
    }

    static int largestSubarray(int[] arr, int k) {

        // to store the result
        int ans = 0;

        // consider all subarrays starting from i
        for (int i = 0; i < arr.length; i++) {

            // to store the sum of the subarray
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                // if the sum is greater than k
                if (sum > k) {

                    // update the result
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}
