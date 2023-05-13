package com.manindra.mathematics;

public class PrimeFactor {

    public static void main(String[] args) {
        primeFactorSolOne(12);
        System.out.println();
        primeFactorSolTwo(84);//450
        System.out.println();
        primeFactorSolThree(450);
    }

    static void primeFactorSolOne(int n){
        for (int i=2;i<n;i++){
            if (isPrime(i)){
                int x=i;
                while (n%x==0){
                    System.out.print(i+ " ");
                    x=x*i;
                }
            }
        }
    }

    static void primeFactorSolTwo(int n){
        if (n<=1)
            return;
        for (int i=2;i*i<=n;i++){
            while (n%i==0){
                System.out.print(i + " ");
                n=n/i;
            }
        }
        if (n>1)
            System.out.println(n);
    }

    static void primeFactorSolThree(int n){ //0(Sqrt(n)) time complexity
        if (n<=1)
            return;
        while (n%2==0){
            System.out.print(2 + " ");
            n=n/2;
        }
        while (n%3==0){
            System.out.print(3 +" ");
            n=n/3;
        }
        for (int i=5;i*i<=n;i=i+6){
            while (n%i==0){
                System.out.print(i + " ");
                n=n/i;
            }
            while (n%(i+2)==0){
                System.out.print(i+2);
                n=n/(i+2);
            }
        }
        if (n>3)
            System.out.print(n);
    }

    static boolean isPrime(int n){ //O(sqrt(n))-time complexity
        if (n==1)
            return false;
        for (int i=2;i*i<=n;i++){ //for (int i=2;i<Math.sqrt(n);i++){
            if (n%i==0)
                return false;
        }
        return true;
    }
}
