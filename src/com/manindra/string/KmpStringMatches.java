package com.manindra.string;

public class KmpStringMatches {

    public static void main(String[] args) {
        String text="abcdefg",pattern="bcd";
        Kmp(pattern,text);
    }

    static void Kmp(String pattern,String text){ //tc 0(2n)
        int N=text.length();
        int M=pattern.length();
        int [] lps=new int[M];
        fillLpsSolTwo(pattern,lps);
        int i=0,j=0;
        while (i<N){
            if (pattern.charAt(j)==text.charAt(i)){
                i++;
                j++;
            }
            if (j==M){
                System.out.println("Found pattern at index "+ (i-j));
                j=lps[j-1];
            } else if (i<N && pattern.charAt(j)!=text.charAt(i)) {
                if (j==0)
                    i++;
                else
                    j=lps[j-1];
            }
        }
    }

    static void fillLpsSolTwo(String str,int [] lps){ //tc o(n)
        int n=str.length(),length=0;
        lps[0]=0;
        int i=1;
        while (i<n){
            if (str.charAt(i)==str.charAt(length)){
                length++;
                lps[i]=length;
                i++;
            }else {
                if (length==0){
                    lps[i]=0;
                    i++;
                }else {
                    length=lps[length-1];
                }
            }
        }
    }
}
