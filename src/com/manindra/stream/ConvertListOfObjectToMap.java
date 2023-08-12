package com.manindra.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertListOfObjectToMap {

    public static void main(String[] args) {

        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(new Employee(1,"Employee1",1001));
        employeeList.add(new Employee(2,"Employee2",1002));
        employeeList.add(new Employee(3,"Employee3",1003));
        employeeList.add(new Employee(4,"Employee4",1004));
        employeeList.add(new Employee(5,"Employee5",1005));
        employeeList.add(new Employee(6,"Employee6",1006));

        employeeList.stream().sorted(Comparator.comparing(Employee::getEmpSal).reversed()).
                collect(Collectors.toMap(Employee::getEmpName,Employee::getEmpId,
                        (oldValue,newValue)->oldValue, LinkedHashMap::new));
        System.out.println("Employee  " +employeeList);
    }
}
