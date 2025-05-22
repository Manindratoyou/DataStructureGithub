package com.manindra.interview_2;

import java.util.Arrays;
import java.util.List;

public class ImmutablePersonTest {

    public static void main(String[] args) {
        List<String> departments = Arrays.asList("HR", "Finance");
        ImmutablePerson person = new ImmutablePerson("John Doe", departments);

        System.out.println("Name: " + person.getName());
        System.out.println("Departments: " + person.getDept());

        // Attempt to modify the list returned by getDept
        try {
            person.getDept().add("IT"); // This will throw an UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify the department list.");
        }

        // Original list remains unaffected
        System.out.println("Departments after modification attempt: " + person.getDept());
    }
}
