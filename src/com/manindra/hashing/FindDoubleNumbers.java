package com.manindra.hashing;

import java.util.HashSet;

public class FindDoubleNumbers {

    public static void main(String[] args) {
        int[] arr = {8, 4, 9, 18, 40, 20, 22, 45};

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int count = 0;
        System.out.print("Numbers with double present: ");
        for (int num : arr) {
            if (set.contains(num * 2)) {
                System.out.print(num + " ");
                count++;
            }
        }

        System.out.println("\nCount: " + count);
    }
}

