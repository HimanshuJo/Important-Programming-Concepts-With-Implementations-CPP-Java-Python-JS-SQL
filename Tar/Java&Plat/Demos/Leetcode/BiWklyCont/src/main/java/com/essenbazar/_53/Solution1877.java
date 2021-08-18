package com.essenbazar._53;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair 
 * sum in a list of pairs.

    For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum 
    would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.

	Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:
	
	    Each element of nums is in exactly one pair, and
	    The maximum pair sum is minimized.
	
	Return the minimized maximum pair sum after optimally pairing up the elements.
	
	Example 1:
	
	Input: nums = [3,5,2,3]
	Output: 7
	Explanation: The elements can be paired up into pairs (3,3) and (5,2).
	The maximum pair sum is max(3+3, 5+2) = max(6, 7) = 7.

 */
class Solution1877 {
	List<Integer> list_ = new ArrayList<>();

	public int minPairSum(int[] nums) {
		findOptimalPairs(nums, nums.length);
		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < list_.size() - 1; ++i) {
			temp.add(list_.get(i) + list_.get(i + 1));
			i += 1;
		}
		int max = Integer.MIN_VALUE;
		for (int num : temp) {
			if (num > max) {
				max = num;
			}
		}
		return max;
	}

	public void findOptimalPairs(int arr[], int N) {
		Arrays.sort(arr);
		for (int i = 0, j = N - 1; i <= j; i++, j--) {
			list_.add(arr[i]);
			list_.add(arr[j]);
		}
	}
}
