package com.manindra.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithZerosAndOnes {

    public static void main(String[] args) {
        int [] arr={1,0,1,1,1,0,0}; //op is 6 =>0,1,1,1,0,0
        int [] arr1={1,1,1,1}; //op 0
        //System.out.println(longestSubArrayWithZerosAndOnes(arr));
        System.out.println(longestSubArrayWithZerosAndOnesSolTwo(arr));
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
    static int longestSubArrayWithZerosAndOnesSolTwo(int [] arr){
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0,max_len=0;
        for (int i=0;i<arr.length;i++){
            arr[i]=(arr[i]==0 ) ? -1 : 1 ;
        }
        for (int i=0;i<arr.length;i++){
            sum+=arr[i];
            if (sum==0)
                max_len=i+1;
            if (map.containsKey(sum+arr.length)==true){
                if (max_len<i-map.get(sum+arr.length))
                    max_len=i-map.get(sum+arr.length);
            }else {
                map.put(sum+arr.length ,i);
            }

        }
        return max_len;
    }
}
