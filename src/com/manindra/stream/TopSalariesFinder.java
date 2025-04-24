package com.manindra.stream;

import java.util.*;
import java.util.stream.Collectors;

public class TopSalariesFinder {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee(101, "Alice", 95000),
                new Employee(102, "Bob", 87000),
                new Employee(103, "Charlie", 105000),
                new Employee(104, "Diana", 115000),
                new Employee(105, "Ethan", 99000));

        int n = 3;
        // top 3 salary details
        List<Employee> topN = employees.stream().sorted(Comparator.comparingDouble(Employee::getEmpSal).
                reversed()).limit(n).collect(Collectors.toList());

        topN.forEach(System.out::println);

        // only 3 highest

        int rank = 3; // 3rd highest
        Optional<Employee> thirdHighest = employees.stream().sorted(Comparator.comparingDouble(Employee::getEmpSal).
                        reversed()).skip(rank - 1)  // skip 1st and 2nd
                .findFirst();    // get the next one (3rd)

        if (thirdHighest.isPresent()) {
            System.out.println("3rd highest-salaried employee:");
            System.out.println(thirdHighest.get());
        } else {
            System.out.println("Not enough employees in the list.");
        }
    }
}

