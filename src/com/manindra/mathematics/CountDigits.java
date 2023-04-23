package com.manindra.mathematics;

public class CountDigits {

    public static void main(String[] args) {

        System.out.println(countDigit(9234));
    }

    static int countDigit(int n){
        int res=0;
        while (n>0){
            n=n/10;
            res++;
        }
        return  res;
    }
}
