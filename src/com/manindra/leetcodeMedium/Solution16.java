package com.manindra.leetcodeMedium;

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
}
