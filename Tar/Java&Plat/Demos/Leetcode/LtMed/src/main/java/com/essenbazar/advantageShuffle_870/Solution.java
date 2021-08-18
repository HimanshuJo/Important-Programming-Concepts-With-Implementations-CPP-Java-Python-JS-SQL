/*
Project for solving some common algorithm problems
 */
package com.essenbazar.advantageShuffle_870;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author himanshu
 */

/*

Given two arrays A and B of equal size, the advantage of A with respect to B is the
number of indices i for which A[i] > B[i].

Return any permutation of A that maximizes its advantage with respect to B.

Example 1:

Input: A = [2,7,11,15], B = [1,10,4,11]
Output: [2,11,7,15]

Example 2:

Input: A = [12,24,8,32], B = [13,25,32,11]
Output: [24,32,8,12]

*/

/*

Algo:

    Suppose A = [12, 24, 8, 32]

            B = [13, 25, 32, 11]

    First intution is to sort the two arrays:
        So A becomes [8, 12, 24, 32]
           B becomes [11, 13, 25, 32]

        but we will also need the indexes of the elements in B

    We can start comparing the indexes:
        is A[0] > or < B[0] and so on ...

        in this example we have 8 < 11, so we can say that it can't be used anywhere
            as all the numbers after 11 in the array B will also be greater

        -------

        Next element 12 satisfies the condition,
            so we can take an array, in the positions given to us in the array B
                we can start putting the elements

            e.g. 24     32              12
                 35     25      32      11

            At this point, when we still travel A, it will go out of boung, but we will start have an
                element left in B

                Here we need to go back to the unused numbers that are there are start putting those

                 24     32       8       12
                 35     25      32       11

    -------

    Which data structures to use:

        We need the original indexes for B array  // A map if Integer and Queue can be used here
            // Queue because we need the order also

        Second thing we need is sorting of array A and B

        Third thing we need is to store the unused number  // here also we need an order, so QUEUE
            // as whenever we have multiple placeholders where we need to put the unused numbers
                we will put those, in the order in which they are occurring

        Last is the result array // initially we can fill it with -1
            // as afterwards when we want to store all the unused numbers that time we can see
                whether we have a value -1, and then at that position we need to fill the unused number

*/

public class Solution {
    public int [] advantageCount(int [] A, int [] B) {
        int n = A.length;
        
        // we need to store the indexes of B
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            // if the value is absent, we need to put that value for the first time, or else
                // we need to take the queue out of it, and add that particular index to the queue
                
            map.putIfAbsent(B[i], new LinkedList<>());
            map.get(B[i]).add(i);
        }
        
        // sorting the array
        Arrays.sort(A);
        Arrays.sort(B);
        
        // to go over the array and find the indexes or the value that can be mapped
        
        int i = 0, j = 0;
        int [] result = new int[n];
        Arrays.fill(result, -1);
        
        Queue<Integer> unusedNumbers = new LinkedList<>();
        
        // we need to loop over each element while my i and j are in bounds
            // that means they are within n
        
        while (i < n && j < n) {
            if (A[i] > B[j]) {
                // get the index from the map
                int index = map.get(B[j]).poll();
                result[index] = A[i];
                ++j;
            } else {
                unusedNumbers.add(A[i]);
            }
            ++i;
        }
        
        // iterate over unused nums and add those nums wherein I have -1 in my result array
        
        for (int index = 0; index < n; ++index) {
            if (result[index] == -1) {
                result[index] = unusedNumbers.poll();
            }
        }
        
        return result;
    }
}
