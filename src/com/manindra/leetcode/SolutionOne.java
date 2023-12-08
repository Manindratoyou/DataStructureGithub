package com.manindra.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionOne {

    public static void main(String[] args) {
        int [] arr={2,11,5,10,7,8};
        int targetSum=9;
        int [] result=solutionOne(arr,targetSum);
        int [] result2=solutionTwo(arr,targetSum);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
    }

    public static int [] solutionOne(int [] numbers,int targetSum){
        int [] result=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i< numbers.length;i++){
            if (!map.containsKey(targetSum-numbers[i]))
                map.put(numbers[i], i);
            else {
                result[1]=i;
                result[0]=map.get(targetSum-numbers[i]);
                return result;
            }
        }
        throw new IllegalArgumentException("Numbers Not found");
    }

    static int[] solutionTwo(int[] nums, int target) {

        // Create a HashMap
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // Get the complement using the target value
            int complement = target - nums[i];

            // Search the hashmap for complement, if found, we got our pair
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Put the element in hashmap for subsequent searches.
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
