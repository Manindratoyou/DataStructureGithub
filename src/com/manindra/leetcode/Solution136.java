package com.manindra.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution136 {

    public static void main(String[] args) {

        int [] arr={2,2,1};
        System.out.println(singleNumber(arr));
        System.out.println(singleNumberSolutionTwo(arr));
    }

    static int singleNumber(int [] arr){

        int result=0;
        for (int num : arr)
            result^=num;
        return result;
    }
    static int singleNumberSolutionTwo(int [] arr){
        Set<Integer> set=new HashSet<>();
        for (int num : arr){
            if (set.contains(num))
                set.remove(num);
            else
                set.add(num);
        }
        return set.iterator().next();
    }
    public int singleNumberSolutionThree(int[] nums) {
        int sing = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sing = sing ^ nums[i];
        }
        return sing;

    }

}
