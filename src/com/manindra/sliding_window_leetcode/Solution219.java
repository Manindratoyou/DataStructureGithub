package com.manindra.sliding_window_leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution219 {// ContainsDuplicatesII

    public static void main(String[] args) {
        int [] nums={1,2,3,1}; int k=3;
        System.out.println(containsNearByDuplicates(nums,k));
        System.out.println(containsNearbyDuplicate2(nums,k));
    }

    static boolean containsNearByDuplicates(int [] nums, int k){

        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i]) && i-map.get(nums[i])<=k)
                return true;

            map.put(nums[i],i);
        }
        return false;
    }

    //Sliding Window using HashSet
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // Maintain the sliding window of size k
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }

            // If duplicate found in the current window
            if (!window.add(nums[i])) {
                return true;
            }
        }

        return false;
    }
}
