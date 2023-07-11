package com.manindra.bitmagic;

public class PowerOfTwo {

    public static void main(String[] args) {

        int input=4;//op true
        int input1=6;//op false
        System.out.println(isPow(input));
        System.out.println(isPowSolTwo(input));
    }

    static boolean isPow(int n){
        if (n==0)
            return false;
        while (n!=1){
            if (n%2 !=0)
                return false;
            n=n/2;
        }
        return true;
    }
    static boolean isPowSolTwo(int n){
        /*if (n==0)
            return false;
        return ((n&(n-1))==0);*/
        return  ((n&(n-1))==0);
    }
}
