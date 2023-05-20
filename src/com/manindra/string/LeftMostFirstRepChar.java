package com.manindra.string;

import java.util.Arrays;

public class LeftMostFirstRepChar {

    public static void main(String[] args) {
        System.out.println(leftMostSolOne("manindra"));
        System.out.println(leftMostSolTwo("manindra"));
        System.out.println(leftMostSolThree("abcdc"));
        System.out.println(leftMostSolFour("abcdc"));
    }

    static int leftMostSolOne(String str){//naive solution o(n2) time complexity
        for (int i=0;i<str.length();i++){
            for (int j=i+1;j<str.length();j++){
                if (str.charAt(i)==str.charAt(j))
                    return i;
            }
        }
        return -1;
    }

    static int leftMostSolTwo(String str){//better approach linear time
        int [] count=new int[256];
        for (int i=0;i<str.length();i++){
            count[str.charAt(i)]++;
        }
        for (int i=0;i<str.length();i++){
            if (count[str.charAt(i)]>1)
                return i;
        }
        return -1;
    }
    static int leftMostSolThree(String str){ //tc o(n+char) sc o (char)
       /*int [] fIndex=new int[26];
        Arrays.fill(fIndex,-1);
        int res=Integer.MAX_VALUE;
        for (int i=0;i<str.length();i++){
            int fi=fIndex[str.charAt(i)-'a']++;

            if (fi==-1)
                fIndex[str.charAt(i)-'a']=i;
            else
                res=Math.min(res,fi);
        }
        return (res==Integer.MAX_VALUE) ? -1 :res;*/
        int [] fIndex=new int[256];
        Arrays.fill(fIndex,-1);
        int res=Integer.MAX_VALUE;
        for (int i=0;i<str.length();i++){
            int fi=fIndex[str.charAt(i)]++;

            if (fi==-1)
                fIndex[str.charAt(i)]=i;
            else
                res=Math.min(res,fi);
        }
        return (res==Integer.MAX_VALUE) ? -1 :res;
    }

    static int leftMostSolFour(String str){//best
        boolean [] isVisited=new boolean[26];
        int res=-1;
        for (int i=str.length()-1;i>=0;i--){
            if (isVisited[str.charAt(i)-'a'])
                res=i;
            else
                isVisited[str.charAt(i)-'a']=true;
        }
        return res;
    }

}
