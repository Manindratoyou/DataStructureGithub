package com.manindra.hashing;

public class LongestSubArrayWithZerosAndOnes {

    public static void main(String[] args) {
        int [] arr={1,0,1,1,1,0,0}; //op is 6 =>0,1,1,1,0,0
        int [] arr1={1,1,1,1}; //op 0
        System.out.println(longestSubArrayWithZerosAndOnes(arr));
    }
    static int longestSubArrayWithZerosAndOnes(int [] arr){ //tc 0(n2) as 0(1)
        int result=0;
        for (int i=0;i<arr.length;i++){
            int c0=0,c1=0;
            for (int j=i;j<arr.length;j++){
                if (arr[j]==0)
                    c0++;
                else
                    c1++;
                if (c0==c1)
                    result=Math.max(result,c0+c1);
            }
        }
        return result;
    }
}
