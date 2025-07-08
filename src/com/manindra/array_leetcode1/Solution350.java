package com.manindra.array_leetcode1;

import java.util.*;

public class Solution350 { //Intersection of two arrays II

    public static void main(String[] args) {
        int [] nums1={1,2,2,1};
        int [] nums2={2,2};
        int [] intersectionResult=intersect(nums1,nums2);
        System.out.println("Intersection of two sorted arrays II "+ Arrays.toString(intersectionResult));
    }

    public static int [] intersect(int [] nums1,int [] nums2){
        //use HashMap to count occurrence of each element in nums1
        Map<Integer,Integer> countMap=new HashMap<>();
        for (int num : nums1)
            countMap.put(num, countMap.getOrDefault(num,0)+1);

        //use a list to store the intersection elements
        List<Integer> intersectionList=new ArrayList<>();
        for (int num : nums2){
            if (countMap.containsKey(num) && countMap.get(num)>0){
                intersectionList.add(num);
                countMap.put(num, countMap.get(num)-1);
            }
        }

        //convert the list to an array
        int [] result=new int[intersectionList.size()];
        for (int i=0;i<intersectionList.size();i++)
            result[i]=intersectionList.get(i);

        return result;
    }
}
