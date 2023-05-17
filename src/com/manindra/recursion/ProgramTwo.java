package com.manindra.recursion;

public class ProgramTwo {

    public static void main(String[] args) {
        functionOne(2);
    }
    static void functionOne(int n){
        if (n==0)
            return;
        System.out.println("Manindra");
        functionOne(n-1);
    }
}
