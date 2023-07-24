package com.manindra.hashing;

public class SubArrayWithZeroSum {

    public static void main(String[] args) {
        int [] arr={1,4,13,-3,-10,5};//13,-3,-10 sum is zero
        System.out.println(isZeroSumSolOne(arr));
    }

    static boolean isZeroSumSolOne(int [] arr){ //O(n2)
        for (int i=0;i< arr.length;i++){
            int current_sum=0;
            for (int j=i;j< arr.length;j++){
                current_sum+=arr[j];
                if (current_sum==0)
                    return true;
            }
        }
        return false;
    }
}
