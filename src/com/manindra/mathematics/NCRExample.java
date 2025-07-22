package com.manindra.mathematics;

public class NCRExample {

    public static void main(String[] args) {
        int n = 5, r = 2;
        System.out.println("nCr of " + n + " and " + r + " is: " + nCr(n, r));
    }

    static int nCr(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    static int factorial(int num) {
        int fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }
}

