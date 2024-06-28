package com.manindra.interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program4 {

    public static void main(String[] args) {
        // Sample data
        Address address1 = new Address("Home", "DELHI", "110001");
        Address address2 = new Address("Work", "Mumbai", "400001");

        Person person1 = new Person("1", "John Doe", Arrays.asList(address1));
        Person person2 = new Person("2", "Jane Doe", Arrays.asList(address2));
        Person person3 = new Person("3", "John Smith", Arrays.asList(address1));
        Person person4 = new Person("4", "Jane Smith", Arrays.asList(address2));

        List<Person> persons = Arrays.asList(person1, person2, person3, person4);

        // Step 1: Remove duplicates
        List<Person> uniquePersons = persons.stream()
                .distinct()
                .collect(Collectors.toList());

        // Step 2: Sort by name in descending order
        List<Person> sortedPersons = uniquePersons.stream()
                .sorted((p1, p2) -> p2.getName().compareToIgnoreCase(p1.getName()))
                .collect(Collectors.toList());

        // Step 3: Extract Persons with city 'DELHI' or name contains 'JOHN'
        List<Person> filteredPersons = sortedPersons.stream()
                .filter(person -> "DELHI".equalsIgnoreCase(person.getAddresses().get(0).getCity())
                        || person.getName().toUpperCase().contains("JOHN"))
                .collect(Collectors.toList());

        // Step 4: Get Person names in UPPER CASE
        String[] namesInUpperCase = filteredPersons.stream()
                .map(person -> person.getName().toUpperCase())
                .toArray(String[]::new);

        // Print the result
        Arrays.stream(namesInUpperCase).forEach(System.out::println);
    }


    static class Person {
        private String id;
        private String name;
        private List<Address> addresses;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Address> getAddresses() {
            return addresses;
        }

        public void setAddresses(List<Address> addresses) {
            this.addresses = addresses;
        }

        public Person(String id, String name, List<Address> addresses) {
            this.id = id;
            this.name = name;
            this.addresses = addresses;
        }
    }

    static class Address {
        private String name;
        private String city;
        private String zipCode;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public Address(String name, String city, String zipCode) {
            this.name = name;
            this.city = city;
            this.zipCode = zipCode;
        }
    }

}
