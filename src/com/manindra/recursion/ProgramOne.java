package com.manindra.recursion;

public class ProgramOne {

    public static void main(String[] args) {
        System.out.println("before function2");
        function2();
        System.out.println("after function2");
    }
    static void function2(){
        System.out.println("before function1");
        function1();
        System.out.println("after function1");
    }
    static void function1(){
        System.out.println("function1");
    }
}
