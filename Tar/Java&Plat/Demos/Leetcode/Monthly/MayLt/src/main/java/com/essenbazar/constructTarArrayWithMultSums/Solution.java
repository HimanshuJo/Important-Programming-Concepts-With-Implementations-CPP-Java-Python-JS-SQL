/*
Project for solving some May_21 leetcode problems
 */
package com.essenbazar.constructTarArrayWithMultSums;

import java.util.PriorityQueue;

/**
 *
 * @author himanshu
 */

/*

Given an array of integers target. 

From a starting array, A consisting of all 1's, you may perform the following procedure :

    let x be the sum of all elements currently in your array.
    choose index i, such that 0 <= i < target.size and set the value of A at index i to x.
    You may repeat this procedure as many times as needed.

Return True if it is possible to construct the target array from A otherwise return False.

Input: target = [9,3,5]
Output: true
Explanation: Start with [1, 1, 1] 
[1, 1, 1], sum = 3 choose index 1
[1, 3, 1], sum = 5 choose index 2
[1, 3, 5], sum = 9 choose index 0
[9, 3, 5] Done

 */

 /*

Main steps:

    1. Find the total sum

    2. Find the index of the maximum value

    3. Then we find the difference sum
            sum = total - maxValue

    4. Update the maximum value
            maxValue -= diff

    5. Repeat till all the values are equal to 1

    -------

    Some conditions where we need special care:
        
        When the total sum (except max) > max value

            e.g. arr = {1, 2, 2}

                 Here the total sum is 5
                 max value is 2

                 Diff = 5 - 2 = 3
        
        When the total sum (except max) == 0

        When maxValue is divisible by total sum (except max) that is maxValue % diff = 0
        
 */
class Solution {

    public boolean isPossible(int[] target) {
        long sum = 0;
        int maxIndex = 0;

        for (int i = 0; i < target.length; ++i) {
            sum += target[i];

            if (target[maxIndex] < target[i]) {
                maxIndex = i;
            }
        }

        // Now we need to find out the difference (totalSum - maxValue)
        long diff = sum - target[maxIndex];

        // if the value at the maxIndex is 1, then we are sure that all the other
        // values are already 1
        if (target[maxIndex] == 1 || diff == 1) {
            return true;
        }

        if (diff > target[maxIndex] || diff == 0 || target[maxIndex] % diff == 0) {
            return false;
        }

        target[maxIndex] %= diff;

        return isPossible(target);
    }
}

/*

Time Complexity:

    O(N log max A)

Space Complexity:

    O(max A)

 */
class SolutionBFS {

    public boolean isPossible(int[] target) {
        long sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        for (int i = 0; i < target.length; ++i) {
            sum += target[i];
            pq.offer(target[i]);
        }

        while (pq.peek() != 1) {
            int val = pq.poll();
            long diff = sum - val;

            if (diff == 1) {
                return true;
            }

            if (diff > val || diff == 0 || val % diff == 0) {
                return false;
            }

            val %= diff;
            sum = diff + val;
            pq.offer(val);
        }

        return true;
    }
}

/*

Time:
    O(N log N)

Space: O(N)

*/