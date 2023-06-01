package com.manindra.array;

public class MaximumSumCircularSubArray {

    public static void main(String[] args) {
        int [] arr={5,-2,3,4};
        //System.out.println(maxCircularSumArraySolOne(arr,arr.length));
        System.out.println(maxCircularSumArraySolTwo(arr,arr.length));
    }
    static int maxCircularSumArraySolOne(int [] arr,int n){
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
    static int maxCircularSumArraySolTwo(int [] arr,int n){
        int max_normal=normalMaxSum(arr,n);
        if (max_normal<0)
            return max_normal;
        int arr_sum=0;
        for (int i=0;i<n;i++){
            arr_sum+=arr[i];
            arr[i]=-arr[i];
        }
        int max_circular=arr_sum+normalMaxSum(arr, n);
        return Math.max(max_normal,max_circular);
    }

    static int normalMaxSum(int [] arr,int n){
        int result=arr[0];
        for (int i=0;i<n;i++){
            int current=0;
            for (int j=i;j<n;j++){
                current=current+arr[j];
                result=Math.max(result,current);
            }
        }
        return result;
    }
}
