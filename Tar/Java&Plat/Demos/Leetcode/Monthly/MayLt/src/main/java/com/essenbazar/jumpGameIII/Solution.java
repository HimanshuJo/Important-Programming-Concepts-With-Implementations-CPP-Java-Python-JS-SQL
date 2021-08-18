/*
Project for solving some May_21 leetcode problems
 */
package com.essenbazar.jumpGameIII;

import java.util.Arrays;

/**
 *
 * @author himanshu
 */

/*

Given an array of non-negative integers nums, 
you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. 
Jump 1 step from index 0 to 1, then 3 steps to the last index.

*/

/*

Suppose we have only one value in our array, so in that case the ans would have been 0
    e.g. int[] arr = {4};

    our dp array will look like {0}

    -------

    Now suppose we have two values in our arr

    e.g. int[] arr = {1, 4}

    our final dp array in this case will look like
        {1, 0}  --> at the 0th index the value of 0 + 1

        because we need one more jump to reach from the 0th index to the last

    -------

    Now suppose we add one more value

    e.g. int[] arr = {1, 1, 4}

    here our final dp will look like
        {1+1, 1, 0}

        as from the 0th index we can only jump 1 step
        
        and we have already stored the number of jumps it would take to reach from
            the 1st index to the last

    -------

    Now suppose we add one more value

    e.g. int[] arr = {3, 1, 1, 4}

    here our final dp will look like
        {1 + 0, 2, 1, 0}  
        from the value of 3, we can have the jump of 1 index, 2 index or jump of 3 index

            as we compare the value of each of these three indexes in our already created dp array

                we find out that the min value is 0

                so we add 1 + 0

    -------

    Now suppose we add one more value

    e.g. int[] arr = {2, 3, 1, 1, 4}

    here our final dp will look like
        {1 + 1, 1, 2, 1, 0}

        we first calculate what is the max jump we can make from the current index

        we check out the min value corresponding to that range in our dp array and add it to the curr index

    -------

    Finally the value at the 0th index will the result value

-------

Summary:

    We are iterating from the last index towards the 0th index and with every jump we need
        to find out the minimum result of all the previous values

        and add just one to it
        
*/

class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // value at the last index will always be 0 as this is the index we need to reach
        dp[n - 1] = 0;
        
        for (int i = n - 2; i >= 0; --i) {
            // for each of the values present at the index i we need to find out the minimum
                // of all the values in between the index and index + the jump we can take from the
                // current index i
                
            int min = Integer.MAX_VALUE;
            
            for (int j = i + 1; j <= Math.min(n - 1, i + nums[i]); ++j) {
                min = Math.min(min, dp[j]);
            }
            
            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }
        
        return dp[0];
        
    }
}