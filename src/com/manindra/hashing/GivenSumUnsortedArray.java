package com.manindra.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GivenSumUnsortedArray {

    public static void main(String[] args) {
        int [] arr={3,2,8,15,-8}; int sum=10;
        System.out.println(givenSumUnsortedArray(arr,sum));
        System.out.println(givenSumUnsortedArraySolTwo(arr,sum));


        HashMap<Integer, Integer> result=givenSum(arr,sum);
        result.forEach((key,val)-> System.out.println(key+" "+val));

    }

    //solution  one
    static boolean givenSumUnsortedArray(int [] arr,int sum){ //tc O(n2) As 0(1)
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j< arr.length;j++)
                if(arr[i]+arr[j]==sum)
                    return true;
        }
        return false;
    }

    //second solution two pointer approach sorted array
    //third solution
    static boolean givenSumUnsortedArraySolTwo(int [] arr, int sum){ //TC 0(N) AS 0(n)
        HashSet<Integer> hashSet=new HashSet<>();
        for (int i=0;i< arr.length;i++){
            if (hashSet.contains(sum-arr[i]))
                return true;
            hashSet.add(arr[i]);
        }
        return false;
    }

    //returning the key and the index value
    static HashMap<Integer, Integer> givenSum(int[] arr, int sum) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = sum - arr[i];
            if (hashMap.containsKey(complement)) {
                int firstIndex = hashMap.get(complement);
                int secondIndex = i;
                return new HashMap<>(Map.of(complement, firstIndex, arr[i], secondIndex));
            }
            hashMap.put(arr[i], i);
        }
        return null; // Return null if no pair with the given sum is found
    }

}
