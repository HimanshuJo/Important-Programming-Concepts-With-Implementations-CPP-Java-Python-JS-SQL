package com.essenbazar.removeElm27;

/**
 *
 * @author hjoshi
 */
/*
 * Given an array nums and a value val, remove all instances of that value
 * in-place and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 */

class Solution {

	public int removeElement(int[] nums, int val) {
		int i = 0;
		for (int num : nums) {
			if (num != val) {
				nums[i] = num;
				++i;
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		int[] nums = { 3, 2, 2, 3 };
		my_obj.removeElement(nums, 3);
	}
}
