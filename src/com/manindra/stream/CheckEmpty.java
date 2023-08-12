package com.manindra.stream;

import java.util.*;

public class CheckEmpty {

    public static void main(String[] args) {

        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(new Employee(1,"Employee1",1001));
        employeeList.add(new Employee(2,"Employee2",1002));

        Optional.ofNullable(employeeList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(Employee::getEmpName)
                .forEach(System.out::println);

    }
}
