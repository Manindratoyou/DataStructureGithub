package com.manindra.array_leetcode2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CountPrimes { //Solution 204

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Prime count less than " + n + ": " + countPrimes(n));
    }
//Time Complexity: O(n log log n)
//Space Complexity: O(n)
    public static int countPrimes(int n) { //Approach 1: Sieve of Eratosthenes (Efficient and Optimal)
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (boolean prime : isPrime) {
            if (prime)
                count++;
        }
        return count;
    }
    //Time Complexity: O(n√n)
    public static int countPrimesNaive(int n) { //Approach 2: Naive Approach (Not Recommended for Large n)
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i))
                count++;
        }
        return count;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return num > 1;
    }

    public static int countPrimesNaive1(int n) { //stream
        long count1 = IntStream.range(0, n).filter(value -> isPrime(value)).count();
        return (int) count1;
    }
}

