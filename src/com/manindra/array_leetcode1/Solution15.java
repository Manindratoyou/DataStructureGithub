package com.manindra.array_leetcode1;

import java.util.*;

public class Solution15 { // 3sum unique triplets

    public static void main(String[] args) {
        int [] nums={-1,0,1,2,-1,-4};
        int [] nums1={0, 0, 0}; //Output: [[0, 0, 0]]
        int [] nums2={1, 2, -2, -1}; //Output: [] (No triplets summing to zero)
        int [] nums3={3, 0, -2, -1, 1, 2};//Output: [[-2, -1, 3], [-2, 0, 2], [-1, 0, 1]]

        List<List<Integer>> result=threeSum(nums);
        List<List<Integer>> result2=threeSumSolTwo(nums1);

        System.out.println("Unique Triplets" + result);
        System.out.println("------------------------");
        System.out.println("Unique Triplets" + result2);
    }

    static List<List<Integer>> threeSum(int[] arr) {

        if (arr == null || arr.length < 3) return new ArrayList<>();

        // Sort the elements
        Arrays.sort(arr);
        Set<List<Integer>> result = new HashSet<>();

        // Now fix the first element and find the other two elements
        for (int i = 0; i < arr.length - 2; i++)
        {
            // Find other two elements using Two Sum approach
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {

                    // Add the set, and move to find other triplets
                    result.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                } else if (sum < 0)
                    left++;
                else
                    right--;
            }
        }
        return new ArrayList<>(result);
    }

    public static List<List<Integer>> threeSumSolOne(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum<target) {
                    left++;
                }else right--;
            }
        }
        return resultList;
    }

    public static List<List<Integer>> threeSumSolTwo(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i=0;i< nums.length-2;i++){

            if (i>0 && nums[i] ==nums[i-1]) continue;

            int target=-nums[i];
            Set<Integer> seen=new HashSet<>();
            for (int j=i+1;j< nums.length;j++){
                int complement= target-nums[j];

                if (seen.contains(complement)){
                    resultList.add(Arrays.asList(nums[i],complement,nums[j]));

                    //skip duplicates
                    while (j< nums.length-1 && nums[j]==nums[j+1]) j++;
                }
                seen.add(nums[j]);
            }
        }
        return resultList;
    }
}
