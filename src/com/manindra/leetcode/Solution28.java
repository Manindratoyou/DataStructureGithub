package com.manindra.leetcode;

public class Solution28 {

    public static void main(String[] args) {

        Solution28 solution28=new Solution28();
        String heystack="hello";
        String needle="ll";
        int result= solution28.strStr(heystack,needle);
        int result1= solution28.strStrSolTwo(heystack,needle);
        System.out.println("Index of first occurrence : "+result);
        System.out.println("Index of first occurrence : "+result1);
    }

    public int strStr(String heystack,String needle){
        if (needle.length()==0)
            return 0;
        int hLen=heystack.length();
        int nLen=needle.length();

        for (int i=0;i<=hLen-nLen;i++){
            int j;
            for (j=0;j<nLen;j++){
                if (heystack.charAt(i+j) !=needle.charAt(j)){
                    break;
                }
            }
            if (j==nLen)
                return i;//found a match
        }
        return -1;
    }
    public int strStrSolTwo(String heystack,String needle){
        if (needle.length()==0)
            return 0;
        int hLen=heystack.length();
        int nLen=needle.length();

        for (int i=0;i<hLen-nLen;i++){
            if (heystack.substring(i,i+nLen).equals(needle))
                return i;//found a match
        }
        return -1;//no match found
    }
}
