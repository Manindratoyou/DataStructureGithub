package com.manindra.iitp.lab5101;

import java.util.Scanner;

class Student {
    String firstName;
    String lastName;
    int age;
}

public class InsertionSort { //write to c program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of students: ");
        int n = scanner.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            students[i] = new Student();

            System.out.println("Firstname of student " + (i + 1) + ": ");
            students[i].firstName = scanner.next();

            System.out.println("Lastname of student " + (i + 1) + ": ");
            students[i].lastName = scanner.next();

            System.out.println("Age of student " + (i + 1) + ": ");
            students[i].age = scanner.nextInt();
        }

        insertionSort(students);

        System.out.println("Sorted order of students:");
        for (int i = 0; i < n; i++) {
            System.out.println("Firstname of student: " + students[i].firstName);
            System.out.println("Lastname of student: " + students[i].lastName);
            System.out.println("Age of student: " + students[i].age);
        }
    }

    private static void insertionSort(Student[] students) {
        int n = students.length;

        for (int i = 1; i < n; i++) {
            Student key = students[i];
            int j = i - 1;

            while
            (j >= 0 && (key.firstName.compareTo(students[j].firstName) < 0 ||
                    (key.firstName.compareTo(students[j].firstName) == 0 && key.lastName.compareTo(students[j].lastName) < 0) ||
                    (key.firstName.compareTo(students[j].firstName) == 0 && key.lastName.compareTo(students[j].lastName) == 0 && key.age < students[j].age))) {
                students[j + 1] = students[j];
                j--;
            }

            students[j + 1] = key;
        }
    }

}