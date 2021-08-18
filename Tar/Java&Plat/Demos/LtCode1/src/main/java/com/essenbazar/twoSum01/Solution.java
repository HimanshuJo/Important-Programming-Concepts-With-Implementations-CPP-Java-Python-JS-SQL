package com.essenbazar.twoSum01;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hjoshi
 */
/*
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Output: Because nums[0] +
 * nums[1] == 9, we return [0, 1].
 * 
 */
class Solution {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; ++i) {
			map.put(i, nums[i]);
		}
		int[] res = new int[2];
		int otherIndex = 0;
		boolean haveFound = false;
		for (int i = 0; i < nums.length; ++i) {
			for (@SuppressWarnings("rawtypes")
			Map.Entry entry : map.entrySet()) {
				if ((int) entry.getValue() == target - nums[i] && (int) entry.getKey() != i) {
					otherIndex = (int) entry.getKey();
					haveFound = true;
				}
			}
			if (haveFound) {
				res[0] = i;
				res[1] = otherIndex;
				break;
			}
		}
		return res;
	}
}
