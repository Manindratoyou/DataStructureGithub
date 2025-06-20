package com.manindra.hashing_leetcode;

import java.util.*;

public class SortByFrequency { //solution 1636

    public static void main(String[] args) {
        SortByFrequency obj = new SortByFrequency();
        System.out.println(Arrays.toString(obj.frequencySort(new int[]{1,1,2,2,2,3}))); // Output: [3,1,1,2,2,2]
        System.out.println(Arrays.toString(obj.frequencySort(new int[]{2,3,1,3,2})));   // Output: [1,3,3,2,2]
        System.out.println(Arrays.toString(obj.frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1}))); // Output: [5,-1,4,4,-6,-6,1,1,1]
    }

    public int[] frequencySort(int[] nums) {
        // Step 1: Count frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert array to boxed Integer[] for custom sorting
        Integer[] boxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        // Step 3: Sort based on frequency ASC, value DESC
        Arrays.sort(boxed, (a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            if (freqA != freqB) {
                return freqA - freqB; // Increasing frequency
            } else {
                return b - a; // Decreasing value
            }
        });

        // Step 4: Convert back to primitive int[]
        return Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();
    }


}

