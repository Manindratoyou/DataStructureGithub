package com.manindra.hashing;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        int [] arr ={5,8,6,13,3,-1}; //6,13,3 contiguous element
        int sum=22;
        System.out.println(isSubArraySumSolOne(arr,sum));
        System.out.println(isSubArraySumSolTwo(arr,sum));
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
    static boolean isSubArraySumSolTwo(int [] arr,int sum){
        Set<Integer> set=new HashSet<>();
        int pre_sum=0;
        for (int i=0;i< arr.length;i++){
            pre_sum+=arr[i];
            if (pre_sum==sum) return true;//special case like arr=2,3,4,6 sum 9 (2+3+4=9)
            if (set.contains(pre_sum-sum))
                return true;
            set.add(pre_sum);
        }
        return false;
    }
}
