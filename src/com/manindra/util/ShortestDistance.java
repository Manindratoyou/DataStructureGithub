package com.manindra.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShortestDistance {

    public static void main(String[] args) {

        String s="loveleetcode"; char c='e';
        //int [] distances=shortestToChar(s,c);
        //int [] distances=shortestToCharSolutionTwo(s,c);
        //int [] distances=shortestToCharSolutionThree(s,c);
        int [] distances=shortestToCharSolutionFour(s,c);
        for (int distance:distances)
            System.out.print(distance+" ");
    }

    public static int [] shortestToChar(String s,char c){

        int n=s.length();
        int [] result=new int[n];

        for (int i=0;i<n;i++){
            int distance=n;
            for (int j=0;j<n;j++){
                if (s.charAt(j)==c)
                    distance=Math.min(distance,Math.abs(j-i));

            }
            result[i]=distance;
        }
        return result;
    }

    static int [] shortestToCharSolutionTwo(String s,char c){

        Map<Character, ArrayList<Integer>> map=new HashMap<>();

        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==c){
                if (map.get(c)==null)
                    map.put(c,new ArrayList<>(Arrays.asList(i)));
                else
                    map.get(c).add(i);
            }
        }

        int [] ans=new int[s.length()];
        Arrays.fill(ans,(int)1e9);
        for (int i=0;i<s.length();i++){
            int mini=(int)1e9;
            for (int index : map.get(c))
                ans[i]=Math.min(ans[i],Math.abs(index-i));

        }
        return ans;
    }

    static int [] shortestToCharSolutionThree(String str,char c){
        StringBuilder sb=new StringBuilder(str);
         int [] ans=new int[str.length()];

         for (int i=0;i<sb.length();i++){
             if (sb.charAt(i)==c){
                 ans[i]=0;
                 continue;
             }
             String s1= str.substring(0,i);
             String s2= sb.substring(i+1);

             int a=s1.lastIndexOf(c);
             int b=s2.indexOf(c);

             if (a==-1)
                 a=Integer.MAX_VALUE;
             else
                 a=s1.length()-a;
             if (b==-1)
                 b=Integer.MAX_VALUE;
             else
                 b=b+1;

             ans[i]=Math.min(a,b);
         }
         return ans;
    }

    static int [] shortestToCharSolutionFour(String str,char c){

        int len=str.length();
        int [] ans=new int[len];

        ans[0]= str.charAt(0)==c ?0 :10001;
        for (int i=1;i<len;i++){
            ans[i]= str.charAt(i) ==c ? 0 : ans[i-1]+1;
        }
        for (int i=len-2;i>=0;i--){
            ans[i]=Math.min(ans[i],ans[i+1]+1);
        }
        return ans;
    }
}
