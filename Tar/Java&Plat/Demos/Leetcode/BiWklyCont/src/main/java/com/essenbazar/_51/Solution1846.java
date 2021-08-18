package com.essenbazar._51;

import java.util.Arrays;

/*
 * You are given an array of positive integers arr. Perform some operations (possibly none) on 
 * arr so that it satisfies these conditions:

    The value of the first element in arr must be 1.
    The absolute difference between any 2 adjacent elements must be less than or equal to 1. 
    In other words, abs(arr[i] - arr[i - 1]) <= 1 for each i where 1 <= i < arr.length (0-indexed). 
    abs(x) is the absolute value of x.

There are 2 types of operations that you can perform any number of times:

    Decrease the value of any element of arr to a smaller positive integer.
    Rearrange the elements of arr to be in any order.

Return the maximum possible value of an element in arr after performing the operations to 
satisfy the conditions.

Example 1:

Input: arr = [2,2,1,2,1]
Output: 2
Explanation: 
We can satisfy the conditions by rearranging arr so it becomes [1,2,2,2,1].
The largest element in arr is 2.
 */

class Solution1846 {

	public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		if (arr.length == 1) {
			return 1;
		}
		int count = 0;
		int max = Integer.MIN_VALUE;
		if (arr[0] == 1) {
			for (int i = 0; i < arr.length - 1; ++i) {
				if (Math.abs(arr[i] - arr[i + 1]) <= 1) {
					count++;
				}
				if (arr[i] > max) {
					max = arr[i];
				}
			}
		}
		if (count == arr.length - 1) {
			Arrays.sort(arr);
			return arr[arr.length - 1];
		} else {
			Arrays.sort(arr);
			if (arr[0] == 1) {
				for (int i = 0; i < arr.length - 1; ++i) {
					if (Math.abs(arr[i] - arr[i + 1]) <= 1) {
					} else {
						arr[i + 1] = arr[i] + 1;
					}
				}
			} else {
				arr[0] = 1;
				for (int i = 0; i < arr.length - 1; ++i) {
					if (Math.abs(arr[i] - arr[i + 1]) <= 1) {
					} else {
						arr[i + 1] = arr[i] + 1;
					}
				}
			}
		}
		int max_ = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] > max_) {
				max_ = arr[i];
			}
		}
		return max_;
	}
}
