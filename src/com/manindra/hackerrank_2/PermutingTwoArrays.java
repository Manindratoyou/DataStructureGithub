package com.manindra.hackerrank_2;

import java.util.*;

public class PermutingTwoArrays {

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        Collections.sort(A);                     // Sort A in ascending order
        B.sort(Collections.reverseOrder());      // Sort B in descending order

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) + B.get(i) < k) {
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        List<Integer> A1 = Arrays.asList(2, 1, 3);
        List<Integer> B1 = Arrays.asList(7, 8, 9);
        int k1 = 10;
        System.out.println(twoArrays(k1, A1, B1)); // Output: YES

        List<Integer> A2 = Arrays.asList(1, 2, 2, 1);
        List<Integer> B2 = Arrays.asList(3, 3, 3, 4);
        int k2 = 5;
        System.out.println(twoArrays(k2, A2, B2)); // Output: NO
    }
}

