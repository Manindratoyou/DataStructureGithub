package com.manindra.basics;

public class FibonacciNumber {

    public static void main(String[] args) {

        int n=5;
        System.out.println("Fibonacci Sequence");
        for (int i=0;i<n;i++){
            int fibonacciNumber=fibonacci(i);
            System.out.print(fibonacciNumber + " ");
        }
    }

    static int fibonacci(int n){
        if (n<=1)
            return n;
        else
            return fibonacci(n-1)+fibonacci(n-2);
    }
}
