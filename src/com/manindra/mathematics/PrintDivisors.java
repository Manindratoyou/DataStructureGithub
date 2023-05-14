package com.manindra.mathematics;

public class PrintDivisors {

    public static void main(String[] args) {
        printDivisorSolOne(6);
        System.out.println();
        printDivisorSolTwo(25);
    }

    static void printDivisorSolOne(int n){ //time complexity Q(n) ,Q(1) Auxiliary space
        for (int i=1;i<=n;i++){
            if (n%i==0)
                System.out.print(i+" ");
        }
    }
    static void printDivisorSolTwo(int n){ //time complexity Q(sqrt(n)) ,Q(1) Auxiliary space
            int i = 1;
            for(i=1; i*i < n; i++)
            {
                if(n % i == 0)
                {
                    System.out.print(i+" ");
                }
            }

            for(; i >= 1; i--)
            {
                if(n % i == 0)
                {
                    System.out.print((n / i)+" ");
                }
            }
    }
}
