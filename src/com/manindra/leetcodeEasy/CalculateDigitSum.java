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
}
