package com.manindra.array;

public class MaximumSumCircularSubArray {

    public static void main(String[] args) {
        int [] arr={5,-2,3,4};
        System.out.println(maxCircularSumArray(arr,arr.length));
    }
    static int maxCircularSumArray(int [] arr,int n){
        int result=arr[0];
        for (int i=0;i<n;i++){
            int current_max=arr[i];
            int current_sum=arr[i];
            for (int j=1;j<n;j++){
                int index=(i+j)%n;
                current_sum+=arr[index];
                current_max=Math.max(current_max,current_sum);
            }
            result=Math.max(result,current_max);
        }
        return result;
    }
}
