package com.manindra.leetcodeEasy;

public class FibonacciNumber { //solution 509

    public static void main(String[] args) {

        int N = 10;
        for (int i = 0; i < N; i++) {
            System.out.print(fibonacciSeriesUsingDP(i) + " ");
        }
        System.out.println();
    }

    static int fibonacciSeriesUsingDP(int n) {

        //declare an array to store fibonacci number
        //1 extra to handle case ,n=0;
        int f[] = new int[n + 2];

        int i;

        //0th and 1st number of the series are 0 and 1
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++) {
            //add the previous 2 numbers in the series and store it
            f[i] = f[i - 1] + f[i - 2];
        }

        //Nth fibonacci number
        return f[n];
    }
}
