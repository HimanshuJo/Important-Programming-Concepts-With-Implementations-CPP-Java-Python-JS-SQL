/*

Directory to test few algorithm tasks

 */
package com.essenbazar.rotatearray189;

import java.util.Arrays;

/**
 *
 * @author hjoshi
 */
/*
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Input: nums = [1,2,3,4,5,6,7], k = 3 Output: [5,6,7,1,2,3,4]
 * 
 * Explanation: rotate 1 steps to the right: [7,1,2,3,4,5,6] rotate 2 steps to
 * the right: [6,7,1,2,3,4,5] rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
class Solution {

	public void rotate(int[] nums, int k) {
		if (k > nums.length) {
			k = k % nums.length;
		}
		int[] res = new int[nums.length];
		for (int i = 0; i < k; i++) {
			res[i] = nums[nums.length - k + i];
		}
		int j = 0;
		for (int m = k; m < nums.length; m++) {
			res[m] = nums[j];
			j++;
		}
		System.arraycopy(res, 0, nums, 0, nums.length);
		System.out.println(Arrays.toString(res));
		System.out.println(Arrays.toString(nums));
	}

	public static void main(String[] args) {
		Solution my_obj = new Solution();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int index = 3;
		my_obj.rotate(nums, index);
	}
}

/*
 * Using the Reverse Approach:
 * 
 * The approach is based on the fact that when we rotate the array k times, k
 * elements from the back end of the array come to the front and the rest of the
 * elements from the front shift backwards
 * 
 * In this approach we can firstly reverse all the elements of the array. Then
 * reversing the first k elements followed by reversing the rest n - k elements
 * give us the required result
 * 
 * Let n = 7, and k = 3
 * 
 * Original List -> 1 2 3 4 5 6 7 After reversing all numbers -> 7 6 5 4 3 2 1
 * After reversing first k numbers -> 5 6 7 4 3 2 1 After reversing last k
 * numbers -> 5 6 7 1 2 3 4
 */

class Solution2 {
	public void rotate(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}

/*
 * Complexity: O(n) as n elements are reversed a total of three times Space :
 * O(1) no extra space is required
 */