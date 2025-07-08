package com.manindra.array_leetcode1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Find the Duplicate Number
//Input: nums = [1,3,4,2,2]
//Output: 2
public class Solution287 {

    public static void main(String[] args) {

        int [] nums={1,3,4,2,2};
        System.out.println(findDuplicateEfficientSolution(nums));

    }

    static int findDuplicateEfficientSolution(int [] nums){

        //start a fast and slow pointer until they meet
        int slow=0,fast=0;
        do {
            slow=nums[slow];
            fast=nums[nums[fast]];

        }while (slow!=fast);

        //as soon as they meet ,move both pointers at same speed until they meet again
        slow=0;
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }

    static int findDuplicateSolTwo(int [] nums){

        Arrays.sort(nums);

        int prev=-1;
        for (int num: nums){
            if (num==prev)
                break;
            prev=num;
        }
        return prev;
    }

    static int findDuplicateSolThree(int [] nums){

        Set<Integer> numset=new HashSet<>();
        for (int num: nums){
            if (numset.contains(num))
                return num;
            numset.add(num);
        }
        return -1;
    }

}
