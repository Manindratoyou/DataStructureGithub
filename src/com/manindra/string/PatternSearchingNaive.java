package com.manindra.string;

public class PatternSearchingNaive {

    public static void main(String[] args) {
        String text="ABABABCD", Pattern="ABAB";
        patternSearchingNaive(text,Pattern);
        //patternSearchingNaiveImprove(text,Pattern);
    }

    static void patternSearchingNaive(String text,String pattern){
        int m=pattern.length();
        int n=text.length();
        for (int i=0;i<n-m;i++){
            int j;
            for (j=0;j<m;j++)
                if (pattern.charAt(j)!=text.charAt(i+j))
                    break;
            if (j==m)
                System.out.print(i+" ");
        }
    }
    static void patternSearchingNaiveImprove(String text,String pattern){
        int m=pattern.length();
        int n=text.length();
        for (int i=0;i<=(n-m); ){
            int j;
            for (j=0;j<m-1;j++)
                if (pattern.charAt(j)!=text.charAt(i+j))
                    break;
            if (j==m)
                System.out.print(i+" ");
            if (j==0)
                i++;
            else
                i=i+j;
        }
    }
}
