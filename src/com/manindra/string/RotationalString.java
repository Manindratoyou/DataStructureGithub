package com.manindra.string;

public class RotationalString {

    public static void main(String[] args) {
        String s1="ABCD",s2="CDAB";
        System.out.println(areRotations(s1,s2));
    }

    static boolean areRotations(String s1,String s2){
        if (s1.length()!=s2.length())
            return false;
        //String temp=s1+s1;return temp.indexOf(s2) != -1;
        return ((s1+s1).indexOf(s2)>=0);
    }
}
