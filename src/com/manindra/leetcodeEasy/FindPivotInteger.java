package com.manindra.leetcodeEasy;

public class FindPivotInteger { //solution 2485

    public static void main(String[] args) {
        System.out.println(pivotInteger(8));  // Output: 6
        System.out.println(pivotInteger(1));  // Output: 1
        System.out.println(pivotInteger(4));  // Output: -1
    }

    public static int pivotInteger(int n) {
        int total = n * (n + 1) / 2;
        int sqrt = (int) Math.sqrt(total);
        return sqrt * sqrt == total ? sqrt : -1;
    }

    public static int pivotInteger2(int n) {
        int totalSum = n * (n + 1) / 2;
        int prefixSum = 0;

        for (int i = 1; i <= n; i++) {
            prefixSum += i;
            int rightSum = totalSum - (i - 1) * i / 2;
            if (prefixSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

    public static int pivotInteger3(int n) {
        int totalSum = n * (n + 1) / 2;

        for (int x = 1; x <= n; x++) {
            int leftSum = x * (x + 1) / 2;
            int rightSum = totalSum - (x - 1) * x / 2;
            if (leftSum == rightSum) return x;
        }
        return -1;
    }
}

