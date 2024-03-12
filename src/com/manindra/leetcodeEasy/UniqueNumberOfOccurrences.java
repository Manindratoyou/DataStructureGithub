package com.manindra.leetcodeEasy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
}
