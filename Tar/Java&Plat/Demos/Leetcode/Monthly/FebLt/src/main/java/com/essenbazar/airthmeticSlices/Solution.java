/*
Project for solving some feb_21 leetcode problems
 */
package com.essenbazar.airthmeticSlices;

/**
 *
 * @author himan
 */

/*

A sequence of numbers is called arithmetic if it consists of at least three
elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequences:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9

The following sequence is not arithmetic.

1, 1, 2, 5, 7


A zero-indexed array A consisting of N numbers is given.
A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of the array A is called arithmetic if the sequence:
A[P], A[P + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.

*/

/*

Suppose we've a bigger array [1, 2, 3, 4, 5, 6, 8, 10, 12, 14]

So here we can have two bigger size airthmetic slices:
    [1, 2, 3, 4, 5, 6]  --> diff of 1

        now inside this how many possible airthmetic slices can be created

            4 + 3 + 2 + 1 = 10

    [6, 8, 10, 12, 14]  --> diff of 2
    
        here, 3 + 2 + 1 = 6

Another example to figure out how to get the air. slices in the bigger slices

    [1, 2, 3, 4, 8, 10, 12, 14]

        At once we'll take three numbers, and find the diff between the consecutive pairs

            if the diff is equal, we got a slice [1, 2, 3]

        At the same time we'll maintain a dp array, in that we keep on adding the air. slice that we have found
            or else we can conclude the number of slices that could be possible by using the previous
            answer that we have
            
            [0, 0, 1, 0, 0, 0, 0, 0]

        moving ahead in the array: [2, 3, 4] also forms a slice
            in the dp array [0, 0, 1, 1 + 1, 0, 0, 0, 0]
                we can say once slice is possible but there was also one slice
                that was possible with the previous one too, so we can say there can be slice possible
                by taking into consideration all the elements present in the previous and current
*/


class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        
        // we will need a dp array
        int [] dp = new int[A.length];
        int result = 0;
        
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                result += dp[i];
            }
        }
        
        return result;
    }
}
