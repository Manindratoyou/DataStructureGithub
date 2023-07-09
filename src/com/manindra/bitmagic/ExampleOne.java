package com.manindra.bitmagic;

public class ExampleOne {

    public static void main(String[] args) {

        int x=3,y=6;
        System.out.println(x&y);// 1 1 -> remaining 0
        System.out.println(x|y);//0 0-> 0 remaining 1
        System.out.println(x^y);//xor 0 0 ->0 ,1 1->0 ,0 1->1,1 0->1
    }
}
