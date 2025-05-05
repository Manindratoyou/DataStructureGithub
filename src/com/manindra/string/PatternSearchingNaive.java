package com.manindra.string;

public class PatternSearchingNaive {

    public static void main(String[] args) {
        String text = "ABABABCD", Pattern = "ABAB";
        String text1 = "ABABABCD", Pattern1 = "AB";
        patternSearchingNaive(text, Pattern);
        System.out.println("--------------");
        searchPattern2(text1, Pattern1);
    }

    static void patternSearchingNaive(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();
        for (int i = 0; i < n - m; i++) {
            int j;
            for (j = 0; j < m; j++)
                if (pattern.charAt(j) != text.charAt(i + j))
                    break;
            if (j == m)
                System.out.print(i + " ");
        }
        System.out.println();
    }

    static void searchPattern2(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j;

            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            if (j == m) {
                System.out.print(i + " ");
            }
        }
    }
}
