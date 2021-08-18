/*
Project for solving some Mar_21 leetcode problems
 */
package com.essenbazar.missingNumber;

/**
 *
 * @author himanshu
 */

/*

Gauss Formula:

    ∑i=0 to n ​i = n(n+1) / 2

    We can compute the sum of nums in linear time, and by Gauss' formula we can compute the sum
        of the first n natural numbers in constant time

    Therefore the number that is missing is simply the result of Gauss' formula minus the sum of nums
        as nums consists of the first n natural numbers minus some number​

*/

public class Solution_2 {
    
    public int missingNumber(int [] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        
        for (int num : nums) actualSum += num;
        
        return expectedSum - actualSum;
    }
    
}

/*

Time Complexity:

    Although Gauss' formula can be computed in O(1) time, summing nums costs us O(n) time

Space Complexity:

    This approach only pushes a few integers around, so it has constant memory usage.

*/