package com.manindra.leetcode;
/*
Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation:
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1).
For nums[3]=2 there exist one smaller number than it (1).
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 */

import java.util.Arrays;

//How Many Numbers Are Smaller Than the Current Number
public class Solution1365 {

    public static void main(String[] args) {

        int [] nums={8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
        //System.out.println(Arrays.toString(smallerNumbersThanCurrentSolTwo(nums)));

    }

    static int [] smallerNumbersThanCurrent(int [] nums){

        //create bucket for counting sort
        int [] buckets=new int[10];

        //get frequency of each element
        for (int num: nums){
            buckets[num]++;
        }

        //count smaller numbers than each element
        for (int i=1;i< buckets.length;i++){
            buckets[i]+=buckets[i-1];
        }

        //populate the result
        int [] result=new int[nums.length];
        for (int i=0;i< result.length;i++){
            if (nums[i]==0)
                result[i]=0;
            else
                result[i]=buckets[nums[i]-1];
        }
        return result;
    }

    static int[]  smallerNumbersThanCurrentSolTwo(int [] nums){

        int [] result=new int[nums.length];
        for (int i=0;i< nums.length;i++){
            int count=0;
            for (int j=0;j< nums.length;j++){
                if (nums[i]>nums[j])
                    count++;
            }
            result[i]=count;
            System.out.println(count);
        }
        return result;
    }



}
