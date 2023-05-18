package com.manindra.recursion;

public class ProgramFive {

    public static void main(String[] args) {
        System.out.println(functionFive(16));
    }
    static int functionFive(int n){
        if (n==1)
            return 0;
        else
            return 1+functionFive(n/2);
    }
}
