package com.manindra.array_leetcode1;

import java.util.ArrayList;
import java.util.List;

//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
public class Solution46 { //permutation

    public static void main(String[] args) {

        int [] nums={1,2,3};
        System.out.println(permute(nums));

    }

    static List<List<Integer>> permute(int [] nums){
        List<List<Integer>> resultList=new ArrayList<>();

        backTrack(resultList,new ArrayList<>(),nums);

        return resultList;
    }

    static void backTrack(List<List<Integer>> resultList,ArrayList<Integer> tempList,int [] nums){

        //if we match the length ,it is a permutation
        if (tempList.size()== nums.length){
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for(int number : nums){
            //skip if we get same element
            if (tempList.contains(number))
                continue;

            //add the new element
            tempList.add(number);

            //go back to try other element
            backTrack(resultList,tempList,nums);

            //remove the element
            tempList.remove(tempList.size()-1);
        }
    }
}
