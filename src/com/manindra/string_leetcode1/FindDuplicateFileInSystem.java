package com.manindra.string_leetcode1;

import java.util.*;

public class FindDuplicateFileInSystem { //solution 609

    public static void main(String[] args) {
        String[] input = {
                "root/a 1.txt(abcd) 2.txt(efgh)",
                "root/c 3.txt(abcd)",
                "root/c/d 4.txt(efgh)",
                "root 4.txt(efgh)"
        };

        System.out.println(findDuplicate(input));
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] parts = path.split(" ");
            String dir = parts[0];

            for (int i = 1; i < parts.length; i++) {
                String file = parts[i];

                int open = file.indexOf('(');
                int close = file.indexOf(')');

                String fileName = file.substring(0, open);
                String content = file.substring(open + 1, close);

                String fullPath = dir + "/" + fileName;

                map.computeIfAbsent(content, x -> new ArrayList<>()).add(fullPath);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> group : map.values()) {
            if (group.size() > 1) {
                result.add(group);
            }
        }

        return result;
    }

}

