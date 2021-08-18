/*
Project for solving some April_21 leetcode problems
 */
package com.essenbazar.beautifulArrangementII;

/**
 *
 * @author himanshu
 */

/*

Given two integers n and k, you need to construct a list which contains n different positive 
integers ranging from 1 to n and obeys the following requirement:

Suppose this list is [a1, a2, a3, ... , an], then the list 
[|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.

If there are multiple answers, print any of them.

Example 1:

Input: n = 3, k = 1
Output: [1, 2, 3]
Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, 
and the [1, 1] has exactly 1 distinct integer: 1.

 */

/*

Suppose N = 9 and k = 5
    
    and our resultant sequence is [1, 9, 2, 8, 3, 4, 5, 6, 7]

        Initially we have a low value 1
        then we have the highest value that is 9

        Now we alternate between these two values and then at the end we have a sequence
            either in increasing or decreasing fashion
    
    -------

    We need to loop in this array, alternating between high and low value
        and then when the k is 1, we can just put down the values either in increasing
        or decreasing order according to the previous value in the sequence

*/

class Solution {

    public int[] constructArray(int n, int k) {
        int [] res = new int [n];
        
        int high = n;
        int low = 1;
        
        int index = 0;
        
        res[index++] = low++;  // we are always putting 1 at the start of the array
        
        boolean isHigh = false;
        
        while (k > 1) {
            res[index++] = high--;
            k--;
            isHigh = true;  // last value here is high therefore true
            
            // we need to put a low value next to this high value
                // in order to put this low value, for example if the k was initially 2
                    // it will become 1, so we should not put a low when when k = 1
            // low value only if k > 1
            if (k > 1) {
                res[index++] = low++;
                k--;
                isHigh = false;  // here we are putting low value there false
            }
        }
        
        // now we need to put the values either in increasing or decreasing fashion
            // these values should be according to the last value in the sequence
        
        while (index < n) {
            if (isHigh) {
                res[index++] = high--;
            } else {
                res[index++] = low++;
            }
        }
        
        return res;
    }
}
