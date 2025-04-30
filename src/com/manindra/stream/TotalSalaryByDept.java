package com.manindra.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TotalSalaryByDept {

    public static void main(String[] args) {
        // Sample list of employees
        List<Employee2> employees = List.of(
                new Employee2("Sales", 50000.0, "Alice"),
                new Employee2("Marketing", 60000.0, "Bob"),
                new Employee2("Sales", 55000.0, "Charlie"),
                new Employee2("Engineering", 70000.0, "David"),
                new Employee2("Marketing", 65000.0, "Eve"),
                new Employee2("Engineering", 75000.0, "Frank")
        );

        // Calculate the total salary for each department
        Map<String, Double> totalSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee2::getDepartment,
                        Collectors.summingDouble(Employee2::getSalary)
                ));

        // Print the result
        System.out.println("Total Salary by Department:");
        totalSalaryByDepartment.forEach((department, totalSalary) ->
                System.out.println(department + ": " + totalSalary)
        );
    }
}
