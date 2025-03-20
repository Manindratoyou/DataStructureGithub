package com.manindra.leetcodeEasy;

import java.util.stream.IntStream;

public class DivisibleAndNonDivisibleSums { //solution 2894
    public static void main(String[] args) {
        System.out.println(differenceOfSums(10, 3)); // Output: 19
        System.out.println(differenceOfSums(5, 6));  // Output: 15
    }

    public static int differenceOfSums(int n, int m) { //TC :O(n) AS :O(1)
        int num1 = 0, num2 = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                num2 += i;  // Sum of numbers divisible by m
            } else {
                num1 += i;  // Sum of numbers not divisible by m
            }
        }

        return num1 - num2;
    }

    public static int differenceOfSums2(int n, int m) {
        int sumDiv = IntStream.rangeClosed(1, n)
                .filter(i -> i % m == 0)
                .sum();

        int sumNotDiv = IntStream.rangeClosed(1, n)
                .filter(i -> i % m != 0)
                .sum();

        return sumDiv - sumNotDiv;
    }

    public static int differenceOfSums3(int n, int m) {
        int totalSum = (n * (n + 1)) / 2; // Sum of all numbers from 1 to n
        int p = n / m; // Number of multiples of m
        int sumDiv = m * (p * (p + 1)) / 2; // Sum of numbers divisible by m

        return totalSum - 2 * sumDiv;
    }
}

