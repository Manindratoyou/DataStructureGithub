package com.manindra.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DepartmentEmployeeMapping {

    public static void main(String[] args) {
        // Sample data
        List<Department> departments = Arrays.asList(
                new Department("IT", Arrays.asList(new Employee("Alice", 30), new Employee("Bob", 25))),
                new Department("HR", Arrays.asList(new Employee("Charlie", 35), new Employee("Diana", 28)))
        );

        // Using nested mapping logic
        List<EmployeeDTO> employeeDTOs = departments.stream()
                .flatMap(department -> department.getEmployees().stream()
                        .map(employee -> new EmployeeDTO(
                                employee.getName(),
                                employee.getAge(),
                                department.getName())
                        )
                )
                .collect(Collectors.toList());

        // Output the results
        employeeDTOs.forEach(System.out::println);
    }

    // Department class
    static class Department {
        private String name;
        private List<Employee> employees;

        public Department(String name, List<Employee> employees) {
            this.name = name;
            this.employees = employees;
        }

        public String getName() {
            return name;
        }

        public List<Employee> getEmployees() {
            return employees;
        }
    }

    // Employee class
    static class Employee {
        private String name;
        private int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    // EmployeeDTO class
    static class EmployeeDTO {
        private String name;
        private int age;
        private String department;

        public EmployeeDTO(String name, int age, String department) {
            this.name = name;
            this.age = age;
            this.department = department;
        }

        @Override
        public String toString() {
            return "EmployeeDTO{name='" + name + "', age=" + age + ", department='" + department + "'}";
        }
    }
}

