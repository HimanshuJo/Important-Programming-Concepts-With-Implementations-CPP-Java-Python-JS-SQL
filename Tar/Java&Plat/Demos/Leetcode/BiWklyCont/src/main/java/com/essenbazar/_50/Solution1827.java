package com.essenbazar._50;

/*

You are given an integer array nums (0-indexed). 

In one operation, you can choose an element of the array and increment it by 1.

    For example, if nums = [1,2,3], you can choose to increment nums[1] to make nums = [1,3,3].

Return the minimum number of operations needed to make nums strictly increasing.

An array nums is strictly increasing if nums[i] < nums[i+1] for all 0 <= i < nums.length - 1. 

An array of length 1 is trivially strictly increasing.

Example 1:

Input: nums = [1,1,1]
Output: 3
Explanation: You can do the following operations:
1) Increment nums[2], so nums becomes [1,1,2].
2) Increment nums[1], so nums becomes [1,2,2].
3) Increment nums[2], so nums becomes [1,2,3].

*/

import java.util.ArrayList;
import java.util.List;

class Solution {

	public int minOperations(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int num : nums) {
			list.add(num);
		}
		int res = 0;
		for (int i = 0; i < list.size() - 1; ++i) {
			int temp = list.get(i);
			if (temp < nums[i + 1]) {
			} else if (temp == list.get(i + 1)) {
				res++;
				list.set(i + 1, list.get(i + 1) + 1);
			} else {
				int temp_ = Math.abs(temp - list.get(i + 1));
				res += temp_;
				res++;
				list.set(i + 1, (temp_ + list.get(i + 1)) + 1);
			}
		}
		return res;
	}
}
