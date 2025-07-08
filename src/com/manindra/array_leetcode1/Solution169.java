package com.manindra.array_leetcode1;

import java.util.HashMap;
import java.util.Map;

public class Solution169 { //Majority Element

    public static void main(String[] args) {

        int [] arr={2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
        System.out.println(majorityElementSolTwo(arr));
    }

    static int majorityElement(int [] arr){ //TC : 0(n) AS:0(1)
        int majority=arr[0];
        int count=1;
        for (int i=1;i<arr.length;i++){
            if (count==0){
                majority=arr[i];
                count=1;
            } else if (arr[i]==majority) {
                count++;
            }else {
                count--;
            }
        }
        return majority;
    }

    static int majorityElementSolTwo(int [] arrays) { //TC : 0(n) AS:0(n)
        Map<Integer, Integer> elementCount = new HashMap<>();

        for (int arr : arrays) {
            elementCount.put(arr, elementCount.getOrDefault(arr, 0) + 1);
        }
        int majority = 0;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : elementCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                majority = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return majority;
    }


}
