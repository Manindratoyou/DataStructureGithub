package com.manindra.interview_2;

import java.util.ArrayList;
import java.util.List;


public class EmployeeToString {

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.firstName = "X";
        employee.lastName = "Y";
        employee.project = new Employee.Project();
        employee.project.id = 1;
        employee.project.name = "ABC";

        String result = convertToString(employee);
        System.out.println(result);
    }

    static String convertToString(Employee employee) {
        List<String> values = new ArrayList<>();
        values.add(employee.firstName);
        values.add(employee.lastName);

        if (employee.project != null) {
            values.add(Integer.toString(employee.project.id));
            values.add(employee.project.name);
        }

        return String.join(", ", values);
    }

    static class Employee {
        String firstName;
        String lastName;
        Project project;

        static class Project {
            int id;
            String name;
        }
    }
}

