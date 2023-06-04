package com.manindra.array;

public class PrefixSum {

    public static void main(String[] args) {
        int [] arr={2,8,3,9,6,5,4};
       /* System.out.println(getSumSolOne(arr,0,2));
        System.out.println(getSumSolOne(arr,1,3));
        System.out.println(getSumSolOne(arr,2,6));*/
        System.out.println(getSumSolTwo(arr,2,6));
    }

    //sum from given index to given index
    static int getSumSolOne(int [] arr,int l,int r){
        int result=0;
        for (int i=l;i<=r;i++){
            result+=arr[i];
        }
        return result;
    }

    //sum from given index to given index
    static int  getSumSolTwo(int[] arr,int l,int r){
        int [] prefixSum=getSum(arr,l,r);
        if (l==0)
            return prefixSum[0];
        return prefixSum[r]-prefixSum[l-1];
    }
    static int[] getSum(int [] arr,int l,int r){ //tc 0(n)
        int n=arr.length;
        int [] prefixSum=new int[n];
        prefixSum[0]=arr[0];
        for (int i=1;i<n;i++)
            prefixSum[i]=prefixSum[i-1]+arr[i];
        return prefixSum;
    }
}
