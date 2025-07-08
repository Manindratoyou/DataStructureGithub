package com.manindra.array_leetcode1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution217 { //contains duplicates

    public static void main(String[] args) {

        int [] nums={1,2,3,1};
        System.out.println(containsDuplicates(nums));
        System.out.println(containsDuplicatesSolutionTwo(nums));
    }

    static boolean containsDuplicates(int [] nums){
        Set<Integer> set=new HashSet<>();

        for (int num : nums){
            if (!set.add(num))// if the set.add() return false ,it means the element already exists in the set.
                return true; //duplicates found
        }
        return false;
    }
    static boolean containsDuplicatesSolutionTwo(int [] nums){

        Arrays.sort(nums);

        for (int i=0;i<nums.length;i++){
            if (nums[i]==nums[i+1])
                return true;
        }
        return false;
    }
}
