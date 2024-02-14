package com.manindra.leetcodeEasy;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

//1436
/*
You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going
from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing
to another city.

It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly
one destination city.
 */
public class DestinationCity {

    public static void main(String[] args) {
        List<List<String>> paths = List.of(
                List.of("London", "New York"),
                List.of("New York", "Lima"),
                List.of("Lima", "Sao Paulo")
        );

        System.out.println(destCity(paths));
        System.out.println(destCitySolutionTwo(paths));
    }

    public static String destCity(List<List<String>> paths) {
        Set<String> citiesA = new HashSet<>();
        Set<String> citiesB = new HashSet<>();

        for (List<String> path : paths) {
            citiesA.add(path.get(0));
            citiesB.add(path.get(1));
        }

        // Find the city in B that is not in A
        for (String city : citiesB) {
            if (!citiesA.contains(city)) {
                return city;
            }
        }

        return null; // The function should never reach here for a valid input
    }

    static String destCitySolutionTwo(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for (List<String> path : paths) {
            set.add(path.get(0));
        }

        for (List<String> path : paths) {
            String s = path.get(1);
            if (!set.contains(s)) {
                return s;
            }
        }
        return "";
    }
}
