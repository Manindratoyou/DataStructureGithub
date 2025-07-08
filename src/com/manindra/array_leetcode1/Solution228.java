package com.manindra.array_leetcode1;

import java.util.ArrayList;
import java.util.List;

public class Solution228 { //Summary Ranges

    public static void main(String[] args) {

        int [] nums={0,1,2,4,5,7};
        List<String> result=summaryRange(nums);
        List<String> result2=summaryRangeSolutionTwo(nums);
        System.out.println(result);
        System.out.println();
        System.out.println(result2);
    }

    //solution one iterative approach
    public static List<String> summaryRange(int [] nums){
        List<String> result=new ArrayList<>();

        for (int i=0;i< nums.length;i++){
            int start=nums[i];
            while (i+1 < nums.length && nums[i+1]==nums[i]+1){
                i++;
            }
            if (start !=nums[i])
                result.add(start+ "->" +nums[i]);
            else
                result.add(String.valueOf(start));
        }
        return result;
    }

    //String Builder Approach
    public static List<String> summaryRangeSolutionTwo(int [] nums){
        List<String> result=new ArrayList<>();

        for (int i=0;i< nums.length;i++) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1)
                i++;
            StringBuilder range = new StringBuilder().append(start);
            if (start !=nums[i])
                range.append("->").append(nums[i]);
            result.add(range.toString());
        }
        return result;
    }
}
