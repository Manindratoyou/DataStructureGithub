package com.manindra.interview;

import com.manindra.stream.Employee;

import java.util.Comparator;
import java.util.List;

public class Program7 {

    public static void main(String[] args) {

        List<Employee> list=List.of(new Employee(101,"name1",300),
                new Employee(102,"name2",400),new Employee(103,"name3",500));
        list.stream().sorted(Comparator.comparing(Employee::getEmpSal).reversed()).skip(1).forEach(System.out::println);
    }
}
