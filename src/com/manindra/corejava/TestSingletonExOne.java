package com.manindra.corejava;

public class TestSingletonExOne {

    public static void main(String[] args) {

        SingletonExampleOne a=SingletonExampleOne.getInstance();
        SingletonExampleOne b=SingletonExampleOne.getInstance();
        SingletonExampleOne c=SingletonExampleOne.getInstance();

        System.out.println("Hashcode of a is "+a.hashCode());
        System.out.println("Hashcode of b is "+b.hashCode());
        System.out.println("Hashcode of c is "+c.hashCode());

        if (a==b && b==c)
            System.out.println("Three object point to the same memory location on the heap i.e to the same object");
        else
            System.out.println("Three object do not point to the same memory location on the heap");
    }
}
