package com.essenbazar._239;

/*
 * Given an integer array nums (0-indexed) and two integers target and start,
 * find an index i such that nums[i] == target and abs(i - start) is minimized.
 * Note that abs(x) is the absolute value of x.

	Return abs(i - start).

	It is guaranteed that target exists in nums.

	Example 1:

	Input: nums = [1,2,3,4,5], target = 5, start = 3
	Output: 1
	Explanation: nums[4] = 5 is the only value equal to target, so the answer is abs(4 - 3) = 1.
 */
import java.util.Map;
import java.util.TreeMap;

class Solution {

	public int getMinDistance(int[] nums, int target, int start) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < nums.length; ++i) {
			map.put(i, nums[i]);
		}
		int res = Integer.MAX_VALUE;
		for (@SuppressWarnings("rawtypes")
		Map.Entry entry : map.entrySet()) {
			if ((int) entry.getValue() == target) {
				if (Math.abs((int) entry.getKey() - start) < res) {
					res = Math.abs((int) entry.getKey() - start);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Solution myObj = new Solution();
		System.out.println(myObj);
	}
}
