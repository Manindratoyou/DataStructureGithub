package com.manindra.hackerrank;

import java.time.LocalDate;
import java.util.Scanner;

public class HackerRankJavaDateTime {

    //08 05 2015
    public static String findDay(int month, int day, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfWeek().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter date (MM DD YYYY): ");
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        int year = scanner.nextInt();

        scanner.close();

        String result = findDay(month, day, year);
        System.out.println(result);
    }
}
