package com.manindra.stack_ds;

//solution 2 : space efficient implementation
public class TwoStackEfficient {

    public static void main(String[] args) {
        TwoStackEfficient twoStacks = new TwoStackEfficient(5);

        twoStacks.pushToStack1(10);
        twoStacks.pushToStack1(20);
        twoStacks.pushToStack2(30);
        twoStacks.pushToStack2(40);

        System.out.println("Popped from Stack 1: " + twoStacks.popFromStack1());
        System.out.println("Popped from Stack 2: " + twoStacks.popFromStack2());
    }

    int capacity;
    int top1, top2;
    int[] array;

    TwoStackEfficient(int n) {
        array = new int[n];
        capacity = n;
        top1 = -1;
        top2 = capacity;
    }

    void pushToStack1(int x) {
        if (top1 < top2 - 1) {
            top1++;
            array[top1] = x;
        } else {
            System.out.println("Stack Overflow for Stack 1 by element: " + x);
        }
    }

    void pushToStack2(int x) {
        if (top1 < top2 - 1) {
            top2--;
            array[top2] = x;
        } else {
            System.out.println("Stack Overflow for Stack 2 by element: " + x);
        }
    }

    int popFromStack1() {
        if (top1 >= 0) {
            int x = array[top1];
            top1--;
            return x;
        } else {
            System.out.println("Stack Underflow for Stack 1");
            return Integer.MIN_VALUE;
        }
    }

    int popFromStack2() {
        if (top2 < capacity) {
            int x = array[top2];
            top2++;
            return x;
        } else {
            System.out.println("Stack Underflow for Stack 2");
            return Integer.MIN_VALUE;
        }
    }
}