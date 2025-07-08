package com.manindra.array_leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateTargetArrayGivenOrder { //1389. Create Target Array in the Given Order

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {0, 1, 2, 3, 4};
        int[] index1 = {0, 1, 2, 2, 1};
        System.out.println("Test Case 1: " + Arrays.toString(createTargetArray(nums1, index1)));

        int[] nums2 = {1, 2, 3, 4, 0};
        int[] index2 = {0, 1, 2, 3, 0};
        System.out.println("Test Case 2: " + Arrays.toString(createTargetArray(nums2, index2)));

        int[] nums3 = {1};
        int[] index3 = {0};
        System.out.println("Test Case 3: " + Arrays.toString(createTargetArray(nums3, index3)));
    }

    static int [] createTargetArray(int [] nums,int [] index){
        List<Integer> target=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            target.add(index[i],nums[i]);
        }

        int [] result=new int[nums.length];
        for (int i=0;i< nums.length;i++){
            result[i]=target.get(i);
        }
        return result;
    }
}
