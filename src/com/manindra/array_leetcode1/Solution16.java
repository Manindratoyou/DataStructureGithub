package com.manindra.array_leetcode1;

import java.util.Arrays;

public class Solution16 { //3Sum Closest

    public static void main(String[] args) {

        int [] nums={-1,2,1,-4};
        int target=1;
        int result=threeSumClosest(nums,target);
        System.out.println("Closest 3Sum to target " +result);
    }

    public static int threeSumClosest(int [] nums ,int target){

        Arrays.sort(nums);
        int closestSum=nums[0]+nums[1]+nums[2];

        for (int i=0;i< nums.length-2;i++){
            int left=i+1;
            int right= nums.length-1;

            while (left<right){
                int currentSum=nums[i]+nums[left]+nums[right];

                //update the closestSum if the currentSum is closer to the target
                if (Math.abs(currentSum-target) <Math.abs(closestSum-target))
                    closestSum=currentSum;

                //adjust pointers based on the comparison with the target
                if (currentSum<target)
                    left++;
                else right--;
            }
        }
        return closestSum;
    }

    static int threeSumClosestSolutionTwo(int[] arr, int target) {

        // Sort the elements
        Arrays.sort(arr);
        int resultSum = arr[0] + arr[1] + arr[2];
        int minDifference = Integer.MAX_VALUE;

        // Now fix the first element and find the other two elements
        for (int i = 0; i < arr.length - 2; i++) {
            // Find other two elements using Two Sum approach
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == target)
                    return target;
                if (sum < target)
                    left++;
                else
                    right--;

                int diffToTarget = Math.abs(sum - target);
                if (diffToTarget < minDifference) {
                    // update the result sum
                    resultSum = sum;
                    minDifference = diffToTarget;
                }
            }
        }
        return resultSum;
    }
}
