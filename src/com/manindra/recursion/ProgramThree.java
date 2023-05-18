package com.manindra.recursion;

public class ProgramThree {

    public static void main(String[] args) {
        functionThree(3);
    }

    static void functionThree(int n){
        if (n==0)
            return;
        System.out.println(n);
        functionThree(n-1);
        System.out.println(n);
    }
}
