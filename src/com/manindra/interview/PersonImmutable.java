package com.manindra.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class PersonImmutable {

    // Member attributes of the final class
    private final String name;
    private final int regNumber;
    private final List<String> metaData;

    // Parameterized constructor of the immutable class
    PersonImmutable(String name, int regNumber, List<String> metaData) {
        // 'this' keyword refers to the current instance itself
        this.name = name;
        this.regNumber = regNumber;

        // Creating an ArrayList with the values from metaData
        this.metaData = new ArrayList<>(metaData);
    }

    // There should not be any setters

    // Getter
    public String getName() {
        return name;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public List<String> getMetaData() {
        // Returning an unmodifiable list to maintain immutability
        return Collections.unmodifiableList(metaData);
    }

    public static void main(String[] args) {
        // Creating an instance of the PersonImmutable class
        List<String> metaDataList = new ArrayList<>();
        metaDataList.add("Meta1");
        metaDataList.add("Meta2");

        PersonImmutable person = new PersonImmutable("ABC", 101, metaDataList);

        // Calling the above methods 1, 2, 3 of class1
        // inside main() method in class2 and
        // executing the print statement over them
        System.out.println(person.getName());
        System.out.println(person.getRegNumber());
        System.out.println(person.getMetaData());

        // Uncommenting below line causes error
        // person.regNumber = 102;

        metaDataList.add("Meta3");
        // Remains unchanged due to deep copy in constructor
        System.out.println(person.getMetaData());

        // Uncommenting below line causes error
        // person.getMetaData().add("Meta4");

        // Remains unchanged due to deep copy in getter
        System.out.println(person.getMetaData());
    }
}

