package com.manindra.bit_manipulation_leetcode;

import java.util.Arrays;

public class SortByBits { //solution 1356

    public static void main2(String[] args) {
        int[] arr = {10, 100, 1000, 10000};
        int[] result = Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> {
                    int bitA = Integer.bitCount(a);
                    int bitB = Integer.bitCount(b);
                    return bitA == bitB ? a - b : bitA - bitB;
                })
                .mapToInt(i -> i)
                .toArray();

        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] result = sortByBits(arr);
        System.out.println(Arrays.toString(result)); // Expected: [0, 1, 2, 4, 8, 3, 5, 6, 7]
    }

    static int[] sortByBits(int[] arr) {
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(temp, (a, b) -> {
            int bitA = Integer.bitCount(a);
            int bitB = Integer.bitCount(b);
            return bitA == bitB ? a - b : bitA - bitB;
        });

        return Arrays.stream(temp).mapToInt(i -> i).toArray();
    }

    public static int[] sortByBits2(int[] arr) {
        Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(boxedArr, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            if (countA == countB) {
                return a - b;
            }
            return countA - countB;
        });

        return Arrays.stream(boxedArr).mapToInt(i -> i).toArray();
    }
}

