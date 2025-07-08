package com.manindra.array_leetcode1;

import java.util.HashMap;
import java.util.Map;

public class FindLuckyInteger { //solution 1394

    public static void main(String[] args) {

        int [] arr = {1,2,2,3,3,3};
        System.out.println(findLucky(arr));
    }

    static int findLucky(int[] arr) {

        int largest=0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer,Integer> m: map.entrySet()){
            if (m.getKey()==m.getValue())
                if (m.getKey()>largest) {
                    largest = m.getKey();
                }

        }
        return largest ==0 ? -1 : largest ;
    }

    public int findLucky2(int[] arr) {
        int[] ca = new int[501]; // Assuming numbers in 'arr' are non-negative and up to 500

        // Count occurrences of each number
        for (int i : arr) {
            ca[i]++;
        }

        // Iterate from the largest possible number downwards
        // to find the largest "lucky number"
        for (int i = 500; i > 0; i--) { // Start from 500 down to 1
            // A number 'i' is lucky if its count (ca[i]) is equal to 'i'
            if (i == ca[i]) {
                return i; // Return the first (largest) lucky number found
            }
        }

        return -1; // No lucky number found
    }
}
