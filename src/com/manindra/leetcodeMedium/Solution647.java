package com.manindra.leetcodeMedium;

/*
Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class Solution647 { //Palindromic Substrings

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }

    static int countSubstrings(String s) {
        if(s.length()==0) return 0;
        int n=s.length();
        int res=0;
        char[] c=s.toCharArray();
        for(int i=0;i<n;i++){
            //odd and even lengths(center for odd -> i,i)
            //center for even ->i ,i+1
            res+=isPalindrome(i,i,c);
            res+=isPalindrome(i,i+1,c);
        }
        return res;
    }
    static int isPalindrome(int s, int e, char[] c){
        int count=0;
        while(s>=0 && e<c.length && c[s--]==c[e++])
            count++;

        return count;
    }
}
