package com.manindra.string;

import java.util.Arrays;

/*
eg -abcdabc : here longest substring is cdab and count is 4.
 */
public class LongestSubStringDistinctCharacter {

    public static void main(String[] args) {
        String input="abcdabc";
        System.out.println(longestDistinctCharactorSolOne(input));
        System.out.println(longestDistinctCharactorSolTwo(input));
        System.out.println(longestDistinctCharactorSolThree(input));
    }

    static int longestDistinctCharactorSolOne(String str){ //tc 0(n3)
       int n=str.length();
       int result=0;
       for (int i=0;i<n;i++)
           for (int j=i;j<n;j++){
               if (areDistinct(str,i,j))
                   result=Math.max(result,j-i+1);
           }
       return result;
    }
    static boolean areDistinct(String str,int i,int j){
        boolean visited[] =new boolean[256];
        for (int k=i;k<=j;k++){
            if (visited[str.charAt(k)]==true)
                return false;
            visited[str.charAt(k)]=true;
        }
        return true;
    }

    static int longestDistinctCharactorSolTwo(String str){ //tc 0(n2)
        int n=str.length();
        int result=0;
        for (int i=0;i<n;i++){
            boolean [] visited=new boolean[256];
            for (int j=i;j<n;j++){
                if (visited[str.charAt(j)]==true)
                    break;
                else {
                    result=Math.max(result,j-i+1);
                    visited[str.charAt(j)]=true;
                }
            }
        }
        return result;
    }
    static int longestDistinctCharactorSolThree(String str){ //tc 0(n)
        int n=str.length();
        int result=0;
        int [] prev=new int[26];
        Arrays.fill(prev,-1);
        int i=0;
        for (int j=0;j<n;j++){
            i=Math.max(i,prev[str.charAt(j)-'a']+1);
            int maxEnd=j-i+1;
            result=Math.max(result,maxEnd);
            prev[str.charAt(j)-'a']=j;
        }
        return result;
    }
}
