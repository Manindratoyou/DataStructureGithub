package com.manindra.recursion;

public class ProgramSix {

    public static void main(String[] args) {
        functionSix(7);
    }

    static void functionSix(int n){
        if (n==0)
            return;
        functionSix(n/2);
        System.out.println(n%2);
    }
}
