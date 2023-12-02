package com.manindra.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSumArrayProblem {

    public static void main(String[] args) {
        int [] arr={2,4,3,7,1,0};
        //threeSum(arr,6);
        System.out.println("---------");
        System.out.println(Arrays.toString(threeSumSolutionTwo(arr,14)));
    }

    public static void threeSum(int [] arr,int target){

        Arrays.sort(arr);
        for (int i=0;i<arr.length-2;i++){
            int j=i+1;
            int k=arr.length-1;
            while (j<k){
                int sum=arr[i]+arr[j]+arr[k];
                if (sum==target){
                    System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
                    j++;
                    k--;
                } else if (sum<target) {
                    j++;
                }else
                    k--;
            }
        }
    }

    //Time Complexity: O(n^2)
    //Auxiliary Space Complexity: O(n)
    static int[] threeSumSolutionTwo(int[] arr, int target) {
        int[] temp = new int[3];

        for (int i = 0; i < arr.length - 2; i++) {
            int[] twoSumResult = twoSumSolTwo(arr, target - arr[i]);

            // Check if twoSumSolTwo found a valid solution
            if (twoSumResult[0] != 0 || twoSumResult[1] != 0) {
                temp[0] = arr[i];
                temp[1] = twoSumResult[0];
                temp[2] = twoSumResult[1];
                return temp;
            }
        }
        return temp;
    }
    static int[] twoSumSolTwo(int[] arr, int target) {
        int[] temp = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                temp[0] = arr[i];
                temp[1] = target - arr[i];
                return temp;
            }
            map.put(arr[i], i);
        }
        return temp;
    }
}
