package com.manindra.leetcode;

public class Solution441 { //Arranging Coins

    public static void main(String[] args) {
        int n = 8;
        System.out.println(arrangeCoins(n)); // Output: 3
        System.out.println(arrangeCoinsSolutionTwo(n)); // Output: 3
        System.out.println(arrangeCoinsSolutionThree(n)); // Output: 3
    }

    //Solution 1: Binary Search
    public static int arrangeCoins(int n) { //Time Complexity: O(log n) : Auxiliary Space: O(1)
        long left = 0, right = n;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long curr = mid * (mid + 1) / 2;

            if (curr == n) {
                return (int) mid;
            } else if (curr < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) right; // Or return (int)(right + 1);
    }

    //Solution 2: Mathematical Approach
    public static int arrangeCoinsSolutionTwo(int n) { //Time Complexity: O(1) : Auxiliary Space: O(1)
        return (int) (Math.sqrt(2.0 * n + 0.25) - 0.5);
    }

    //Solution 3: Linear Search
    public static int arrangeCoinsSolutionThree(int n) { //Time Complexity: O(n) : Auxiliary Space: O(1)
        int k = 0;
        while (n > k) {
            k++;
            n -= k;
        }
        return k;
    }
}
