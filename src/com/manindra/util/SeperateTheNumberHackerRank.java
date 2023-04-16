package com.manindra.util;

public class SeperateTheNumberHackerRank {

    public static void main(String[] args) {

        separateNumbers("1234");//7
        //1234
        //91011
        //99100
       // 101103
       // 010203
        //13
    }

    public static void separateNumbers(String s) {

        long result=solve(s);
        System.out.println(result >0 ? "YES " +result : "NO");
    }

    public static long solve(String s){
        if(s.charAt(0)==0)
            return -1;
        for(int length=1;length*2<=s.length();length++){
            long firstNumber=Long.parseLong(s.substring(0,length));
            StringBuilder sequence=new StringBuilder();
            long number=firstNumber;
            while(sequence.length()<s.length()){
                sequence.append(number);
                number++;
            }
            if(sequence.toString().equals(s))
                return firstNumber;
        }
        return -1;

    }
}
