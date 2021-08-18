package com.essenbazar.numStudentDoingHomework_1450;

/*

Given two integer arrays startTime and endTime and given an integer queryTime.

The ith student started doing their homework at the time startTime[i]
and finished it at time endTime[i].

Return the number of students doing their homework at time queryTime.
More formally, return the number of students where queryTime lays in the interval
[startTime[i], endTime[i]] inclusive.


Input: startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
Output: 1

Explanation: We have 3 students where:

The first student started doing homework at time 1 and finished at time 3 and wasn't doing anything at time 4.
The second student started doing homework at time 2 and finished at time 2 and also wasn't doing anything at time 4.
The third student started doing homework at time 3 and finished at time 7 and was the only student doing homework at time 4.

 */

class Solution {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;

        for (int i = 0; i < startTime.length; i++) {
            if (queryTime <= endTime[i] && queryTime >= startTime[i]) {
                count++;
            } else if (queryTime >= startTime[i] && Math.abs(startTime[i] - endTime[i]) >= queryTime) {
                count++;
            } else if (queryTime >= startTime[i] && startTime[i] - endTime[i] == 0 && startTime[i] == queryTime) {
                count++;
            }
        }
        return count;
    }
}
