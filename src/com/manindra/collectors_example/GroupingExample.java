package com.manindra.collectors_example;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill", "Bob", "Bill");

        // Group names by their starting character
        Map<Character, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));

        System.out.println(grouped);
        System.out.println("====================================");

        List<String> names1 = List.of("John", "Jane", "Jake", "Tom", "Tim");

        Map<Integer, List<String>> groupedByLength = names1.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(groupedByLength);
        System.out.println("====================================");

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        Map<String, List<Integer>> evenOddMap = numbers.stream()
                .collect(Collectors.groupingBy(num -> num % 2 == 0 ? "Even" : "Odd"));

        System.out.println(evenOddMap);
        System.out.println("====================================");

        List<Employee> employees = List.of(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Charlie", "HR"),
                new Employee("David", "Finance")
        );

        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.department));

        System.out.println(byDept);

        System.out.println("====================================");

        List<String> fruits = List.of("Apple", "Banana", "Apple", "Orange", "Banana", "Banana");

        Map<String, Long> fruitCounts = fruits.stream()
                .collect(Collectors.groupingBy(f -> f, Collectors.counting()));

        System.out.println(fruitCounts);
        System.out.println("====================================");

        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 40),
                new Person("Charlie", 30),
                new Person("David", 40)
        );

        Map<Integer, List<String>> namesByAge = people.stream()
                .collect(Collectors.groupingBy(p -> p.age,
                        Collectors.mapping(p -> p.name, Collectors.toList())));

        System.out.println(namesByAge);

    }




    static class Employee {
        String name;
        String department;
        Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", department='" + department + '\'' +
                    '}';
        }
    }
    static class Person {
        String name;
        int age;
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}

