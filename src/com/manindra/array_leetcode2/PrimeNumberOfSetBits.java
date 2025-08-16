package com.manindra.array_leetcode2;

import java.util.stream.IntStream;

public class PrimeNumberOfSetBits { //solution 762

    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6, 10)); // 4
        System.out.println(countPrimeSetBits(10, 15)); // 5
    }

    public static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            int setBits = Integer.bitCount(i); // built-in bit counting
            if (isPrime(setBits)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static int countPrimeSetBits2(int left, int right) {
        return (int) IntStream.rangeClosed(left, right)
                .filter(num -> isPrime(Integer.bitCount(num)))
                .count();
    }

    private static boolean isPrime2(int num) {
        if (num < 2) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(num))
                .allMatch(div -> num % div != 0);
    }


}

