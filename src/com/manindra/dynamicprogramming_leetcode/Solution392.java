package com.manindra.dynamicprogramming_leetcode;

public class Solution392 { //is Subsequence

    public static void main(String[] args) {
        // Sample Test Cases
        System.out.println(isSubsequence("abc", "ahbgdc")); // Output: true
        System.out.println(isSubsequence("axc", "ahbgdc")); // Output: false
        System.out.println(isSubsequence("", "abc")); // Output: true
        System.out.println(isSubsequence("abc", "")); // Output: false
        System.out.println(isSubsequence("", "")); // Output: true
        System.out.println(isSubsequence("aaaaaa", "bbaaaa")); // Output: false
    }

    //approach 1 : Bruit Force Tc: 0(min(m,n) m and length of s and t AS: 0(1)
    static boolean isSubsequence(String s,String t){
        int sIndex=0;
        int tIndex=0;

        while (sIndex<s.length() && tIndex<t.length()){
            if (s.charAt(sIndex)==t.charAt(tIndex))
                sIndex++;
            tIndex++;
        }

        return sIndex==s.length();
    }
    //approach 2 : Dynamic Programming TC: 0(m*n) AS: 0(m*n)
    static boolean isSubsequenceSolutionTwo(String s,String t){

        int m=s.length();
        int n=t.length();

        int [][] dp=new int[m+1][n+1];
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n]==m;
    }

    //approach 3 : Two pointer approach TC: 0(n) AS: 0(1)
    static boolean isSubsequenceSolutionThree(String s,String t){

        int sIndex=0;
        int tIndex=0;
        while (tIndex<t.length()){
            if (sIndex<s.length() && s.charAt(sIndex)==t.charAt(tIndex))
                sIndex++;

            tIndex++;
        }
        return sIndex==s.length();
    }

    boolean isSubsequenceSolutionFive(String str1, String str2) {

        // Initialize pointers for both strings
        int i = 0;
        int j = 0;
        // We can iterate until either of them becomes zero...

        while (i < str1.length() && j < str2.length()) {
            // Compare characters, increment both pointers if same
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                j++; // Only increment second pointer
            }
        }

        // If it is a subsequence, 'i' will have travelled full
        // length of string 'str1', so just check and return
        return (i == str1.length());
    }
}
