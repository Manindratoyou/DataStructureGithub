package com.manindra.recursion;

public class ProgramFour {

    public static void main(String[] args) {
        functionFour(3);
    }
    static void functionFour(int n){
        if (n==0)
            return;
        functionFour(n-1);
        System.out.println(n);
        functionFour(n-1);
    }
}
