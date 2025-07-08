package com.manindra.array_leetcode1;

import java.util.Arrays;
/*
Input: hours = [0,1,2,3,4], target = 2
Output: 3
Explanation: The company wants each employee to work for at least 2 hours.
- Employee 0 worked for 0 hours and didn't meet the target.
- Employee 1 worked for 1 hours and didn't meet the target.
- Employee 2 worked for 2 hours and met the target.
- Employee 3 worked for 3 hours and met the target.
- Employee 4 worked for 4 hours and met the target.
There are 3 employees who met the target.
 */
public class Solution2798 { //Number of Employees Who Met the Target

    public static void main(String[] args) {

        int [] hours = {0,1,2,3,4}; int target = 2;
        System.out.println(numberOfEmployeesWhoMetTarget(hours,target));
        System.out.println(numberOfEmployeesWhoMetTargetSolutionTwo(hours,target));
    }

    static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count=0;
        for (int i=0;i<hours.length;i++){
            if (hours[i]>=target) count++;
        }
        return count;
    }

    static long numberOfEmployeesWhoMetTargetSolutionTwo(int[] hours, int target) {
        return Arrays.stream(hours)
                .filter(hour -> hour >= target)
                .count();
    }
}
