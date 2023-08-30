package com.manindra.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionOne {

    public static void main(String[] args) {
        int [] arr={2,11,5,10,7,8};
        int targetSum=9;
        int [] result=solutionOne(arr,targetSum);
        System.out.println(Arrays.toString(result));
    }

    public static int [] solutionOne(int [] numbers,int targetSum){
        int [] result=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i< numbers.length;i++){
            if (!map.containsKey(targetSum-numbers[i]))
                map.put(numbers[i], i);
            else {
                result[1]=i;
                result[0]=map.get(targetSum-numbers[i]);
                return result;
            }
        }
        throw new IllegalArgumentException("Numbers Not found");
    }
}
