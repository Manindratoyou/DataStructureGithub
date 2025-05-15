package com.manindra.interview_2;

import java.util.*;
import java.util.stream.Collectors;

/*
Objective:
1. Create a map of departments (`Deptname`) to their respective list of employees.
2. Compute and print the employee count for each department.
*/

public class EmployeeFilter2 {

    public static void main(String[] args) {

        List<Employee> list = Arrays.asList(
                new Employee("1", "Anil", "Manager", 100000.0, "HR"),
                new Employee("2", "Sumil", "Sr Manager", 90000.0, "Finance"),
                new Employee("3", "Naresh", "Manager", 150000.0, "HR"),
                new Employee("4", "Suresh", "Executive", 50000.0, "Finance"),
                new Employee("5", "Ramesh", "Clerk", 40000.0, "IT"),
                new Employee("6", "Mahesh", "Manager", 120000.0, "HR")
        );

        // Create a map of department names to their respective list of employees
        Map<String, List<Employee>> departmentEmployeeMap = list.stream()
                .collect(Collectors.groupingBy(Employee::getDeptname));

        // Print the map
        System.out.println("Department to Employee Mapping:");
        departmentEmployeeMap.forEach((dept, employees) ->
                System.out.println(dept + " -> " + employees));

        // Get the employee count for each department
        System.out.println("\nEmployee Count by Department:");
        departmentEmployeeMap.forEach((dept, employees) ->
                System.out.println(dept + ": " + employees.size()));
    }


    static class Employee {

        private String id;
        private String name;
        private String role;
        private Double salary;
        private String deptname;

        public Employee(String id, String name, String role, Double salary, String deptname) {
            this.id = id;
            this.name = name;
            this.role = role;
            this.salary = salary;
            this.deptname = deptname;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getRole() {
            return role;
        }

        public Double getSalary() {
            return salary;
        }

        public String getDeptname() {
            return deptname;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", role='" + role + '\'' +
                    ", salary=" + salary +
                    ", deptname='" + deptname + '\'' +
                    '}';
        }
    }
}
