package com.manindra.array;

public class EquilibriumPoint {

    public static void main(String[] args) {
        int [] arr={3,4,8,-9,9,7};
        System.out.println(ePointSolOne(arr, arr.length));
        System.out.println(ePointSolTwo(arr, arr.length));
    }

    static boolean ePointSolOne(int [] arr,int n){
        for (int i=0;i<n;i++){
            int leftSum=0,result=0;
            for (int j=0;j<i;j++)
                leftSum+=arr[j];
            for (int k=i+1;k<n;k++)
                result+=arr[k];
            if (leftSum==result)
                return true;
        }
        return false;
    }
    static boolean ePointSolTwo(int [] arr,int n){
       int result=0;
       for (int i=0;i<n;i++)
           result += arr[i];
       int leftSum = 0;
       for (int i = 0; i < n; i++){
           result -= arr[i];
           if (leftSum == result)
               return true;
           leftSum += arr[i];
       }
           return false;
    }
    /*
    static int[] getPrefixSum(int [] arr){
        int n=arr.length;
        int [] prefixSum=new int[n];
        prefixSum[0]=arr[0];
        for (int i=1;i<n;i++)
            prefixSum[i]=prefixSum[i-1]+arr[i];
        return prefixSum;
    }
    static int[] getSuffixSum(int [] arr){
        int n=arr.length;
        int [] suffixSum=new int[n];
        suffixSum[n-1]=arr[n-1];
        for (int i=n-2;i>=0;i--)
            suffixSum[i]=suffixSum[i+1]+arr[i];
        return suffixSum;
    }
     */
}
