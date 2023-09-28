package com.manindra.leetcode;

public class Solution58 {

    public static void main(String[] args) {

        Solution58 solution58=new Solution58();
        String s="Hello World";
        int result=solution58.lengthOfLastWord(s);
        int result1= solution58.lengthOfLastWordSolTwo(s);
        System.out.println("Length of Last Word : "+result);
        System.out.println("Length of Last Word : "+result1);
    }

    public int lengthOfLastWord(String s){
        //split the string by spaces
        String [] words=s.split(" ");
        //find the last non-empty word
        for (int i=words.length-1;i>=0;i--){
            if (!words[i].isEmpty())
                return words[i].length();
        }
        return 0;//no non-empty word found
    }
    public int lengthOfLastWordSolTwo(String s){
        if (s==null || s.length()==0)
            return 0;
        int length=0;
        int i=s.length()-1;

        //skip trailing spaces
        while (i>=0 && s.charAt(i) != ' '){
            length++;
            i--;
        }
        return length;
    }
}
