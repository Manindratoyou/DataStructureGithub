package com.manindra.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {

    public static void main(String[] args) {
        int [] arr={1,9,3,4,2,10,20}; //op is 4 [1,2,3,4] not 2 [9,10]
        System.out.println(longestConsecutiveSubsequence(arr));
        System.out.println(longestConsecutiveSubsequenceSolTwo(arr));
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
    static int longestConsecutiveSubsequenceSolTwo(int [] arr){ //tc 0(n) as 0(n)
        Set<Integer> set=new HashSet<>();
        for (int x:arr)
            set.add(x);
        int result=1;
        for (int y :set){
            if (set.contains(y-1)==false){
                int current=1;
                while (set.contains(y+current))
                    current++;
                result=Math.max(result,current);
            }
        }
        return result;
    }
}
