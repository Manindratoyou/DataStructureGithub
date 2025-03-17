package com.manindra.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement { //solution 169

    public static void main(String[] args) {
        int [] arr={8,3,4,8,8};
        System.out.println(findMajority(arr, arr.length));//majority element more than n/2 times
        System.out.println("=================");
        int[] nums1 = {2,2,1,3,1,2,2};
        System.out.println(findMajoritySolTwo(nums1));
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
    static int findMajoritySolTwo(int[] num) {

        int majority = num[0], votes = 1;

        for (int i = 1; i < num.length; i++) {

            if (votes == 0) {
                votes++;
                majority = num[i];
            } else if (majority == num[i]) {
                votes++;
            } else
                votes--;

        }
        return majority;
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
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
