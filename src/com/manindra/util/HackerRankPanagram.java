package com.manindra.util;

public class HackerRankPanagram {

    public static void main(String[] args) {

        //We promptly judged antique ivory buckles for the next prize
        System.out.println(pangrams("The quick brown fox jumps over the lazy dogs"));
    }

    public static String pangrams(String s) {
        return(isPangram(s))? "pangram" : "not pangram";
    }
    public static boolean isPangram(String s){
        String lowerSentence=s.toLowerCase();
        for(char letter='a';letter<='z';letter++){
            if(lowerSentence.indexOf(letter)<0)
                return false;
        }
        return true;
    }
}
