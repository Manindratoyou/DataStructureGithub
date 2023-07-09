package com.manindra.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private String firstName;
    private String surname;

    public Person(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }
}

/*
Create a Person class containing fields : first Name, surname and a parameterized constructor.
	Use java 8 features to create a list of Person objects from list of strings of full names.
 */
public class Test1 {

    public static void main(String[] args) {
        List<String> fullNames = Arrays.asList("John Doe", "Jane Smith", "David Johnson");

        List<Person> persons = fullNames.stream()
                .map(name -> {
                    String[] nameParts = name.split(" ");
                    String firstName = nameParts[0];
                    String surname = nameParts[1];
                    return new Person(firstName, surname);
                })
                .collect(Collectors.toList());
        // Printing the list of Person objects
        persons.forEach(person -> System.out.println(person.getFirstName() + " " + person.getSurname()));
    }
}
