package com.manindra.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithGivenSum {

    public static void main(String[] args) {

        int[] arr = {5, 8, -4, -4, 9, -2, 2};
        int sum = 0;//here 8,-4,-4 sum is 0 and -2 ,2 sum is 0
        //need to return longest sub array length i.e 3
        int[] arr1 = {8, 3, 7};
        int sum1 = 15;//output is 0 even 8+7 is 15 but 8 and 7 and not contiguous
        System.out.println(longestSubArrayWithGivenSumSolOne(arr,sum));
        System.out.println(longestSubArrayWithGivenSumMaxLength(arr,sum));
    }

    static int longestSubArrayWithGivenSumSolOne(int [] arr, int sum){ //tc 0(n2) as 0(1)
        int result=0;
        for (int i=0;i<arr.length;i++){
            int current_sum=0;
            for (int j=i;j<arr.length;j++){
                current_sum+=arr[j];
                if (current_sum==sum)
                    result=Math.max(result,j-i+1);
            }
        }
        return result;
    }
    static int longestSubArrayWithGivenSumMaxLength(int [] arr, int sum){
        Map<Integer,Integer> map=new HashMap<>();
        int pre_sum=0,maxLength=0;
        for (int i=0;i<arr.length;i++){
            pre_sum+=arr[i];
            //when sub array starts from index 0
            if (pre_sum==sum)
                maxLength=i+1;
            //make an entry for pre_sum if it is not present in map
            if (!map.containsKey(pre_sum))
                map.put(pre_sum,i);
            //check if pre_sum-sum is present in map or not
            if (map.containsKey(pre_sum-sum)){
                //update max length
                if (maxLength<(i-map.get(pre_sum-sum)))
                    maxLength=i-map.get(pre_sum-sum);
            }
        }
        return maxLength;
    }
}
