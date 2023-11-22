package com.manindra.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        int [] arr={8,3,4,8,8};
        System.out.println(findMajority(arr, arr.length));//majority element more than n/2 times
        System.out.println(findMajoritySolTwo(arr, arr.length));
        System.out.println("=================");
        int[] nums = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int majorityElement = findMajorityElementSolFour(nums);
        if (majorityElement != -1) {
            System.out.println("Majority Element: " + majorityElement);
        } else {
            System.out.println("No Majority Element");
        }
    }
    static int findMajority(int [] arr,int n){
        for (int i=0;i<n;i++){
            int count=1;
            for (int j=i+1;j<n;j++){
                if (arr[i]==arr[j])
                    count++;
            }
            if (count>n/2);
            return i;
        }
        return -1;
    }
    static int findMajoritySolTwo(int [] arr,int n){
        int res = 0, count = 1;

        for(int i = 1; i < n; i++)
        {
            if(arr[res] == arr[i])
                count++;
            else
                count --;

            if(count == 0)
            {
                res = i; count = 1;
            }
        }

        count = 0;
        for(int i = 0; i < n; i++)
            if(arr[res] == arr[i])
                count++;

        if(count <= n /2)
            res = -1;

        return res;
    }

    static int findMajorityElementSolThree(int[] nums) {
        Arrays.sort(nums);
        int candidate = nums[nums.length / 2];
        int count = 0;

        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        return (count > nums.length / 2) ? candidate : -1;
    }

    static int findMajorityElementSolFour(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
