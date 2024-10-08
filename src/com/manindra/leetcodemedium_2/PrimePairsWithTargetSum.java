package com.manindra.leetcodemedium_2;

import java.util.ArrayList;
import java.util.List;

public class PrimePairsWithTargetSum { //solution 2761

    public static void main(String[] args) {
        int target = 50;
        List<List<Integer>> primePairs = findPrimePairs(target);

        // Output the prime pairs
        for (List<Integer> pair : primePairs) {
            System.out.println(pair);
        }
    }

    // Helper function to generate all primes up to a given limit using Sieve of Eratosthenes
    public static boolean[] generatePrimes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    // Function to find prime pairs with the given target sum
    public static List<List<Integer>> findPrimePairs(int target) {
        List<List<Integer>> result = new ArrayList<>();

        // Generate primes up to the target
        boolean[] isPrime = generatePrimes(target);

        // Find prime pairs
        for (int i = 2; i <= target / 2; i++) {
            if (isPrime[i] && isPrime[target - i]) {
                List<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(target - i);
                result.add(pair);
            }
        }

        return result;
    }

}
