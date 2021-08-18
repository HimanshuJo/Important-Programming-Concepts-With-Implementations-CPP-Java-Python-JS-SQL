package com.essenbazar.maxSubarray_53;

/*

Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.


 */

class Solution {

    //  Ulf Grenander Algo
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] < 0) {
                return nums[0];
            }
        }
        int count = 0;
        for (int num : nums) {
            if (num < 0) {
                count++;
            }
        }
        if (count == nums.length) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            return max;
        }
        int curr = 0;
        int best = 0;
        for (int i = 0; i < nums.length; ++i) {
            curr = Math.max(0, nums[i] + curr);
            best = Math.max(curr, best);
        }
        return best;
    }
}
