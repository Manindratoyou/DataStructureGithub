package com.manindra.array;

public class MaxDifference {

    public static void main(String[] args) {
        int [] arr={2,3,10,6,4,8,1};
        //System.out.println(maxDiffSolOne(arr, arr.length));
        System.out.println(maxDiffSolTwo(arr, arr.length));
    }

    static int maxDiffSolOne(int [] arr,int n){
        int result=arr[1]-arr[0];
        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++)
                result=Math.max(result,arr[j]-arr[i]);
        }
        return result;
    }
    static int maxDiffSolTwo(int [] arr,int n){

        int result=arr[1]-arr[0],minValue=arr[0];
        for (int j=1;j<n;j++){
            result=Math.max(result,arr[j]-minValue);
            minValue=Math.min(minValue,arr[j]);
        }
        return result;
    }

}
