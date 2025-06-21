package com.manindra.hashing_leetcode;

import java.util.*;

public class MajorityElementII { //solution 229

    public static void main(String[] args) {
        MajorityElementII obj = new MajorityElementII();
        System.out.println(obj.majorityElement(new int[]{3,2,3})); // [3]
        System.out.println(obj.majorityElement(new int[]{1,1,1,3,3,2,2,2})); // [1,2]
    }

    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        Integer candidate1 = null, candidate2 = null;

        // First pass: Find potential candidates
        for (int num : nums) {
            if (candidate1 != null && num == candidate1) {
                count1++;
            } else if (candidate2 != null && num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Second pass: Verify counts
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;
        if (count1 > threshold) result.add(candidate1);
        if (count2 > threshold) result.add(candidate2);

        return result;
    }

    public List<Integer> majorityElement2(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int n = nums.length;

        // Step 1: Count frequency of each number
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Collect elements that appear more than n/3 times
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > n / 3) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

}

