package com.manindra.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSpanSum {

    public static void main(String[] args) {

        int [] arr1={0,1,0,0,0,0};//1,0,0,0
        int [] arr2={1,0,1,0,0,1}; //0,1,0,0  op is 4
        //System.out.println(maxCommonSum(arr1,arr2));
        System.out.println(maxCommonSumSolTwo(arr1,arr2));

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
    static int maxCommonSumSolTwo(int [] arr1,int [] arr2){ //tc 0(n) as 0(n)

        //find difference between the two
        int [] temp=new int[arr1.length];
        for (int i=0;i< arr1.length;i++)
            temp[i]=arr1[i]-arr2[i];
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0,max_len=0;
        for (int i=0;i< arr1.length;i++){
            sum+=temp[i];
            if (sum==0)
                max_len=i+1;
            //if the sum is seen before than update max_len if required
            if (map.containsKey(sum))
                max_len=Math.max(max_len,i-map.get(sum));
            else
                map.put(sum,i);
        }
        return max_len;
    }
}
