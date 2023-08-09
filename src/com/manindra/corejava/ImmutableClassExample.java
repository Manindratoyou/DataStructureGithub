package com.manindra.corejava;

import java.util.HashMap;
import java.util.Map;

/*
The class must be declared as final so that child classes can’t be created.
Data members in the class must be declared private so that direct access is not allowed.
Data members in the class must be declared as final so that we can’t change the value of it after object
creation.
A parameterized constructor should initialize all the fields performing a deep copy so that data members
can’t be modified with an object reference.
Deep Copy of objects should be performed in the getter methods to return a copy rather than returning the
actual object reference)
 */
public class ImmutableClassExample {

    public static void main(String[] args)
    {

        // Creating Map object with reference to HashMap
        Map<String, String> map = new HashMap<>();

        // Adding elements to Map object
        // using put() method
        map.put("1", "first");
        map.put("2", "second");

        StudentImmutable s = new StudentImmutable("ABC", 101, map);

        // Calling the above methods 1,2,3 of class1
        // inside main() method in class2 and
        // executing the print statement over them
        System.out.println(s.getName());
        System.out.println(s.getRegNumber());
        System.out.println(s.getMetaData());

        // Uncommenting below line causes error
        // s.regNumber= 102;

        map.put("3", "third");
        // Remains unchanged due to deep copy in constructor
        System.out.println(s.getMetaData());
        s.getMetaData().put("4", "fourth");
        // Remains unchanged due to deep copy in getter
        System.out.println(s.getMetaData());
    }
}
