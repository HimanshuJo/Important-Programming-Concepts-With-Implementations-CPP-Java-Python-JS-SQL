package com.essenbazar._249;

// Concatenation of Array
/*
 * Given an integer array nums of length n, you want to create an array ans of length 2n
 * where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

	Specifically, ans is the concatenation of two nums arrays.

	Return the array ans.

	Example 1:

	Input: nums = [1,2,1]
	Output: [1,2,1,1,2,1]
	Explanation: The array ans is formed as follows:
	- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
	- ans = [1,2,1,1,2,1]
 */

public class Solution1929 {
	public int[] getConcatenation(int[] nums) {
		int[] res = new int[2 * nums.length];
		int len = res.length;
		int len1 = nums.length;
		for (int i = 0; i < len1; ++i) {
			res[i] = nums[i];
		}
		int x = 0;
		for (int i = len1; i < len; ++i) {
			res[i] = nums[x++];
		}
		return res;
	}
}
