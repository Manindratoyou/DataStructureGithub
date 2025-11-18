package com.manindra.string_leetcode1;

public class MagicalString { //solution 481

    public static void main(String[] args) {
        System.out.println(magicalString(6));  // Output: 3
        System.out.println(magicalString(1));  // Output: 1
        System.out.println(magicalString(10)); // Output: 5
    }

    public static int magicalString(int n) {
        if (n == 0) return 0;
        if (n <= 3) return 1; // first 3 chars "122", one '1'

        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 2;

        int read = 2;
        int write = 3;
        int num = 1;   // next number to write
        int countOnes = 1; // already have one '1'

        while (write < n) {
            int repeat = arr[read];

            for (int i = 0; i < repeat && write < n; i++) {
                arr[write] = num;
                if (num == 1) countOnes++;
                write++;
            }

            num = 3 - num; // flip: 1->2, 2->1
            read++;
        }

        return countOnes;
    }


}

