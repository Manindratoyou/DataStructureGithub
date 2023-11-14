package com.manindra.leetcode;

public class Solution367 { //valid perfect square

    public static void main(String[] args) {

        int num1=16;
        int num2=14;
        //System.out.println(num1 + " is a valid perfect square : "+isPerfectSquare(num1));
        //System.out.println(num2 + " is a valid perfect square : "+isPerfectSquare(num2));
        System.out.println(num1 + " is a valid perfect square : "+isPerfectSquareSolutionTwo(num1));
        System.out.println(num2 + " is a valid perfect square : "+isPerfectSquareSolutionTwo(num2));
    }

    public static boolean isPerfectSquare(int num){
        if (num<2) return true;//0 and 1 are perfect square

        long left =2;
        long right=num/2;

        while (left<=right){
            long mid=left+(right-left)/2;
            long square=mid*mid;

            if (square==num) return true;
            else if (square<num) left=mid+1;
            else right=mid-1;
        }
        return false;
    }
    public static boolean isPerfectSquareSolutionTwo(int num){
        int i=1;
        while (num>0){
            num-=i;
            i+=2;
        }
        return num==0;
    }

}
