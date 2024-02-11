package com.manindra.leetcodeMedium;

/*
Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class Solution50 {

    public static void main(String[] args) {

        double x = 2.10000; int n = 3;
        System.out.println(myPow(x,n));
        System.out.println(powerSolutionTwo(x,n));
    }


    static double myPow(double x, int n) {
        if(n>=0)
            return positive(x,n);
        else
            return negative(x,n);
    }

    static double negative(double x, int n)
    {
        if(n==-1)
            return 1/x;

        double smallOutput=myPow(x,n/2);
        if(n%2==0)
            return smallOutput*smallOutput;
        else
            return (1/x)*smallOutput*smallOutput;
    }

    static double positive(double x, int n)
    {
        if(n==0)
            return 1;

        double smallOutput=myPow(x,n/2);
        if(n%2==0)
            return smallOutput*smallOutput;
        else
            return x*smallOutput*smallOutput;
    }

    static String powerSolutionTwo(double x,double n){
        double res=1;
        for (double i=0;i<n;i++){
            res=res*x;
        }
        // Using String.format to format the number
        String formattedNumber = String.format("%.5f", res);
        return formattedNumber;
    }
}
