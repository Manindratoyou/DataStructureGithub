package com.manindra.array_leetcode1;

import java.util.HashMap;
import java.util.Map;

/*
Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 */
public class Solution1512 { //Number of Good Pairs

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1, 1, 3};
        int[] nums1 = {1, 1,1};
        int[] nums2 = {1, 2,3};
        System.out.println("Number of good pairs: " + numIdenticalPairs(nums));
        System.out.println("Number of good pairs: " + numIdenticalPairsSolutionTwo(nums1));
        System.out.println("Number of good pairs: " + numIdenticalPairsSolutionTwo(nums2));
        System.out.println("Number of good pairs: " + numIdenticalPairsSolutionThree(nums));
    }

    public static int numIdenticalPairs(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int numIdenticalPairsSolutionTwo(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            count += countMap.getOrDefault(num, 0);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        return count;
    }

    public static int numIdenticalPairsSolutionThree(int[] nums) {

        //calculate the frequency of each number
        int [] count=new int[102];

        for (int num : nums){
            count[num]++;
        }

        int totalCount=0;

        //calculate the total number of pairs possible
        for (int i: count){
            totalCount+=((i)*(i-1))/2;
        }
        return totalCount;
    }


}
