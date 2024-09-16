package com.manindra.interview;

import com.manindra.stream.Employee;

public class EmployeeTest {

    public static void main(String[] args) {
        // Creating instances of the Person class
        Employee person1 = new Employee(1,"Alice", 25);
        Employee person2 = new Employee(1,"Alice", 25);
        Employee person3 = new Employee(3,"ABC", 28);

        // Using overridden methods
        System.out.println("person1 equals person2: " + person1.equals(person2));
        System.out.println("person2 equals person3: " + person2.equals(person3));
        System.out.println("person1 hashCode: " + person1.hashCode());
        System.out.println("person2 hashCode: " + person2.hashCode());
        System.out.println("person3 hashCode: " + person3.hashCode());
        System.out.println("person1 toString: " + person1);
        System.out.println("person2 toString: " + person2);
        System.out.println("person3 toString: " + person3);
    }
}
