package com.manindra.string;

/*
All subsequence of ABC are : "", "A", "B", "C", "AB", "AC", "BC", "ABC"
 */
public class SubsequenceString {

    public static void main(String[] args) {
        System.out.println(isSubSeqIterative("ABCD","AD"));
        System.out.println(isSubSeqRecursive("ABCD","AD",4,2));
    }

    static boolean isSubSeqIterative(String s1,String s2){ //tc 0(m+n) as 0(1)
        int n=s1.length();
        int m=s2.length();
        /*if (n<m){
            return false;
        }*/
        int j = 0;
        for (int i=0;i<n && j<m;i++){
            if (s1.charAt(i)==s2.charAt(j))
                j++;
        }
        return (j==m);
    }
    static boolean isSubSeqRecursive(String s1,String s2,int n,int m){ //tc & as-0(m+n)

        if (m==0)
            return true;
        if (n==0)
            return false;
        if (s1.charAt(n-1)==s2.charAt(m-1))
            return isSubSeqRecursive(s1,s2,n-1,m-1);
        else
            return isSubSeqRecursive(s1,s2,n-1,m);
    }
}
