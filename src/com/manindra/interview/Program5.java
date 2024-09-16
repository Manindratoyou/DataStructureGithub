package com.manindra.interview;

import com.manindra.stream.Employee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
I have three list ,i want common employee from list and list 2 and then those employees
who are not there in the list3
 */
public class Program5 {

    public static void main(String[] args) {
        List<Employee> list1 = new ArrayList<>();
        List<Employee> list2 = new ArrayList<>();
        List<Employee> list3 = new ArrayList<>();

        // Add some Employee objects to the lists

        List<Employee> result = findCommonAndNotInList3(list1, list2, list3);
        System.out.println(result);
    }

    //Solution 1: Using Streams
    public static List<Employee> findCommonAndNotInList3(List<Employee> list1, List<Employee> list2, List<Employee> list3) {
        List<Employee> commonEmployees = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());

        List<Employee> result = commonEmployees.stream()
                .filter(employee -> !list3.contains(employee))
                .collect(Collectors.toList());

        return result;
    }

    //Solution 2: Using HashSet
    public static List<Employee> findCommonAndNotInList3_SolTwo(List<Employee> list1, List<Employee> list2, List<Employee> list3) {
        Set<Employee> commonSet = new HashSet<>(list1);
        commonSet.retainAll(new HashSet<>(list2));

        Set<Employee> notInList3Set = new HashSet<>(commonSet);
        notInList3Set.removeAll(new HashSet<>(list3));

        return new ArrayList<>(notInList3Set);
    }

}
