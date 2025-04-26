package com.manindra.leetcodeEasy;

public class CalculateDigitSum { //solution 2243

    public static void main(String[] args) {

        String s="11111222223";int k=3;
        CalculateDigitSum digitSum=new CalculateDigitSum();
        System.out.println(digitSum.digitSum(s,k));

    }

    public String digitSum(String s,int k){
        while (s.length()>k){
            s=calculateDigitSum(s,k);
        }
        return s;
    }

    private String calculateDigitSum(String s,int k){
        StringBuilder sb=new StringBuilder();
        int start=0;
        while (start<s.length()){
            int end=Math.min(start+k,s.length());
            int sum=0;
            for (int i=start;i<end;i++){
                sum+=s.charAt(i)-'0';
            }
            sb.append(sum);
            start+=k;
        }
        return sb.toString();
    }

    public String digitSum2(String s, int k) {
        while(s.length()>k){
            String ns=""; // replace the old string with updated one
            for(int i=0;i<s.length();i+=k){
                String t=s.substring(i,Math.min(i+k,s.length())); // form the string of k size
                int sum=0;
                for(int l=0;l<t.length();l++){ // to find the character sum of string t
                    sum+=t.charAt(l)-'0';
                }
                ns+="" + sum;    //update the string with sum of k size string character
            }
            s=ns; //update the old string with updated one
        }
        return s;
    }
}
