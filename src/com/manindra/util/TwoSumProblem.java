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
    /*
    static int [] twoSumSorting(int [] arr,int target){
        int [] copyArray= Arrays.copyOf(arr,arr.length);
        Arrays.sort(copyArray);

        int head=0;
        int tail= copyArray.length-1;

        int num1 = 0,num2=0;
        while (head<tail){
            int sum=copyArray[head]+copyArray[tail];
            if (sum<target)
                head++;
            else if (sum>target) {
                tail--;
            }
            else {
                num1=copyArray[head];
                num2=copyArray[tail];
                break;
            }
        }
        //create the result array with indices
        int [] result=new int[2];
        for (int i=0;i<arr.length;i++){
            if (arr[i]==num1)
                result[0]=i;
            if (arr[i]==num2)
                result[1]=i;
        }
        return result;
    }
    static int [] twoSumHashing(int [] arr,int target){

        Map<Integer,Integer> map=new HashMap<>();

        for (int i=0;i<arr.length;i++){

            //get the complement using the target value
            int complement=target-arr[i];

            //search the hashmap for complement ,if found we got our pair
            if(map.containsKey(complement))
                return new int[]{map.get(complement),i};

            //put the element for subsequent search
            map.put(arr[i],i);

        }
        throw new IllegalArgumentException("NO Two Sum Solution");
    }
     */
}
