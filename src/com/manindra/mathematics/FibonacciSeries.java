package com.manindra.mathematics;

public class FibonacciSeries {

    public static void main(String[] args) {
        int N=10;
        //1.
        fibonacci(N);
        System.out.println();
        //2.
        for (int i=0;i<N;i++){
            System.out.print(fibonacciRecursion(i)+" ");
        }
        System.out.println();
        //3.
        for (int i=0;i<N;i++){
            System.out.print(fibonacciUsingDynamicProgramming(i)+" ");
        }
    }

    static void fibonacci(int n){
        int num1=0,num2=1;
        for (int i=0;i<n;i++){

            System.out.print(num1+" ");

            int num3=num2+num1;
            num1=num2;
            num2=num3;
        }
    }

    static int fibonacciRecursion(int n){

        //base case
        if (n<=1)
            return n;
        return fibonacciRecursion(n-1)+fibonacciRecursion(n-2);
    }


    static int fibonacciUsingDynamicProgramming(int n){

        //declare an array to store fibonacci numbers
        int [] f=new int[n+2];

        int i;

        //0 th and 1st number of the series are 0 and 1;
        f[0]=0;
        f[1]=1;

        for (i=2;i<=n;i++){
            //add the previous 2 numbers in the series and store it;
            f[i]=f[i-1]+f[i-2];
        }

        //n the fibonacci number
        return f[n];
    }
}
