package com.manindra.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubArrayWithGivenSum { //check this program

    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 13, 3, -1}; //6,13,3 contiguous element
        int sum = 22;
        System.out.println(isSubArraySumSolOne(arr, 21)); // for two sum only
        System.out.println(isSubArraySumSolTwo(arr, sum));
        System.out.println(subArrayWithGivenSum(arr, sum));
    }

    static boolean isSubArraySumSolOne(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum)
                    return true;
            }
        }
        return false;
    }

    static boolean isSubArraySumSolTwo(int[] arr, int sum) {
        Set<Integer> set = new HashSet<>();
        int targetSum = 0;
        for (int i = 0; i < arr.length; i++) {
            targetSum += arr[i];
            if (targetSum == sum)
                return true;//special case like arr=2,3,4,6 sum 9 (2+3+4=9)
            if (set.contains(targetSum - sum))
                return true;
            set.add(targetSum);
        }
        return false;
    }

    //
    // check same solution in array ds for only pos number
    static boolean subArrayWithGivenSum(int[] arr, int target) { //works both for pos and neg number
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int currSum = 0;

        for (int num : arr) {
            currSum += num;

            if (currSum == target) {
                return true;
            }

            if (prefixSumMap.containsKey(currSum - target)) {
                return true;
            }

            prefixSumMap.put(currSum, prefixSumMap.getOrDefault(currSum, 0) + 1);
        }

        return false;
    }
}
