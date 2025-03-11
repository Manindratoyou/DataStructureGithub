package com.manindra.hackerrank_2;

public class LibraryFine {

    public static void main(String[] args) {
        // Example Input
        int d1 = 9, m1 = 6, y1 = 2015; // Returned Date
        int d2 = 6, m2 = 6, y2 = 2015; // Due Date

        // Compute Fine
        //int fine = libraryFine(d1, m1, y1, d2, m2, y2);
        int fine = libraryFine2(d1, m1, y1, d2, m2, y2);

        // Print the result
        System.out.println(fine);
    }

    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        if (y1 < y2 || (y1 == y2 && m1 < m2) || (y1 == y2 && m1 == m2 && d1 <= d2)) {
            return 0; // No fine if returned on time or before
        }

        if (y1 > y2) {
            return 10000; // Different year
        }

        if (m1 > m2) {
            return 500 * (m1 - m2); // Same year, different month
        }

        return 15 * (d1 - d2); // Same month, different day
    }

    public static int libraryFine2(int d1, int m1, int y1, int d2, int m2, int y2) {
        if (y1 > y2) {
            return 10000;
        } else if (m1 > m2 && y1 == y2) {
            return 500 * (m1 - m2);
        } else if (d1 > d2 && m1 == m2 && y1 == y2) {
            return 15 * (d1 - d2);
        } else {
            return 0;
        }

    }

}

