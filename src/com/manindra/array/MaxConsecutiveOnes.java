package com.manindra.array;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {

        int arr[] = {0, 1, 1, 1, 0, 1, 1};
        System.out.println(maxConsecutiveOnesSolOne(arr));
    }

    static int maxConsecutiveOnesSolOne(int [] arr){
        int result=0;
        int n= arr.length;
        for (int i=0;i<n;i++){
            int current=0;
            for (int j=i;j<n;j++){
                if(arr[j] == 1)
                    current++;
                else
                    break;
            }
            result=Math.max(current,result);
        }
        return result;
    }
}
