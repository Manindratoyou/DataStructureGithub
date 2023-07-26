package com.manindra.hashing;

public class LongestSubArrayWithGivenSum {

    public static void main(String[] args) {

        int[] arr = {5, 8, -4, -4, 9, -2, 2};
        int sum = 0;//here 8,-4,-4 sum is 0 and -2 ,2 sum is 0
        //need to return longest sub array length i.e 3
        int[] arr1 = {8, 3, 7};
        int sum1 = 15;//output is 0 even 8+7 is 15 but 8 and 7 and not contiguous
        System.out.println(longestSubArrayWithGivenSumSolOne(arr,sum));
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
}
