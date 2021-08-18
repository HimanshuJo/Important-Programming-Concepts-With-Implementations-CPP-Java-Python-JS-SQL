/*
Project for solving some common algorithm problems
 */
package com.essenbazar.airthmeticSlices_413;

/*

An integer array is called arithmetic if it consists of at least three elements and
if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.

Example 1:

Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.

 */
class Solution {

    public int numberOfArithmeticSlices(int[] A) {

        int[] dp = new int[A.length];
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
