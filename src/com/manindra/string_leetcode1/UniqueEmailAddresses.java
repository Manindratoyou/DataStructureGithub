package com.manindra.string_leetcode1;

import java.util.*;

public class UniqueEmailAddresses { //solution 929

    public static void main(String[] args) {
        String[] emails = {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        };
        System.out.println(numUniqueEmails(emails));  // Output: 2
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0];
            String domain = parts[1];

            // Remove after '+'
            int plusIndex = local.indexOf('+');
            if (plusIndex != -1) {
                local = local.substring(0, plusIndex);
            }

            // Remove all dots
            local = local.replace(".", "");

            // Rebuild final email
            String finalEmail = local + "@" + domain;
            set.add(finalEmail);
        }

        return set.size();
    }

}

