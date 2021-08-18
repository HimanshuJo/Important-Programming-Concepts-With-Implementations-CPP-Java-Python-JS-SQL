package com.essenbazar._238;

import java.util.Arrays;

/**
 *
 * @author himanshu
 */

/*
 *
 * The frequency of an element is the number of times it occurs in an array.
 *
 * You are given an integer array nums and an integer k.
 *
 * In one operation, you can choose an index of nums and increment the element
 * at that index by 1.
 *
 * Return the maximum possible frequency of an element after performing at most
 * k operations.
 *
 * Example 1:
 *
 * Input: nums = [1,2,4], k = 5 Output: 3 Explanation: Increment the first
 * element three times and the second element two times to make nums = [4,4,4].
 * 4 has a frequency of 3.
 *
 */

/*
 *
 * Intution behind the problem:
 *
 * Sliding window problem
 *
 * We sort the array A
 *
 * The key is to actually find out the valid condition k + sum >= size * max
 *
 * which is
 *
 * k + sum >= (j - i + 1) * A[j]
 *
 * Explanation:
 *
 * For every new element A[j] to the sliding window, add it to the sum by sum +=
 * A[j]
 *
 * Check is it's a valid window by
 *
 * sum + k < (long) A[j] * (j - i + 1)
 *
 * If not removing A[i] from the window by sum -= A[i] i += 1
 *
 * Then update the res by res = max(res, j - i + 1)
 *
 */

class Solution {
	public int maxFrequency(int[] nums, int k) {

		int res = 1, i = 0, j;
		long sum = 0;
		Arrays.sort(nums);

		// 1, 2, 4 // [5]

		for (j = 0; j < nums.length; ++j) {
			sum += nums[j];

			while (sum + k < (long) nums[j] * (j - i + 1)) {
				sum -= nums[i];
				i += 1;
			}

			res = Math.max(res, j - i + 1);
		}

		return res;

	}
}

// using Binary Search

/*
 *
 * Idea:
 *
 * For index in range [0..n - 1] of array nums:
 *
 * We can count maximum frequency of nums[index] if we make other elements equal
 * to nums[index] by performing at most k operations
 *
 * In our custom count function, we can perform binary search to find the
 * smallest mid in range [0..index], which sums of (nums[mid], nums[mid +
 * 1],...nums[index - 1]) + k >= (index - mid) * nums[index]
 *
 * Complexity:
 *
 * Time: = O(N Log N)
 *
 * Space: O(N)
 *
 */

class Solution2 {
	long[] preSum;

	public int maxFrequency(int[] nums, int k) {
		int n = nums.length;
		Arrays.sort(nums);

		preSum = new long[n + 1];

		for (int i = 0; i < n; ++i) {
			preSum[i + 1] = preSum[i] + nums[i];
		}

		int res = 0;

		for (int i = 0; i < n; ++i) {
			res = Math.max(res, count(nums, k, i));
		}

		return res;
	}

	// left right inclusive
	long getSum(int left, int right) {
		return preSum[right + 1] - preSum[left];
	}

	// count frequency of nums[index] if we can make other elements equal to
	// nums[index]
	int count(int[] nums, int k, int i) {
		int left = 0, right = i, res = i;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			// getting sum of (nums[mid], nums[mid + 1],...nums[index - 1])
			long s = getSum(mid, i - 1); // passing left and right for the function

			// if we found an answer; then we try to find a better answer in the left side
			if (s + k >= (long) (i - mid) * nums[i]) {

				res = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return i - res + 1;
	}
}

// More clear sliding window approach

/*
 *
 * Here we can see that in order to calculate maximum frequency of a number, we
 * can increment some number less than it. E.g., Suppose we have an array arr []
 * = {1,2,3}
 *
 * Now in order to make let's suppose the frequency of 3 to 3, then we can
 * increment 2 one time and 1 two times
 *
 * Lets say we increment k numbers less than x to make them all x
 *
 * Then the operation required will be equal to Ops = k * x - sum
 *
 * where sum is the sum of all the numbers less than x which were incremented
 *
 * We can utilize this property to create a sliding window approach.
 *
 * So initially we can sort the array
 *
 * Let's say we have a window (i , j), then that window can be made to have all
 * the elements equal to the maximum (which is a[j])
 *
 * Therefore we can check
 *
 * if a[j] * (j - i + 1) - sum[i : j] <= k
 *
 * If it, then we can increase j, else we need to increase i
 *
 */

class Solution3 {
	public int maxFrequency(int[] arr, int k) {
		int n = arr.length;

		Arrays.sort(arr);

		int res = 0;
		int left = 0;

		long sum = 0;

		for (int right = 0; right < n; ++right) {
			sum += arr[right];

			while (arr[right] * 1L * (right - left + 1) - sum > k) {
				sum -= arr[left];
				left++;
			}

			res = Math.max(res, right - left + 1);
		}

		return res;
	}
}