package com.manindra.recursion;

public class GetSumUsingRecursion {

    public static void main(String[] args) {
        System.out.println(getSum(4));
    }

    static int getSum(int n){//tc Qn AS- Qn
        if (n==0)
            return 0;
        return n+getSum(n-1);
    }
}
