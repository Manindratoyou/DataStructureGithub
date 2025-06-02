package com.manindra.leetcodeEasy;

import java.util.*;

public class UniqueNumberOfOccurrences { //solution 1207

    /*
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of
occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
     */
    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr));

    }

    static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurenceMap = new HashMap<>();
        for (int num : arr) {
            occurenceMap.put(num, occurenceMap.getOrDefault(num, 0) + 1);
        }
        Set<Integer> uniqueValues = new HashSet<>();
        for (int value : occurenceMap.values()) {
            if (uniqueValues.contains(value)) {
                return false;
            }
            uniqueValues.add(value);
        }
        return true;
    }

    public boolean uniqueOccurrences2(int[] arr) {
        int[] ca = new int[2001]; // Assuming the range of numbers in 'arr' is such that arr[i] + 1000 fits within 0-2000

        // Count occurrences of each number
        for (int i : arr) {
            ca[i + 1000]++; // Offset by 1000 to handle negative numbers if they exist
        }

        // Sort the array of counts
        Arrays.sort(ca);

        // Check for unique occurrences
        // We iterate up to 1999 because we compare ca[i] with ca[i+1]
        for (int i = 0; i < 2000; i++) {
            // If the current count is not zero (meaning it actually occurred)
            // AND the current count is equal to the next count
            if (ca[i] != 0 && ca[i] == ca[i + 1]) {
                return false; // Found duplicate occurrences
            }
        }

        return true; // All occurrences are unique
    }
}
