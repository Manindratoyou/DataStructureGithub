package com.manindra.string;

/*
String Rank
ABC    1
ACB    2
BAC    3
BCA    4
CAB    5
CBA    6
 */
public class LexicographicRank {

    public static void main(String[] args) {
        String str = "BAC";
        System.out.println(lexicographicRank(str));
    }

    static int lexicographicRank(String str) {
        int result = 1;
        int n = str.length();
        int mul = fact(n);
        int[] count = new int[256];

        for (int i = 0; i < n; i++)
            count[str.charAt(i)]++;

        for (int i = 1; i < 256; i++)
            count[i] += count[i - 1];

        for (int i = 0; i < n - 1; i++) {
            mul = mul / (n - i);
            result = result + count[str.charAt(i) - 1] * mul;

            for (int j = str.charAt(i); j < 256; j++)
                count[j]--;
        }

        return result;
    }

    static int fact(int n) {
        return (n <= 1) ? 1 : n * fact(n - 1);
    }
}
