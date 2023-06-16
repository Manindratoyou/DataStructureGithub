package com.manindra.sorting;

import java.util.Arrays;

public class MiniumDifferenceArray {

    public static void main(String[] args) {
        int [] arr={1,8,12,5,18};
        //System.out.println(miniumDifferenceArray(arr));
        System.out.println(miniumDifferenceArraySolTwo(arr));

    }

    static int miniumDifferenceArray(int [] arr){ //tc 0(n2)
        int result=Integer.MAX_VALUE;
        for (int i=1;i<arr.length;i++){
            for (int j=0;j<i;j++){
                result=Math.min(result,Math.abs(arr[i]-arr[j]));
            }
        }
        return result;
    }

    static int miniumDifferenceArraySolTwo(int [] arr){ //tc 0(nlogn)
        Arrays.sort(arr);
        int result=Integer.MAX_VALUE;
        for (int i=1;i<arr.length;i++){
            result=Math.min(result,Math.abs(arr[i]-arr[i-1]));
        }
        return result;
    }
}
