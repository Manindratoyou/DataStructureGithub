package com.manindra.interview;

import java.util.Arrays;

public class Program2 {

    /*
    You are organizing a music concert and want to arrange the performance on stage in a visually appealing manner.
    To achieve this, each performer is represented by distinct positive integers, and you want to arrange them on stage
    in such a way that for every odd index, the element is swapped with the element at the preceding even index.

   Write a function/method in Java named danceForm that takes an integer n representing the number of performers and an
   array a of length n representing the performers' order. The function should rearrange the array to create a
   visually appealing dance form.
     */

    public static void main(String[] args) {
        int[] performers = {1, 2, 3, 4, 5, 6};
        int n = 6;
        danceForm(n, performers);
        System.out.println(Arrays.toString(performers)); // Output: [2, 1, 4, 3, 6, 5]

    }

    public static void danceForm(int n, int[] a) {
        for (int i = 0; i < n; i++) {
            int temp = Integer.MIN_VALUE;
            if (i % 2 == 1) {
                temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp;
            }
        }
    }
}
