package com.manindra.recursion;

public class ProgramSeven {

    public static void main(String[] args) {
        printNumber(4);
    }
    static void printNumber(int n){
        if (n==0)
            return;
        //System.out.println(n);//print n to 1 recursive
        printNumber(n-1);
        System.out.println(n);//print 1 to n recursive
    }
}
