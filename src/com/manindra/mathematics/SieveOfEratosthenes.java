package com.manindra.mathematics;

import java.util.Arrays;

public class SieveOfEratosthenes {

    public static void main(String[] args) {

        printPrimesSolOne(25);
        System.out.println();
        printPrimesSolTwo(25);
    }

    static void printPrimesSolOne(int n){ //time complexity o(n *Sqrt(n))
        for (int i=2;i<=n;i++){
            if (checkPrime(i))
                System.out.print(i+ " ");
        }
    }
    static void printPrimesSolTwo(int n){
        boolean[] isPrime=new boolean[n+1];
        Arrays.fill(isPrime,true);
        for (int i=2;i*i<=n;i++){
            if (isPrime[i]){
                for (int j=2*i;j<=n;j=j+i){
                    isPrime[j]=false;
                }
            }
        }
        for (int i=2;i<=n;i++){
            if (isPrime[i])
                System.out.print(i+ " ");
        }
    }

    static boolean checkPrime(int n) {
        if (n == 1)
            return false;
        for (int i = 2; i * i <= n; i++) { //for (int i=2;i<Math.sqrt(n);i++){
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
