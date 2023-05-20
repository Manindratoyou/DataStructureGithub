package com.manindra.string;

import java.util.Arrays;

public class LeftMostFirstNonRepChar {

    public static void main(String[] args) {
        System.out.println(leftMostNPSolOne("geeksforgeeks"));
        System.out.println(leftMostNPSolTwo("geeksforgeeks"));
        System.out.println(leftMostNPSolThree("geeksforgeeks"));
    }
    static int leftMostNPSolOne(String str){//naive solution o(n2) time complexity
        for (int i=0;i<str.length();i++){
            boolean flag=false;
            for (int j=0;j<str.length();j++){
                if (i!=j && str.charAt(i)==str.charAt(j)) {
                    flag = true;
                    break;
                }
            }
            if (flag==false)
                return i;
        }
        return -1;
    }

    static int leftMostNPSolTwo(String str) {
        int [] count=new int[256];

        for (int i=0;i<str.length();i++){
            count[str.charAt(i)]++;
        }
        for (int i=0;i<str.length();i++){
            if (count[str.charAt(i)]==1)
                return i;
        }
        return -1;
    }
    static int leftMostNPSolThree(String str) {
        int [] FI=new int[26];
        Arrays.fill(FI,-1);
        for (int i=0;i<str.length();i++){
            if (FI[str.charAt(i)-'a']==-1)
                FI[str.charAt(i)-'a']=i;
            else
                FI[str.charAt(i)-'a']=-2;
        }
        int res=Integer.MAX_VALUE;
        for (int i=0;i<26;i++){
            if (FI[i]>=0)
                res=Math.min(res,FI[i]);
        }
        return res==Integer.MAX_VALUE ? -1 :res;
    }
}
