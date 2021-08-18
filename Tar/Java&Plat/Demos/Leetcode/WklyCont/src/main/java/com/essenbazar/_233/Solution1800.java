package com.essenbazar._233;

/*
 * Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.

	A subarray is defined as a contiguous sequence of numbers in an array.

	A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r,
	numsi < numsi+1. Note that a subarray of size 1 is ascending.

	Example 1:

	Input: nums = [10,20,30,5,10,50]
	Output: 65
	Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.
 */

public class Solution1800 {
	public int maxAscendingSum(int[] nums) {
		int maxSum = nums[0];
		int currSum = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			// if previous index is strictly less than the next index
			if (nums[i - 1] < nums[i]) {
				currSum = currSum + nums[i];
				maxSum = Math.max(maxSum, currSum);
			} else {
				maxSum = Math.max(maxSum, currSum);
				currSum = nums[i];
			}
		}
		return Math.max(maxSum, currSum);
	}
}
