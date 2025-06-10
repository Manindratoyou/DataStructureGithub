package com.manindra.hackerrank_2;

public class CamelCaseProblemHackerRank {

    public static void main(String[] args) {

        System.out.println(camelcase("IdCard"));
    }
    public static int camelcase(String s) {
        int numberOfWords=1;
        boolean temp;
        for(int i=1;i<s.length();i++){
            temp=Character.isUpperCase(s.charAt(i));
            if(temp)
                numberOfWords++;
        }
        return numberOfWords;

    }

}
