package com.manindra.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubArrayWithGivenSum { //check this program

    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 13, 3, -1}; //6,13,3 contiguous element
        int sum = 22;
        System.out.println(isSubArraySumSolOne(arr, 21));
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
        int pre_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            pre_sum += arr[i];
            if (pre_sum == sum) return true;//special case like arr=2,3,4,6 sum 9 (2+3+4=9)
            if (set.contains(pre_sum - sum))
                return true;
            set.add(pre_sum);
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
