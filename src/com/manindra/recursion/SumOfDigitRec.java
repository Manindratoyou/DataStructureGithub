package com.manindra.recursion;

public class SumOfDigitRec {

    public static void main(String[] args) {
        System.out.println(getSumRec(253));
    }
    static int getSumRec(int n){//tc Q(d) a.s Q(d)
        if (n==0)
            return 0;
        return getSumRec(n/10)+n%10;
    }
}
