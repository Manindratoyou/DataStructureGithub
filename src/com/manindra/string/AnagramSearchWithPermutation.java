package com.manindra.string;

public class AnagramSearchWithPermutation {

    static final int CHAR=256;

    public static void main(String[] args) {
        String text="geeksforgeeks",pattern="frog";
        //System.out.println(isPresentAnagramPermutationSolOne(text,pattern));
        System.out.println(isPresentAnagramPermutationSolTwo(text,pattern));
    }
    static boolean isPresentAnagramPermutationSolOne(String text,String pattern){
        int n=text.length();
        int m=pattern.length();
        for (int i=0;i<=n-m;i++){
            if (areAnagram(pattern,text,i))
                return true;
        }
        return false;
    }
    static boolean isPresentAnagramPermutationSolTwo(String text,String pattern){ //tc 0(n) as:Q(char)
        int [] CT=new int[CHAR];
        int [] CP=new int[CHAR];
        for (int i=0;i<pattern.length();i++){
            CT[text.charAt(i)]++;
            CP[pattern.charAt(i)]++;
        }
        for (int i=pattern.length();i<text.length();i++){
            if (areSame(CP,CT))
                return true;
            CT[text.charAt(i)]++;
            CT[text.charAt(i-pattern.length())]--;
        }
        return false;
    }
    static boolean areSame(int [] CT,int[] CP){
        for (int i=0;i<CHAR;i++){
            if (CT[i]!=CP[i])
                return false;
        }
        return true;
    }

    static boolean areAnagram(String pattern,String text,int i){
        int [] count=new int[26];
        for (int j=0;j<pattern.length();j++){
            count[pattern.charAt(j)-'a']++;
            count[text.charAt(i+j)-'a']--;
        }
        for (int j=0;i<26;i++){
            if (count[j]!=0)
                return false;
        }
        return true;

    }
}
