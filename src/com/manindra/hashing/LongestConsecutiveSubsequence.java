package com.manindra.hashing;

import java.util.Arrays;

public class LongestConsecutiveSubsequence {

    public static void main(String[] args) {
        int [] arr={1,9,3,4,2,10,20}; //op is 4 [1,2,3,4] not 2 [9,10]
    }

    static int longestConsecutiveSubsequence(int [] arr){ //tc 0(nlogn)
        Arrays.sort(arr);
        int result=1,current=1;
        for (int i=1;i< arr.length;i++){
            if (arr[i]==arr[i-1]+1)
                current++;
            else if (arr[i] != arr[i-1]) {
                result=Math.max(current,result);
                current=1;
            }
        }
        return Math.max(result,current);
    }
}
