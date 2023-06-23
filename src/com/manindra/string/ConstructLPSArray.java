package com.manindra.string;

//kmp algorithm part1
public class ConstructLPSArray {

    public static void main(String[] args) {
        String txt="abacabad";
        int [] lps=new int[txt.length()];
        //fillLpsSolOne(txt,lps);
        fillLpsSolTwo(txt,lps);
        for (int i=0;i<txt.length();i++)
            System.out.print(lps[i]+" ");
    }
    static void fillLpsSolOne(String str,int [] lps){//tc 0(n3)
        for (int i=0;i<str.length();i++)
            lps[i]=longProperPrefixSuffix(str,i+1);
    }

    private static int longProperPrefixSuffix(String str, int n) {
        for (int length=n-1;length>0;length--){
            boolean flag=true;
            for (int i=0;i<length;i++)
                if (str.charAt(i)!=str.charAt(n-length+i))
                    flag=false;
            if (flag==true)
                return length;
        }
        return 0;
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
