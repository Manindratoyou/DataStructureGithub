package com.manindra.string;

public class ReverseWordString {

    public static void main(String[] args) {
        String s="welcome to Gfg";
        int n=s.length();
        char[] str=s.toCharArray();
        reverseWord(str,n);
        String st=new String(str);
        System.out.println(st);
    }


    static void reverseWord(char [] str,int n){
        int start=0;
        for (int end=0;end<n;end++){
            if (str[end]==' '){
                reverse(str,start,end-1);
                start=end+1;
            }
        }
        reverse(str,start,n-1);
        reverse(str,0,n-1);//reversing the whole string
    }
    static void reverse(char [] str, int low, int high){
        while (low<high){
            char temp=str[low];
            str[low]=str[high];
            str[high]=temp;
            low++;
            high--;
        }
    }
}
