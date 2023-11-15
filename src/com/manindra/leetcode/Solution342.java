package com.manindra.leetcode;

public class Solution342 { //power of 4

    public static void main(String[] args) {

        System.out.println(isPowerOfFour(16)); // true
        System.out.println(isPowerOfFour(1)); // true
        System.out.println(isPowerOfFour(87)); // false
        System.out.println(isPowerOfFour(64)); // true
    }

    static boolean isPowerOfFour(int n){

        if (n<=0) return false;

        //keep dividing by 4 until it become 1
        while (n>1){
            if (n%4 !=0) return false;
            n=n/4;
        }
        return true;
    }
}
