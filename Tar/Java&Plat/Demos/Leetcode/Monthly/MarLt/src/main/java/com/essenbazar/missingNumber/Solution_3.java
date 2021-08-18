/*
Project for solving some Mar_21 leetcode problems
 */
package com.essenbazar.missingNumber;

/**
 *
 * @author himanshu
 */

/*

Algo: Bit Manipulation

Intution:

    We can harness the fact that XOR is its own inverse to find the missing element in linear time

Algo:

    Because we know that nums contains n numbers and that it is missing exactly one number on the rane [0 ... n -1]
        we know that n definitely replaces the missing number in nums.

        Therefore we initialize an integer to n and XOR it with every index and value
            we will be left with the missing number

    Index 	0 	1 	2 	3
    Value 	0 	1 	3 	4


    missing = 4 XOR (0 XOR 0) XOR (1 XOR 1) XOR (2 XOR 3) XOR (3 XOR 4)
            = (4 XOR 4) XOR (0 XOR 0) XOR (1 XOR 1) XOR (3 XOR 3) XOR 2
            = 0 XOR 0 XOR 0 XOR 0 XOR 2
            = 2
*/

public class Solution_3 {
    public int missingNumber(int [] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        
        return missing;
    }
}
