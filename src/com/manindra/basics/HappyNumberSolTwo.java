package com.manindra.basics;

import java.util.HashSet;

/*
Time complexity : 0(n*log(n))
Auxiliary space : 0(n) since using extra set for storage
 */
public class HappyNumberSolTwo {

    public static void main(String[] args) {
        System.out.println(isHappyNumber(19));
    }

    static boolean isHappyNumber(int n){
        HashSet<Integer> hashSet=new HashSet<>();
        while (true){
            n=numberSquareSum(n);
            if (n==1)
                return true;
            if (hashSet.contains(n))
                return false;
            hashSet.add(n);
        }
    }
    static int numberSquareSum(int n){
        int squareSum=0;
        while (n!=0){
            squareSum+=(n%10)*(n%10);
            n/=10;
        }
        return squareSum;
    }
}
