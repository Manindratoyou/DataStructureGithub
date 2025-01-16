package com.manindra.hackerrank;

import java.util.stream.IntStream;

public class JavaSubarray {

    public static void main(String[] args) {
        int[] arr = {1, -2, 4, -5, 1};
        System.out.println(countNegativeSubarrays(arr)); // Output: 9
    }
    /*
    input
    5
    1 -2 4 -5 1
    public static void main(String[] args) {
            Scanner scn = new Scanner(System.in); //1 -2 4 -5 1
            int n = scn.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = i; j < n; j++) {
                    sum += arr[j];
                    if (sum < 0) {
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
     */

    public static int countNegativeSubarrays(int[] arr) {
        int count = 0;
        int n = arr.length;

        // Iterate over all possible subarrays
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countNegativeSubarrays2(int[] arr) {
        return (int) IntStream.range(0, arr.length)
                .flatMap(i -> IntStream.range(i, arr.length)
                        .map(j -> IntStream.rangeClosed(i, j).map(k -> arr[k]).sum()))
                .filter(sum -> sum < 0)
                .count();
    }

}

