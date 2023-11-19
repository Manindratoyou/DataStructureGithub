package com.manindra.util;

import java.util.*;

public class TwoSumProblem {

    public static void main(String[] args) {
        int [] arr={2,11,5,10,7,8};
        //int result [] =twoSum(arr,9);
        int result[] =twoSumSecondWay(arr,9);
        printArray(result);

    }
    public static int[] twoSum(int arr[],int target){
        Arrays.sort(arr);
        int left=0;
        int right=arr.length-1;
        int [] result =new int[2];
        while (left<right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                result[0] = arr[left];
                result[1] = arr[right];
                return result;
            } else if (sum < target) {
                left++;
            } else
                right--;
        }
            return new int[0];
    }
    //two sum problem solution second way
    public static int[] twoSumSecondWay(int[] numbers,int target){
        int[] result=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i< numbers.length;i++){
            if (!map.containsKey(target-numbers[i])){
                map.put(numbers[i],i );
            }else {
                result[1]=i;
                result[0]= map.get(target-numbers[i]);
                return result;
            }
        }
        throw new IllegalArgumentException("two numbers not found");
    }

    static int[] targetSumSolutionThree(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        int[] temp = new int[2];

        for (int num : arr) {
            int complement = target - num;

            if (seen.contains(complement)) {
                temp[0] = complement;
                temp[1] = num;
                break; // Break after finding the first pair
            }

            seen.add(num);
        }

        return temp;
    }

    static void printArray(int[] arr){
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
