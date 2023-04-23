package com.manindra.mathematics;

public class Factorial {

    public static void main(String[] args) {

        System.out.println(factIterative(5));
        System.out.println(factRecursive(5));
    }

    static int factIterative(int number){
        int res=1;
        for(int i=1;i<=number;i++){
            res=res*i;
        }
        return res;
    }

    static int factRecursive(int n){
        if (n==0)
            return 1;
        return n*factRecursive(n-1);
    }
}
