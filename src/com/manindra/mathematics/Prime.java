package com.manindra.mathematics;

public class Prime {

    public static void main(String[] args) {

        System.out.println(isPrimeSolutionOne(7));
        printPrimes(10);
    }

    //solution one (Q7 Notes)
    static boolean isPrimeSolutionOne(int n){
        if (n==1)
            return false;
        for (int i=2;i<n;i++){
            if (n%i==0)
                return false;
        }
        return true;
    }

    //print prime number from 1 to n(q10)
    static void printPrimes(int n){
        for (int i=2;i<n;i++){
            if (isPrimeSolutionOne(i))
                System.out.print(i +" ");
        }
    }
}
