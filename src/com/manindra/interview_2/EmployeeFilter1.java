package com.manindra.interview_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
Criteria:
1. Filter all managers and Sr Managers with salary greater or equal to 1 lakh.
2. Sort those managers based on their name length in decreasing order.
*/

public class EmployeeFilter1 {

    public static void main(String[] args) {

        List<Employee> list = Arrays.asList(
                new Employee("1", "Anil", "Manager", 100000.0),
                new Employee("2", "Sumil", "Sr Manager", 90000.0),
                new Employee("3", "Naresh", "Manager", 150000.0)
        );

        // Process the list
        List<Employee> filteredSortedEmployees = list.stream()
                .filter(emp -> (emp.getRole().equals("Manager") || emp.getRole().equals("Sr Manager"))
                        && emp.getSalary() >= 100000.0)
                .sorted(Comparator.comparingInt((Employee emp) -> emp.getName().length()).reversed())
                .collect(Collectors.toList());

        // Print the filtered and sorted employees
        filteredSortedEmployees.forEach(System.out::println);
    }

    static class Employee {

        private String id;
        private String name;
        private String role;
        private Double salary;

        public Employee(String id, String name, String role, Double salary) {
            this.id = id;
            this.name = name;
            this.role = role;
            this.salary = salary;
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

        @Override
        public String toString() {
            return "Employee{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", role='" + role + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}
