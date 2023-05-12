package com.manindra.string;

public class PalindromeCheck {

    public static void main(String[] args) {
        System.out.println(isPalSolutionOne("ABBA"));
        System.out.println(isPalSolutionTwo("ABCDCBA"));
    }

    static boolean isPalSolutionOne(String str){
        StringBuilder rev=new StringBuilder(str);
        rev.reverse();
        return str.equals(rev.toString());
    }
    static boolean isPalSolutionTwo(String str){
        int begin=0;
        int end=str.length()-1;
        while (begin<end){
            if (str.charAt(begin)==str.charAt(end))
                return true;
            begin++;
            end--;
        }
        return false;
    }
    /*
    while (begin<end){
            if (str.charAt(begin)!=str.charAt(end))
                return false;
            begin++;
            end--;
        }
        return true;
     */

}
