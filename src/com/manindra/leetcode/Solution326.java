package com.manindra.leetcode;

public class Solution326 { //power of three

    public static void main(String[] args) {

        System.out.println(isPowerOfThree(27)); //output : true
        System.out.println(isPowerOfThree(0));  //output : false
        System.out.println(isPowerOfThree(9));  //output : true
        System.out.println(isPowerOfThree(45));  //output : false
    }

    static boolean isPowerOfThree(int n){

        if (n<=0) return false;

        //keep dividing by 3 until it become 1
        while (n>1){
            if (n%3 !=0) return false;
            n=n/3;
        }
        return true;
    }
}
