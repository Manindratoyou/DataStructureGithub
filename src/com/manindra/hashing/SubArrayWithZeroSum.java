package com.manindra.hashing;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithZeroSum {

    public static void main(String[] args) {
        int[] arr = {1, 4, 13, -3, -10, 5};//13,-3,-10 sum is zero
        System.out.println(isZeroSumSolOne(arr));
        System.out.println(isZeroSumSolTwo(arr));
    }

    static boolean isZeroSumSolOne(int[] arr) { //O(n2)
        for (int i = 0; i < arr.length; i++) {
            int current_sum = 0;
            for (int j = i; j < arr.length; j++) {
                current_sum += arr[j];
                if (current_sum == 0)
                    return true;
            }
        }
        return false;
    }

    static boolean isZeroSumSolTwo(int[] arr) { //O(n)

        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (set.contains(sum))
                return true;
            if (sum == 0) //[-3,2,1]
                return true;
            set.add(sum);
        }
        return false;
    }
}
