package com.manindra.util;

import java.util.Arrays;

public class ThreeSumArrayProblem {

    public static void main(String[] args) {
        int [] arr={2,4,3,7,1,0};
        threeSum(arr,6);
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
}
