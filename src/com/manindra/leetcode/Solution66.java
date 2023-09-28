package com.manindra.leetcode;

import java.util.Arrays;

public class Solution66 {

    public static void main(String[] args) {

        int [] input1={1,2,3};
        int [] input2={4,3,2,1};
        int [] input3={9,9,9};

        int [] result1=plusOne(input1);
        int [] result2=plusOne(input2);
        int [] result3=plusOne(input3);

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println(arrayToString(result3));
    }

    public static int [] plusOne(int [] digits){
        int n=digits.length;
        //traverse the digit from right to left
        for (int i=n-1;i>=0;i--){
            //increment the current digit
            digits[i]++;
            //if the digits become 10 ,set it to 0 and carry over the 1 to next digit
            if (digits[i]==10)
                digits[i]=0;
            else
                //if the digit does not become 10 ,there is no need to carry over ,so we can return the result
                return digits;
        }
        //if we reach here ,it means all digit become 0 ,so we need to add a new leading 1.
        int [] result=new int[n+1];
        result[0]=1;

        return result;
    }

    public static int [] plusOneSolTwo(int [] digits){

        int n=digits.length;
        //traverse the digit from right to left
        for (int i=n-1;i>=0;i--){
            //increment the current digit and check if it becomes 10
            digits[i]++;
            if (digits[i]<10){
                //if it less than 10 ,we don't need to carry over , so we can return the result
                return digits;

            }
            //if it becomes 10 ,set it to 0 and continue to next digit
            digits[i]=0;
        }

        //if we reach here ,it means all digits become 0 ,so we need to add a new leading 1
        int [] result=new int[n+1];
        result[0]=1;

        return result;

    }

    public static String arrayToString(int [] arr){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for (int i=0;i<arr.length;i++){
            sb.append(arr[i]);
            if (i<arr.length-1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
