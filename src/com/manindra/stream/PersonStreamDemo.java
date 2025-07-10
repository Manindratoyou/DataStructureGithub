package com.manindra.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class PersonStreamDemo {

    public static void main(String[] args) {
        // 1. Create a list of Person objects to work with.
        List<Person> personList = Arrays.asList(
                new Person("Alice", 42),
                new Person("Bob", 28),
                new Person("Charlie", 35),
                new Person("David", 50),
                new Person("Alice", 38), // Duplicate name to be filtered by distinct()
                new Person("Eve", 25),
                new Person("Frank", 50),
                new Person("Grace", 31)
        );

        System.out.println("Original list of people:");
        personList.forEach(System.out::println);
        System.out.println("-----------------------------------");


        // 2. Process the list using a stream, as shown in the image.
        List<String> results = personList.stream()
                // Filter to keep only people older than 30.
                .filter(p -> p.getAge() > 30)

                // Map each Person object to their name (a String).
                .map(Person::getName)

                // Keep only the unique names. "Alice" will appear only once.
                .distinct()

                // Sort the names in natural alphabetical order.
                .sorted()

                // Collect the final stream of names into a new List.
                .collect(Collectors.toList());


        // 3. Print the final result.
        System.out.println("\nResult: Sorted list of unique names for people older than 30:");
        System.out.println(results);
    }
}

