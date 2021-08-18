/*
Project for solving some April_21 leetcode problems
 */
package com.essenbazar.minOperationsArrayEqual;

/**
 *
 * @author himanshu
 */

/*

You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid 
values of i (i.e. 0 <= i < n).

In one operation, you can select two indices x and y where 0 <= x, y < n 
and subtract 1 from arr[x] and add 1 to arr[y] (i.e. perform arr[x] -=1 and arr[y] += 1). 

The goal is to make all the elements of the array equal. 
It is guaranteed that all the elements of the array can be made equal using some operations.

Given an integer n, the length of the array. Return the minimum number of operations 
needed to make all the elements of arr equal.

Example 1:

Input: n = 3
Output: 2
Explanation: arr = [1, 3, 5]
First operation choose x = 2 and y = 0, this leads arr to be [2, 3, 4]
In the second operation choose x = 2 and y = 0 again, thus arr = [3, 3, 3].

*/

/*

Algo:

    First and the foremost thing is what is the value to which we will be changing all the
        other values to form the equal array

    We can take the middle value, and change all the other values

    There will be two cases:

        When n is odd:

            our middle value will contain only one element

            -------

            Since we are doing addition and substraction in a pair, so to calculate
                the result we can just focus on half of the values

                e.g. suppose our array is:
                    
                        1   3   5   7   9
                       +4   +2     -2   -4

                    So focusing on just first two values, we will in total require 6 operations

                        in essence we need to add 2 + 4
                        = 2 (1 + 2)
                            here 1 + 2 is an Airthmetic progression
                        = 2 (sum(mid))
                        = 2 (sum(n / 2))
                        = 2 * (mid * (mid + 1) / 2)

                            formula for finding the sum of n elements
            
            -------

            If n is odd, we can just say that we will require (mid * mid + 1) steps

        When n is even:

            I will be have two members lying in the mid:

                e.g. 1  3   5   7   9   11

                    here mid will (5 + 7) / 2

*/
public class Solution {
    public int minOperations(int n) {
        int mid = n / 2;
        
        return n % 2 == 0 ? (mid * mid) : mid * (mid + 1);
    }
}
