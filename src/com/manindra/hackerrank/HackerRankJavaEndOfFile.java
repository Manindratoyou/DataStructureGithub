package com.manindra.hackerrank;

import java.util.Scanner;

public class HackerRankJavaEndOfFile {

    /*
    Hello world
I am a file
Read me until end-of-file.
     */

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int lineNumber = 0;

        while (scanner.hasNext()) {
            lineNumber++;
            String line = scanner.nextLine();
            System.out.println(lineNumber + " " + line);
        }

        scanner.close();
    }
}
