package com.manindra.mathematics;

public class CountZeroInFactorial {

    public static void main(String[] args) {
        System.out.println(countZero(5)); //120 trailing zero 1
        System.out.println(countZero(10));//overflow issue with higher value
        System.out.println(countTrailingZero(251));
    }

    static int countZero(int n) {
        int res = 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            res = res * i;
        }

        while (res % 10 == 0) {
            count++;
            res = res / 10;
        }
        return count;
    }

    //count zero efficient solution
    static int countTrailingZero(int n) {
        int res = 0;
        for (int i = 5; i <= n; i = i * 5) {
            res = res + n / i;
        }
        return res;
    }
}
