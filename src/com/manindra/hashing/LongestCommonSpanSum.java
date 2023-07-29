package com.manindra.hashing;

public class LongestCommonSpanSum {

    public static void main(String[] args) {

        int [] arr1={0,1,0,0,0,0};//1,0,0,0
        int [] arr2={1,0,1,0,0,1}; //0,1,0,0  op is 4
        System.out.println(maxCommonSum(arr1,arr2));

    }

    static int maxCommonSum(int [] arr1,int [] arr2){ //tc 0(n2) as 0(1)
        int result=0;
        for (int i=0;i< arr1.length;i++){
            int sum1=0,sum2=0;
            for (int j=i;j< arr2.length;j++){
                sum1+=arr1[j];
                sum2+=arr2[j];
                if (sum1==sum2)
                    result=Math.max(result,j-i+1);
            }
        }
        return result;
    }
}
