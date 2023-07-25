package com.manindra.hashing;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        int [] arr ={5,8,6,13,3,-1}; //6,13,3 contiguous element
        int sum=22;
        System.out.println(isSubArraySumSolOne(arr,sum));
    }

    static boolean isSubArraySumSolOne(int [] arr,int sum){
        for (int i=0;i< arr.length;i++){
            int curr_sum=0;
            for (int j=i;j< arr.length;j++){
                curr_sum+=arr[j];
                if (curr_sum==sum)
                    return true;
            }
        }
        return false;
    }
}
