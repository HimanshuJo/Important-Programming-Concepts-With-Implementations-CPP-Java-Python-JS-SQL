/*
Project for solving some May_21 leetcode problems
 */
package com.essenbazar.courseScheduleIII;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * @author himanshu
 */

/*

There are n different online courses numbered from 1 to n. 

You are given an array courses where courses[i] = [durationi, lastDayi]

indicate that the ith course should be taken continuously for durationi days and must be 
finished before or on lastDayi.

You will start on the 1st day and you cannot take two or more courses simultaneously.

Return the maximum number of courses that you can take.

Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
Output: 3
Explanation: 
There are totally 4 courses, but you can take 3 courses at most:
First, take the 1st course, it costs 100 days so you will finish it on the 100th day, 
    and ready to take the next course on the 101st day.
Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, and ready to take the next course on the 1101st day. 
Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day. 
The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.

*/

/*

First intution is to find out what is the total time frame that I have?

    For that I can simply sort the input on the 'endTime'

    Suppose we have an input as follows: 
        [[7,17], [3,12], [10,20], [9,10], [5,20], [10,19], [4,18]]

        After sorting the input on the endTime it will look like this:

        [[9,10], [3,12], [7,17], [4,18], [10,19], [5,20], [10,20]]

            So I have this in the ascending order of the last day on which I need to complete the 
                respective courses

                If I am getting the same last day, in that case, we have to sort them based on their duration

        -------

        Ultimately now we have a time frame, that in 20 units of time I need to see how many courses
            I can complete

        After this I can start iterating and use the 'Greedy Approach' to find the number of courses
            that I can complete

            In the greedy approach, for the current iteration we will check, whether we can include that
                particular data in our result or not

                If we can, we will include it,

                else, we will check whether we can exclude some data from our result set and instead of that
                    if we can include the particular data

        -------

        Intution:

            For any iteration, check if taking up current course would get completed in the designated time

            1. If yes, then we can add the new course and update the time

            2. If it exceeds deadline, swap it with the biggest duration from the ones taken up

                ** The swaps should reduce the time taken till now
                        we should not be exceeding the time we were taking previously
                        before swapping it with the current course

*/

/*

Important points for the algo:

    1. Sorting the array based on the end time

    2. Take priority queue (maxHeap) to store the durations

    3. Iterate over the input and try to minimize the endtime while maximizing the courses

    4. Return courses completed  --> size of the PQ in the end

*/

public class Solution {
    
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);  // sort in descending order
        
        int time = 0;  // time that I have taken to complete all the courses that I've considered till now
        
        for (int[] course : courses) {
            // check if we consider the current course
            // if the duration of this course <= lastDay
            if (course[0] <= course[1]) {
                // if the current course can be completed within the last day given
                if (course[0] + time <= course[1]) {
                    pq.offer(course[0]);
                    time += course[0];
                } else {
                    // check if we swap this couse with some earlier course that I have choosen
                    // that could happen only if the element that I am going to pop has a time
                        // greater than the couse that I am going to offer now
                    if (pq.peek() > course[0]) {
                        time -= pq.poll();
                        time += course[0];
                        pq.offer(course[0]);
                    }
                }
            }
        }
        
        return pq.size();
    }
    
}
