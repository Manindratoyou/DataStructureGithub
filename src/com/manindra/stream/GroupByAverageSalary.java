package com.manindra.stream;

import java.util.*;
import java.util.stream.Collectors;

public class GroupByAverageSalary {

    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
                new Employee(1, 100.0, "Admin"),
                new Employee(2, 200.0, "Finance"),
                new Employee(3, 300.0, "Finance"),
                new Employee(4, 400.0, "Admin")
        );

        Map<String, Double> collect = list.stream().collect(
                Collectors.groupingBy(Employee::getDept,
                        Collectors.averagingDouble(Employee::getSal)));

        System.out.println(collect);
    }

    static class Employee {
        private int id;
        private double sal;
        private String dept;

        public Employee(int id, double sal, String dept) {
            this.id = id;
            this.sal = sal;
            this.dept = dept;
        }

        public int getId() {
            return id;
        }

        public double getSal() {
            return sal;
        }

        public String getDept() {
            return dept;
        }

        @Override
        public String toString() {
            return "Employee{id=" + id + ", sal=" + sal + ", dept='" + dept + "'}";
        }
    }
}

