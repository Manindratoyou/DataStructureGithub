package com.manindra.corejava;

public class Test10 {

    static int x = 10;
    int y = 20;

    public static void main(String[] args) {

        Test10 test = new Test10();
        test.x = 888;
        test.y = 999;
        Test10 test2 = new Test10();
        System.out.println(test2.x + " " + test2.y);
    }
}
