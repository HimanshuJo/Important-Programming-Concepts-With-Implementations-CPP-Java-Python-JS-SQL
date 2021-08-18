package com.essenbazar._241;

import java.util.ArrayList;
import java.util.List;

/*
The XOR total of an array is defined as the bitwise XOR of all its elements,
or 0 if the array is empty.

    For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.

Given an array nums, return the sum of all XOR totals for every subset of nums.

Note: Subsets with the same elements should be counted multiple times.

An array a is a subset of an array b if a can be obtained from b by
    deleting some (possibly zero) elements of b.

Input: nums = [1,3]
Output: 6
Explanation: The 4 subsets of [1,3] are:
- The empty subset has an XOR total of 0.
- [1] has an XOR total of 1.
- [3] has an XOR total of 3.
- [1,3] has an XOR total of 1 XOR 3 = 2.
0 + 1 + 3 + 2 = 6
 */

public class Solution1863 {

	public int subsetXORSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> curr = new ArrayList<>();
		backtrack(res, curr, nums, 0);
		int xor = 0;
		for (List<Integer> list : res) {
			int currXor = 0;
			for (Integer val : list) {
				if (val != null) {
					currXor ^= val;
				}
			}
			xor += currXor;
		}
		return xor;
	}

	public void backtrack(List<List<Integer>> res, List<Integer> curr, int[] nums, int pos) {
		res.add(new ArrayList<>(curr));
		for (int i = pos; i < nums.length; ++i) {
			curr.add(nums[i]);
			backtrack(res, curr, nums, i + 1);
			curr.remove(curr.size() - 1);
		}
	}

	public static void main(String[] args) {
		Solution1863 obj = new Solution1863();
		int[] nums = { 3, 4, 5, 6, 7, 8 };
		System.out.println(obj.subsetXORSum(nums));
	}
}
