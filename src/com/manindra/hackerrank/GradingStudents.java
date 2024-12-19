package com.manindra.hackerrank;

import java.util.*;

public class GradingStudents {

    public static void main(String[] args) {
        // Test cases
        List<Integer> grades = Arrays.asList(73, 67, 38, 33, 84, 29);

        // Get rounded grades
        List<Integer> result = gradingStudents(grades);

        // Print the results
        System.out.println("Original Grades: " + grades);
        System.out.println("Rounded Grades: " + result);
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {

        List<Integer> list=new ArrayList<>();
        for (int i=0;i<grades.size();i++){
            int mark=grades.get(i);
            if (mark<38){
                list.add(mark);
            }else {
                int multiple=(mark/5)+1;
                int mulof5=multiple*5;
                int diff=mulof5-mark;
                if (diff<3)
                    list.add(mulof5);
                else
                    list.add(mark);
            }
        }
        return list;
    }

    public static List<Integer> gradingStudents2(List<Integer> grades) {
        List<Integer> roundedGrades = new ArrayList<>();

        for (int grade : grades) {
            if (grade < 38) {
                // Grade is failing, no rounding
                roundedGrades.add(grade);
            } else {
                // Calculate the next multiple of 5
                int nextMultipleOfFive = ((grade / 5) + 1) * 5;

                // Check if the difference is less than 3
                if (nextMultipleOfFive - grade < 3) {
                    roundedGrades.add(nextMultipleOfFive);
                } else {
                    roundedGrades.add(grade);
                }
            }
        }

        return roundedGrades;
    }

}

