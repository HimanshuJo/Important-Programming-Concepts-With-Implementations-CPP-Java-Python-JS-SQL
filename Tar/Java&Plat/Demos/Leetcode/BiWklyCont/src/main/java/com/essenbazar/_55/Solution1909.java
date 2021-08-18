package com.essenbazar._55;

// Remove One Element to Make the Array Strictly Increasing

/*
 * Given a 0-indexed integer array nums, return true if it can be made strictly increasing
 * after removing exactly one element, or false otherwise.
 * If the array is already strictly increasing, return true.

	The array nums is strictly increasing if nums[i - 1] < nums[i] for each index (1 <= i < nums.length).

	Example 1:

	Input: nums = [1,2,10,5,7]
	Output: true
	Explanation: By removing 10 at index 2 from nums, it becomes [1,2,5,7].
	[1,2,5,7] is strictly increasing, so return true.
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
	public boolean canBeIncreasing(int[] nums) {
		if (isGood(nums)) {
			return true;
		} else {
			List<Integer> list = new ArrayList<>();
			for (int num : nums) {
				list.add(num);
			}
			for (int i = 0; i < nums.length; ++i) {
				list.remove(i);
				if (isGood(list)) {
					return true;
				}
				list.add(nums[i]);
			}
			return false;
		}
	}

	public boolean isGood(int[] nums) {
		for (int i = 0; i < nums.length - 1; ++i) {
			if (nums[i] < nums[i + 1]) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isGood(List<Integer> nums) {
		for (int i = 0; i < nums.size() - 1; ++i) {
			if (nums.get(i) < nums.get(i + 1)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
