package com.essenbazar._240;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*

The min-product of an array is equal to the minimum value in the array multiplied by the array's sum.

    For example, the array [3,2,5] (minimum value is 2)
        has a min-product of 2 * (3+2+5) = 2 * 10 = 20.

Given an array of integers nums, return the maximum min-product of any non-empty
    subarray of nums.

    Since the answer may be large, return it modulo 109 + 7.

Note that the min-product should be maximized before performing the modulo operation.
    Testcases are generated such that the maximum min-product without modulo will
    fit in a 64-bit signed integer.

A subarray is a contiguous part of an array.

Input: nums = [1,2,3,2]
Output: 14
Explanation: The maximum min-product is achieved with the subarray [2,3,2] (minimum value is 2).
2 * (2+3+2) = 2 * 7 = 14.

 */

class Solution1856 {

	public static int maxSumMinProduct(int[] a) {
		long MOD = (int) (1e9 + 7);
		int n = a.length;
		if (n == 1) {
			return (int) (((long) a[0] * (long) a[0]) % MOD);
		}
		long res = 0L;
		long[] preS = new long[n + 1];
		preS[0] = 0L;
		int ii = 1;
		for (int num : a) {
			preS[ii] = preS[ii - 1] + num;
			ii++;
		}
		Stack<List<Integer>> stack = new Stack<>();
		for (int i = 0; i < a.length; ++i) {
			int newStart = i;
			while (!stack.isEmpty() && stack.peek().get(1) > a[i]) {
				List<Integer> check_ = stack.pop();
				int start = check_.get(0);
				int value = check_.get(1);
				long total = preS[i] - preS[start];
				res = Math.max(res, value * total);
				newStart = start;
			}
			List<Integer> arr_ = new ArrayList<>();
			arr_.add(newStart);
			arr_.add(a[i]);
			stack.add(arr_);
		}
		for (List<Integer> check : stack) {
			long total = preS[a.length] - preS[check.get(0)];
			res = Math.max(res, check.get(1) * total);
		}
		return (int) (res % MOD);
	}
}
