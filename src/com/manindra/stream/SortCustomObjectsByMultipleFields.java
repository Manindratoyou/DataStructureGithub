package com.manindra.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortCustomObjectsByMultipleFields {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", 25),
                new Person("Alice", 30),
                new Person("John", 20)
        );

        List<Person> sortedPeople = people.stream()
                .sorted(Comparator.comparing(Person::getName)
                        .thenComparing(Person::getAge))
                .collect(Collectors.toList());

        sortedPeople.forEach(System.out::println);
    }
}
