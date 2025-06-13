package com.manindra.hackerrank_2;

import java.util.*;

public class LonelyInteger {

    public static int lonelyinteger(List<Integer> a) {
        int result = 0;
        for (int num : a) {
            result ^= num; // XOR all elements
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> test1 = Arrays.asList(1, 2, 3, 4, 3, 2, 1); // Output: 4
        List<Integer> test2 = Arrays.asList(0, 0, 1);             // Output: 1
        List<Integer> test3 = Arrays.asList(7);                   // Output: 7

        System.out.println("Lonely integer in test1: " + lonelyinteger(test1));
        System.out.println("Lonely integer in test2: " + lonelyinteger(test2));
        System.out.println("Lonely integer in test3: " + lonelyinteger(test3));
    }
}
